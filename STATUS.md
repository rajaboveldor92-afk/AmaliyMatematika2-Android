# Exact status — v0.8.0

## Implemented in source
- Chapters 1–4, 17 topics.
- Existing Uzbek / Russian / English structured lecture content retained.
- **183 / 183 source PDF pages bundled** for full source coverage.
- Topic-level Textbook tab with original pages and selectable extracted source text.
- Complete original Uzbek topic text expandable from the Lecture tab.
- Bundled offline MathJax/WebView formula rendering for structured formula cards, with Unicode fallback.
- 210 quiz questions, 99 glossary terms, interactive topic trainers retained.
- 51 UZ/RU/EN video scripts retained.
- Offline scripted interactive video-lesson fallback added for every topic/language.
- Account / activation, device licensing, token persistence, progress sync and update path retained.
- Media3 HLS/DASH + Widevine integration retained.
- `FLAG_SECURE`, dynamic watermark and R8/ProGuard configuration retained.
- FastAPI + SQLite backend retained.

## Important language scope
The structured lesson UI/lecture blocks/tests/glossary remain trilingual. The newly bundled **complete source textbook text and exact page images are the original Uzbek source**, not a full page-by-page Russian/English translation. A full professionally edited RU/EN translation of all 183 pages is a separate editorial/translation pass.

## External production inputs still required
- Real narrated video files encoded/hosted as HLS/DASH or MP4.
- HTTPS production backend/domain.
- Widevine-capable DRM provider if DRM is required.
- Publisher release signing keystore.
- Android build environment / GitHub Actions run for an installable APK.

The package contains no production secrets or private signing keys.
