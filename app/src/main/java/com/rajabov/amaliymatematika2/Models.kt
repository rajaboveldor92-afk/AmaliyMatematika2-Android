package com.rajabov.amaliymatematika2

enum class AppLanguage(val code: String, val display: String) {
    UZ("uz", "O‘zbek"),
    RU("ru", "Русский"),
    EN("en", "English")
}

enum class TopicId {
    TOPIC_1_1,
    TOPIC_1_2,
    TOPIC_2_1,
    TOPIC_2_2,
    TOPIC_2_3,
    TOPIC_2_4,
    TOPIC_3_1,
    TOPIC_3_2,
    TOPIC_3_3,
    TOPIC_3_4,
    TOPIC_4_1,
    TOPIC_4_2,
    TOPIC_4_3,
    TOPIC_4_4,
    TOPIC_4_5,
    TOPIC_4_6,
    TOPIC_4_7
}

data class TriText(
    val uz: String,
    val ru: String,
    val en: String
) {
    fun get(lang: AppLanguage): String = when (lang) {
        AppLanguage.UZ -> uz
        AppLanguage.RU -> ru
        AppLanguage.EN -> en
    }
}

data class LectureSection(
    val title: TriText,
    val body: TriText,
    val formula: String? = null
)

data class GlossaryTerm(
    val uz: String,
    val ru: String,
    val en: String,
    val note: TriText? = null
)

data class QuizQuestion(
    val id: String,
    val prompt: TriText,
    val answers: List<TriText>,
    val correctIndex: Int,
    val explanation: TriText
)

data class VideoLesson(
    val manifestUrl: String,
    val drmLicenseUrl: String? = null,
    val isDash: Boolean = false
)

data class TopicContent(
    val id: TopicId,
    val title: TriText,
    val summary: TriText,
    val sections: List<LectureSection>,
    val quiz: List<QuizQuestion>,
    val video: VideoLesson
)
