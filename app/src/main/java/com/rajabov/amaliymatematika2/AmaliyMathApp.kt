package com.rajabov.amaliymatematika2

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.*
import kotlin.random.Random

private enum class AppScreen { LANGUAGE, HOME, CHAPTER1, CHAPTER2, CHAPTER3, CHAPTER4, TOPIC, GLOSSARY, ACCOUNT, ABOUT, FULL_BOOK }
private enum class TopicTab { LECTURE, BOOK, VIDEO, PRACTICE, TEST }

@Composable
fun AmaliyMathApp() {
    val context = LocalContext.current
    val prefs = remember { AppPrefs(context) }
    val appScope = rememberCoroutineScope()
    val savedLanguage = remember { prefs.getLanguage() }
    var language by rememberSaveable { mutableStateOf<AppLanguage?>(savedLanguage) }
    var screen by rememberSaveable { mutableStateOf(if (savedLanguage == null) AppScreen.LANGUAGE else AppScreen.HOME) }
    var selectedTopic by rememberSaveable { mutableStateOf(TopicId.TOPIC_1_1) }
    var best11 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_1_1)) }
    var best12 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_1_2)) }
    var best21 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_2_1)) }
    var best22 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_2_2)) }
    var best23 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_2_3)) }
    var best24 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_2_4)) }
    var best31 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_3_1)) }
    var best32 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_3_2)) }
    var best33 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_3_3)) }
    var best34 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_3_4)) }
    var best41 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_1)) }
    var best42 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_2)) }
    var best43 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_3)) }
    var best44 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_4)) }
    var best45 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_5)) }
    var best46 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_6)) }
    var best47 by rememberSaveable { mutableIntStateOf(prefs.getBest(TopicId.TOPIC_4_7)) }

    fun bestFor(id: TopicId): Int = when (id) {
        TopicId.TOPIC_1_1 -> best11; TopicId.TOPIC_1_2 -> best12
        TopicId.TOPIC_2_1 -> best21; TopicId.TOPIC_2_2 -> best22
        TopicId.TOPIC_2_3 -> best23; TopicId.TOPIC_2_4 -> best24
        TopicId.TOPIC_3_1 -> best31; TopicId.TOPIC_3_2 -> best32
        TopicId.TOPIC_3_3 -> best33; TopicId.TOPIC_3_4 -> best34
        TopicId.TOPIC_4_1 -> best41; TopicId.TOPIC_4_2 -> best42; TopicId.TOPIC_4_3 -> best43
        TopicId.TOPIC_4_4 -> best44; TopicId.TOPIC_4_5 -> best45; TopicId.TOPIC_4_6 -> best46; TopicId.TOPIC_4_7 -> best47
    }

    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            when (screen) {
                AppScreen.LANGUAGE -> LanguageScreen { lang -> prefs.setLanguage(lang); language = lang; screen = AppScreen.HOME }
                AppScreen.HOME -> HomeScreen(
                    lang = language ?: AppLanguage.UZ,
                    chapter1Progress = listOf(best11,best12),
                    chapter2Progress = listOf(best21,best22,best23,best24),
                    chapter3Progress = listOf(best31,best32,best33,best34),
                    chapter4Progress = listOf(best41,best42,best43,best44,best45,best46,best47),
                    onLanguage = { screen = AppScreen.LANGUAGE },
                    onChapter1 = { screen = AppScreen.CHAPTER1 },
                    onChapter2 = { screen = AppScreen.CHAPTER2 },
                    onChapter3 = { screen = AppScreen.CHAPTER3 },
                    onChapter4 = { screen = AppScreen.CHAPTER4 },
                    onGlossary = { screen = AppScreen.GLOSSARY },
                    onFullBook = { screen = AppScreen.FULL_BOOK },
                    onAccount = { screen = AppScreen.ACCOUNT },
                    onAbout = { screen = AppScreen.ABOUT }
                )
                AppScreen.CHAPTER1 -> ChapterScreen(
                    language ?: AppLanguage.UZ, ContentRepository.chapter1, ContentRepository.chapter1Topics, { id -> bestFor(id) },
                    onBack = { screen = AppScreen.HOME },
                    onTopic = { selectedTopic = it; screen = AppScreen.TOPIC }
                )
                AppScreen.CHAPTER2 -> ChapterScreen(
                    lang = language ?: AppLanguage.UZ,
                    title = ContentRepository.chapter2,
                    topics = ContentRepository.chapter2Topics,
                    bestFor = { id -> bestFor(id) },
                    onBack = { screen = AppScreen.HOME },
                    onTopic = { selectedTopic = it; screen = AppScreen.TOPIC }
                )
                AppScreen.CHAPTER3 -> ChapterScreen(
                    lang = language ?: AppLanguage.UZ,
                    title = ContentRepository.chapter3,
                    topics = ContentRepository.chapter3Topics,
                    bestFor = { id -> bestFor(id) },
                    onBack = { screen = AppScreen.HOME },
                    onTopic = { selectedTopic = it; screen = AppScreen.TOPIC }
                )
                AppScreen.CHAPTER4 -> ChapterScreen(
                    lang = language ?: AppLanguage.UZ,
                    title = ContentRepository.chapter4,
                    topics = ContentRepository.chapter4Topics,
                    bestFor = { id -> bestFor(id) },
                    onBack = { screen = AppScreen.HOME },
                    onTopic = { selectedTopic = it; screen = AppScreen.TOPIC }
                )
                AppScreen.TOPIC -> TopicScreen(
                    lang = language ?: AppLanguage.UZ,
                    topicId = selectedTopic,
                    bestScore = bestFor(selectedTopic),
                    onBestScore = { score ->
                        when(selectedTopic) {
                            TopicId.TOPIC_1_1 -> { best11=maxOf(best11,score); prefs.setBest(TopicId.TOPIC_1_1, best11) }
                            TopicId.TOPIC_1_2 -> { best12=maxOf(best12,score); prefs.setBest(TopicId.TOPIC_1_2, best12) }
                            TopicId.TOPIC_2_1 -> { best21=maxOf(best21,score); prefs.setBest(TopicId.TOPIC_2_1, best21) }
                            TopicId.TOPIC_2_2 -> { best22=maxOf(best22,score); prefs.setBest(TopicId.TOPIC_2_2, best22) }
                            TopicId.TOPIC_2_3 -> { best23=maxOf(best23,score); prefs.setBest(TopicId.TOPIC_2_3, best23) }
                            TopicId.TOPIC_2_4 -> { best24=maxOf(best24,score); prefs.setBest(TopicId.TOPIC_2_4, best24) }
                            TopicId.TOPIC_3_1 -> { best31=maxOf(best31,score); prefs.setBest(TopicId.TOPIC_3_1, best31) }
                            TopicId.TOPIC_3_2 -> { best32=maxOf(best32,score); prefs.setBest(TopicId.TOPIC_3_2, best32) }
                            TopicId.TOPIC_3_3 -> { best33=maxOf(best33,score); prefs.setBest(TopicId.TOPIC_3_3, best33) }
                            TopicId.TOPIC_3_4 -> { best34=maxOf(best34,score); prefs.setBest(TopicId.TOPIC_3_4, best34) }
                            TopicId.TOPIC_4_1 -> { best41=maxOf(best41,score); prefs.setBest(TopicId.TOPIC_4_1, best41) }
                            TopicId.TOPIC_4_2 -> { best42=maxOf(best42,score); prefs.setBest(TopicId.TOPIC_4_2, best42) }
                            TopicId.TOPIC_4_3 -> { best43=maxOf(best43,score); prefs.setBest(TopicId.TOPIC_4_3, best43) }
                            TopicId.TOPIC_4_4 -> { best44=maxOf(best44,score); prefs.setBest(TopicId.TOPIC_4_4, best44) }
                            TopicId.TOPIC_4_5 -> { best45=maxOf(best45,score); prefs.setBest(TopicId.TOPIC_4_5, best45) }
                            TopicId.TOPIC_4_6 -> { best46=maxOf(best46,score); prefs.setBest(TopicId.TOPIC_4_6, best46) }
                            TopicId.TOPIC_4_7 -> { best47=maxOf(best47,score); prefs.setBest(TopicId.TOPIC_4_7, best47) }
                        }
                        if (prefs.hasUsableSession() && ApiClient.isConfigured()) {
                            appScope.launch {
                                ApiClient.syncProgress(selectedTopic, bestFor(selectedTopic), prefs.accessToken())
                            }
                        }
                    },
                    onBack = {
                        screen = when {
                            selectedTopic.name.startsWith("TOPIC_4") -> AppScreen.CHAPTER4
                            selectedTopic.name.startsWith("TOPIC_3") -> AppScreen.CHAPTER3
                            selectedTopic.name.startsWith("TOPIC_2") -> AppScreen.CHAPTER2
                            else -> AppScreen.CHAPTER1
                        }
                    }
                )
                AppScreen.GLOSSARY -> GlossaryScreen(language ?: AppLanguage.UZ) { screen = AppScreen.HOME }
                AppScreen.ACCOUNT -> AccountScreen(language ?: AppLanguage.UZ, prefs) { screen = AppScreen.HOME }
                AppScreen.ABOUT -> AboutScreen(language ?: AppLanguage.UZ) { screen = AppScreen.HOME }
                AppScreen.FULL_BOOK -> FullBookScreen(language ?: AppLanguage.UZ) { screen = AppScreen.HOME }
            }
        }
    }
}

@Composable
private fun LanguageScreen(onSelect: (AppLanguage) -> Unit) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Language, null, modifier = Modifier.size(64.dp))
        Spacer(Modifier.height(16.dp))
        Text("Tilni tanlang / Выберите язык / Choose language", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))
        AppLanguage.entries.forEach { lang ->
            Button(onClick = { onSelect(lang) }, modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                Text(lang.display, fontSize = 18.sp)
            }
        }
    }
}

@Composable
private fun HomeScreen(
    lang: AppLanguage,
    chapter1Progress: List<Int>,
    chapter2Progress: List<Int>,
    chapter3Progress: List<Int>,
    chapter4Progress: List<Int>,
    onLanguage: () -> Unit,
    onChapter1: () -> Unit,
    onChapter2: () -> Unit,
    onChapter3: () -> Unit,
    onChapter4: () -> Unit,
    onGlossary: () -> Unit,
    onFullBook: () -> Unit,
    onAccount: () -> Unit,
    onAbout: () -> Unit
) {
    val labels = uiLabels(lang)
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(ContentRepository.appTitle.get(lang), style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                    Text("E.O. Rajabov • Sh.R. Ergashova • S.G‘. To‘ychiyev")
                    Text(titleFor(lang,"v0.8.0 • 183 sahifa • professional formula • interaktiv video-dars","v0.8.0 • 183 страницы • профессиональные формулы • интерактивный видео-урок","v0.8.0 • 183 pages • professional formulas • interactive video lesson"), style=MaterialTheme.typography.bodySmall)
                }
                IconButton(onClick = onLanguage) { Icon(Icons.Default.Translate, labels.changeLanguage) }
            }
        }
        item {
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(titleFor(lang,"Kitobning to‘liq qamrovi","Полное покрытие учебника","Full textbook coverage"), fontWeight=FontWeight.Bold)
                    Text(titleFor(lang,"Qo‘llanmaning barcha 183 PDF sahifasi ilovaga kiritildi. Har bir mavzuda asl sahifalar va qidiriladigan matn mavjud.","В приложение включены все 183 страницы пособия. В каждой теме доступны исходные страницы и текст для поиска.","All 183 textbook pages are bundled in the app. Each topic includes the source pages and searchable text."))
                    Button(onClick=onChapter4){ Text(titleFor(lang,"4-bobni ochish","Открыть главу 4","Open Chapter 4")) }
                    OutlinedButton(onClick=onFullBook){ Text(titleFor(lang,"To‘liq 183 sahifali kitob","Полный учебник: 183 страницы","Full 183-page textbook")) }
                }
            }
        }
        item { Text(labels.chapters, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) }
        items(ContentRepository.chapters.indices.toList()) { i ->
            val action = when(i){0->onChapter1;1->onChapter2;2->onChapter3;3->onChapter4;else->null}
            OutlinedCard(Modifier.fillMaxWidth()) {
                Row(Modifier.padding(16.dp), verticalAlignment=Alignment.CenterVertically) {
                    Icon(Icons.Default.Book,null); Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(ContentRepository.chapters[i].get(lang), fontWeight=FontWeight.SemiBold)
                        when(i){
                            0 -> Text("1.1 ${chapter1Progress[0]}/20 • 1.2 ${chapter1Progress[1]}/20", style=MaterialTheme.typography.bodySmall)
                            1 -> Text("2.1 ${chapter2Progress[0]}/10 • 2.2 ${chapter2Progress[1]}/10 • 2.3 ${chapter2Progress[2]}/10 • 2.4 ${chapter2Progress[3]}/10", style=MaterialTheme.typography.bodySmall)
                            2 -> Text("3.1 ${chapter3Progress[0]}/15 • 3.2 ${chapter3Progress[1]}/15 • 3.3 ${chapter3Progress[2]}/15 • 3.4 ${chapter3Progress[3]}/15", style=MaterialTheme.typography.bodySmall)
                            3 -> Text("4.1 ${chapter4Progress[0]}/10 • 4.2 ${chapter4Progress[1]}/10 • 4.3 ${chapter4Progress[2]}/10 • 4.4 ${chapter4Progress[3]}/10 • 4.5 ${chapter4Progress[4]}/10 • 4.6 ${chapter4Progress[5]}/10 • 4.7 ${chapter4Progress[6]}/10", style=MaterialTheme.typography.bodySmall)
                            else -> Text(labels.comingNext, style=MaterialTheme.typography.bodySmall)
                        }
                    }
                    if(action!=null) TextButton(onClick=action){Text(labels.open)}
                }
            }
        }
        item {
            Column(Modifier.fillMaxWidth(), verticalArrangement=Arrangement.spacedBy(8.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick=onGlossary, modifier=Modifier.weight(1f)){Icon(Icons.Default.School,null);Spacer(Modifier.width(6.dp));Text(labels.glossary)}
                    OutlinedButton(onClick=onAbout, modifier=Modifier.weight(1f)){Icon(Icons.Default.Security,null);Spacer(Modifier.width(6.dp));Text(labels.about)}
                }
                OutlinedButton(onClick=onAccount, modifier=Modifier.fillMaxWidth()){
                    Icon(Icons.Default.Security,null);Spacer(Modifier.width(6.dp));
                    Text(titleFor(lang,"Hisob / Aktivatsiya / Yangilanish","Аккаунт / Активация / Обновление","Account / Activation / Update"))
                }
            }
        }
    }
}

@Composable
private fun ChapterScreen(
    lang: AppLanguage,
    title: TriText,
    topics: List<TopicContent>,
    bestFor: (TopicId)->Int,
    onBack: () -> Unit,
    onTopic: (TopicId) -> Unit
) {
    val labels=uiLabels(lang)
    Column(Modifier.fillMaxSize()) {
        HeaderRow(title.get(lang), labels.back, onBack)
        LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement=Arrangement.spacedBy(12.dp)) {
            items(topics){topic ->
                val best=bestFor(topic.id)
                ElevatedCard(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement=Arrangement.spacedBy(8.dp)) {
                        Text(topic.title.get(lang), style=MaterialTheme.typography.titleMedium, fontWeight=FontWeight.Bold)
                        Text(topic.summary.get(lang))
                        LinearProgressIndicator(progress={ (best/topic.quiz.size.toFloat()).coerceIn(0f,1f)},modifier=Modifier.fillMaxWidth())
                        Text(labels.bestScore(best,topic.quiz.size),style=MaterialTheme.typography.bodySmall)
                        Button(onClick={onTopic(topic.id)}){Text(labels.openTopic)}
                    }
                }
            }
        }
    }
}

