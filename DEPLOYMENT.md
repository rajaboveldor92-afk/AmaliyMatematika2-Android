# Production deployment checklist — v0.7.0

## 1. Backend
Use `backend/docker-compose.yml` on a VPS or cloud host. Before starting:
- set a long random `AM2_JWT_SECRET` (at least 32 bytes);
- set a long random `AM2_ADMIN_KEY`;
- expose the service only through HTTPS (reverse proxy such as Caddy/Nginx or managed HTTPS);
- back up `backend/data/am2.db`.

## 2. Issue licenses
Use the admin endpoint documented in `backend/README.md`. A license can be limited to 1, 2 or more devices. The default example is 2.

## 3. Video protection
Upload the rendered lesson videos to a professional streaming/CDN service. Configure protected HLS or DASH. If using Widevine, obtain the provider's license endpoint and register each topic with the backend admin endpoint.

The APK must never contain storage credentials, CDN signing keys, DRM secrets or the admin key.

## 4. Android build
Install Android Studio / Android SDK 36 and JDK 17-compatible tooling on the build computer. Add a private signing keystore outside the project repository.

Build against the real API domain:

```bash
./gradlew clean assembleRelease -PAM2_API_BASE_URL=https://api.example.com
```

Then sign/verify the release through your controlled Android build environment. Keep the signing key private and backed up.

## 5. Private update channel
Upload the signed APK to an HTTPS download location. Set `AM2_APK_URL` and `AM2_APK_SHA256` on the backend. The installed app checks `/v1/update`; when a newer version exists it can open the new APK URL. Android still requires the user to confirm installation for a privately distributed APK.

For Google Play distribution, use Play's update flow instead of a private APK URL.

## 6. Author-protection stack
Recommended combined protections:
- release signing certificate;
- R8/ProGuard;
- server-side license/device checks;
- short-lived video grants;
- protected HLS/DASH;
- Widevine where available;
- `FLAG_SECURE`;
- moving per-session watermark;
- no source code distributed to students.
