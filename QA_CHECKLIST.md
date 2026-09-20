# QA checklist — v0.7.0

## Content layer
- [x] Chapters 1–4 remain present.
- [x] 17 topic IDs remain present.
- [x] UZ/RU/EN content structure retained.
- [x] Quiz bank retained from v0.6.0.

## Android source
- [x] versionName = 0.7.0, versionCode = 7.
- [x] INTERNET permission present.
- [x] backups disabled.
- [x] cleartext traffic disabled.
- [x] `FLAG_SECURE` present.
- [x] API base URL configurable by Gradle property.
- [x] account/activation screen added.
- [x] protected video grant client added.
- [x] progress sync client added.
- [x] update checker/client added.

## Backend runtime test
- [x] health endpoint returns OK.
- [x] admin can create a license.
- [x] first and second device activation accepted for a 2-device license.
- [x] third device activation rejected.
- [x] admin can register a protected stream.
- [x] licensed client receives a protected video grant.
- [x] progress upsert returns best score.
- [x] update endpoint returns v0.7.0 metadata.

## Not verifiable in this environment
- [ ] Android Gradle compilation (Android SDK/build-tools absent).
- [ ] release APK signing (publisher keystore not supplied).
- [ ] real Widevine playback (provider/license server not supplied).
- [ ] production HTTPS/CDN behavior (public domain not supplied).
