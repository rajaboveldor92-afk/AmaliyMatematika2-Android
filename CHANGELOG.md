# v0.8.0

- Fixed Kotlin 2.3 compiler configuration: migrated from deprecated/error `android.kotlinOptions { jvmTarget = "17" }` to top-level `kotlin { compilerOptions { jvmTarget.set(JvmTarget.JVM_17) } }`.
- versionCode 9, versionName 0.8.0.

# Changelog

## v0.7.0
- Added production account/activation screen in UZ/RU/EN.
- Added token/session persistence and expiry checks.
- Added backend license activation with maximum-device enforcement.
- Added topic-level protected video grant flow.
- Added progress synchronization endpoint/client.
- Added update metadata endpoint/client and APK URL handoff.
- Added self-hosted FastAPI/SQLite backend and Docker deployment.
- Added admin license and protected-stream registration endpoints.
- Kept `FLAG_SECURE`, dynamic watermarking, Media3 HLS/DASH/Widevine integration, R8 and no-backup configuration.
- Bumped Android version to 0.7.0 / versionCode 7.

## v0.6.0
- Persistent local progress and language.
- Backend data contracts and update-ready architecture.

Earlier releases added Chapters 1–4 interactive content.

## v0.7.1
- Added GitHub Actions workflow that builds an installable debug APK on an Android-capable runner.
- Workflow installs Android SDK 36/build-tools 36.0.0 and uses Gradle 8.13 + JDK 17.
- Version bumped to 0.7.1 (versionCode 8).

## v0.8.0
- Fixed GitHub Actions APK build environment.
- Added `android-actions/setup-android@v4` before `sdkmanager`.
- Updated Gradle setup action and enabled basic caching.
- Previous `exit code 127` / no Gradle results failure should now proceed to the actual Gradle build stage.
