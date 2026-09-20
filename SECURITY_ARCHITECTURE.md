# Security architecture — v0.7.0

## Threat model
The goal is to reduce casual copying, direct file sharing, APK modification and anonymous redistribution. No software can prevent a second physical camera from recording a screen, so attribution and layered controls matter.

## Controls
1. **Content access** — backend activation + bearer token + per-topic grants.
2. **Device binding** — server stores license/device pairs and enforces `max_devices`.
3. **Video delivery** — HLS/DASH; Widevine license URL is supplied only through server configuration.
4. **No download UI** — the player exposes streaming playback only.
5. **Screen capture** — Android `FLAG_SECURE` blocks normal screenshots and most OS-level screen recording/casting paths.
6. **Forensic watermark** — server returns a short session/topic watermark ID; player moves it periodically.
7. **APK integrity hardening** — release minification/resource shrinking and private signing certificate.
8. **Secrets** — no DRM/storage/admin secrets are embedded in the APK.
9. **Updates** — backend provides version metadata and SHA-256 metadata; production host must use HTTPS.
10. **Progress** — best score is persisted locally and can be synced to the licensed student account.

## Production hardening still recommended
- verify app/device integrity on the backend (e.g. platform integrity attestation) before issuing sensitive grants;
- use short-lived signed CDN URLs or cookies;
- rotate backend keys;
- add audit logs/rate limits;
- use a managed DRM service if Widevine is required;
- never commit the signing keystore or production `.env` file.
