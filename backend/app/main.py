from __future__ import annotations

import hashlib
import os
import secrets
import sqlite3
import time
from contextlib import contextmanager
from pathlib import Path
from typing import Optional

import jwt
from fastapi import Depends, FastAPI, Header, HTTPException
from pydantic import BaseModel, Field

APP_VERSION_CODE = int(os.getenv("AM2_VERSION_CODE", "7"))
APP_VERSION_NAME = os.getenv("AM2_VERSION_NAME", "0.7.0")
JWT_SECRET = os.getenv("AM2_JWT_SECRET", "CHANGE-ME-IN-PRODUCTION")
JWT_TTL_SECONDS = int(os.getenv("AM2_JWT_TTL_SECONDS", "2592000"))  # 30 days
ADMIN_KEY = os.getenv("AM2_ADMIN_KEY", "CHANGE-ME-ADMIN")
DB_PATH = Path(os.getenv("AM2_DB_PATH", str(Path(__file__).resolve().parents[1] / "data" / "am2.db")))
PUBLIC_APK_URL = os.getenv("AM2_APK_URL", "")
PUBLIC_APK_SHA256 = os.getenv("AM2_APK_SHA256", "")

app = FastAPI(title="Amaliy Matematika 2 API", version=APP_VERSION_NAME)


@contextmanager
def db():
    DB_PATH.parent.mkdir(parents=True, exist_ok=True)
    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    try:
        yield conn
        conn.commit()
    finally:
        conn.close()


def init_db() -> None:
    with db() as conn:
        conn.executescript(
            """
            PRAGMA journal_mode=WAL;
            CREATE TABLE IF NOT EXISTS licenses (
                code TEXT PRIMARY KEY,
                student_id TEXT NOT NULL,
                max_devices INTEGER NOT NULL DEFAULT 2,
                active INTEGER NOT NULL DEFAULT 1,
                expires_at INTEGER
            );
            CREATE TABLE IF NOT EXISTS activations (
                license_code TEXT NOT NULL,
                device_tag TEXT NOT NULL,
                created_at INTEGER NOT NULL,
                last_seen INTEGER NOT NULL,
                PRIMARY KEY (license_code, device_tag),
                FOREIGN KEY (license_code) REFERENCES licenses(code)
            );
            CREATE TABLE IF NOT EXISTS videos (
                topic_id TEXT PRIMARY KEY,
                manifest_url TEXT NOT NULL,
                drm_license_url TEXT,
                is_dash INTEGER NOT NULL DEFAULT 1
            );
            CREATE TABLE IF NOT EXISTS progress (
                student_id TEXT NOT NULL,
                topic_id TEXT NOT NULL,
                best_score INTEGER NOT NULL,
                updated_at INTEGER NOT NULL,
                PRIMARY KEY (student_id, topic_id)
            );
            """
        )


@app.on_event("startup")
def startup() -> None:
    init_db()


class ActivationRequest(BaseModel):
    licenseCode: str = Field(min_length=4, max_length=128)
    deviceTag: str = Field(min_length=2, max_length=128)
    appVersion: str = Field(min_length=1, max_length=64)


class ProgressRequest(BaseModel):
    topicId: str
    bestScore: int = Field(ge=0, le=1000)


class CreateLicenseRequest(BaseModel):
    studentId: str = Field(min_length=1, max_length=128)
    code: Optional[str] = None
    maxDevices: int = Field(default=2, ge=1, le=10)
    expiresAtEpochSeconds: Optional[int] = None


class SetVideoRequest(BaseModel):
    topicId: str
    manifestUrl: str
    drmLicenseUrl: Optional[str] = None
    isDash: bool = True


def require_admin(x_admin_key: str = Header(default="")) -> None:
    if not secrets.compare_digest(x_admin_key, ADMIN_KEY):
        raise HTTPException(status_code=401, detail="invalid admin key")