@Composable
private fun HeaderRow(title: String, backLabel: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, backLabel) }
        Text(title, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun TopicScreen(
    lang: AppLanguage,
    topicId: TopicId,
    bestScore: Int,
    onBestScore: (Int) -> Unit,
    onBack: () -> Unit
) {
    val topic = ContentRepository.topic(topicId)
    var tab by rememberSaveable(topicId) { mutableStateOf(TopicTab.LECTURE) }
    val labels = uiLabels(lang)

    Column(Modifier.fillMaxSize()) {
        HeaderRow(topic.title.get(lang), labels.back, onBack)
        if (bestScore > 0) {
            Text(
                labels.bestScore(bestScore, topic.quiz.size),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
        ScrollableTabRow(selectedTabIndex = tab.ordinal) {
            TopicTab.entries.forEach { t ->
                Tab(selected = tab == t, onClick = { tab = t }, text = { Text(labels.tabName(t)) })
            }
        }
        when (tab) {
            TopicTab.LECTURE -> LectureTab(topic, lang)
            TopicTab.BOOK -> BookTopicTab(topicId, lang)
            TopicTab.VIDEO -> VideoTab(topic, lang)
            TopicTab.PRACTICE -> when (topicId) {
                TopicId.TOPIC_1_1 -> Topic11Practice(lang)
                TopicId.TOPIC_1_2 -> Topic12Practice(lang)
                TopicId.TOPIC_2_1 -> Topic21Practice(lang)
                TopicId.TOPIC_2_2 -> Topic22Practice(lang)
                TopicId.TOPIC_2_3 -> Topic23Practice(lang)
                TopicId.TOPIC_2_4 -> Topic24Practice(lang)
                TopicId.TOPIC_3_1 -> Topic31Practice(lang)
                TopicId.TOPIC_3_2 -> Topic32Practice(lang)
                TopicId.TOPIC_3_3 -> Topic33Practice(lang)
                TopicId.TOPIC_3_4 -> Topic34Practice(lang)
                TopicId.TOPIC_4_1 -> Topic41Practice(lang)
                TopicId.TOPIC_4_2 -> Topic42Practice(lang)
                TopicId.TOPIC_4_3 -> Topic43Practice(lang)
                TopicId.TOPIC_4_4 -> Topic44Practice(lang)
                TopicId.TOPIC_4_5 -> Topic45Practice(lang)
                TopicId.TOPIC_4_6 -> Topic46Practice(lang)
                TopicId.TOPIC_4_7 -> Topic47Practice(lang)
            }
            TopicTab.TEST -> QuizTab(topic.quiz, lang, onBestScore)
        }
    }
}

@Composable
private fun LectureTab(topic: TopicContent, lang: AppLanguage) {
    val context = LocalContext.current
    var showFullText by rememberSaveable(topic.id) { mutableStateOf(false) }
    val fullText = remember(topic.id) {
        runCatching { context.assets.open(BookSource.topicTextAsset(topic.id)).bufferedReader().use { it.readText() } }.getOrDefault("")
    }
    val pageChunks = remember(fullText) {
        fullText.split("===== PDF SAHIFA ").map { it.trim() }.filter { it.isNotBlank() }
    }
    val range = remember(topic.id) { BookSource.pageRange(topic.id) }
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item { Text(topic.summary.get(lang), style = MaterialTheme.typography.bodyLarge) }
        item {
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(titleFor(lang,"Kitob bilan to‘liq qamrov","Полное покрытие учебника","Full textbook coverage"), fontWeight=FontWeight.Bold)
                    Text(titleFor(lang,
                        "Bu mavzu qo‘llanmaning ${range.start}-${range.end}-PDF sahifalarini qamrab oladi. Quyidagi asosiy ma’ruza bloklaridan tashqari kitobning to‘liq asl matnini ham shu oynada ochishingiz mumkin.",
                        "Тема охватывает PDF-страницы ${range.start}-${range.end}. Помимо структурированных блоков лекции здесь можно открыть полный оригинальный текст пособия.",
                        "This topic covers PDF pages ${range.start}-${range.end}. In addition to the structured lecture blocks, you can open the complete original textbook text here."))
                    OutlinedButton(onClick={showFullText=!showFullText}) {
                        Text(if(showFullText) titleFor(lang,"To‘liq matnni yopish","Скрыть полный текст","Hide full text") else titleFor(lang,"Kitobdagi to‘liq matnni ochish","Открыть полный текст","Open full textbook text"))
                    }
                }
            }
        }
        items(topic.sections) { section ->
            SectionCard(section.title.get(lang), section.body.get(lang), section.formula)
        }
        if (showFullText) {
            item {
                Text(titleFor(lang,
                    "Asl qo‘llanma matni (o‘zbekcha). Formulalarning aniq terilishi uchun «Kitob» yorlig‘idagi asl sahifalardan foydalaning.",
                    "Оригинальный текст пособия (узбекский). Для точного набора формул используйте вкладку «Учебник».",
                    "Original textbook text (Uzbek). For exact formula typesetting use the Textbook tab."),
                    style=MaterialTheme.typography.bodySmall)
            }
            items(pageChunks) { chunk ->
                ElevatedCard(Modifier.fillMaxWidth()) {
                    androidx.compose.foundation.text.selection.SelectionContainer {
                        Text(chunk, modifier=Modifier.padding(14.dp), style=MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionCard(title: String, body: String, formula: String? = null) {
    ElevatedCard(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            if (!formula.isNullOrBlank()) {
                Spacer(Modifier.height(8.dp))
                ProfessionalFormula(formula)
            }
            Spacer(Modifier.height(8.dp))
            Text(body, style = MaterialTheme.typography.bodyLarge)
        }
    }
}


@Composable
private fun ProfessionalFormula(raw: String) {
    val latex = remember(raw) { basicLatex(raw) }
    val fallback = remember(raw) { htmlEscape(raw) }
    AndroidView(
        factory = { ctx ->
            android.webkit.WebView(ctx).apply {
                setBackgroundColor(android.graphics.Color.TRANSPARENT)
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                isVerticalScrollBarEnabled = false
                isHorizontalScrollBarEnabled = false
            }
        },
        update = { web ->
            val html = """
                <!doctype html><html><head><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=2">
                <style>
                  body{margin:0;padding:8px 4px;background:transparent;color:#111;font-family:serif;text-align:center;}
                  #fallback{font-size:23px;line-height:1.35;}
                  #math{display:none;font-size:23px;overflow-x:auto;}
                </style>
                <script>
                  window.MathJax={tex:{inlineMath:[['\\(','\\)']]},startup:{ready:()=>{MathJax.startup.defaultReady();MathJax.startup.promise.then(()=>{document.getElementById('fallback').style.display='none';document.getElementById('math').style.display='block';});}}};
                </script>
                <script async src="tex-mml-chtml.js"></script></head>
                <body><div id="fallback">$fallback</div><div id="math">\\($latex\\)</div></body></html>
            """.trimIndent()
            web.settings.allowFileAccess = true
            web.loadDataWithBaseURL("file:///android_asset/mathjax/", html, "text/html", "UTF-8", null)
        },
        modifier = Modifier.fillMaxWidth().height(96.dp)
    )
}

private fun basicLatex(source: String): String {
    val sub = mapOf(
        '₀' to "0", '₁' to "1", '₂' to "2", '₃' to "3", '₄' to "4", '₅' to "5", '₆' to "6", '₇' to "7", '₈' to "8", '₉' to "9",
        '₊' to "+", '₋' to "-", '₌' to "=", 'ₐ' to "a", 'ₑ' to "e", 'ᵢ' to "i", 'ⱼ' to "j", 'ₖ' to "k", 'ₙ' to "n", 'ₓ' to "x"
    )
    val sup = mapOf(
        '⁰' to "0", '¹' to "1", '²' to "2", '³' to "3", '⁴' to "4", '⁵' to "5", '⁶' to "6", '⁷' to "7", '⁸' to "8", '⁹' to "9",
        '⁺' to "+", '⁻' to "-", '⁼' to "=", 'ⁿ' to "n", 'ᵃ' to "a", 'ᵅ' to "\\alpha", 'ᵝ' to "\\beta"
    )
    val out = StringBuilder()
    var i = 0
    while (i < source.length) {
        val c = source[i]
        if (sub.containsKey(c)) {
            val b = StringBuilder()
            while (i < source.length && sub.containsKey(source[i])) { b.append(sub[source[i]]); i++ }
            out.append("_{${b}}")
            continue
        }
        if (sup.containsKey(c)) {
            val b = StringBuilder()
            while (i < source.length && sup.containsKey(source[i])) { b.append(sup[source[i]]); i++ }
            out.append("^{${b}}")
            continue
        }
        out.append(when (c) {
            '∫' -> "\\int "
            'Σ' -> "\\sum "
            '∑' -> "\\sum "
            'Π', '∏' -> "\\prod "
            '√' -> "\\sqrt{}"
            '∞' -> "\\infty "
            '→' -> "\\to "
            '⇒' -> "\\Rightarrow "
            '≤' -> "\\le "
            '≥' -> "\\ge "
            '≠' -> "\\ne "
            '≈' -> "\\approx "
            '−' -> "-"
            '·' -> "\\cdot "
            'π' -> "\\pi "
            'α' -> "\\alpha "
            'β' -> "\\beta "
            'γ' -> "\\gamma "
            'λ' -> "\\lambda "
            'μ' -> "\\mu "
            'σ' -> "\\sigma "
            'ξ' -> "\\xi "
            'η' -> "\\eta "
            'φ' -> "\\varphi "
            'θ' -> "\\theta "
            'Δ' -> "\\Delta "
            '∩' -> "\\cap "
            '∪' -> "\\cup "
            else -> c.toString()
        })
        i++
    }
    return out.toString().replace("lim", "\\operatorname{lim}")
}

private fun htmlEscape(s: String): String = s
    .replace("&", "&amp;")
    .replace("<", "&lt;")
    .replace(">", "&gt;")
    .replace("\"", "&quot;")

@Composable
private fun BookTopicTab(topicId: TopicId, lang: AppLanguage) {
    val context = LocalContext.current
    val range = remember(topicId) { BookSource.pageRange(topicId) }
    var showText by rememberSaveable(topicId) { mutableStateOf(false) }
    val extractedText = remember(topicId) {
        runCatching { context.assets.open(BookSource.topicTextAsset(topicId)).bufferedReader().use { it.readText() } }.getOrDefault("")
    }
    Column(Modifier.fillMaxSize()) {
        ElevatedCard(Modifier.fillMaxWidth().padding(12.dp)) {
            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    titleFor(lang,
                        "Qo‘llanmaning aynan shu mavzuga tegishli ${range.count} sahifasi to‘liq kiritilgan (${range.start}-${range.end}-PDF sahifalar). Formulalar asl nashrdagi ko‘rinishda saqlanadi.",
                        "Полностью включены ${range.count} страниц пособия по этой теме (PDF-страницы ${range.start}-${range.end}). Формулы сохраняются в исходном виде.",
                        "All ${range.count} textbook pages for this topic are included (PDF pages ${range.start}-${range.end}). Formulas keep the original typesetting."),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { showText = false }, enabled = showText) {
                        Text(titleFor(lang,"Asl sahifalar","Страницы","Pages"))
                    }
                    OutlinedButton(onClick = { showText = true }, enabled = !showText) {
                        Text(titleFor(lang,"Qidiriladigan matn","Текст","Searchable text"))
                    }
                }
            }
        }
        if (showText) {
            LazyColumn(Modifier.fillMaxSize().padding(horizontal = 14.dp, vertical = 6.dp)) {
                item {
                    Text(titleFor(lang,
                        "Quyidagi matn PDFdan avtomatik ajratilgan asl o‘zbekcha matndir; formulalar uchun yuqoridagi ‘Asl sahifalar’ rejimi aniqroq.",
                        "Ниже — автоматически извлечённый оригинальный узбекский текст PDF; для формул точнее режим «Страницы».",
                        "Below is automatically extracted original Uzbek PDF text; use Pages for exact formula typography."), style = MaterialTheme.typography.bodySmall)
                    Spacer(Modifier.height(8.dp))
                    androidx.compose.foundation.text.selection.SelectionContainer {
                        Text(extractedText, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        } else {
            BookPagesWebView(range, Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun BookPagesWebView(range: BookPageRange, modifier: Modifier = Modifier) {
    val html = remember(range) {
        buildString {
            append("<!doctype html><html><head><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=yes'><style>body{margin:0;background:#e8e8e8} .p{margin:10px auto;background:white;box-shadow:0 1px 8px #999;max-width:1000px} img{display:block;width:100%;height:auto}</style></head><body>")
            for (page in range.start..range.end) {
                append("<div class='p'><img src='")
                append(BookSource.pageAsset(page))
                append("' alt='page ").append(page).append("'></div>")
            }
            append("</body></html>")
        }
    }
    AndroidView(
        factory = { ctx ->
            android.webkit.WebView(ctx).apply {
                setBackgroundColor(android.graphics.Color.rgb(232,232,232))
                settings.builtInZoomControls = true
                settings.displayZoomControls = false
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.allowFileAccess = true
            }
        },
        update = { web -> web.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null) },
        modifier = modifier
    )
}

@Composable
private fun FullBookScreen(lang: AppLanguage, onBack: () -> Unit) {
    var page by rememberSaveable { mutableIntStateOf(1) }
    Column(Modifier.fillMaxSize()) {
        HeaderRow(titleFor(lang,"Amaliy matematika 2 — to‘liq kitob","Прикладная математика 2 — полный учебник","Applied Mathematics 2 — full textbook"), titleFor(lang,"Orqaga","Назад","Back"), onBack)
        ElevatedCard(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp)) {
            Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(titleFor(lang,"183 sahifaning barchasi ilovaga kiritilgan.","Все 183 страницы включены в приложение.","All 183 pages are bundled in the app."), fontWeight = FontWeight.Bold)
                Text(titleFor(lang,"PDF sahifa: $page / ${BookSource.TOTAL_PAGES}","Страница PDF: $page / ${BookSource.TOTAL_PAGES}","PDF page: $page / ${BookSource.TOTAL_PAGES}"))
                Slider(value = page.toFloat(), onValueChange = { page = it.roundToInt().coerceIn(1, BookSource.TOTAL_PAGES) }, valueRange = 1f..BookSource.TOTAL_PAGES.toFloat(), steps = BookSource.TOTAL_PAGES - 2)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick={ page=(page-1).coerceAtLeast(1) }, enabled=page>1, modifier=Modifier.weight(1f)){ Text("←") }
                    Button(onClick={ page=(page+1).coerceAtMost(BookSource.TOTAL_PAGES) }, enabled=page<BookSource.TOTAL_PAGES, modifier=Modifier.weight(1f)){ Text("→") }
                }
            }
        }
        BookPagesWebView(BookPageRange(page,page), Modifier.fillMaxSize())
    }
}

@Composable
private fun VideoTab(topic: TopicContent, lang: AppLanguage) {
    val context = LocalContext.current
    val prefs = remember { AppPrefs(context) }
    val labels = uiLabels(lang)
    val videoScope = rememberCoroutineScope()
    var grant by remember(topic.id) { mutableStateOf<ProtectedVideoGrant?>(null) }
    var loading by remember(topic.id) { mutableStateOf(false) }
    var error by remember(topic.id) { mutableStateOf<String?>(null) }

    val bundledLesson = topic.video.takeIf { it.manifestUrl.isNotBlank() }
    val token = prefs.accessToken()

    LaunchedEffect(topic.id, token) {
        if (bundledLesson == null && token.isNotBlank() && prefs.hasUsableSession() && ApiClient.isConfigured()) {
            loading = true
            error = null
            ApiClient.videoGrant(topic.id, token)
                .onSuccess { grant = it }
                .onFailure { error = it.message }
            loading = false
        }
    }

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        when {
            bundledLesson != null -> SecureVideoPlayer(
                lesson = bundledLesson,
                lang = lang,
                watermark = remember { prefs.watermarkTag() }
            )
            grant != null -> {
                val g = grant!!
                SecureVideoPlayer(
                    lesson = VideoLesson(g.manifestUrl, g.drmLicenseUrl, g.isDash),
                    lang = lang,
                    watermark = "AM2 • ${g.watermarkId}"
                )
            }
            loading -> {
                CircularProgressIndicator()
                Text(titleFor(lang,"Himoyalangan video olinmoqda…","Загрузка защищённого видео…","Loading protected video…"))
            }
            !ApiClient.isConfigured() -> {
                ScriptedVideoLesson(topic.id, lang)
                ElevatedCard(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text(titleFor(lang,
                            "Bu oflayn interaktiv video-dars. Keyinchalik real MP4/HLS + Widevine oqimi shu modulga ulanadi.",
                            "Это офлайн интерактивный видео-урок. Позже к этому модулю подключается поток MP4/HLS + Widevine.",
                            "This is an offline interactive video lesson. A real MP4/HLS + Widevine stream can later replace it."), style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(8.dp))
                        Text(labels.videoSecurity, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
            !prefs.hasUsableSession() -> {
                ElevatedCard(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(titleFor(lang,"Video uchun aktivatsiya kerak","Для видео нужна активация","Activation is required for video"), fontWeight = FontWeight.Bold)
                        Text(titleFor(lang,
                            "Hisob / Aktivatsiya bo‘limida litsenziya kodini kiriting. Bitta litsenziya serverda belgilangan qurilmalar sonigacha ishlaydi.",
                            "Введите код лицензии в разделе Аккаунт / Активация. Лицензия работает на числе устройств, заданном сервером.",
                            "Enter the license code in Account / Activation. A license works on the number of devices allowed by the server."))
                    }
                }
            }
            else -> {
                error?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                Button(onClick = {
                    loading = true; error = null
                    videoScope.launch {
                        ApiClient.videoGrant(topic.id, token)
                            .onSuccess { grant = it }
                            .onFailure { error = it.message }
                        loading = false
                    }
                }) { Text(titleFor(lang,"Qayta urinish","Повторить","Retry")) }
            }
        }
    }
}


@Composable
private fun ScriptedVideoLesson(topicId: TopicId, lang: AppLanguage) {
    val context = LocalContext.current
    val key = remember(topicId) { topicId.name.removePrefix("TOPIC_").lowercase() }
    val script = remember(topicId, lang) {
        runCatching {
            context.assets.open("video_scripts/topic_${key}_${lang.code}.txt")
                .bufferedReader().use { it.readText() }
        }.getOrElse { "" }
    }
    val steps = remember(script) {
        script.split(Regex("\\n\\s*\\n"))
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .filterNot { it.startsWith("AMALIY MATEMATIKA 2") || it.startsWith("Til:") || it.startsWith("Язык:") || it.startsWith("Language:") }
    }
    var index by rememberSaveable(topicId, lang) { mutableIntStateOf(0) }
    var playing by rememberSaveable(topicId, lang) { mutableStateOf(false) }

    LaunchedEffect(playing, index, steps.size) {
        if (playing && steps.isNotEmpty()) {
            delay(9000)
            if (index < steps.lastIndex) index++ else playing = false
        }
    }

    ElevatedCard(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.PlayArrow, null, modifier = Modifier.size(40.dp))
                Spacer(Modifier.width(8.dp))
                Column(Modifier.weight(1f)) {
                    Text(titleFor(lang,"Interaktiv video-dars","Интерактивный видео-урок","Interactive video lesson"), fontWeight = FontWeight.Bold)
                    Text(titleFor(lang,"Oflayn ishlaydi; mavzu ssenariysi qadam-baqadam namoyish qilinadi.","Работает офлайн; сценарий темы показывается пошагово.","Works offline; the lesson script is presented step by step."), style=MaterialTheme.typography.bodySmall)
                }
            }
            if (steps.isEmpty()) {
                Text(titleFor(lang,"Ssenariy topilmadi.","Сценарий не найден.","Lesson script not found."))
            } else {
                LinearProgressIndicator(progress = { (index + 1f) / steps.size.toFloat() }, modifier = Modifier.fillMaxWidth())
                Text(titleFor(lang,"Qadam ${index+1}/${steps.size}","Шаг ${index+1}/${steps.size}","Step ${index+1}/${steps.size}"), style=MaterialTheme.typography.labelLarge)
                Text(steps[index], style = MaterialTheme.typography.bodyLarge)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick={ index=(index-1).coerceAtLeast(0); playing=false }, enabled=index>0, modifier=Modifier.weight(1f)) { Text("←") }
                    Button(onClick={ playing=!playing }, modifier=Modifier.weight(1.4f)) {
                        Text(if(playing) titleFor(lang,"Pauza","Пауза","Pause") else titleFor(lang,"Boshlash","Старт","Play"))
                    }
                    OutlinedButton(onClick={ index=(index+1).coerceAtMost(steps.lastIndex); playing=false }, enabled=index<steps.lastIndex, modifier=Modifier.weight(1f)) { Text("→") }
                }
            }
        }
    }
}

@Composable
private fun SecureVideoPlayer(lesson: VideoLesson, lang: AppLanguage, watermark: String) {
    val context = LocalContext.current
    val player = remember(lesson.manifestUrl) { ExoPlayer.Builder(context).build() }

    DisposableEffect(lesson.manifestUrl, lesson.drmLicenseUrl) {
        val itemBuilder = MediaItem.Builder()
            .setUri(lesson.manifestUrl)
            .setMimeType(if (lesson.isDash) MimeTypes.APPLICATION_MPD else MimeTypes.APPLICATION_M3U8)

        if (!lesson.drmLicenseUrl.isNullOrBlank()) {
            itemBuilder.setDrmConfiguration(
                MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
                    .setLicenseUri(lesson.drmLicenseUrl)
                    .build()
            )
        }

        player.setMediaItem(itemBuilder.build())
        player.prepare()
        onDispose { player.release() }
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(Modifier.fillMaxWidth().aspectRatio(16f / 9f).background(Color.Black)) {
            AndroidView(
                factory = { ctx -> PlayerView(ctx).also { it.player = player; it.useController = true } },
                modifier = Modifier.fillMaxSize()
            )
            MovingWatermark(text = watermark, modifier = Modifier.fillMaxSize())
        }
        Text(
            when (lang) {
                AppLanguage.UZ -> "Yuklab olish tugmasi berilmaydi; oqim server tokeni va DRM bilan ulanishga tayyor."
                AppLanguage.RU -> "Кнопки скачивания нет; плеер подготовлен для токенизированного потока и DRM."
                AppLanguage.EN -> "No download control is exposed; the player is ready for tokenized streaming and DRM."
            },
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun MovingWatermark(text: String, modifier: Modifier = Modifier) {
    var x by remember { mutableIntStateOf(18) }
    var y by remember { mutableIntStateOf(18) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(7000)
            x = Random.nextInt(12, 180)
            y = Random.nextInt(12, 120)
        }
    }
    Box(modifier) {
        Text(
            text,
            color = Color.White.copy(alpha = 0.55f),
            fontSize = 12.sp,
            modifier = Modifier.offset { IntOffset(x, y) }
                .background(Color.Black.copy(alpha = 0.18f), RoundedCornerShape(4.dp))
                .padding(4.dp)
        )
    }
}

// ---------- Topic 1.1 practice ----------

@Composable
private fun Topic11Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { IntegralAreaExplorer(lang) }
        item { RiemannExplorer(lang) }
        item { SubstitutionTrainer(lang) }
        item { IntegrationByPartsTrainer(lang) }
        item { ErrorSpotter11(lang) }
        item { StepBuilder11(lang) }
    }
}

@Composable
private fun IntegralAreaExplorer(lang: AppLanguage) {
    var upper by rememberSaveable { mutableFloatStateOf(1f) }
    val exact = upper * upper * upper / 3f
    PracticeCard(titleFor(lang, "Integral yuzasi trenajyori", "Тренажёр площади интеграла", "Integral area explorer")) {
        Text("f(x)=x²,  0 ≤ x ≤ ${"%.2f".format(upper)}")
        Slider(value = upper, onValueChange = { upper = it }, valueRange = 0.2f..1.0f)
        Text("∫₀ᵇ x²dx = b³/3 ≈ ${"%.4f".format(exact)}")
        Spacer(Modifier.height(8.dp))
        IntegralGraph(upper = upper, rectangles = null)
    }
}

@Composable
private fun RiemannExplorer(lang: AppLanguage) {
    var n by rememberSaveable { mutableFloatStateOf(6f) }
    val nInt = n.roundToInt().coerceIn(2, 30)
    val upper = 1f
    val exact = 1f / 3f
    val riemann = (1..nInt).sumOf { k ->
        val x = upper.toDouble() * k / nInt
        x * x * upper / nInt
    }.toFloat()
    PracticeCard(titleFor(lang, "Riman yig‘indisi trenajyori", "Тренажёр сумм Римана", "Riemann sum explorer")) {
        Text("n = $nInt")
        Slider(value = n, onValueChange = { n = it }, valueRange = 2f..30f, steps = 27)
        Text("Sₙ ≈ ${"%.5f".format(riemann)}   |   exact = ${"%.5f".format(exact)}")
        Text("|Sₙ − exact| ≈ ${"%.5f".format(abs(riemann - exact))}")
        Spacer(Modifier.height(8.dp))
        IntegralGraph(upper = upper, rectangles = nInt)
    }
}

@Composable
private fun IntegralGraph(upper: Float, rectangles: Int?) {
    Canvas(Modifier.fillMaxWidth().height(220.dp)) {
        val left = 34f
        val bottom = size.height - 28f
        val w = size.width - left - 16f
        val h = size.height - 44f
        drawLine(Color.Gray, Offset(left, bottom), Offset(left + w, bottom), strokeWidth = 2f)
        drawLine(Color.Gray, Offset(left, bottom), Offset(left, bottom - h), strokeWidth = 2f)

        fun px(x: Float) = left + (x / 1.05f) * w
        fun py(y: Float) = bottom - (y / 1.05f) * h

        if (rectangles != null) {
            val dx = upper / rectangles
            for (k in 1..rectangles) {
                val xRight = k * dx
                val height = xRight * xRight
                drawRect(
                    color = Color(0x33666666),
                    topLeft = Offset(px(xRight - dx), py(height)),
                    size = androidx.compose.ui.geometry.Size(px(xRight) - px(xRight - dx), bottom - py(height)),
                    style = Stroke(width = 1.5f)
                )
            }
        }

        var prev = Offset(px(0f), py(0f))
        for (i in 1..100) {
            val x = upper * i / 100f
            val point = Offset(px(x), py(x * x))
            drawLine(Color.DarkGray, prev, point, strokeWidth = 3f)
            prev = point
        }
    }
}

@Composable
private fun SubstitutionTrainer(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    val options = listOf(
        "t=ln x,  dt=dx/x,  x:1→e ⇒ t:0→1",
        "t=x²,  dt=2x dx,  x:1→e ⇒ t:1→e²",
        "t=eˣ,  dt=eˣdx,  x:1→e ⇒ t:e→eᵉ"
    )
    PracticeCard(titleFor(lang, "Almashtirishni tanlang", "Выберите замену", "Choose the substitution")) {
        Text("∫₁ᵉ (ln²x)/x dx")
        Text(titleFor(lang, "Qaysi almashtirish mos?", "Какая замена подходит?", "Which substitution is appropriate?"))
        options.forEachIndexed { i, option ->
            OutlinedButton(
                onClick = { if (selected < 0) selected = i },
                modifier = Modifier.fillMaxWidth(),
                enabled = selected < 0
            ) { Text(option, modifier = Modifier.fillMaxWidth()) }
        }
        if (selected >= 0) {
            Feedback(selected == 0, lang)
            Text(if (selected == 0) "∫₀¹t²dt=1/3" else titleFor(lang, "dx/x va chegaralar mos kelmaydi.", "Не согласуются dx/x и пределы.", "The differential and limits do not match."))
            TextButton(onClick = { selected = -1 }) { Text(titleFor(lang, "Qayta", "Снова", "Try again")) }
        }
    }
}

@Composable
private fun IntegrationByPartsTrainer(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    val options = listOf(
        "u=x−π, dv=cos x dx",
        "u=cos x, dv=(x−π)dx",
        "u=1, dv=(x−π)cos x dx"
    )
    PracticeCard(titleFor(lang, "Bo‘laklab integrallash", "Интегрирование по частям", "Integration by parts")) {
        Text("∫₀^π (x−π)cos x dx")
        Text(titleFor(lang, "u va dv ni qulay tanlang.", "Выберите удобные u и dv.", "Choose convenient u and dv."))
        options.forEachIndexed { i, option ->
            OutlinedButton(onClick = { if (selected < 0) selected = i }, enabled = selected < 0, modifier = Modifier.fillMaxWidth()) {
                Text(option, modifier = Modifier.fillMaxWidth())
            }
        }
        if (selected >= 0) {
            Feedback(selected == 0, lang)
            if (selected == 0) Text("du=dx, v=sin x  ⇒  result = −2")
            TextButton(onClick = { selected = -1 }) { Text(titleFor(lang, "Qayta", "Снова", "Try again")) }
        }
    }
}

@Composable
private fun ErrorSpotter11(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    val answers = listOf("2x+C", "x³/3+C", "x²/2+C", "3x²+C")
    PracticeCard(titleFor(lang, "Xatoni toping", "Найдите ошибку", "Spot the error")) {
        Text(titleFor(lang, "Talaba ∫x²dx=2x+C deb yozdi. To‘g‘ri boshlang‘ich funksiyani tanlang.", "Студент написал ∫x²dx=2x+C. Выберите правильную первообразную.", "A student wrote ∫x²dx=2x+C. Choose the correct antiderivative."))
        answers.forEachIndexed { i, a ->
            OutlinedButton(onClick = { if (selected < 0) selected = i }, enabled = selected < 0, modifier = Modifier.fillMaxWidth()) { Text(a) }
        }
        if (selected >= 0) {
            Feedback(selected == 1, lang)
            if (selected == 1) Text("d(x³/3)/dx=x²")
            TextButton(onClick = { selected = -1 }) { Text(titleFor(lang, "Qayta", "Снова", "Try again")) }
        }
    }
}

@Composable
private fun StepBuilder11(lang: AppLanguage) {
    var selected by remember { mutableStateOf(emptyList<Int>()) }
    val steps = listOf(
        titleFor(lang, "F(x)=x³/3 ni toping", "Найдите F(x)=x³/3", "Find F(x)=x³/3"),
        titleFor(lang, "F(1)−F(0) ni yozing", "Запишите F(1)−F(0)", "Write F(1)−F(0)"),
        titleFor(lang, "Natija 1/3", "Результат 1/3", "Result 1/3")
    )
    val order = listOf(1, 0, 2)
    PracticeCard(titleFor(lang, "Yechim qadamlarini tartiblang", "Расположите шаги решения", "Order the solution steps")) {
        Text("∫₀¹x²dx")
        order.forEach { idx ->
            OutlinedButton(
                onClick = { if (idx !in selected) selected = selected + idx },
                enabled = idx !in selected,
                modifier = Modifier.fillMaxWidth()
            ) { Text(steps[idx], modifier = Modifier.fillMaxWidth()) }
        }
        if (selected.isNotEmpty()) Text(selected.joinToString(" → ") { (it + 1).toString() })
        if (selected.size == 3) {
            Feedback(selected == listOf(0, 1, 2), lang)
            TextButton(onClick = { selected = emptyList() }) { Text(titleFor(lang, "Qayta boshlash", "Сбросить", "Reset")) }
        }
    }
}

// ---------- Topic 1.2 practice ----------

@Composable
private fun Topic12Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { ImproperTypeClassifier(lang) }
        item { PIntegralExplorer(lang) }
        item { InfiniteLimitExplorer(lang) }
        item { EndpointLimitExplorer(lang) }
        item { GeneratedPChallenge(lang) }
        item { NumericImproperChallenge(lang) }
    }
}

