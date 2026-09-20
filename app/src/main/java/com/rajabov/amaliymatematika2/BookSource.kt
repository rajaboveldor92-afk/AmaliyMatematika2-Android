package com.rajabov.amaliymatematika2

data class BookPageRange(val start: Int, val end: Int) {
    val count: Int get() = end - start + 1
}

object BookSource {
    const val TOTAL_PAGES = 183

    fun pageRange(topicId: TopicId): BookPageRange = when (topicId) {
        TopicId.TOPIC_1_1 -> BookPageRange(5, 12)
        TopicId.TOPIC_1_2 -> BookPageRange(13, 24)
        TopicId.TOPIC_2_1 -> BookPageRange(25, 29)
        TopicId.TOPIC_2_2 -> BookPageRange(30, 38)
        TopicId.TOPIC_2_3 -> BookPageRange(39, 50)
        TopicId.TOPIC_2_4 -> BookPageRange(51, 58)
        TopicId.TOPIC_3_1 -> BookPageRange(59, 59)
        TopicId.TOPIC_3_2 -> BookPageRange(60, 65)
        TopicId.TOPIC_3_3 -> BookPageRange(66, 78)
        TopicId.TOPIC_3_4 -> BookPageRange(79, 92)
        TopicId.TOPIC_4_1 -> BookPageRange(93, 104)
        TopicId.TOPIC_4_2 -> BookPageRange(105, 114)
        TopicId.TOPIC_4_3 -> BookPageRange(115, 124)
        TopicId.TOPIC_4_4 -> BookPageRange(125, 129)
        TopicId.TOPIC_4_5 -> BookPageRange(130, 139)
        TopicId.TOPIC_4_6 -> BookPageRange(140, 153)
        TopicId.TOPIC_4_7 -> BookPageRange(154, 178)
    }

    fun pageAsset(page: Int): String = "book_pages/page_${page.toString().padStart(3, '0')}.jpg"

    fun topicTextAsset(topicId: TopicId): String = when (topicId) {
        TopicId.TOPIC_1_1 -> "book_text/topic_1_1_uz.txt"
        TopicId.TOPIC_1_2 -> "book_text/topic_1_2_uz.txt"
        TopicId.TOPIC_2_1 -> "book_text/topic_2_1_uz.txt"
        TopicId.TOPIC_2_2 -> "book_text/topic_2_2_uz.txt"
        TopicId.TOPIC_2_3 -> "book_text/topic_2_3_uz.txt"
        TopicId.TOPIC_2_4 -> "book_text/topic_2_4_uz.txt"
        TopicId.TOPIC_3_1 -> "book_text/topic_3_1_uz.txt"
        TopicId.TOPIC_3_2 -> "book_text/topic_3_2_uz.txt"
        TopicId.TOPIC_3_3 -> "book_text/topic_3_3_uz.txt"
        TopicId.TOPIC_3_4 -> "book_text/topic_3_4_uz.txt"
        TopicId.TOPIC_4_1 -> "book_text/topic_4_1_uz.txt"
        TopicId.TOPIC_4_2 -> "book_text/topic_4_2_uz.txt"
        TopicId.TOPIC_4_3 -> "book_text/topic_4_3_uz.txt"
        TopicId.TOPIC_4_4 -> "book_text/topic_4_4_uz.txt"
        TopicId.TOPIC_4_5 -> "book_text/topic_4_5_uz.txt"
        TopicId.TOPIC_4_6 -> "book_text/topic_4_6_uz.txt"
        TopicId.TOPIC_4_7 -> "book_text/topic_4_7_uz.txt"
    }
}
