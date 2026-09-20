package com.rajabov.amaliymatematika2

/**
 * Production backend contracts. No secret is embedded in the APK.
 * The real service must validate app signature/Play Integrity, license and device limits.
 */
data class ActivationRequest(
    val licenseCode: String,
    val deviceTag: String,
    val appVersion: String
)

data class ActivationResponse(
    val ok: Boolean,
    val studentId: String?,
    val accessToken: String?,
    val expiresAtEpochSeconds: Long?,
    val message: String?
)

data class ProtectedVideoGrant(
    val manifestUrl: String,
    val drmLicenseUrl: String?,
    val expiresAtEpochSeconds: Long,
    val watermarkId: String,
    val isDash: Boolean = true
)

data class UpdateInfo(
    val versionCode: Int,
    val versionName: String,
    val mandatory: Boolean,
    val apkUrl: String?,
    val sha256: String?,
    val releaseNotesUz: String?,
    val releaseNotesRu: String?,
    val releaseNotesEn: String?
)