@Composable
private fun ImproperTypeClassifier(lang: AppLanguage) {
    val examples = listOf(
        "∫₁^∞ dx/x²" to 0,
        "∫₀¹ dx/√x" to 1,
        "∫₋∞⁰ xe^(−x²)dx" to 0,
        "∫₀¹ dx/(1−x)²" to 1
    )
    var index by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang, "Xosmas integral turini aniqlang", "Определите тип несобственного интеграла", "Classify the improper integral")) {
        Text(examples[index].first, style = MaterialTheme.typography.titleLarge)
        listOf(
            titleFor(lang, "1-tur: cheksiz chegara", "I род: бесконечный предел", "Type I: infinite limit"),
            titleFor(lang, "2-tur: chegaralanmagan funksiya", "II род: неограниченная функция", "Type II: unbounded integrand")
        ).forEachIndexed { i, label ->
            OutlinedButton(onClick = { if (selected < 0) selected = i }, enabled = selected < 0, modifier = Modifier.fillMaxWidth()) { Text(label) }
        }
        if (selected >= 0) {
            Feedback(selected == examples[index].second, lang)
            Button(onClick = {
                index = (index + 1) % examples.size
                selected = -1
            }) { Text(titleFor(lang, "Keyingi misol", "Следующий пример", "Next example")) }
        }
    }
}

