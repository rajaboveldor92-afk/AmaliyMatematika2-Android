# AM2 protected backend

This service implements the server side required by the Android app:

- license activation;
- maximum-device enforcement;
- signed access tokens;
- per-topic protected video grants;
- privacy-preserving moving watermark IDs;
- progress sync;
- update metadata;
- admin endpoints for issuing licenses and registering video streams.

## Run locally

```bash
python -m uvicorn app.main:app --host 127.0.0.1 --port 8000
```

Set strong production values for `AM2_JWT_SECRET` and `AM2_ADMIN_KEY`. Put the service behind HTTPS. The Android release build must point `CONTENT_API_BASE_URL` to the public HTTPS origin.

## Create a student license

```bash
curl -X POST http://127.0.0.1:8000/admin/licenses \
  -H 'X-Admin-Key: CHANGE-ME-ADMIN' \
  -H 'Content-Type: application/json' \
  -d '{"studentId":"STUDENT-001","maxDevices":2}'
```

## Register a protected video

The `manifestUrl` should be a protected DASH/HLS stream URL from your video/CDN provider. For Widevine, set the provider's HTTPS license endpoint in `drmLicenseUrl`.

```bash
curl -X POST http://127.0.0.1:8000/admin/videos \
  -H 'X-Admin-Key: CHANGE-ME-ADMIN' \
  -H 'Content-Type: application/json' \
  -d '{"topicId":"TOPIC_1_1","manifestUrl":"https://cdn.example/t11/manifest.mpd","drmLicenseUrl":"https://drm.example/widevine","isDash":true}'
```

Do not store CDN signing secrets, DRM secrets, or the admin key in the APK.

## Reset registered devices

```bash
curl -X POST http://127.0.0.1:8000/admin/licenses/ABC123/reset-devices \
  -H 'X-Admin-Key: CHANGE-ME-ADMIN'
```

## Deactivate a license

```bash
curl -X POST http://127.0.0.1:8000/admin/licenses/ABC123/deactivate \
  -H 'X-Admin-Key: CHANGE-ME-ADMIN'
```
