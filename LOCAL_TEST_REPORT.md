# Local backend smoke-test report

Tested with FastAPI `TestClient` against a temporary SQLite database.

Passed:
- `/health`;
- license creation;
- activation on device D1;
- activation on device D2;
- rejection of device D3 for a 2-device license;
- protected video registration;
- authorized video grant;
- progress sync;
- update metadata.

No production secrets or real student data were used.
