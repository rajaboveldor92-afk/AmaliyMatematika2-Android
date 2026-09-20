package com.rajabov.amaliymatematika2

import android.content.Context
import android.provider.Settings
import java.security.MessageDigest

/** Local-only persistence. Production identity/license validation must come from the backend. */
class AppPrefs(private val context: Context) {
    private val prefs = context.getSharedPreferences("am2_prefs", Context.MODE_PRIVATE)

    fun getLanguage(): AppLanguage? = prefs.getString("language", null)?.let { code ->
        AppLanguage.entries.firstOrNull { it.code == code }
    }

    fun setLanguage(lang: AppLanguage) {
        prefs.edit().putString("language", lang.code).apply()
    }

    fun getBest(topic: TopicId): Int = prefs.getInt("best_${topic.name}", 0)

    fun setBest(topic: TopicId, score: Int) {
        prefs.edit().putInt("best_${topic.name}", score).apply()
    }

    fun setLicensedStudent(studentId: String) {
        prefs.edit().putString("student_id", studentId.trim()).apply()
    }

    fun setSession(studentId: String, accessToken: String, expiresAtEpochSeconds: Long) {
        prefs.edit()
            .putString("student_id", studentId.trim())
            .putString("access_token", accessToken)
            .putLong("access_token_exp", expiresAtEpochSeconds)
            .apply()
    }

    fun accessToken(): String = prefs.getString("access_token", "") ?: ""
    fun accessTokenExpiry(): Long = prefs.getLong("access_token_exp", 0L)
    fun hasUsableSession(nowEpochSeconds: Long = System.currentTimeMillis() / 1000): Boolean =
        accessToken().isNotBlank() && (accessTokenExpiry() == 0L || accessTokenExpiry() > nowEpochSeconds + 60)

    fun clearSession() {
        prefs.edit().remove("student_id").remove("access_token").remove("access_token_exp").apply()
    }

    fun getLicensedStudent(): String = prefs.getString("student_id", "UNACTIVATED") ?: "UNACTIVATED"

    fun deviceTag(): String {
        val raw = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: "unknown-device"
        val digest = MessageDigest.getInstance("SHA-256").digest(raw.toByteArray())
        return digest.take(4).joinToString("") { "%02x".format(it) }.uppercase()
    }

    fun watermarkTag(): String = "AM2 • ${getLicensedStudent()} • D-${deviceTag()}"
}