@Composable
private fun PIntegralExplorer(lang: AppLanguage) {
    var alpha by rememberSaveable { mutableFloatStateOf(1.5f) }
    val infinityConverges = alpha > 1f
    val zeroConverges = alpha < 1f
    PracticeCard(titleFor(lang, "p-integral laboratoriyasi", "Лаборатория p-интегралов", "p-integral lab")) {
        Text("α = ${"%.2f".format(alpha)}")
        Slider(value = alpha, onValueChange = { alpha = it }, valueRange = 0.25f..2.5f)
        HorizontalDivider()
        Text("∫₁^∞ x⁻ᵅdx", fontWeight = FontWeight.Bold)
        Text(
            if (infinityConverges) titleFor(lang, "Yaqinlashadi", "Сходится", "Converges") + " = ${"%.3f".format(1f / (alpha - 1f))}"
            else titleFor(lang, "Uzoqlashadi", "Расходится", "Diverges")
        )
        Spacer(Modifier.height(8.dp))
        Text("∫₀¹ x⁻ᵅdx", fontWeight = FontWeight.Bold)
        Text(
            if (zeroConverges) titleFor(lang, "Yaqinlashadi", "Сходится", "Converges") + " = ${"%.3f".format(1f / (1f - alpha))}"
            else titleFor(lang, "Uzoqlashadi", "Расходится", "Diverges")
        )
        Text(titleFor(lang, "α=1 ikki mezonning chegaraviy nuqtasi.", "α=1 — граничная точка двух критериев.", "α=1 is the boundary point for both criteria."), style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun InfiniteLimitExplorer(lang: AppLanguage) {
    var xi by rememberSaveable { mutableFloatStateOf(2f) }
    val value = atan(xi.toDouble())
    val target = Math.PI / 2.0
    PracticeCard(titleFor(lang, "Cheksiz chegarani limit bilan ko‘ring", "Исследуйте бесконечный предел", "Explore the infinite limit")) {
        Text("J(ξ)=∫₀^ξ dx/(1+x²)=arctan ξ")
        Text("ξ = ${"%.1f".format(xi)}")
        Slider(value = xi, onValueChange = { xi = it }, valueRange = 0.5f..20f)
        Text("J(ξ) ≈ ${"%.5f".format(value)}")
        Text("π/2 ≈ ${"%.5f".format(target)}")
        LinearProgressIndicator(progress = { (value / target).toFloat().coerceIn(0f, 1f) }, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun EndpointLimitExplorer(lang: AppLanguage) {
    var epsilon by rememberSaveable { mutableFloatStateOf(0.25f) }
    val value = 2.0 * (1.0 - sqrt(epsilon.toDouble()))
    PracticeCard(titleFor(lang, "Uzilish nuqtasiga yaqinlashing", "Приближайтесь к точке разрыва", "Approach the singular endpoint")) {
        Text("∫₀¹ dx/√x = lim ε→0+ ∫ε¹ dx/√x")
        Text("ε = ${"%.3f".format(epsilon)}")
        Slider(value = epsilon, onValueChange = { epsilon = it }, valueRange = 0.001f..0.5f)
        Text("∫ε¹ x⁻¹ᐟ²dx ≈ ${"%.5f".format(value)}")
        Text(titleFor(lang, "ε→0 da qiymat 2 ga yaqinlashadi.", "При ε→0 значение стремится к 2.", "As ε→0, the value approaches 2."))
    }
}

@Composable
private fun GeneratedPChallenge(lang: AppLanguage) {
    val pool = remember { listOf(0.5, 0.8, 1.0, 1.2, 1.5, 2.0, 3.0) }
    var alpha by remember { mutableDoubleStateOf(1.5) }
    var modeInfinity by remember { mutableStateOf(true) }
    var selected by remember { mutableIntStateOf(-1) }

    fun newChallenge() {
        alpha = pool.random()
        modeInfinity = Random.nextBoolean()
        selected = -1
    }

    LaunchedEffect(Unit) { newChallenge() }

    val correctConverges = if (modeInfinity) alpha > 1.0 else alpha < 1.0
    PracticeCard(titleFor(lang, "Tasodifiy adaptiv savol", "Случайное адаптивное задание", "Random adaptive challenge")) {
        Text(if (modeInfinity) "∫₁^∞ dx/x^${alpha}" else "∫₀¹ dx/x^${alpha}", style = MaterialTheme.typography.titleLarge)
        listOf(
            titleFor(lang, "Yaqinlashadi", "Сходится", "Converges"),
            titleFor(lang, "Uzoqlashadi", "Расходится", "Diverges")
        ).forEachIndexed { i, label ->
            OutlinedButton(onClick = { if (selected < 0) selected = i }, enabled = selected < 0, modifier = Modifier.fillMaxWidth()) { Text(label) }
        }
        if (selected >= 0) {
            val isCorrect = (selected == 0) == correctConverges
            Feedback(isCorrect, lang)
            Button(onClick = { newChallenge() }) { Text(titleFor(lang, "Yangi savol", "Новый вопрос", "New question")) }
        }
    }
}

@Composable
private fun NumericImproperChallenge(lang: AppLanguage) {
    var input by rememberSaveable { mutableStateOf("") }
    var checked by rememberSaveable { mutableStateOf<Boolean?>(null) }
    PracticeCard(titleFor(lang, "Javobni o‘zingiz kiriting", "Введите ответ самостоятельно", "Enter the answer yourself")) {
        Text("∫₁^∞ dx/x³ = ?", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = input,
            onValueChange = { input = it; checked = null },
            label = { Text(titleFor(lang, "Masalan: 0.5", "Например: 0.5", "Example: 0.5")) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val parsed = input.replace(',', '.').toDoubleOrNull()
            checked = parsed != null && abs(parsed - 0.5) < 1e-6
        }) { Text(titleFor(lang, "Tekshirish", "Проверить", "Check")) }
        checked?.let { Feedback(it, lang) }
    }
}

@Composable
private fun PracticeCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    ElevatedCard(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            content()
        }
    }
}

@Composable
private fun Feedback(correct: Boolean, lang: AppLanguage) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        if (correct) Icon(Icons.Default.CheckCircle, null)
        Text(
            if (correct) titleFor(lang, "To‘g‘ri!", "Верно!", "Correct!")
            else titleFor(lang, "Noto‘g‘ri. Yana urinib ko‘ring.", "Неверно. Попробуйте ещё раз.", "Incorrect. Try again."),
            fontWeight = FontWeight.Bold
        )
    }
}


// ---------- Chapter 2 practice ----------

@Composable
private fun Topic21Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { PartialSumLab(lang) }
        item { NecessaryConditionTrainer(lang) }
        item { TelescopingLab(lang) }
        item { GeometricSeriesLab(lang) }
    }
}

@Composable
private fun PartialSumLab(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(10f) }
    var harmonic by rememberSaveable { mutableStateOf(true) }
    val n=nF.roundToInt().coerceIn(2,80)
    val values=(1..n).map { k -> if(harmonic) 1.0/k else (2.0/3.0)*0.5.pow(k-1) }
    val partial=values.runningFold(0.0){a,b->a+b}.drop(1)
    PracticeCard(titleFor(lang,"Qismiy yig‘indilar laboratoriyasi","Лаборатория частичных сумм","Partial-sum laboratory")) {
        Row(horizontalArrangement=Arrangement.spacedBy(8.dp)) {
            FilterChip(selected=harmonic,onClick={harmonic=true},label={Text("Σ1/n")})
            FilterChip(selected=!harmonic,onClick={harmonic=false},label={Text("(2/3)Σ(1/2)ⁿ⁻¹")})
        }
        Text("n=$n   Sₙ≈${"%.5f".format(partial.last())}")
        Slider(value=nF,onValueChange={nF=it},valueRange=2f..80f,steps=77)
        Text(if(harmonic) titleFor(lang,"Sₙ sekin, lekin cheksiz o‘sadi — garmonik qator uzoqlashadi.","Sₙ медленно, но неограниченно растёт — гармонический ряд расходится.","Sₙ grows slowly but without bound—the harmonic series diverges.") else titleFor(lang,"Sₙ 4/3 ga yaqinlashadi.","Sₙ стремится к 4/3.","Sₙ approaches 4/3."))
        Canvas(Modifier.fillMaxWidth().height(170.dp)) {
            val maxY=(partial.maxOrNull()?:1.0).coerceAtLeast(1.0)
            val w=size.width-24f; val h=size.height-24f
            var prev:Offset?=null
            partial.forEachIndexed { i,v ->
                val pt=Offset(12f+w*i/(partial.size-1).coerceAtLeast(1), size.height-12f-(v/maxY*h).toFloat())
                prev?.let{drawLine(Color.DarkGray,it,pt,strokeWidth=2f)}; prev=pt
            }
        }
    }
}

@Composable
private fun NecessaryConditionTrainer(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Zaruriy shartni tekshiring","Проверьте необходимое условие","Check the necessary condition")) {
        Text("uₙ = n/(n+1)")
        Text(titleFor(lang,"Σuₙ haqida qaysi xulosa darhol keladi?","Какой вывод о Σuₙ можно сделать сразу?","What can be concluded immediately about Σuₙ?"))
        listOf(
            titleFor(lang,"Uzoqlashadi, chunki uₙ→1≠0","Расходится, так как uₙ→1≠0","Diverges because uₙ→1≠0"),
            titleFor(lang,"Yaqinlashadi, chunki uₙ chegaralangan","Сходится, так как uₙ ограничен","Converges because uₙ is bounded"),
            titleFor(lang,"Yig‘indisi 1","Сумма равна 1","Sum is 1")
        ).forEachIndexed{i,t-> OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun TelescopingLab(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(5f) }
    val n=nF.roundToInt().coerceIn(1,40)
    val sn=0.5*(1.0-1.0/(2*n+1))
    PracticeCard(titleFor(lang,"Teleskopik qator","Телескопический ряд","Telescoping series")) {
        Text("uₙ = 1/[(2n−1)(2n+1)] = ½(1/(2n−1)−1/(2n+1))")
        Slider(value=nF,onValueChange={nF=it},valueRange=1f..40f,steps=38)
        Text("S$n = ½(1−1/${2*n+1}) ≈ ${"%.6f".format(sn)}")
        Text(titleFor(lang,"n oshganda Sₙ→1/2.","При росте n: Sₙ→1/2.","As n grows, Sₙ→1/2."))
    }
}

@Composable
private fun GeometricSeriesLab(lang: AppLanguage) {
    var q by rememberSaveable { mutableFloatStateOf(0.5f) }
    val a=2.0/3.0
    val status=abs(q)<1f
    PracticeCard(titleFor(lang,"Geometrik qator simulyatori","Симулятор геометрического ряда","Geometric-series simulator")) {
        Text("a₁=2/3, q=${"%.2f".format(q)}")
        Slider(value=q,onValueChange={q=it},valueRange=-1.2f..1.2f)
        Text(if(status) titleFor(lang,"|q|<1: yaqinlashadi","|q|<1: сходится","|q|<1: converges") else titleFor(lang,"|q|≥1: uzoqlashadi","|q|≥1: расходится","|q|≥1: diverges"),fontWeight=FontWeight.Bold)
        if(status) Text("S=a₁/(1−q)≈${"%.5f".format(a/(1-q))}")
    }
}

@Composable
private fun Topic22Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { PSeriesLab(lang) }
        item { RatioTestLab(lang) }
        item { RootTestTrainer(lang) }
        item { TestChooser22(lang) }
    }
}

