# Amaliy Matematika 2 v0.8.0 — full textbook coverage

Source: `amaliy_matematika_2 (7).pdf`, 183 PDF pages.

The app now bundles **all 183 source pages** as optimized JPEG assets. Every learning topic has a dedicated **Kitob / Учебник / Textbook** tab that opens the exact original pages, preserving the source formula typesetting and figures. A selectable extracted-text view is also included for each topic.

| Topic | Source PDF pages | Pages bundled |
|---|---:|---:|
| 1.1 | 5–12 | 8 |
| 1.2 | 13–24 | 12 |
| 2.1 | 25–29 | 5 |
| 2.2 | 30–38 | 9 |
| 2.3 | 39–50 | 12 |
| 2.4 | 51–58 | 8 |
| 3.1 | 59 | 1 |
| 3.2 | 60–65 | 6 |
| 3.3 | 66–78 | 13 |
| 3.4 | 79–92 | 14 |
| 4.1 | 93–104 | 12 |
| 4.2 | 105–114 | 10 |
| 4.3 | 115–124 | 10 |
| 4.4 | 125–129 | 5 |
| 4.5 | 130–139 | 10 |
| 4.6 | 140–153 | 14 |
| 4.7 | 154–178 | 25 |
| Front matter | 1–4 | 4 |
| References + contents | 179–183 | 5 |

Total: **183 / 183 PDF pages bundled**.

## Lecture expansion

The existing 108 curated trilingual lecture blocks remain. In v0.8.0 each topic's Lecture tab additionally offers **Kitobdagi to‘liq matnni ochish**, which loads the complete text extracted from all source pages assigned to that topic. Because PDF text extraction can flatten mathematical layout, the exact original page rendering remains available in the Textbook tab.

## Formula rendering

Structured lecture formula cards now use a bundled offline WebView/MathJax renderer with a fallback to the original Unicode formula. The original source pages remain the exact reference for the textbook layout.

## Video lesson fallback

Each of the 17 topics already has UZ/RU/EN lesson scripts. When a production HLS/DASH/DRM video server is not configured, v0.8.0 now shows an offline interactive step-by-step lesson player instead of an empty video placeholder. This is not a rendered MP4; it is a usable in-app fallback until real hosted video assets are connected.
