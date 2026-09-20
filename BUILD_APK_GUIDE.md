# APK build guide — v0.8.0

The GitHub Actions workflow now explicitly sets up Android SDK command-line tools before calling `sdkmanager`. This fixes the previous `exit code 127` failure that occurred before Gradle started.

Workflow: `.github/workflows/build-apk.yml`

It builds:

`app/build/outputs/apk/debug/app-debug.apk`

## GitHub steps
1. Push the updated workflow to the repository.
2. Open **Actions** → **Build Android APK** → **Run workflow**.
3. Wait for the run to finish.
4. Download the `AmaliyMatematika2-debug-apk` artifact.
5. Unzip it and install `app-debug.apk` on Android.

If a later build fails inside Gradle, open the failed step and copy the first red error block; that will be a separate source/dependency issue rather than the previous missing-command problem.