@Composable
private fun PSeriesLab(lang: AppLanguage) {
    var p by rememberSaveable { mutableFloatStateOf(1.5f) }
    var nF by rememberSaveable { mutableFloatStateOf(30f) }
    val n=nF.roundToInt().coerceIn(5,150)
    val sn=(1..n).sumOf{1.0/it.toDouble().pow(p.toDouble())}
    PracticeCard(titleFor(lang,"p-qator laboratoriyasi","Лаборатория p-ряда","p-series laboratory")) {
        Text("Σ 1/nᵖ, p=${"%.2f".format(p)}")
        Slider(value=p,onValueChange={p=it},valueRange=0.3f..2.5f)
        Slider(value=nF,onValueChange={nF=it},valueRange=5f..150f)
        Text("S$n≈${"%.5f".format(sn)}")
        Text(if(p>1f) titleFor(lang,"p>1 ⇒ yaqinlashadi","p>1 ⇒ сходится","p>1 ⇒ converges") else titleFor(lang,"p≤1 ⇒ uzoqlashadi","p≤1 ⇒ расходится","p≤1 ⇒ diverges"),fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun RatioTestLab(lang: AppLanguage) {
    var r by rememberSaveable { mutableFloatStateOf(0.7f) }
    PracticeCard(titleFor(lang,"Dalamber alomati","Признак Д’Аламбера","Ratio test")) {
        Text("aₙ=rⁿ,  |aₙ₊₁/aₙ|=|r|")
        Slider(value=r,onValueChange={r=it},valueRange=0f..1.5f)
        Text("l=${"%.2f".format(r)}")
        Text(when { r<0.999f -> titleFor(lang,"l<1: yaqinlashadi","l<1: сходится","l<1: converges"); r>1.001f -> titleFor(lang,"l>1: uzoqlashadi","l>1: расходится","l>1: diverges"); else -> titleFor(lang,"l=1: alomat xulosa bermaydi","l=1: признак не решает","l=1: inconclusive") },fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun RootTestTrainer(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Koshi alomati: qo‘llanmadagi misol","Признак Коши: пример из пособия","Root test: textbook example")) {
        Text("aₙ = 1/[ln(n+1)]ⁿ")
        Text("lim ⁿ√aₙ = ?")
        listOf("0","1","e","∞").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0){Feedback(selected==0,lang);Text(titleFor(lang,"ⁿ√aₙ=1/ln(n+1)→0<1.","ⁿ√aₙ=1/ln(n+1)→0<1.","ⁿ√aₙ=1/ln(n+1)→0<1."))}
    }
}

@Composable
private fun TestChooser22(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Qaysi alomat qulay?","Какой признак удобнее?","Which test is natural?")) {
        Text("Σ n!/3ⁿ")
        listOf(titleFor(lang,"Dalamber","Д’Аламбер","Ratio"),titleFor(lang,"Integral","Интегральный","Integral"),titleFor(lang,"Koshi radikal","Радикальный Коши","Root")).forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0){Feedback(selected==0,lang);Text(titleFor(lang,"Faktoriallar nisbatda sodda qisqaradi.","Факториалы удобно сокращаются в отношении.","Factorials simplify naturally in a ratio."))}
    }
}

@Composable
private fun Topic23Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { RadiusFamilyLab(lang) }
        item { PowerSeriesPointLab(lang) }
        item { IntervalBuilder23(lang) }
        item { EndpointTrainer23(lang) }
    }
}

@Composable
private fun RadiusFamilyLab(lang: AppLanguage) {
    var family by rememberSaveable { mutableIntStateOf(0) }
    val names=listOf("aₙ=1/n","aₙ=1/n!","aₙ=n!")
    val r=listOf("R=1","R=∞","R=0")
    PracticeCard(titleFor(lang,"Yaqinlashish radiusi laboratoriyasi","Лаборатория радиуса сходимости","Radius-of-convergence lab")) {
        Row(horizontalArrangement=Arrangement.spacedBy(6.dp)){names.forEachIndexed{i,n->FilterChip(selected=family==i,onClick={family=i},label={Text(n)})}}
        Text(r[family],style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
        Text(when(family){0->"lim (1/n)/(1/(n+1)) = 1";1->"lim (1/n!)/(1/(n+1)!) = ∞";else->"lim n!/(n+1)! = 0"})
    }
}

@Composable
private fun PowerSeriesPointLab(lang: AppLanguage) {
    var x by rememberSaveable { mutableFloatStateOf(0.5f) }
    var nF by rememberSaveable { mutableFloatStateOf(20f) }
    val n=nF.roundToInt().coerceIn(2,80)
    val sn=(1..n).sumOf{k->x.toDouble().pow(k)/k}
    PracticeCard(titleFor(lang,"Σxⁿ/n nuqtaviy trenajyori","Тренажёр Σxⁿ/n","Pointwise trainer for Σxⁿ/n")) {
        Text("x=${"%.2f".format(x)}, n=$n, Sₙ≈${"%.5f".format(sn)}")
        Slider(value=x,onValueChange={x=it},valueRange=-1.2f..1.2f)
        Slider(value=nF,onValueChange={nF=it},valueRange=2f..80f)
        Text(when { x>=1f -> titleFor(lang,"x≥1: x=1 da garmonik qator; tashqarida ham uzoqlashadi.","x≥1: при x=1 гармонический ряд; вне интервала также расходимость.","x≥1: harmonic at x=1; outside also divergent."); x>=-1f -> titleFor(lang,"−1≤x<1: yaqinlashish sohasi.","−1≤x<1: область сходимости.","−1≤x<1: convergence set."); else -> titleFor(lang,"x<−1: uzoqlashadi.","x<−1: расходится.","x<−1: diverges.") },fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun IntervalBuilder23(lang: AppLanguage) {
    var center by rememberSaveable { mutableFloatStateOf(2f) }
    var radius by rememberSaveable { mutableFloatStateOf(1f) }
    PracticeCard(titleFor(lang,"Markaz va radiusdan interval tuzing","Постройте интервал по центру и радиусу","Build interval from center and radius")) {
        Text("α=${"%.1f".format(center)}, R=${"%.1f".format(radius)}")
        Text("α−R < x < α+R  ⇒  ${"%.1f".format(center-radius)} < x < ${"%.1f".format(center+radius)}",fontWeight=FontWeight.Bold)
        Text(titleFor(lang,"Markaz","Центр","Center"));Slider(value=center,onValueChange={center=it},valueRange=-3f..5f)
        Text(titleFor(lang,"Radius","Радиус","Radius"));Slider(value=radius,onValueChange={radius=it},valueRange=0.2f..4f)
    }
}

@Composable
private fun EndpointTrainer23(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Chegara nuqtasini tekshirish","Проверка конца интервала","Endpoint check")) {
        Text("Σ xⁿ/n, R=1.  x=−1 da nima bo‘ladi?")
        listOf(titleFor(lang,"Leybnits bo‘yicha yaqinlashadi","Сходится по Лейбницу","Converges by Leibniz"),titleFor(lang,"Garmonik bo‘lib uzoqlashadi","Становится гармоническим и расходится","Becomes harmonic and diverges"),titleFor(lang,"Hadlar nol bo‘ladi","Члены равны нулю","Terms vanish")).forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun Topic24Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { TaylorApproxLab(lang) }
        item { SeriesMatcher24(lang) }
        item { GaussianExpansionLab(lang) }
        item { TaylorErrorLab(lang) }
    }
}

private fun factorial(n:Int):Double=(1..n).fold(1.0){a,b->a*b}

@Composable
private fun TaylorApproxLab(lang: AppLanguage) {
    var degreeF by rememberSaveable { mutableFloatStateOf(4f) }
    var x by rememberSaveable { mutableFloatStateOf(1f) }
    val d=degreeF.roundToInt().coerceIn(0,10)
    val approx=(0..d).sumOf{k->x.toDouble().pow(k)/factorial(k)}
    val exact=exp(x.toDouble())
    PracticeCard(titleFor(lang,"eˣ Teylor approksimatsiyasi","Аппроксимация eˣ рядом Тейлора","Taylor approximation of eˣ")) {
        Text("x=${"%.2f".format(x)}  n=$d")
        Slider(value=x,onValueChange={x=it},valueRange=-2f..2f)
        Slider(value=degreeF,onValueChange={degreeF=it},valueRange=0f..10f,steps=9)
        Text("Sₙ≈${"%.7f".format(approx)}   eˣ≈${"%.7f".format(exact)}")
        Text("|xato|≈${"%.2e".format(abs(exact-approx))}")
    }
}

@Composable
private fun SeriesMatcher24(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Yoyilmani funksiyaga moslang","Сопоставьте разложение функции","Match the expansion")) {
        Text("1 − x²/2! + x⁴/4! − x⁶/6! + …")
        listOf("cos x","sin x","eˣ","ln(1+x)").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun GaussianExpansionLab(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Almashtirish orqali yoyish","Разложение подстановкой","Expansion by substitution")) {
        Text("eˣ = 1+x+x²/2!+…  da x→−x²")
        Text(titleFor(lang,"e^(−x²) ning dastlabki hadlarini tanlang.","Выберите первые члены e^(−x²).","Choose the first terms of e^(−x²)."))
        listOf("1−x²+x⁴/2!−x⁶/3!+…","1+x²+x⁴/2!+…","x−x³/3!+…").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun TaylorErrorLab(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(3f) }
    val n=nF.roundToInt().coerceIn(0,10)
    val approx=(0..n).sumOf{k->1.0/factorial(k)}
    val err=abs(E-approx)
    PracticeCard(titleFor(lang,"Qoldiq had va xatolik","Остаток и ошибка","Remainder and error")) {
        Text("e¹ ≈ Σₖ₌₀ⁿ1/k!, n=$n")
        Slider(value=nF,onValueChange={nF=it},valueRange=0f..10f,steps=9)
        Text("Sₙ=${"%.8f".format(approx)}")
        Text("|e−Sₙ|=${"%.3e".format(err)}")
        Text(titleFor(lang,"n oshishi bilan qoldiq kamayishini kuzating.","Наблюдайте уменьшение остатка при росте n.","Observe the remainder shrink as n increases."))
    }
}



// ---------- Chapter 3 practice ----------

@Composable
private fun Topic31Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { OdeOrderTrainer31(lang) }
        item { SolutionVerifier31(lang) }
        item { CauchyParameterLab31(lang) }
        item { SlopeField31(lang) }
    }
}

@Composable
private fun OdeOrderTrainer31(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Tenglama tartibini aniqlang","Определите порядок уравнения","Identify the equation order")) {
        Text("x y′ + sin(x) y′′ = 0", style=MaterialTheme.typography.titleLarge)
        listOf("1","2","3","4").forEachIndexed { i,t -> OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)} }
        if(selected>=0){ Feedback(selected==1,lang); Text(titleFor(lang,"Eng yuqori hosila y′′ — 2-tartib.","Старшая производная y′′ — второй порядок.","The highest derivative is y′′, so the order is 2.")) }
    }
}

@Composable
private fun SolutionVerifier31(lang: AppLanguage) {
    var c by rememberSaveable { mutableFloatStateOf(2f) }
    var x by rememberSaveable { mutableFloatStateOf(1f) }
    val y=c/x
    val derivative=-c/(x*x)
    val rhs=-y/x
    PracticeCard(titleFor(lang,"Yechimni bevosita tekshirish","Проверка решения подстановкой","Verify a solution by substitution")) {
        Text("y=C/x  →  y′=−y/x")
        Text("C=${"%.1f".format(c)}, x=${"%.2f".format(x)}")
        Slider(value=c,onValueChange={c=it},valueRange=0.5f..5f)
        Slider(value=x,onValueChange={x=it},valueRange=0.5f..4f)
        Text("y′=${"%.4f".format(derivative)}    −y/x=${"%.4f".format(rhs)}")
        Feedback(abs(derivative-rhs)<1e-5,lang)
    }
}

@Composable
private fun CauchyParameterLab31(lang: AppLanguage) {
    var x0 by rememberSaveable { mutableFloatStateOf(1f) }
    var y0 by rememberSaveable { mutableFloatStateOf(2f) }
    val c=y0*x0
    PracticeCard(titleFor(lang,"Koshi shartidan parametrni toping","Найдите параметр из условия Коши","Find the parameter from a Cauchy condition")) {
        Text("y=C/x,   y(x₀)=y₀")
        Text("x₀=${"%.1f".format(x0)}, y₀=${"%.1f".format(y0)}  ⇒  C=x₀y₀=${"%.2f".format(c)}",fontWeight=FontWeight.Bold)
        Slider(value=x0,onValueChange={x0=it},valueRange=0.5f..4f)
        Slider(value=y0,onValueChange={y0=it},valueRange=0.5f..5f)
        Text(titleFor(lang,"Boshlang‘ich nuqta integral egri chiziqlar oilasidan bitta egri chiziqni tanlaydi.","Начальная точка выбирает одну кривую из семейства интегральных кривых.","The initial point selects one curve from the family of integral curves."))
    }
}

@Composable
private fun SlopeField31(lang: AppLanguage) {
    var k by rememberSaveable { mutableFloatStateOf(1f) }
    PracticeCard(titleFor(lang,"Yo‘nalishlar maydoni: y′=ky","Поле направлений: y′=ky","Slope field: y′=ky")) {
        Text("k=${"%.2f".format(k)}")
        Slider(value=k,onValueChange={k=it},valueRange=-2f..2f)
        Canvas(Modifier.fillMaxWidth().height(220.dp)) {
            val nx=9; val ny=7
            for(i in 0 until nx) for(j in 0 until ny){
                val px=(i+0.5f)*size.width/nx; val py=(j+0.5f)*size.height/ny
                val y=2f*(1f-py/size.height)-1f
                val slope=k*y
                val len=22f
                val dx=(len/sqrt(1f+slope*slope)); val dy=-slope*dx
                drawLine(Color.Gray, Offset(px-dx/2,py-dy/2), Offset(px+dx/2,py+dy/2), strokeWidth=2f)
            }
        }
        Text(titleFor(lang,"k>0 da y=0 dan yuqorida qiyalik musbat, pastda manfiy; k<0 da aksincha.","При k>0 выше y=0 наклон положительный, ниже отрицательный; при k<0 наоборот.","For k>0 slopes are positive above y=0 and negative below; for k<0 the pattern reverses."))
    }
}

@Composable
private fun Topic32Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { SeparationMatch32(lang) }
        item { ExponentialIvp32(lang) }
        item { TrigIntegral32(lang) }
        item { StepOrder32(lang) }
    }
}

@Composable
private fun SeparationMatch32(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"To‘g‘ri ajratishni tanlang","Выберите правильное разделение","Choose the correct separation")) {
        Text("y′ = 2xy")
        val opts=listOf("dy/y = 2x dx","y dy = 2x dx","dy = 2y dx/x","dx/x = 2y dy")
        opts.forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0){Feedback(selected==0,lang);Text(titleFor(lang,"y bilan bog‘liq ko‘paytuvchi dy tomonida, x bilan bog‘liq had dx tomonida bo‘ladi.","Множитель с y переносится к dy, а с x — к dx.","Place the y-dependent factor with dy and the x-dependent factor with dx."))}
    }
}

@Composable
private fun ExponentialIvp32(lang: AppLanguage) {
    var k by rememberSaveable { mutableFloatStateOf(1f) }
    var y0 by rememberSaveable { mutableFloatStateOf(1f) }
    var x by rememberSaveable { mutableFloatStateOf(1f) }
    val y=y0*exp((k*x).toDouble()).toFloat()
    PracticeCard(titleFor(lang,"Ajraladigan IVP: y′=ky, y(0)=y₀","Разделяемая задача: y′=ky, y(0)=y₀","Separable IVP: y′=ky, y(0)=y₀")) {
        Text("y=y₀e^(kx)",fontWeight=FontWeight.Bold)
        Text("k=${"%.2f".format(k)}, y₀=${"%.2f".format(y0)}, x=${"%.2f".format(x)}")
        Slider(value=k,onValueChange={k=it},valueRange=-2f..2f)
        Slider(value=y0,onValueChange={y0=it},valueRange=0.5f..4f)
        Slider(value=x,onValueChange={x=it},valueRange=0f..2f)
        Text("y(x)≈${"%.5f".format(y)}",style=MaterialTheme.typography.headlineSmall)
    }
}

