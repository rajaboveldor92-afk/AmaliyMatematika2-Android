# Build fix v0.7.4

GitHub Actions build #5 failed at `:app:checkDebugAarMetadata` because the 2026.09 Compose BOM resolved Compose 1.12.1, which requires compileSdk 37 and AGP 9.1+, while this project intentionally builds with compileSdk 36 and AGP 8.13.2.

Fixes in v0.7.4:
- Compose BOM pinned to `2025.12.00` (Compose 1.10 generation, compatible with the API 36 toolchain used here).
- `activity-compose` pinned to `1.12.4`.
- Lifecycle pinned to `2.10.0` for both runtime KTX and runtime Compose.
- `core-ktx` pinned to `1.17.0`.
- compileSdk/targetSdk remain 36 and AGP remains 8.13.2.
- versionCode 10 / versionName 0.7.4.