def sign_token(student_id: str, license_code: str, device_tag: str) -> tuple[str, int]:
    now = int(time.time())
    exp = now + JWT_TTL_SECONDS
    token = jwt.encode(
        {"sub": student_id, "lic": license_code, "dev": device_tag, "iat": now, "exp": exp},
        JWT_SECRET,
        algorithm="HS256",
    )
    return token, exp


def auth_user(authorization: str = Header(default="")) -> dict:
    if not authorization.startswith("Bearer "):
        raise HTTPException(status_code=401, detail="missing bearer token")
    token = authorization[7:]
    try:
        payload = jwt.decode(token, JWT_SECRET, algorithms=["HS256"])
    except jwt.PyJWTError as exc:
        raise HTTPException(status_code=401, detail="invalid or expired token") from exc

    with db() as conn:
        lic = conn.execute("SELECT * FROM licenses WHERE code=?", (payload["lic"],)).fetchone()
        act = conn.execute(
            "SELECT * FROM activations WHERE license_code=? AND device_tag=?",
            (payload["lic"], payload["dev"]),
        ).fetchone()
        if not lic or not act or not lic["active"]:
            raise HTTPException(status_code=401, detail="license inactive")
        if lic["expires_at"] and int(time.time()) > int(lic["expires_at"]):
            raise HTTPException(status_code=401, detail="license expired")
        conn.execute(
            "UPDATE activations SET last_seen=? WHERE license_code=? AND device_tag=?",
            (int(time.time()), payload["lic"], payload["dev"]),
        )
    return payload


@app.get("/health")
def health():
    return {"ok": True, "version": APP_VERSION_NAME}


@app.post("/v1/activate")
def activate(req: ActivationRequest):
    now = int(time.time())
    code = req.licenseCode.strip().upper()
    with db() as conn:
        lic = conn.execute("SELECT * FROM licenses WHERE code=?", (code,)).fetchone()
        if not lic or not lic["active"]:
            return {"ok": False, "studentId": None, "accessToken": None, "expiresAtEpochSeconds": None, "message": "Invalid or inactive license"}
        if lic["expires_at"] and now > int(lic["expires_at"]):
            return {"ok": False, "studentId": None, "accessToken": None, "expiresAtEpochSeconds": None, "message": "License expired"}

        existing = conn.execute(
            "SELECT 1 FROM activations WHERE license_code=? AND device_tag=?",
            (code, req.deviceTag),
        ).fetchone()
        if not existing:
            count = conn.execute("SELECT COUNT(*) c FROM activations WHERE license_code=?", (code,)).fetchone()["c"]
            if count >= lic["max_devices"]:
                return {"ok": False, "studentId": None, "accessToken": None, "expiresAtEpochSeconds": None, "message": "Device limit reached"}
            conn.execute(
                "INSERT INTO activations(license_code,device_tag,created_at,last_seen) VALUES(?,?,?,?)",
                (code, req.deviceTag, now, now),
            )
        else:
            conn.execute(
                "UPDATE activations SET last_seen=? WHERE license_code=? AND device_tag=?",
                (now, code, req.deviceTag),
            )

    token, exp = sign_token(lic["student_id"], code, req.deviceTag)
    return {"ok": True, "studentId": lic["student_id"], "accessToken": token, "expiresAtEpochSeconds": exp, "message": "Activated"}


@app.get("/v1/videos/{topic_id}")
def video_grant(topic_id: str, user: dict = Depends(auth_user)):
    with db() as conn:
        row = conn.execute("SELECT * FROM videos WHERE topic_id=?", (topic_id,)).fetchone()
    if not row:
        raise HTTPException(status_code=404, detail="video not configured")
    # The URLs should normally be short-lived/signed at the CDN or DRM provider.
    # This backend does not expose storage credentials in the APK.
    wm_source = f"{user['sub']}|{user['dev']}|{topic_id}|{int(time.time()) // 3600}"
    watermark_id = hashlib.sha256(wm_source.encode()).hexdigest()[:12].upper()
    return {
        "manifestUrl": row["manifest_url"],
        "drmLicenseUrl": row["drm_license_url"],
        "expiresAtEpochSeconds": int(time.time()) + 3600,
        "watermarkId": watermark_id,
        "isDash": bool(row["is_dash"]),
    }