@Composable
private fun TrigIntegral32(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Trigonometrik ajraladigan tenglama","Тригонометрическое разделяемое уравнение","Trigonometric separable equation")) {
        Text("y′ = tg x · tg y")
        Text(titleFor(lang,"Umumiy integralni tanlang.","Выберите общий интеграл.","Choose the general integral."))
        listOf("sin y cos x=C","cos y sin x=C","sin y/cos x=C","x+y=C").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun StepOrder32(lang: AppLanguage) {
    var phase by rememberSaveable { mutableIntStateOf(0) }
    val steps=listOf(
        titleFor(lang,"1. O‘zgaruvchilarni ajratish","1. Разделить переменные","1. Separate variables"),
        titleFor(lang,"2. Ikki tomonni integrallash","2. Проинтегрировать обе части","2. Integrate both sides"),
        titleFor(lang,"3. O‘zgarmas C ni kiritish","3. Ввести постоянную C","3. Introduce constant C"),
        titleFor(lang,"4. Boshlang‘ich shart bo‘lsa C ni aniqlash","4. При начальном условии найти C","4. Use the initial condition to determine C")
    )
    PracticeCard(titleFor(lang,"Yechim algoritmini ketma-ket bajaring","Выполните алгоритм решения по шагам","Walk through the solution algorithm")) {
        steps.forEachIndexed { i,t -> Button(onClick={ if(i==phase) phase=(phase+1).coerceAtMost(4) }, enabled=i<=phase, modifier=Modifier.fillMaxWidth()) { Text(if(i<phase) "✓ $t" else t) } }
        if(phase==4) Feedback(true,lang)
    }
}

@Composable
private fun Topic33Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { HomogeneousSubstitution33(lang) }
        item { LinearMethod33(lang) }
        item { IntegratingFactor33(lang) }
        item { BernoulliTransform33(lang) }
    }
}

@Composable
private fun HomogeneousSubstitution33(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Bir jinsli tenglama almashtirishi","Подстановка для однородного уравнения","Homogeneous-equation substitution")) {
        Text("y′ = y/x + sin(y/x)")
        listOf("y=tx","y=u+v","y=eˣ","y=x²").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0){Feedback(selected==0,lang);Text("dy=xdt+t dx")}
    }
}

@Composable
private fun LinearMethod33(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Tenglama turini aniqlang","Определите тип уравнения","Classify the equation")) {
        Text("y′ + 2xy = x")
        listOf(titleFor(lang,"Chiziqli","Линейное","Linear"),titleFor(lang,"Bernulli n=3","Бернулли n=3","Bernoulli n=3"),titleFor(lang,"Bir jinsli y/x","Однородное y/x","Homogeneous y/x"),titleFor(lang,"Ikkinchi tartibli","Второго порядка","Second order")).forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun IntegratingFactor33(lang: AppLanguage) {
    var a by rememberSaveable { mutableFloatStateOf(1f) }
    var x by rememberSaveable { mutableFloatStateOf(1f) }
    val mu=exp((0.5f*a*x*x).toDouble())
    PracticeCard(titleFor(lang,"Integrallovchi ko‘paytuvchi laboratoriyasi","Лаборатория интегрирующего множителя","Integrating-factor lab")) {
        Text("y′ + (a x)y = Q(x)")
        Text("μ(x)=e^(∫ax dx)=e^(a x²/2)")
        Text("a=${"%.2f".format(a)}, x=${"%.2f".format(x)}  ⇒  μ≈${"%.5f".format(mu)}")
        Slider(value=a,onValueChange={a=it},valueRange=-2f..2f)
        Slider(value=x,onValueChange={x=it},valueRange=0f..2f)
    }
}

@Composable
private fun BernoulliTransform33(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(3f) }
    val n=nF.roundToInt().coerceIn(2,6)
    PracticeCard(titleFor(lang,"Bernulli almashtirishi","Подстановка Бернулли","Bernoulli substitution")) {
        Text("y′+P(x)y=Q(x)yⁿ")
        Text("n=$n  ⇒  z=y^(1−n)=y^${1-n}",style=MaterialTheme.typography.titleLarge,fontWeight=FontWeight.Bold)
        Slider(value=nF,onValueChange={nF=it},valueRange=2f..6f,steps=3)
        if(n==3) Text(titleFor(lang,"Qo‘llanmadagi y′+xy=xy³ misolida z=y⁻².","В примере y′+xy=xy³ из пособия z=y⁻².","For the text's example y′+xy=xy³, z=y⁻²."))
    }
}

@Composable
private fun Topic34Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { CharacteristicRoots34(lang) }
        item { RootTypeMatcher34(lang) }
        item { IvpCoefficient34(lang) }
        item { ForcingAnsatz34(lang) }
    }
}

@Composable
private fun CharacteristicRoots34(lang: AppLanguage) {
    var p by rememberSaveable { mutableFloatStateOf(-7f) }
    var q by rememberSaveable { mutableFloatStateOf(6f) }
    val disc=p*p-4*q
    PracticeCard(titleFor(lang,"Xarakteristik ildizlar laboratoriyasi","Лаборатория характеристических корней","Characteristic-root lab")) {
        Text("y′′ + p y′ + q y = 0")
        Text("p=${"%.1f".format(p)}, q=${"%.1f".format(q)}, Δ=${"%.2f".format(disc)}")
        Slider(value=p,onValueChange={p=it},valueRange=-8f..8f)
        Slider(value=q,onValueChange={q=it},valueRange=-8f..16f)
        val result=when {
            disc>1e-4 -> { val r=sqrt(disc); "k₁=${"%.3f".format((-p+r)/2)}, k₂=${"%.3f".format((-p-r)/2)}" }
            abs(disc)<=1e-4 -> "k=${"%.3f".format(-p/2)}  (double)"
            else -> "k=${"%.3f".format(-p/2)} ± ${"%.3f".format(sqrt(-disc)/2)}i"
        }
        Text(result,style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun RootTypeMatcher34(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Ildizdan yechim ko‘rinishini tanlang","Выберите вид решения по корням","Choose the solution form from the roots")) {
        Text("k=2±3i")
        val opts=listOf("e^(2x)(C₁cos3x+C₂sin3x)","C₁e^(2x)+C₂e^(3x)","(C₁+C₂x)e^(2x)","C₁cos2x+C₂sin2x")
        opts.forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun IvpCoefficient34(lang: AppLanguage) {
    var v0 by rememberSaveable { mutableFloatStateOf(3f) }
    val c1=v0/3f; val c2=-c1
    PracticeCard(titleFor(lang,"Boshlang‘ich shartdan C₁,C₂","C₁,C₂ из начальных условий","C₁,C₂ from initial conditions")) {
        Text("x′′−x′−2x=0,  x(0)=0,  x′(0)=v₀")
        Text("v₀=${"%.1f".format(v0)}  ⇒  C₁=${"%.3f".format(c1)}, C₂=${"%.3f".format(c2)}")
        Text("x(t)=C₁e^(2t)+C₂e^(−t)")
        Slider(value=v0,onValueChange={v0=it},valueRange=-6f..6f)
        if(abs(v0-3f)<0.05f) Text(titleFor(lang,"Qo‘llanmadagi misol: C₁=1, C₂=−1.","Пример пособия: C₁=1, C₂=−1.","Text example: C₁=1, C₂=−1."))
    }
}

@Composable
private fun ForcingAnsatz34(lang: AppLanguage) {
    var forcing by rememberSaveable { mutableIntStateOf(0) }
    val labels=listOf("e^(4x)","cos x−3sin x","x²","3sin x with y′′+y")
    val ansatz=listOf("Ae^(4x)","Acos x+Bsin x","Ax²+Bx+C","x(Acos x+Bsin x)")
    PracticeCard(titleFor(lang,"Xususiy yechim ansatzini tanlash","Выбор пробного частного решения","Choose a particular-solution ansatz")) {
        labels.forEachIndexed{i,t->FilterChip(selected=forcing==i,onClick={forcing=i},label={Text(t)})}
        Text(ansatz[forcing],style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
        if(forcing==3) Text(titleFor(lang,"Bu rezonans holati: i xarakteristik ildiz, shuning uchun x ga ko‘paytiriladi.","Это резонанс: i — характеристический корень, поэтому умножаем на x.","This is resonance: i is a characteristic root, so multiply by x."))
    }
}


// ---------- Chapter 4 practice ----------

@Composable
private fun Topic41Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { EventSetLab41(lang) }
        item { CombinatoricsLab41(lang) }
        item { GeometricProbability41(lang) }
    }
}

@Composable
private fun EventSetLab41(lang: AppLanguage) {
    var event by rememberSaveable { mutableIntStateOf(0) }
    val omega=(1..6).toList()
    val sets=listOf(omega.filter{it%2==0}, omega.filter{it>=4}, omega.filter{it==1 || it==3 || it==5})
    val names=listOf(
        titleFor(lang,"Juft son","Чётное число","Even result"),
        titleFor(lang,"Kamida 4","Не меньше 4","At least 4"),
        titleFor(lang,"Toq son","Нечётное число","Odd result")
    )
    val a=sets[event]
    PracticeCard(titleFor(lang,"Kubik hodisalari laboratoriyasi","Лаборатория событий для кубика","Die-event laboratory")) {
        names.forEachIndexed{i,n->FilterChip(selected=event==i,onClick={event=i},label={Text(n)})}
        Text("Ω = {1,2,3,4,5,6}")
        Text("A = ${a.joinToString(prefix="{",postfix="}")}",fontWeight=FontWeight.Bold)
        Text("P(A)=${a.size}/6 = ${"%.3f".format(a.size/6.0)}")
        Text(titleFor(lang,"Natijalarni o‘zgartirib klassik m/n ta’rifini ko‘ring.","Меняйте событие и наблюдайте классическое отношение m/n.","Change the event and observe the classical m/n definition."))
    }
}

private fun comb(n:Int,r:Int):Double {
    if(r<0 || r>n) return 0.0
    val k=min(r,n-r)
    var v=1.0
    for(i in 1..k) v=v*(n-k+i)/i
    return v
}

@Composable
private fun CombinatoricsLab41(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(10f) }
    var rF by rememberSaveable { mutableFloatStateOf(3f) }
    var mode by rememberSaveable { mutableIntStateOf(0) }
    val n=nF.roundToInt().coerceIn(2,20); val r=rF.roundToInt().coerceIn(1,n)
    val value=when(mode){0->comb(n,r);1->factorial(n)/factorial(n-r);else->n.toDouble().pow(r)}
    PracticeCard(titleFor(lang,"Kombinatorika kalkulyatori","Комбинаторный калькулятор","Combinatorics calculator")) {
        Row(horizontalArrangement=Arrangement.spacedBy(6.dp)){
            FilterChip(selected=mode==0,onClick={mode=0},label={Text("Cₙʳ")})
            FilterChip(selected=mode==1,onClick={mode=1},label={Text("Aₙʳ")})
            FilterChip(selected=mode==2,onClick={mode=2},label={Text("nʳ")})
        }
        Text("n=$n, r=$r  ⇒  ${"%.0f".format(value)}",style=MaterialTheme.typography.headlineSmall)
        Text("n");Slider(value=nF,onValueChange={nF=it; if(rF>it) rF=it},valueRange=2f..20f,steps=17)
        Text("r");Slider(value=rF,onValueChange={rF=it.coerceAtMost(nF)},valueRange=1f..nF.coerceAtLeast(1f))
        Text(when(mode){0->titleFor(lang,"Tartib muhim emas.","Порядок не важен.","Order does not matter.");1->titleFor(lang,"Tartib muhim, takror yo‘q.","Порядок важен, без повторений.","Order matters, no repetition.");else->titleFor(lang,"Tartib muhim, takror mumkin.","Порядок важен, повторения разрешены.","Order matters, repetition allowed.")})
    }
}

@Composable
private fun GeometricProbability41(lang: AppLanguage) {
    var favorable by rememberSaveable { mutableFloatStateOf(0.4f) }
    PracticeCard(titleFor(lang,"Geometrik ehtimol slideri","Слайдер геометрической вероятности","Geometric probability slider")) {
        Text(titleFor(lang,"Butun kesma uzunligi 1. Qulay qism uzunligini tanlang.","Длина всего отрезка 1. Выберите длину благоприятной части.","Total interval length is 1. Choose the favorable length."))
        Slider(value=favorable,onValueChange={favorable=it},valueRange=0f..1f)
        LinearProgressIndicator(progress={favorable},modifier=Modifier.fillMaxWidth())
        Text("P(A)=L(A)/L(Ω)=${"%.2f".format(favorable)}",fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun Topic42Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { AdditionRule42(lang) }
        item { ConditionalLab42(lang) }
        item { BayesLab42(lang) }
    }
}

@Composable
private fun AdditionRule42(lang: AppLanguage) {
    var pa by rememberSaveable { mutableFloatStateOf(.6f) }
    var pb by rememberSaveable { mutableFloatStateOf(.5f) }
    var pab by rememberSaveable { mutableFloatStateOf(.2f) }
    val cap=pab.coerceAtMost(min(pa,pb)); val union=(pa+pb-cap).coerceIn(0f,1f)
    PracticeCard(titleFor(lang,"Qo‘shish formulasi laboratoriyasi","Лаборатория формулы сложения","Addition-rule laboratory")) {
        Text("P(A)=${"%.2f".format(pa)}  P(B)=${"%.2f".format(pb)}  P(A∩B)=${"%.2f".format(cap)}")
        Text("P(A∪B)=${"%.2f".format(union)}",style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
        Text("P(A)");Slider(value=pa,onValueChange={pa=it},valueRange=0f..1f)
        Text("P(B)");Slider(value=pb,onValueChange={pb=it},valueRange=0f..1f)
        Text("P(A∩B)");Slider(value=pab,onValueChange={pab=it},valueRange=0f..1f)
        if(pab>min(pa,pb)) Text(titleFor(lang,"Kesishma min(P(A),P(B)) dan katta bo‘la olmaydi; hisobda avtomatik chekladi.","Пересечение не может превышать min(P(A),P(B)); в расчёте оно ограничено.","The intersection cannot exceed min(P(A),P(B)); the calculation clamps it."),style=MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun ConditionalLab42(lang: AppLanguage) {
    var pb by rememberSaveable { mutableFloatStateOf(.5f) }
    var joint by rememberSaveable { mutableFloatStateOf(.2f) }
    val j=joint.coerceAtMost(pb); val cond=if(pb>0f) j/pb else 0f
    PracticeCard(titleFor(lang,"Shartli ehtimol","Условная вероятность","Conditional probability")) {
        Text("P(A|B)=P(A∩B)/P(B)")
        Text("P(B)=${"%.2f".format(pb)}, P(A∩B)=${"%.2f".format(j)} ⇒ P(A|B)=${"%.3f".format(cond)}")
        Slider(value=pb,onValueChange={pb=it.coerceAtLeast(.05f)},valueRange=.05f..1f)
        Slider(value=joint,onValueChange={joint=it},valueRange=0f..1f)
    }
}

@Composable
private fun BayesLab42(lang: AppLanguage) {
    var prior by rememberSaveable { mutableFloatStateOf(.2f) }
    var sens by rememberSaveable { mutableFloatStateOf(.8f) }
    var falsePos by rememberSaveable { mutableFloatStateOf(.1f) }
    val pa=prior*sens+(1-prior)*falsePos
    val post=if(pa>0) prior*sens/pa else 0f
    PracticeCard(titleFor(lang,"Beyes yangilanishi","Байесовское обновление","Bayesian update")) {
        Text("P(H)=${"%.2f".format(prior)}, P(A|H)=${"%.2f".format(sens)}, P(A|¬H)=${"%.2f".format(falsePos)}")
        Text("P(A)=${"%.3f".format(pa)}")
        Text("P(H|A)=${"%.3f".format(post)}",style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
        Text("P(H)");Slider(value=prior,onValueChange={prior=it},valueRange=.01f..0.99f)
        Text("P(A|H)");Slider(value=sens,onValueChange={sens=it},valueRange=.01f..0.99f)
        Text("P(A|¬H)");Slider(value=falsePos,onValueChange={falsePos=it},valueRange=.01f..0.99f)
    }
}

@Composable
private fun Topic43Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { BinomialLab43(lang) }
        item { PoissonLab43(lang) }
        item { MostLikely43(lang) }
        item { NormalApprox43(lang) }
    }
}

@Composable
private fun BinomialLab43(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(6f) }; var kF by rememberSaveable { mutableFloatStateOf(2f) }; var p by rememberSaveable { mutableFloatStateOf(.2f) }
    val n=nF.roundToInt().coerceIn(1,30); val k=kF.roundToInt().coerceIn(0,n); val q=1-p
    val prob=comb(n,k)*p.toDouble().pow(k)*q.toDouble().pow(n-k)
    PracticeCard(titleFor(lang,"Bernulli ehtimoli","Вероятность Бернулли","Binomial probability")) {
        Text("Pₙ(k)=Cₙᵏpᵏqⁿ⁻ᵏ")
        Text("n=$n, k=$k, p=${"%.2f".format(p)} ⇒ P≈${"%.6f".format(prob)}",style=MaterialTheme.typography.titleLarge)
        Text("n");Slider(value=nF,onValueChange={nF=it;if(kF>it)kF=it},valueRange=1f..30f,steps=28)
        Text("k");Slider(value=kF,onValueChange={kF=it.coerceAtMost(nF)},valueRange=0f..nF)
        Text("p");Slider(value=p,onValueChange={p=it},valueRange=.01f..0.99f)
        if(n==6 && k==2 && abs(p-.2f)<.01f) Text(titleFor(lang,"Qo‘llanmadagi lotereya misoli: 0.24576.","Пример лотереи из пособия: 0.24576.","Text lottery example: 0.24576."))
    }
}

@Composable
private fun PoissonLab43(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(4000f) }; var p by rememberSaveable { mutableFloatStateOf(.0005f) }; var kF by rememberSaveable { mutableFloatStateOf(3f) }
    val n=nF.roundToInt().coerceAtLeast(1); val k=kF.roundToInt().coerceIn(0,12); val lambda=n*p
    val prob=exp(-lambda.toDouble())*lambda.toDouble().pow(k)/factorial(k)
    PracticeCard(titleFor(lang,"Puasson taqribi","Приближение Пуассона","Poisson approximation")) {
        Text("λ=np=${"%.3f".format(lambda)};  P(k)≈e⁻λ λᵏ/k!")
        Text("k=$k ⇒ P≈${"%.6f".format(prob)}",style=MaterialTheme.typography.titleLarge)
        Text("n");Slider(value=nF,onValueChange={nF=it},valueRange=100f..5000f)
        Text("p");Slider(value=p,onValueChange={p=it},valueRange=.0001f..0.02f)
        Text("k");Slider(value=kF,onValueChange={kF=it},valueRange=0f..12f,steps=11)
    }
}

@Composable
private fun MostLikely43(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(50f) }; var p by rememberSaveable { mutableFloatStateOf(.05f) }
    val n=nF.roundToInt(); val q=1-p; val lo=n*p-q; val hi=n*p+p
    PracticeCard(titleFor(lang,"Eng ehtimolli son","Наиболее вероятное число","Most probable count")) {
        Text("np−q ≤ k₀ ≤ np+p")
        Text("${"%.3f".format(lo)} ≤ k₀ ≤ ${"%.3f".format(hi)}",fontWeight=FontWeight.Bold)
        Text(titleFor(lang,"Oraliqdagi butun son(lar) k₀ nomzodlaridir.","Целое число (или числа) в интервале — кандидаты k₀.","Integer value(s) in the interval are candidate k₀ values."))
        Slider(value=nF,onValueChange={nF=it},valueRange=5f..200f)
        Slider(value=p,onValueChange={p=it},valueRange=.01f..0.99f)
    }
}

@Composable
private fun NormalApprox43(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(100f) }; var p by rememberSaveable { mutableFloatStateOf(.65f) }; var kF by rememberSaveable { mutableFloatStateOf(65f) }
    val n=nF.roundToInt().coerceAtLeast(2); val k=kF.roundToInt().coerceIn(0,n); val q=1-p; val sd=sqrt((n*p*q).toDouble()).coerceAtLeast(1e-9)
    val x=(k-n*p)/sd; val phi=exp(-x*x/2)/sqrt(2*PI); val approx=phi/sd
    PracticeCard(titleFor(lang,"Muavr–Laplas lokal trenajyori","Локальный тренажёр Муавра–Лапласа","Local De Moivre–Laplace trainer")) {
        Text("x=(k−np)/√(npq)=${"%.3f".format(x)}")
        Text("Pₙ(k)≈${"%.6f".format(approx)}")
        Slider(value=nF,onValueChange={nF=it;if(kF>it)kF=it},valueRange=20f..600f)
        Slider(value=p,onValueChange={p=it},valueRange=.1f..0.9f)
        Slider(value=kF,onValueChange={kF=it.coerceAtMost(nF)},valueRange=0f..nF)
    }
}

@Composable
private fun Topic44Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { DiscreteDistribution44(lang) }
        item { CdfStep44(lang) }
        item { DistributionPolygon44(lang) }
    }
}

