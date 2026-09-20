package com.rajabov.amaliymatematika2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object ApiClient {
    private fun baseUrl(): String = BuildConfig.CONTENT_API_BASE_URL.trimEnd('/')

    fun isConfigured(): Boolean = !baseUrl().contains("example.invalid") && baseUrl().startsWith("https://")

    suspend fun activate(request: ActivationRequest): Result<ActivationResponse> = withContext(Dispatchers.IO) {
        runCatching {
            val body = JSONObject()
                .put("licenseCode", request.licenseCode)
                .put("deviceTag", request.deviceTag)
                .put("appVersion", request.appVersion)
                .toString()
            val json = requestJson("POST", "/v1/activate", body = body)
            ActivationResponse(
                ok = json.optBoolean("ok", false),
                studentId = json.optNullableString("studentId"),
                accessToken = json.optNullableString("accessToken"),
                expiresAtEpochSeconds = if (json.has("expiresAtEpochSeconds") && !json.isNull("expiresAtEpochSeconds")) json.getLong("expiresAtEpochSeconds") else null,
                message = json.optNullableString("message")
            )
        }
    }

    suspend fun videoGrant(topicId: TopicId, accessToken: String): Result<ProtectedVideoGrant> = withContext(Dispatchers.IO) {
        runCatching {
            val json = requestJson("GET", "/v1/videos/${topicId.name}", bearer = accessToken)
            ProtectedVideoGrant(
                manifestUrl = json.getString("manifestUrl"),
                drmLicenseUrl = json.optNullableString("drmLicenseUrl"),
                expiresAtEpochSeconds = json.getLong("expiresAtEpochSeconds"),
                watermarkId = json.getString("watermarkId"),
                isDash = json.optBoolean("isDash", true)
            )
        }
    }

    suspend fun updateInfo(): Result<UpdateInfo> = withContext(Dispatchers.IO) {
        runCatching {
            val json = requestJson("GET", "/v1/update")
            UpdateInfo(
                versionCode = json.getInt("versionCode"),
                versionName = json.getString("versionName"),
                mandatory = json.optBoolean("mandatory", false),
                apkUrl = json.optNullableString("apkUrl"),
                sha256 = json.optNullableString("sha256"),
                releaseNotesUz = json.optNullableString("releaseNotesUz"),
                releaseNotesRu = json.optNullableString("releaseNotesRu"),
                releaseNotesEn = json.optNullableString("releaseNotesEn")
            )
        }
    }

    suspend fun syncProgress(topicId: TopicId, bestScore: Int, accessToken: String): Result<Int> = withContext(Dispatchers.IO) {
        runCatching {
            val body = JSONObject().put("topicId", topicId.name).put("bestScore", bestScore).toString()
            val json = requestJson("POST", "/v1/progress", body = body, bearer = accessToken)
            json.getInt("bestScore")
        }
    }

    private fun requestJson(method: String, path: String, body: String? = null, bearer: String? = null): JSONObject {
        val connection = (URL(baseUrl() + path).openConnection() as HttpURLConnection).apply {
            requestMethod = method
            connectTimeout = 10_000
            readTimeout = 15_000
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Content-Type", "application/json; charset=utf-8")
            if (!bearer.isNullOrBlank()) setRequestProperty("Authorization", "Bearer $bearer")
            if (body != null) {
                doOutput = true
                outputStream.use { it.write(body.toByteArray(Charsets.UTF_8)) }
            }
        }
        val status = connection.responseCode
        val stream = if (status in 200..299) connection.inputStream else connection.errorStream
        val text = BufferedReader(InputStreamReader(stream)).use { it.readText() }
        connection.disconnect()
        if (status !in 200..299) {
            val message = runCatching { JSONObject(text).optString("detail", text) }.getOrDefault(text)
            error("HTTP $status: $message")
        }
        return JSONObject(text)
    }

    private fun JSONObject.optNullableString(key: String): String? =
        if (!has(key) || isNull(key)) null else optString(key).takeIf { it.isNotBlank() }
}