@app.post("/v1/progress")
def save_progress(req: ProgressRequest, user: dict = Depends(auth_user)):
    now = int(time.time())
    with db() as conn:
        old = conn.execute(
            "SELECT best_score FROM progress WHERE student_id=? AND topic_id=?",
            (user["sub"], req.topicId),
        ).fetchone()
        best = max(req.bestScore, old["best_score"] if old else 0)
        conn.execute(
            "INSERT INTO progress(student_id,topic_id,best_score,updated_at) VALUES(?,?,?,?) "
            "ON CONFLICT(student_id,topic_id) DO UPDATE SET best_score=excluded.best_score, updated_at=excluded.updated_at",
            (user["sub"], req.topicId, best, now),
        )
    return {"ok": True, "bestScore": best}


@app.get("/v1/update")
def update_info():
    return {
        "versionCode": APP_VERSION_CODE,
        "versionName": APP_VERSION_NAME,
        "mandatory": False,
        "apkUrl": PUBLIC_APK_URL or None,
        "sha256": PUBLIC_APK_SHA256 or None,
        "releaseNotesUz": "Himoyalangan video, aktivatsiya, qurilma limiti, progress sync va update klienti.",
        "releaseNotesRu": "Защищённое видео, активация, лимит устройств, синхронизация прогресса и клиент обновлений.",
        "releaseNotesEn": "Protected video, activation, device limits, progress sync and update client.",
    }


@app.post("/admin/licenses", dependencies=[Depends(require_admin)])
def create_license(req: CreateLicenseRequest):
    code = (req.code or secrets.token_hex(6)).upper()
    with db() as conn:
        conn.execute(
            "INSERT OR REPLACE INTO licenses(code,student_id,max_devices,active,expires_at) VALUES(?,?,?,?,?)",
            (code, req.studentId.strip(), req.maxDevices, 1, req.expiresAtEpochSeconds),
        )
    return {"ok": True, "code": code, "studentId": req.studentId, "maxDevices": req.maxDevices}


@app.post("/admin/videos", dependencies=[Depends(require_admin)])
def set_video(req: SetVideoRequest):
    with db() as conn:
        conn.execute(
            "INSERT INTO videos(topic_id,manifest_url,drm_license_url,is_dash) VALUES(?,?,?,?) "
            "ON CONFLICT(topic_id) DO UPDATE SET manifest_url=excluded.manifest_url, drm_license_url=excluded.drm_license_url, is_dash=excluded.is_dash",
            (req.topicId, req.manifestUrl, req.drmLicenseUrl, 1 if req.isDash else 0),
        )
    return {"ok": True}


@app.get("/admin/licenses", dependencies=[Depends(require_admin)])
def list_licenses():
    with db() as conn:
        rows = conn.execute(
            "SELECT l.code,l.student_id,l.max_devices,l.active,l.expires_at,COUNT(a.device_tag) device_count "
            "FROM licenses l LEFT JOIN activations a ON a.license_code=l.code GROUP BY l.code ORDER BY l.student_id"
        ).fetchall()
    return [dict(r) for r in rows]

@app.post("/admin/licenses/{code}/reset-devices", dependencies=[Depends(require_admin)])
def reset_devices(code: str):
    code = code.strip().upper()
    with db() as conn:
        lic = conn.execute("SELECT 1 FROM licenses WHERE code=?", (code,)).fetchone()
        if not lic:
            raise HTTPException(status_code=404, detail="license not found")
        conn.execute("DELETE FROM activations WHERE license_code=?", (code,))
    return {"ok": True, "code": code}


@app.post("/admin/licenses/{code}/deactivate", dependencies=[Depends(require_admin)])
def deactivate_license(code: str):
    code = code.strip().upper()
    with db() as conn:
        cur = conn.execute("UPDATE licenses SET active=0 WHERE code=?", (code,))
        if cur.rowcount == 0:
            raise HTTPException(status_code=404, detail="license not found")
    return {"ok": True, "code": code, "active": False}