@Composable
private fun DiscreteDistribution44(lang: AppLanguage) {
    val xs=listOf(0,1,2,3); val ps=listOf(.20,.25,.31,.24)
    PracticeCard(titleFor(lang,"Diskret taqsimot jadvali","Таблица дискретного распределения","Discrete distribution table")) {
        xs.indices.forEach{i->Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){Text("x=${xs[i]}");Text("p=${ps[i]}")}}
        Text("Σpᵢ=${"%.2f".format(ps.sum())}",fontWeight=FontWeight.Bold)
        Text(titleFor(lang,"Bu 4.4.1-misoldagi jadval.","Это таблица из примера 4.4.1.","This is the table from Example 4.4.1."))
    }
}

@Composable
private fun CdfStep44(lang: AppLanguage) {
    var x by rememberSaveable { mutableFloatStateOf(1.5f) }
    val vals=listOf(0 to .20,1 to .25,2 to .31,3 to .24)
    val fx=vals.filter{it.first<x}.sumOf{it.second}
    PracticeCard(titleFor(lang,"F(x)=P(X<x) pog‘onali trenajyor","Ступенчатый тренажёр F(x)=P(X<x)","Step-CDF trainer F(x)=P(X<x)")) {
        Text("x=${"%.2f".format(x)} ⇒ F(x)=${"%.2f".format(fx)}",style=MaterialTheme.typography.headlineSmall)
        Slider(value=x,onValueChange={x=it},valueRange=-1f..4f)
        Text(titleFor(lang,"x atom nuqtalaridan o‘tganda F sakraydi.","При прохождении точек-атомов F делает скачки.","F jumps when x passes a mass point."))
    }
}

@Composable
private fun DistributionPolygon44(lang: AppLanguage) {
    val ps=listOf(.20f,.25f,.31f,.24f)
    PracticeCard(titleFor(lang,"Taqsimot poligoni","Полигон распределения","Distribution polygon")) {
        Canvas(Modifier.fillMaxWidth().height(220.dp)) {
            val left=30f; val bottom=size.height-25f; val width=size.width-left-15f; val height=bottom-15f
            drawLine(Color.Gray,Offset(left,bottom),Offset(size.width-10,bottom),strokeWidth=2f)
            drawLine(Color.Gray,Offset(left,bottom),Offset(left,10f),strokeWidth=2f)
            val pts=ps.mapIndexed{i,p->Offset(left+width*i/3f,bottom-height*(p/.35f))}
            pts.zipWithNext().forEach{(a,b)->drawLine(Color.DarkGray,a,b,strokeWidth=3f)}
            pts.forEach{drawCircle(Color.Gray,6f,it)}
        }
        Text("(0,.20), (1,.25), (2,.31), (3,.24)")
    }
}

@Composable
private fun Topic45Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { ExponentialInterval45(lang) }
        item { NormalizeDensity45(lang) }
        item { CdfDensityRelation45(lang) }
    }
}

@Composable
private fun ExponentialInterval45(lang: AppLanguage) {
    var alpha by rememberSaveable { mutableFloatStateOf(1f) }; var a by rememberSaveable { mutableFloatStateOf(1f) }; var b by rememberSaveable { mutableFloatStateOf(2f) }
    val lo=min(a,b); val hi=max(a,b); val prob=exp((-alpha*lo).toDouble())-exp((-alpha*hi).toDouble())
    PracticeCard(titleFor(lang,"Eksponensial oraliq ehtimoli","Вероятность интервала для экспоненциального распределения","Exponential interval probability")) {
        Text("f(x)=αe^(−αx), x>0")
        Text("α=${"%.2f".format(alpha)}, (${"%.2f".format(lo)}, ${"%.2f".format(hi)}) ⇒ P≈${"%.5f".format(prob)}")
        Text("α");Slider(value=alpha,onValueChange={alpha=it},valueRange=.2f..3f)
        Text("a");Slider(value=a,onValueChange={a=it},valueRange=0f..4f)
        Text("b");Slider(value=b,onValueChange={b=it},valueRange=0f..4f)
    }
}

@Composable
private fun NormalizeDensity45(lang: AppLanguage) {
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    PracticeCard(titleFor(lang,"Zichlikni normallash","Нормировка плотности","Normalize a density")) {
        Text("f(x)=2C/(1+x²),  −∞<x<∞")
        Text(titleFor(lang,"∫f=1 bo‘lishi uchun C ni tanlang.","Выберите C так, чтобы ∫f=1.","Choose C so that ∫f=1."))
        listOf("1/(2π)","1/π","π/2","2π").forEachIndexed{i,t->OutlinedButton(onClick={selected=i},modifier=Modifier.fillMaxWidth()){Text(t)}}
        if(selected>=0) Feedback(selected==0,lang)
    }
}

@Composable
private fun CdfDensityRelation45(lang: AppLanguage) {
    var x by rememberSaveable { mutableFloatStateOf(1f) }
    val f=if(x>=0) exp(-x.toDouble()) else 0.0
    val F=if(x>=0) 1-exp(-x.toDouble()) else 0.0
    PracticeCard(titleFor(lang,"F va f bog‘lanishi","Связь F и f","Relationship between F and f")) {
        Text("f(x)=e^(−x), x≥0;  F(x)=1−e^(−x)")
        Text("x=${"%.2f".format(x)}:  f=${"%.4f".format(f)}, F=${"%.4f".format(F)}")
        Slider(value=x,onValueChange={x=it},valueRange=-1f..5f)
        Text(titleFor(lang,"x≥0 da F′(x)=f(x).","При x≥0 выполняется F′(x)=f(x).","For x≥0, F′(x)=f(x)."))
    }
}

@Composable
private fun Topic46Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { MomentsLab46(lang) }
        item { BinomialMoments46(lang) }
        item { ModeMedian46(lang) }
    }
}

