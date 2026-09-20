package com.rajabov.amaliymatematika2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private fun tr(lang: AppLanguage, uz: String, ru: String, en: String): String = when (lang) {
    AppLanguage.UZ -> uz
    AppLanguage.RU -> ru
    AppLanguage.EN -> en
}

@Composable
fun AccountScreen(lang: AppLanguage, prefs: AppPrefs, onBack: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var license by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }
    var busy by remember { mutableStateOf(false) }
    var student by remember { mutableStateOf(prefs.getLicensedStudent()) }
    var update by remember { mutableStateOf<UpdateInfo?>(null) }
    var updateError by remember { mutableStateOf<String?>(null) }

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth().padding(8.dp)) {
            TextButton(onClick = onBack) { Text(tr(lang, "Orqaga", "Назад", "Back")) }
            Text(tr(lang, "Hisob va himoya", "Аккаунт и защита", "Account & protection"), fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp))
        }
        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(tr(lang, "Aktivatsiya", "Активация", "Activation"), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(tr(lang, "Talaba: $student", "Студент: $student", "Student: $student"))
                    Text(tr(lang, "Qurilma: D-${prefs.deviceTag()}", "Устройство: D-${prefs.deviceTag()}", "Device: D-${prefs.deviceTag()}"), style = MaterialTheme.typography.bodySmall)
                    if (!ApiClient.isConfigured()) {
                        Text(tr(lang,
                            "Server manzili hali production domeniga almashtirilmagan. DEPLOYMENT.md bo‘yicha sozlang.",
                            "Адрес сервера ещё не заменён на production-домен. Настройте по DEPLOYMENT.md.",
                            "The server URL is not yet set to a production domain. Configure it using DEPLOYMENT.md."),
                            style = MaterialTheme.typography.bodySmall)
                    }
                    OutlinedTextField(
                        value = license,
                        onValueChange = { license = it.uppercase() },
                        label = { Text(tr(lang, "Litsenziya kodi", "Код лицензии", "License code")) },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        enabled = !busy && license.length >= 4 && ApiClient.isConfigured(),
                        onClick = {
                            busy = true; message = null
                            scope.launch {
                                val res = ApiClient.activate(ActivationRequest(license.trim(), prefs.deviceTag(), BuildConfig.VERSION_NAME))
                                res.onSuccess { r ->
                                    if (r.ok && !r.studentId.isNullOrBlank() && !r.accessToken.isNullOrBlank()) {
                                        prefs.setSession(r.studentId, r.accessToken, r.expiresAtEpochSeconds ?: 0L)
                                        student = r.studentId
                                        message = tr(lang, "Faollashtirildi.", "Активировано.", "Activated.")
                                    } else message = r.message ?: tr(lang, "Aktivatsiya rad etildi.", "Активация отклонена.", "Activation rejected.")
                                }.onFailure { message = it.message }
                                busy = false
                            }
                        }
                    ) { Text(if (busy) tr(lang, "Tekshirilmoqda…", "Проверка…", "Checking…") else tr(lang, "Faollashtirish", "Активировать", "Activate")) }
                    message?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                    if (prefs.accessToken().isNotBlank()) {
                        TextButton(onClick = { prefs.clearSession(); student = prefs.getLicensedStudent(); message = tr(lang,"Sessiya tozalandi.","Сессия очищена.","Session cleared.") }) {
                            Text(tr(lang, "Ushbu qurilmadagi sessiyani tozalash", "Очистить сессию на этом устройстве", "Clear session on this device"))
                        }
                    }
                }
            }

            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(tr(lang, "Yangilanish", "Обновление", "Update"), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text("${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})")
                    Button(enabled = !busy && ApiClient.isConfigured(), onClick = {
                        busy = true; updateError = null
                        scope.launch {
                            ApiClient.updateInfo().onSuccess { update = it }.onFailure { updateError = it.message }
                            busy = false
                        }
                    }) { Text(tr(lang,"Yangilanishni tekshirish","Проверить обновление","Check for updates")) }
                    update?.let { u ->
                        val note = when(lang) { AppLanguage.UZ -> u.releaseNotesUz; AppLanguage.RU -> u.releaseNotesRu; AppLanguage.EN -> u.releaseNotesEn }
                        Text(tr(lang, "Serverdagi versiya: ${u.versionName}", "Версия на сервере: ${u.versionName}", "Server version: ${u.versionName}"))
                        note?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                        if (u.versionCode > BuildConfig.VERSION_CODE && !u.apkUrl.isNullOrBlank()) {
                            Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(u.apkUrl))) }) {
                                Text(tr(lang,"Yangi APKni ochish","Открыть новый APK","Open new APK"))
                            }
                            Text(tr(lang,
                                "Android o‘rnatishni foydalanuvchining tasdig‘isiz yakunlamaydi.",
                                "Android не завершит установку без подтверждения пользователя.",
                                "Android will not complete installation without user confirmation."), style = MaterialTheme.typography.bodySmall)
                        } else if (u.versionCode <= BuildConfig.VERSION_CODE) {
                            Text(tr(lang,"Sizda oxirgi versiya.","У вас последняя версия.","You have the latest version."))
                        }
                    }
                    updateError?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                }
            }
        }
    }
}
