# Amaliy Matematika 2 — Android v0.8.0

Protected interactive learning application based on the supplied **Amaliy matematika 2** manual.

## Full textbook coverage
- 4 chapters / 17 topics.
- All **183 PDF pages** are bundled as optimized source-page images.
- Every topic has a **Kitob / Учебник / Textbook** tab with the exact original pages for that topic.
- Every topic also has searchable extracted source text.
- The Lecture tab keeps the structured UZ/RU/EN lecture blocks and can expand the complete original Uzbek textbook text for the topic.
- Original source pages are the authoritative view for formulas, figures and layout.

## Learning system retained
- 108 structured trilingual lecture blocks.
- 210 auto-checked quiz questions.
- 99 UZ/RU/EN glossary entries.
- Topic-specific interactive trainers.
- 51 trilingual video lesson scripts under `app/src/main/assets/video_scripts/`.

## v0.8.0 presentation improvements
- Structured formula cards now use a bundled offline MathJax/WebView renderer, with the original Unicode expression as fallback.
- Exact book pages preserve the source formula typesetting offline.
- The Video tab no longer becomes an empty placeholder when no production server is configured: it shows a usable offline step-by-step interactive lesson from the bundled script.
- Real narrated MP4/HLS video assets are still external production inputs and can replace the scripted fallback through the existing protected Media3 flow.

## Protection / production architecture
- account / license activation screen;
- device-tag binding and server-side device limit;
- signed bearer tokens;
- protected per-topic video grants;
- HLS/DASH and Widevine-ready Media3 player;
- dynamic forensic watermark;
- `FLAG_SECURE`;
- local + server progress synchronization;
- update check and new-APK handoff;
- FastAPI + SQLite backend under `backend/`.

## Configure Android app

```bash
./gradlew assembleRelease -PAM2_API_BASE_URL=https://api.example.com
```

The app does not treat `example.invalid` as a production API.

## Build status
The source is prepared for the GitHub Actions build workflow in `.github/workflows/build-apk.yml`. The working container used to prepare this package does not include a complete Android/Gradle toolchain, so the final APK still needs to be built through GitHub Actions or Android Studio.

See `FULL_BOOK_COVERAGE.md` and `STATUS_V080.md`.