@Composable
private fun MomentsLab46(lang: AppLanguage) {
    val xs=listOf(-3.0,-1.0,0.0,2.0,8.0,11.0); val ps=listOf(.111,.105,.121,.242,.145,.276)
    val mean=xs.indices.sumOf{xs[it]*ps[it]}; val ex2=xs.indices.sumOf{xs[it]*xs[it]*ps[it]}; val variance=ex2-mean*mean
    PracticeCard(titleFor(lang,"M, D, σ kalkulyatori","Калькулятор M, D, σ","M, D, σ calculator")) {
        Text(titleFor(lang,"Qo‘llanmadagi 4.6.1-misol yechimida ishlatilgan p(−3)=0.111 qiymati bo‘yicha:","По значению p(−3)=0.111, использованному в решении примера 4.6.1:","Using p(−3)=0.111 as used in the worked solution of Example 4.6.1:"))
        Text("M[X]=${"%.3f".format(mean)}")
        Text("D[X]=${"%.5f".format(variance)}")
        Text("σ=${"%.5f".format(sqrt(variance))}",style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
    }
}

@Composable
private fun BinomialMoments46(lang: AppLanguage) {
    var nF by rememberSaveable { mutableFloatStateOf(20f) }; var p by rememberSaveable { mutableFloatStateOf(.4f) }
    val n=nF.roundToInt(); val q=1-p; val mean=n*p; val variance=n*p*q
    PracticeCard(titleFor(lang,"Binomial xarakteristikalar","Характеристики биномиального распределения","Binomial characteristics")) {
        Text("M=np=${"%.3f".format(mean)}; D=npq=${"%.3f".format(variance)}; σ=${"%.3f".format(sqrt(variance.toDouble()))}")
        Slider(value=nF,onValueChange={nF=it},valueRange=1f..100f)
        Slider(value=p,onValueChange={p=it},valueRange=.01f..0.99f)
    }
}

@Composable
private fun ModeMedian46(lang: AppLanguage) {
    var center by rememberSaveable { mutableFloatStateOf(0f) }
    PracticeCard(titleFor(lang,"Moda va mediana vizualizatori","Визуализатор моды и медианы","Mode and median visualizer")) {
        Text(titleFor(lang,"Simmetrik normal zichlikda markaz bir vaqtda moda va mediana bo‘ladi.","У симметричной нормальной плотности центр одновременно является модой и медианой.","For a symmetric normal density, the center is both mode and median."))
        Text("center=${"%.2f".format(center)}",style=MaterialTheme.typography.titleLarge)
        Slider(value=center,onValueChange={center=it},valueRange=-3f..3f)
        Canvas(Modifier.fillMaxWidth().height(180.dp)){
            val pts=(0..80).map{i->
                val xv=center-4+8*i/80f; val yv=exp(-0.5*(xv-center)*(xv-center));
                Offset(i*size.width/80f,size.height-20f-(size.height-35f)*yv.toFloat())
            }
            pts.zipWithNext().forEach{(a,b)->drawLine(Color.Gray,a,b,strokeWidth=3f)}
            val cx=size.width/2; drawLine(Color.DarkGray,Offset(cx,10f),Offset(cx,size.height-15f),strokeWidth=2f)
        }
    }
}

@Composable
private fun Topic47Practice(lang: AppLanguage) {
    LazyColumn(Modifier.fillMaxSize().padding(16.dp),verticalArrangement=Arrangement.spacedBy(16.dp)) {
        item { SampleStats47(lang) }
        item { EmpiricalCdf47(lang) }
        item { Histogram47(lang) }
        item { ConfidenceInterval47(lang) }
        item { MleBinomial47(lang) }
    }
}

private val ageSample47=listOf(18,17,23,18,17,19,18,20,17,22,19,21,18,18,17,22,18,21,17,21,18,17,23,19,18)

@Composable
private fun SampleStats47(lang: AppLanguage) {
    val sorted=ageSample47.sorted(); val mean=sorted.average(); val minv=sorted.first(); val maxv=sorted.last(); val median=sorted[sorted.size/2]
    val freq=sorted.groupingBy{it}.eachCount()
    PracticeCard(titleFor(lang,"25 talaba yoshi: variatsion/statistik qator","Возраст 25 студентов: вариационный/статистический ряд","Ages of 25 students: variation/statistical series")) {
        Text(sorted.joinToString(", "),style=MaterialTheme.typography.bodySmall)
        Text("n=${sorted.size}, R=${maxv-minv}, x̄=${"%.2f".format(mean)}, Me=$median",fontWeight=FontWeight.Bold)
        Text(freq.entries.joinToString("   "){"${it.key}:${it.value}"})
    }
}

@Composable
private fun EmpiricalCdf47(lang: AppLanguage) {
    var x by rememberSaveable { mutableFloatStateOf(19f) }
    val nx=ageSample47.count{it<x}; val f=nx/ageSample47.size.toFloat()
    PracticeCard(titleFor(lang,"Empirik Fₙ*(x)","Эмпирическая Fₙ*(x)","Empirical Fₙ*(x)")) {
        Text("x=${"%.1f".format(x)}, nₓ=$nx, n=${ageSample47.size}")
        Text("Fₙ*(x)=nₓ/n=${"%.3f".format(f)}",style=MaterialTheme.typography.headlineSmall)
        Slider(value=x,onValueChange={x=it},valueRange=16f..24f)
    }
}

@Composable
private fun Histogram47(lang: AppLanguage) {
    val freq=ageSample47.groupingBy{it}.eachCount().toSortedMap(); val maxCount=(freq.values.maxOrNull()?:1).toFloat()
    PracticeCard(titleFor(lang,"Chastotalar gistogrammasi","Гистограмма частот","Frequency histogram")) {
        Canvas(Modifier.fillMaxWidth().height(220.dp)) {
            val keys=freq.keys.toList(); val barW=size.width/(keys.size*1.4f); val gap=(size.width-barW*keys.size)/(keys.size+1)
            keys.forEachIndexed{i,k->
                val h=(freq[k]!!/maxCount)*(size.height-30f); val left=gap+i*(barW+gap)
                drawRect(Color.Gray,topLeft=Offset(left,size.height-h-20f),size=androidx.compose.ui.geometry.Size(barW,h))
            }
        }
        Text(freq.entries.joinToString(" | "){"${it.key}:${it.value}"})
    }
}

@Composable
private fun ConfidenceInterval47(lang: AppLanguage) {
    var mean by rememberSaveable { mutableFloatStateOf(1000f) }; var sigma by rememberSaveable { mutableFloatStateOf(40f) }; var nF by rememberSaveable { mutableFloatStateOf(100f) }; var gamma by rememberSaveable { mutableIntStateOf(0) }
    val n=nF.roundToInt().coerceAtLeast(2); val z=if(gamma==0)1.96 else 2.58; val eps=z*sigma/sqrt(n.toDouble()); val lo=mean-eps; val hi=mean+eps
    PracticeCard(titleFor(lang,"Ishonchlilik oralig‘i laboratoriyasi","Лаборатория доверительного интервала","Confidence-interval laboratory")) {
        Row(horizontalArrangement=Arrangement.spacedBy(6.dp)){FilterChip(selected=gamma==0,onClick={gamma=0},label={Text("γ=.95")});FilterChip(selected=gamma==1,onClick={gamma=1},label={Text("γ=.99")})}
        Text("x̄=${"%.1f".format(mean)}, σ=${"%.1f".format(sigma)}, n=$n")
        Text("(${"%.2f".format(lo)}, ${"%.2f".format(hi)})",style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold)
        Text("x̄");Slider(value=mean,onValueChange={mean=it},valueRange=900f..1100f)
        Text("σ");Slider(value=sigma,onValueChange={sigma=it},valueRange=5f..100f)
        Text("n");Slider(value=nF,onValueChange={nF=it},valueRange=10f..500f)
        if(abs(mean-1000f)<1f && abs(sigma-40f)<1f && n==100 && gamma==0) Text(titleFor(lang,"Qo‘llanmadagi 4.7.10-misolga mos: taxminan (992.16, 1007.84).","Соответствует примеру 4.7.10: примерно (992.16, 1007.84).","Matches Example 4.7.10: approximately (992.16, 1007.84)."))
    }
}

@Composable
private fun MleBinomial47(lang: AppLanguage) {
    var successesF by rememberSaveable { mutableFloatStateOf(400f) }; var trialsF by rememberSaveable { mutableFloatStateOf(1000f) }
    val trials=trialsF.roundToInt().coerceAtLeast(1); val succ=successesF.roundToInt().coerceIn(0,trials); val phat=succ/trials.toDouble()
    PracticeCard(titleFor(lang,"Binomial p uchun maksimal ehtimollik bahosi","Оценка максимального правдоподобия p","Maximum-likelihood estimate of binomial p")) {
        Text("p̂ = successes / trials")
        Text("$succ / $trials = ${"%.4f".format(phat)}",style=MaterialTheme.typography.headlineSmall)
        Text(titleFor(lang,"Muvaffaqiyatlar soni","Число успехов","Successes"));Slider(value=successesF,onValueChange={successesF=it.coerceAtMost(trialsF)},valueRange=0f..trialsF)
        Text(titleFor(lang,"Sinovlar soni","Число испытаний","Trials"));Slider(value=trialsF,onValueChange={trialsF=it;if(successesF>it)successesF=it},valueRange=100f..2000f)
    }
}

// ---------- Quiz ----------

@Composable
private fun QuizTab(questions: List<QuizQuestion>, lang: AppLanguage, onCompleted: (Int) -> Unit) {
    val labels = uiLabels(lang)
    var activeIds by remember { mutableStateOf(questions.indices.toList()) }
    var position by remember { mutableIntStateOf(0) }
    var selected by remember { mutableIntStateOf(-1) }
    var score by remember { mutableIntStateOf(0) }
    var wrongIds by remember { mutableStateOf(emptyList<Int>()) }
    var finished by remember { mutableStateOf(false) }

    fun restart(ids: List<Int>) {
        activeIds = ids
        position = 0
        selected = -1
        score = 0
        wrongIds = emptyList()
        finished = false
    }

    if (finished) {
        LazyColumn(
            Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Text(labels.result, style = MaterialTheme.typography.headlineSmall) }
            item { Text("$score / ${activeIds.size}", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold) }
            item { Text(labels.mistakesCount(wrongIds.size)) }
            if (wrongIds.isNotEmpty()) {
                item {
                    Button(onClick = { restart(wrongIds) }) { Text(labels.retryMistakes) }
                }
                item { Text(labels.mistakesPreview, fontWeight = FontWeight.Bold) }
                items(wrongIds.take(5)) { idx ->
                    Text("• ${questions[idx].prompt.get(lang)}")
                }
            }
            item {
                OutlinedButton(onClick = { restart(questions.indices.toList()) }) { Text(labels.restart) }
            }
        }
        return
    }

    val globalIndex = activeIds[position]
    val q = questions[globalIndex]
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        item { Text("${position + 1}/${activeIds.size}", style = MaterialTheme.typography.labelLarge) }
        item { Text(q.prompt.get(lang), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) }
        items(q.answers.indices.toList()) { i ->
            val chosen = selected == i
            OutlinedButton(
                onClick = { if (selected < 0) selected = i },
                modifier = Modifier.fillMaxWidth(),
                enabled = selected < 0
            ) {
                Text(q.answers[i].get(lang), modifier = Modifier.fillMaxWidth())
            }
            if (chosen) {
                Text(if (i == q.correctIndex) labels.correct else labels.incorrect, fontWeight = FontWeight.Bold)
                Text(q.explanation.get(lang))
            }
        }
        if (selected >= 0) {
            item {
                Button(onClick = {
                    val right = selected == q.correctIndex
                    val nextScore = score + if (right) 1 else 0
                    val nextWrong = if (right) wrongIds else wrongIds + globalIndex
                    score = nextScore
                    wrongIds = nextWrong
                    if (position == activeIds.lastIndex) {
                        finished = true
                        if (activeIds.size == questions.size) onCompleted(nextScore)
                    } else {
                        position++
                        selected = -1
                    }
                }) { Text(if (position == activeIds.lastIndex) labels.finish else labels.next) }
            }
        }
    }
}

// ---------- Glossary / About ----------

@Composable
private fun GlossaryScreen(lang: AppLanguage, onBack: () -> Unit) {
    val labels = uiLabels(lang)
    Column(Modifier.fillMaxSize()) {
        HeaderRow(labels.glossary, labels.back, onBack)
        LazyColumn(Modifier.fillMaxSize().padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(ContentRepository.glossary) { term ->
                OutlinedCard(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text(term.uz, fontWeight = FontWeight.Bold)
                        Text(term.ru)
                        Text(term.en)
                        term.note?.let { Text(it.get(lang), style = MaterialTheme.typography.bodySmall) }
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutScreen(lang: AppLanguage, onBack: () -> Unit) {
    val labels = uiLabels(lang)
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        HeaderRow(labels.about, labels.back, onBack)
        Text(ContentRepository.appTitle.get(lang), style = MaterialTheme.typography.headlineSmall)
        Text("© 2026 E.O. Rajabov, Sh.R. Ergashova, S.G‘. To‘ychiyev")
        Text(labels.copyrightBody)
        Text(labels.securityBody)
        Text("Version 0.8.0")
    }
}

private fun titleFor(lang: AppLanguage, uz: String, ru: String, en: String): String = when (lang) {
    AppLanguage.UZ -> uz
    AppLanguage.RU -> ru
    AppLanguage.EN -> en
}

private data class UiLabels(
    val changeLanguage: String,
    val chapters: String,
    val comingNext: String,
    val open: String,
    val glossary: String,
    val about: String,
    val back: String,
    val lecture: String,
    val book: String,
    val video: String,
    val practice: String,
    val test: String,
    val chapterOneReady: String,
    val twoTopicsReady: String,
    val openChapter: String,
    val openTopic: String,
    val videoReadyTitle: String,
    val videoReadyBody: String,
    val videoSecurity: String,
    val correct: String,
    val incorrect: String,
    val result: String,
    val restart: String,
    val next: String,
    val finish: String,
    val retryMistakes: String,
    val mistakesPreview: String,
    val copyrightBody: String,
    val securityBody: String,
    val bestScorePrefix: String,
    val mistakesPrefix: String,
    val progressPrefix: String
) {
    fun tabName(tab: TopicTab) = when (tab) {
        TopicTab.LECTURE -> lecture
        TopicTab.BOOK -> book
        TopicTab.VIDEO -> video
        TopicTab.PRACTICE -> practice
        TopicTab.TEST -> test
    }

    fun bestScore(score: Int, total: Int) = "$bestScorePrefix: $score/$total"
    fun mistakesCount(count: Int) = "$mistakesPrefix: $count"
    fun progressLine(a: Int, b: Int) = "$progressPrefix: 1.1 $a/20 • 1.2 $b/20"
}

private fun uiLabels(lang: AppLanguage): UiLabels = when (lang) {
    AppLanguage.UZ -> UiLabels(
        changeLanguage = "Tilni almashtirish",
        chapters = "Boblar",
        comingNext = "Keyingi versiyalarda to‘ldiriladi",
        open = "Ochish",
        glossary = "UZ–RU–EN lug‘at",
        about = "Mualliflik va himoya",
        back = "Orqaga",
        lecture = "Ma’ruza",
        book = "Kitob",
        video = "Video",
        practice = "Mashqlar",
        test = "Test",
        chapterOneReady = "1-bob kengaytirildi",
        twoTopicsReady = "1.1 va 1.2 mavzulari ma’ruza, trenajyor va 20 tadan test bilan tayyor.",
        openChapter = "1-bobni ochish",
        openTopic = "Mavzuni ochish",
        videoReadyTitle = "Himoyalangan video moduli tayyor",
        videoReadyBody = "Video URL hali ulanmagan. HLS/DASH + Widevine serveri ulanganda video shu yerda ochiladi.",
        videoSecurity = "FLAG_SECURE, dinamik watermark va DRM arxitekturasi saqlangan.",
        correct = "To‘g‘ri!",
        incorrect = "Noto‘g‘ri",
        result = "Natija",
        restart = "Testni boshidan ishlash",
        next = "Keyingi",
        finish = "Yakunlash",
        retryMistakes = "Faqat xatolarni qayta ishlash",
        mistakesPreview = "Qayta ko‘rish kerak bo‘lgan savollar",
        copyrightBody = "Ilova va o‘quv kontenti mualliflik huquqi bilan himoyalanadi. Talabalarga source code emas, imzolangan APK/AAB tarqatiladi.",
        securityBody = "FLAG_SECURE + R8 obfuscation + server tokenlari + DRM + dinamik watermark birgalikda ishlatiladi. 100% nusxa olishni to‘xtatish imkonsiz, ammo noqonuniy tarqatish sezilarli qiyinlashtiriladi.",
        bestScorePrefix = "Eng yaxshi test",
        mistakesPrefix = "Xatolar",
        progressPrefix = "Natija"
    )

    AppLanguage.RU -> UiLabels(
        changeLanguage = "Сменить язык",
        chapters = "Главы",
        comingNext = "Будет дополнено в следующих версиях",
        open = "Открыть",
        glossary = "Словарь UZ–RU–EN",
        about = "Авторские права и защита",
        back = "Назад",
        lecture = "Лекция",
        book = "Учебник",
        video = "Видео",
        practice = "Упражнения",
        test = "Тест",
        chapterOneReady = "Глава 1 расширена",
        twoTopicsReady = "Темы 1.1 и 1.2 содержат лекции, тренажёры и по 20 тестовых вопросов.",
        openChapter = "Открыть главу 1",
        openTopic = "Открыть тему",
        videoReadyTitle = "Модуль защищённого видео готов",
        videoReadyBody = "URL видео ещё не подключён. После подключения HLS/DASH + Widevine видео откроется здесь.",
        videoSecurity = "FLAG_SECURE, динамический watermark и DRM-архитектура сохранены.",
        correct = "Верно!",
        incorrect = "Неверно",
        result = "Результат",
        restart = "Пройти тест заново",
        next = "Далее",
        finish = "Завершить",
        retryMistakes = "Повторить только ошибки",
        mistakesPreview = "Вопросы для повторения",
        copyrightBody = "Приложение и учебный контент защищаются авторским правом. Студентам выдаётся подписанный APK/AAB, а не исходный код.",
        securityBody = "FLAG_SECURE + R8-обфускация + серверные токены + DRM + динамический watermark применяются совместно. Полностью исключить копирование невозможно, но незаконное распространение существенно усложняется.",
        bestScorePrefix = "Лучший тест",
        mistakesPrefix = "Ошибки",
        progressPrefix = "Результат"
    )

    AppLanguage.EN -> UiLabels(
        changeLanguage = "Change language",
        chapters = "Chapters",
        comingNext = "Will be completed in later versions",
        open = "Open",
        glossary = "UZ–RU–EN glossary",
        about = "Copyright & protection",
        back = "Back",
        lecture = "Lecture",
        book = "Textbook",
        video = "Video",
        practice = "Practice",
        test = "Test",
        chapterOneReady = "Chapter 1 expanded",
        twoTopicsReady = "Topics 1.1 and 1.2 now include lectures, trainers and 20 quiz questions each.",
        openChapter = "Open Chapter 1",
        openTopic = "Open topic",
        videoReadyTitle = "Protected video module is ready",
        videoReadyBody = "No video URL is connected yet. Once HLS/DASH + Widevine is configured, video will play here.",
        videoSecurity = "FLAG_SECURE, dynamic watermarking and DRM architecture remain enabled.",
        correct = "Correct!",
        incorrect = "Incorrect",
        result = "Result",
        restart = "Restart full test",
        next = "Next",
        finish = "Finish",
        retryMistakes = "Retry mistakes only",
        mistakesPreview = "Questions to review",
        copyrightBody = "The app and learning content are protected by copyright. Students receive a signed APK/AAB, not the source code.",
        securityBody = "FLAG_SECURE + R8 obfuscation + server tokens + DRM + dynamic watermarking are combined. Copying cannot be made absolutely impossible, but unauthorized redistribution is made substantially harder.",
        bestScorePrefix = "Best quiz",
        mistakesPrefix = "Mistakes",
        progressPrefix = "Progress"
    )
}
