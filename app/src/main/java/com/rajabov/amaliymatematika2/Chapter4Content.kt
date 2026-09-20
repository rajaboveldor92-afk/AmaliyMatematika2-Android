package com.rajabov.amaliymatematika2

object Chapter4Content {
    val chapterTitle = TriText(
        "4-bob. Ehtimollar nazariyasi va matematik statistika elementlari",
        "Глава 4. Элементы теории вероятностей и математической статистики",
        "Chapter 4. Elements of probability theory and mathematical statistics"
    )

    val topic41Title = TriText(
        "4.1. Tasodifiy hodisalar, klassik ehtimol, kombinatorika va geometrik ehtimol",
        "4.1. Случайные события, классическая вероятность, комбинаторика и геометрическая вероятность",
        "4.1. Random events, classical probability, combinatorics and geometric probability"
    )
    val topic42Title = TriText(
        "4.2. Qo‘shish va ko‘paytirish teoremalari. Shartli, to‘la ehtimol va Beyes formulasi",
        "4.2. Теоремы сложения и умножения. Условная и полная вероятность. Формула Байеса",
        "4.2. Addition and multiplication rules. Conditional and total probability. Bayes' formula"
    )
    val topic43Title = TriText(
        "4.3. Bernulli sxemasi. Puasson va Muavr–Laplas formulalari",
        "4.3. Схема Бернулли. Формулы Пуассона и Муавра–Лапласа",
        "4.3. Bernoulli scheme. Poisson and De Moivre–Laplace formulas"
    )
    val topic44Title = TriText(
        "4.4. Diskret tasodifiy miqdor va taqsimot qonuni",
        "4.4. Дискретная случайная величина и закон распределения",
        "4.4. Discrete random variable and distribution law"
    )
    val topic45Title = TriText(
        "4.5. Uzluksiz tasodifiy miqdor: taqsimot va zichlik funksiyalari",
        "4.5. Непрерывная случайная величина: функция распределения и плотность",
        "4.5. Continuous random variable: distribution and density functions"
    )
    val topic46Title = TriText(
        "4.6. Matematik kutilma, dispersiya va o‘rtacha kvadratik chetlanish",
        "4.6. Математическое ожидание, дисперсия и среднее квадратическое отклонение",
        "4.6. Expectation, variance and standard deviation"
    )
    val topic47Title = TriText(
        "4.7. Matematik statistika: variatsion qator, empirik taqsimot va baholash",
        "4.7. Математическая статистика: вариационный ряд, эмпирическое распределение и оценивание",
        "4.7. Mathematical statistics: variation series, empirical distribution and estimation"
    )

    private val topic41Sections = listOf(
        LectureSection(TriText("Tasodifiy hodisa va Ω", "Случайное событие и Ω", "Random event and Ω"), TriText(
            "Tajriba natijasida yuz berishi ham, yuz bermasligi ham mumkin bo‘lgan hodisa tasodifiy hodisa deyiladi. Barcha mumkin bo‘lgan elementar natijalar to‘plami Ω bilan belgilanadi. Qo‘llanmadagi kubik misolida Ω={1,2,3,4,5,6}.",
            "Событие, которое в результате опыта может произойти или не произойти, называется случайным. Множество всех элементарных исходов обозначается Ω. В примере с игральной костью Ω={1,2,3,4,5,6}.",
            "An event that may or may not occur in an experiment is random. The set of all elementary outcomes is denoted Ω. In the die example, Ω={1,2,3,4,5,6}."), "Ω={ω₁,ω₂,…}"),
        LectureSection(TriText("Hodisalar ustida amallar", "Операции над событиями", "Operations on events"), TriText(
            "Hodisalarning yig‘indisi A∪B, ko‘paytmasi A∩B, ayirmasi A\\B va qarama-qarshi hodisa Ā orqali ifodalanadi. Qo‘llanmada 1 dan 15 gacha kartochkalar misolida bu amallar to‘plamlar orqali quriladi.",
            "Используются объединение A∪B, пересечение A∩B, разность A\\B и противоположное событие Ā. В пособии эти операции строятся на примере карточек с числами от 1 до 15.",
            "Use union A∪B, intersection A∩B, difference A\\B and complement Ā. The text illustrates these operations with cards numbered 1 through 15.")),
        LectureSection(TriText("Ehtimolning klassik ta’rifi", "Классическое определение вероятности", "Classical definition of probability"), TriText(
            "Teng imkoniyatli n ta elementar natijadan m tasi A hodisaga imkoniyat yaratsa, A hodisaning ehtimoli m/n ga teng.",
            "Если из n равновозможных элементарных исходов m благоприятствуют событию A, то вероятность события A равна m/n.",
            "If m of n equally likely elementary outcomes favor A, then the probability of A is m/n."), "P(A)=m/n"),
        LectureSection(TriText("Kombinatorika", "Комбинаторика", "Combinatorics"), TriText(
            "Qo‘llanmada o‘rinlashtirish, guruhlash va o‘rin almashtirishlar klassik ehtimolni hisoblash uchun qo‘llanadi. Tartib muhim bo‘lsa o‘rinlashtirish, tartib muhim bo‘lmasa guruhlash ishlatiladi.",
            "В пособии размещения, сочетания и перестановки применяются при вычислении классических вероятностей. Если порядок важен — размещения; если не важен — сочетания.",
            "The text uses arrangements, combinations and permutations for classical probability. Use arrangements when order matters and combinations when it does not."), "Aₙʳ=n!/(n−r)!,   Cₙʳ=n!/[r!(n−r)!],   Pₙ=n!"),
        LectureSection(TriText("Takroriy o‘rinlashtirish", "Размещения с повторениями", "Arrangements with repetition"), TriText(
            "Elementlar takrorlanishi mumkin bo‘lgan va tartib muhim bo‘lgan r o‘rinli ketma-ketliklar soni nʳ ga teng. Qo‘llanmadagi 1,2,3,4 raqamlardan besh xonali sonlar tuzish misoli shu turga kiradi.",
            "Если элементы могут повторяться и порядок важен, число последовательностей длины r равно nʳ. Пример с пятизначными числами из цифр 1,2,3,4 относится к этому типу.",
            "When repetition is allowed and order matters, the number of length-r sequences is nʳ. The five-digit-number example using 1,2,3,4 is of this type."), "N=nʳ"),
        LectureSection(TriText("Geometrik ehtimol", "Геометрическая вероятность", "Geometric probability"), TriText(
            "Natijalar tekis taqsimlangan geometrik sohada ehtimol qulay soha o‘lchovining barcha mumkin bo‘lgan soha o‘lchoviga nisbatidir; uzunlik, yuza yoki hajm ishlatilishi mumkin.",
            "При равномерном выборе в геометрической области вероятность равна отношению меры благоприятной области к мере всей области; это может быть длина, площадь или объём.",
            "For a uniform geometric experiment, probability is the ratio of the measure of the favorable region to that of the whole region; the measure may be length, area or volume."), "P(A)=μ(A)/μ(Ω)")
    )

    private val topic42Sections = listOf(
        LectureSection(TriText("Birgalikda bo‘lmagan hodisalar", "Несовместные события", "Mutually exclusive events"), TriText(
            "Birgalikda yuz bera olmaydigan A va B hodisalar uchun yig‘indi ehtimoli ehtimollar yig‘indisiga teng.",
            "Для несовместных событий A и B вероятность суммы равна сумме вероятностей.",
            "For mutually exclusive A and B, the probability of their union is the sum of probabilities."), "P(A∪B)=P(A)+P(B)"),
        LectureSection(TriText("Umumiy qo‘shish formulasi", "Общая формула сложения", "General addition rule"), TriText(
            "A va B bir vaqtda ham yuz berishi mumkin bo‘lsa, ularning kesishmasi bir marta ayiriladi.",
            "Если A и B могут происходить одновременно, вероятность пересечения вычитается один раз.",
            "If A and B may occur together, subtract the intersection once."), "P(A∪B)=P(A)+P(B)−P(A∩B)"),
        LectureSection(TriText("Bog‘liq bo‘lmagan hodisalar", "Независимые события", "Independent events"), TriText(
            "P(AB)=P(A)P(B) tenglik bajarilsa, A va B o‘zaro bog‘liq bo‘lmagan hodisalar deyiladi.",
            "Если P(AB)=P(A)P(B), события A и B называются независимыми.",
            "Events A and B are independent when P(A∩B)=P(A)P(B)."), "P(A∩B)=P(A)P(B)"),
        LectureSection(TriText("Shartli ehtimol", "Условная вероятность", "Conditional probability"), TriText(
            "B hodisa yuz bergan shartda A hodisaning ehtimoli A va B ning birgalikdagi ehtimolini P(B) ga bo‘lish orqali topiladi.",
            "Вероятность A при условии наступления B равна отношению совместной вероятности A и B к P(B).",
            "The probability of A given B is the joint probability of A and B divided by P(B)."), "P(A|B)=P(A∩B)/P(B)"),
        LectureSection(TriText("To‘la ehtimol formulasi", "Формула полной вероятности", "Law of total probability"), TriText(
            "H₁,…,Hₙ birgalikda bo‘lmagan to‘liq guruh bo‘lsa, A ehtimoli gipotezalar bo‘yicha shartli ehtimollarning og‘irliklangan yig‘indisi bilan hisoblanadi.",
            "Если H₁,…,Hₙ образуют полную группу несовместных событий, вероятность A вычисляется как взвешенная сумма условных вероятностей по гипотезам.",
            "If H₁,…,Hₙ form a complete mutually exclusive group, P(A) is the weighted sum of conditional probabilities over the hypotheses."), "P(A)=ΣP(Hᵢ)P(A|Hᵢ)"),
        LectureSection(TriText("Beyes formulasi", "Формула Байеса", "Bayes' formula"), TriText(
            "A hodisa kuzatilgandan keyin Hᵢ gipotezaning ehtimoli oldingi ehtimol va P(A|Hᵢ) orqali qayta hisoblanadi.",
            "После наблюдения события A вероятность гипотезы Hᵢ пересчитывается по априорной вероятности и P(A|Hᵢ).",
            "After observing A, the probability of hypothesis Hᵢ is updated using its prior probability and P(A|Hᵢ)."), "P(Hᵢ|A)=P(Hᵢ)P(A|Hᵢ)/P(A)")
    )

    private val topic43Sections = listOf(
        LectureSection(TriText("Bernulli sxemasi", "Схема Бернулли", "Bernoulli scheme"), TriText(
            "Har bir tajribada ikki natija bo‘lib, tajribalar mustaqil va A hodisaning ehtimoli p o‘zgarmas bo‘lsa, Bernulli sxemasi hosil bo‘ladi. q=1−p.",
            "Если в каждом опыте два исхода, опыты независимы и вероятность события A постоянна и равна p, получаем схему Бернулли. q=1−p.",
            "A Bernoulli scheme has two outcomes per trial, independent trials, and a constant success probability p. Let q=1−p."), "q=1−p"),
        LectureSection(TriText("Bernulli formulasi", "Формула Бернулли", "Bernoulli/binomial formula"), TriText(
            "n mustaqil tajribada A hodisaning aynan k marta yuz berish ehtimoli binomial formula bilan hisoblanadi.",
            "Вероятность того, что событие A произойдёт ровно k раз в n независимых испытаниях, вычисляется по биномиальной формуле.",
            "The probability of exactly k successes in n independent trials is given by the binomial formula."), "Pₙ(k)=Cₙᵏpᵏqⁿ⁻ᵏ"),
        LectureSection(TriText("Eng ehtimolli k", "Наиболее вероятное k", "Most probable k"), TriText(
            "Qo‘llanmada eng ehtimolli yuz berishlar soni k₀ uchun np−q≤k₀≤np+p tengsizlik berilgan.",
            "В пособии для наиболее вероятного числа успехов k₀ дано неравенство np−q≤k₀≤np+p.",
            "The text gives np−q≤k₀≤np+p for the most probable number of successes."), "np−q≤k₀≤np+p"),
        LectureSection(TriText("Puasson teoremasi", "Теорема Пуассона", "Poisson theorem"), TriText(
            "n katta, p kichik va λ=np bo‘lganda binomial ehtimol Puasson formulasi bilan taqribiy hisoblanadi.",
            "При большом n, малом p и λ=np биномиальная вероятность приближённо вычисляется формулой Пуассона.",
            "For large n, small p and λ=np, the binomial probability is approximated by Poisson's formula."), "Pₙ(k)≈e^(−λ) λᵏ/k!,  λ=np"),
        LectureSection(TriText("Muavr–Laplas lokal formulasi", "Локальная формула Муавра–Лапласа", "Local De Moivre–Laplace formula"), TriText(
            "n katta, p va q yetarlicha katta bo‘lganda aynan k marta yuz berish ehtimoli standart normal zichlik orqali taqribiy hisoblanadi.",
            "При большом n и достаточно больших p и q вероятность ровно k успехов приближённо выражается через плотность стандартного нормального распределения.",
            "For large n with p and q not too small, the probability of exactly k successes is approximated using the standard normal density."), "Pₙ(k)≈φ(x)/√(npq),  x=(k−np)/√(npq)"),
        LectureSection(TriText("Muavr–Laplas integral formulasi", "Интегральная формула Муавра–Лапласа", "Integral De Moivre–Laplace formula"), TriText(
            "k ning k₁ va k₂ oralig‘ida yotish ehtimoli standart normal taqsimot funksiyasi qiymatlari ayirmasi bilan taqribiy hisoblanadi.",
            "Вероятность того, что число успехов лежит между k₁ и k₂, приближённо равна разности значений функции стандартного нормального распределения.",
            "The probability that the number of successes lies between k₁ and k₂ is approximated by a difference of standard-normal distribution values."), "P(k₁≤k≤k₂)≈Φ₀(x₂)−Φ₀(x₁)")
    )

    private val topic44Sections = listOf(
        LectureSection(TriText("Tasodifiy miqdor", "Случайная величина", "Random variable"), TriText(
            "Tajriba natijasida qaysi qiymatni qabul qilishi oldindan noma’lum bo‘lgan miqdor tasodifiy miqdor deyiladi.",
            "Величина, значение которой до опыта неизвестно, называется случайной величиной.",
            "A quantity whose value is not known before the experiment is a random variable.")),
        LectureSection(TriText("Diskret va uzluksiz", "Дискретная и непрерывная", "Discrete and continuous"), TriText(
            "Chekli yoki sanoqli qiymatlar qabul qiluvchi miqdor diskret, oraliqni to‘ldirib sanoqsiz qiymatlar qabul qiluvchi miqdor uzluksiz deyiladi.",
            "Величина с конечным или счётным множеством значений дискретна; принимающая несчётное множество значений на интервале — непрерывна.",
            "A variable with finitely or countably many values is discrete; one taking uncountably many values across an interval is continuous.")),
        LectureSection(TriText("Diskret taqsimot qonuni", "Закон распределения дискретной величины", "Discrete distribution law"), TriText(
            "Diskret X uchun xᵢ qiymatlar va pᵢ=P{X=xᵢ} ehtimollar jadvali taqsimot qonunini beradi; ehtimollar yig‘indisi 1 ga teng.",
            "Для дискретной X таблица значений xᵢ и вероятностей pᵢ=P{X=xᵢ} задаёт закон распределения; сумма вероятностей равна 1.",
            "For discrete X, a table of values xᵢ and probabilities pᵢ=P{X=xᵢ} defines the distribution; the probabilities sum to 1."), "Σpᵢ=1"),
        LectureSection(TriText("Taqsimot funksiyasi", "Функция распределения", "Distribution function"), TriText(
            "Qo‘llanmada F(x)={X<x} hodisaning ehtimoli sifatida aniqlanadi. Diskret miqdor uchun F(x) pog‘onali funksiya bo‘ladi.",
            "В пособии F(x) определяется как вероятность события {X<x}. Для дискретной величины F(x) является ступенчатой функцией.",
            "The text defines F(x) as P{X<x}. For a discrete variable, F(x) is a step function."), "F(x)=P{X<x}"),
        LectureSection(TriText("Taqsimot poligoni", "Полигон распределения", "Distribution polygon"), TriText(
            "(xᵢ,pᵢ) nuqtalarni koordinata tekisligida belgilab, qo‘shni nuqtalarni kesmalar bilan tutashtirish taqsimot poligonini beradi.",
            "Если отметить точки (xᵢ,pᵢ) и соединить соседние точки отрезками, получаем полигон распределения.",
            "Plotting (xᵢ,pᵢ) and connecting adjacent points gives the distribution polygon.")),
        LectureSection(TriText("Qo‘llanmadagi jadval", "Таблица из пособия", "Table from the text"), TriText(
            "4.4.1-misolda X={0,1,2,3} va P={0.20,0.25,0.31,0.24} berilib, F(x) hamda poligon quriladi.",
            "В примере 4.4.1 заданы X={0,1,2,3} и P={0.20,0.25,0.31,0.24}; строятся F(x) и полигон.",
            "Example 4.4.1 uses X={0,1,2,3} with P={0.20,0.25,0.31,0.24} to build F(x) and the polygon."))
    )

    private val topic45Sections = listOf(
        LectureSection(TriText("Uzluksiz tasodifiy miqdor", "Непрерывная случайная величина", "Continuous random variable"), TriText(
            "Agar F(x) ni −∞ dan x gacha zichlik funksiyasining integrali sifatida ifodalash mumkin bo‘lsa, X uzluksiz tasodifiy miqdor deb qaraladi.",
            "Если F(x) представима как интеграл плотности от −∞ до x, X рассматривается как непрерывная случайная величина.",
            "If F(x) can be represented as the integral of a density from −∞ to x, X is treated as a continuous random variable."), "F(x)=∫₋∞ˣ f(t)dt"),
        LectureSection(TriText("Oraliqqa tushish ehtimoli", "Вероятность попадания в интервал", "Interval probability"), TriText(
            "Uzluksiz miqdor uchun a va b oralig‘iga tushish ehtimoli F(b)−F(a) yoki zichlikning a dan b gacha integrali orqali topiladi.",
            "Для непрерывной величины вероятность попадания в (a,b) равна F(b)−F(a) или интегралу плотности от a до b.",
            "For a continuous variable, the probability of falling in (a,b) is F(b)−F(a), equivalently the integral of the density from a to b."), "P(a<X<b)=F(b)−F(a)=∫ₐᵇf(x)dx"),
        LectureSection(TriText("Zichlikning normallashuvi", "Нормировка плотности", "Density normalization"), TriText(
            "Zichlik nomanfiy bo‘lib, butun sonlar o‘qida integrali 1 ga teng bo‘lishi kerak.",
            "Плотность неотрицательна, а её интеграл по всей числовой оси равен 1.",
            "A density is nonnegative and integrates to 1 over the real line."), "f(x)≥0,  ∫₋∞∞f(x)dx=1"),
        LectureSection(TriText("Zichlik va hosila", "Плотность и производная", "Density and derivative"), TriText(
            "F differensiallanuvchi nuqtalarda zichlik f(x)=F′(x) orqali olinadi.",
            "В точках дифференцируемости F плотность равна f(x)=F′(x).",
            "Where F is differentiable, the density is f(x)=F′(x)."), "f(x)=F′(x)"),
        LectureSection(TriText("Eksponensial zichlik misoli", "Пример экспоненциальной плотности", "Exponential-density example"), TriText(
            "Qo‘llanmadagi f(x)=αe^(−αx), x>0, α>0 misolida (1,2) oralig‘i ehtimoli zichlik integralidan olinadi.",
            "В примере f(x)=αe^(−αx), x>0, α>0 вероятность интервала (1,2) находится интегрированием плотности.",
            "For f(x)=αe^(−αx), x>0, α>0, the text computes the probability of (1,2) by integrating the density."), "P(1<X<2)=e^(−α)−e^(−2α)"),
        LectureSection(TriText("Normallash konstantasi", "Нормировочная константа", "Normalization constant"), TriText(
            "Qo‘llanmada f(x)=2C/(1+x²) uchun ∫f=1 shartidan C topiladi. Bu mashq zichlikni normallash g‘oyasini mustahkamlaydi.",
            "В пособии для f(x)=2C/(1+x²) константа C находится из условия ∫f=1. Этот пример закрепляет нормировку плотности.",
            "For f(x)=2C/(1+x²), the text determines C from ∫f=1, reinforcing density normalization."), "C=1/(2π)")
    )

    private val topic46Sections = listOf(
        LectureSection(TriText("Diskret matematik kutilma", "Математическое ожидание дискретной величины", "Discrete expectation"), TriText(
            "Diskret X ning matematik kutilmasi uning qiymatlari va mos ehtimollari ko‘paytmalarining yig‘indisidir.",
            "Математическое ожидание дискретной X равно сумме произведений её значений на соответствующие вероятности.",
            "The expectation of a discrete X is the sum of its values times their probabilities."), "M[X]=Σxᵢpᵢ"),
        LectureSection(TriText("Dispersiya", "Дисперсия", "Variance"), TriText(
            "Dispersiya X ning matematik kutilmadan chetlanishi kvadratining matematik kutilmasidir. Hisoblashda D[X]=M[X²]−(M[X])² formulasi qulay.",
            "Дисперсия — математическое ожидание квадрата отклонения от среднего. Удобна формула D[X]=M[X²]−(M[X])².",
            "Variance is the expectation of the squared deviation from the mean. A convenient formula is D[X]=M[X²]−(M[X])²."), "D[X]=M[X²]−(M[X])²"),
        LectureSection(TriText("Standart chetlanish", "Среднее квадратическое отклонение", "Standard deviation"), TriText(
            "O‘rtacha kvadratik chetlanish dispersiyaning kvadrat ildizidir.",
            "Среднее квадратическое отклонение равно квадратному корню из дисперсии.",
            "The standard deviation is the square root of the variance."), "σₓ=√D[X]"),
        LectureSection(TriText("Binomial va Puasson xarakteristikalari", "Характеристики биномиального и пуассоновского распределений", "Binomial and Poisson characteristics"), TriText(
            "Qo‘llanmada binomial taqsimot uchun M=np, D=npq; Puasson taqsimoti uchun M=D=λ natijalari olinadi.",
            "В пособии получены M=np, D=npq для биномиального распределения и M=D=λ для распределения Пуассона.",
            "The text derives M=np and D=npq for the binomial distribution, and M=D=λ for the Poisson distribution."), "Binomial: M=np, D=npq;  Poisson: M=D=λ"),
        LectureSection(TriText("Uzluksiz miqdor uchun", "Для непрерывной величины", "For a continuous variable"), TriText(
            "Uzluksiz X uchun matematik kutilma va dispersiya zichlik funksiyasi bilan integrallar orqali aniqlanadi.",
            "Для непрерывной X математическое ожидание и дисперсия задаются интегралами с плотностью.",
            "For continuous X, expectation and variance are defined by integrals involving the density."), "M[X]=∫₋∞∞xf(x)dx"),
        LectureSection(TriText("Moda va mediana", "Мода и медиана", "Mode and median"), TriText(
            "Zichlik funksiyasining maksimum nuqtasi moda deyiladi. Mediana xₚ qiymati ehtimolni ikki teng qismga bo‘ladi: chap va o‘ng tomonda 1/2 dan ehtimol qoladi.",
            "Точка максимума плотности называется модой. Медиана xₚ делит вероятность пополам: слева и справа остаётся по 1/2.",
            "The maximum point of the density is the mode. A median xₚ splits the probability into two halves."), "P(X<xₚ)=P(X>xₚ)=1/2")
    )

    private val topic47Sections = listOf(
        LectureSection(TriText("Bosh to‘plam va tanlama", "Генеральная совокупность и выборка", "Population and sample"), TriText(
            "X ning mumkin bo‘lgan qiymatlari to‘plami bosh to‘plam, tajribada kuzatilgan x₁,…,xₙ qiymatlar esa tanlama deb ataladi. n — tanlama hajmi.",
            "Множество возможных значений X — генеральная совокупность, а наблюдаемые x₁,…,xₙ — выборка. n — объём выборки.",
            "The set of possible values of X is the population; observed values x₁,…,xₙ form a sample. n is the sample size.")),
        LectureSection(TriText("Variatsion va statistik qator", "Вариационный и статистический ряды", "Variation and statistical series"), TriText(
            "Tanlama elementlarini kamaymaydigan tartibda joylashtirish variatsion qatorni beradi. Har bir varianta uchun chastota nᵢ va nisbiy chastota pᵢ*=nᵢ/n statistik qatorni tuzadi.",
            "Упорядочивание элементов выборки по неубыванию даёт вариационный ряд. Частоты nᵢ и относительные частоты pᵢ*=nᵢ/n образуют статистический ряд.",
            "Sorting the sample in nondecreasing order gives the variation series. Frequencies nᵢ and relative frequencies pᵢ*=nᵢ/n form the statistical series."), "pᵢ*=nᵢ/n"),
        LectureSection(TriText("Poligon, gistogramma va empirik funksiya", "Полигон, гистограмма и эмпирическая функция", "Polygon, histogram and empirical CDF"), TriText(
            "Diskret chastotalar poligoni nuqtalarni ulash orqali, interval qator uchun gistogramma to‘g‘ri to‘rtburchaklar orqali quriladi. Empirik taqsimot Fₙ*(x)=nₓ/n.",
            "Полигон частот строится соединением точек, гистограмма интервального ряда — прямоугольниками. Эмпирическая функция распределения Fₙ*(x)=nₓ/n.",
            "The frequency polygon connects plotted points; an interval-series histogram uses rectangles. The empirical distribution is Fₙ*(x)=nₓ/n."), "Fₙ*(x)=nₓ/n"),
        LectureSection(TriText("Tanlama sonli xarakteristikalari", "Числовые характеристики выборки", "Sample numerical characteristics"), TriText(
            "Tanlama o‘rtachasi qiymatlarning chastotalar bilan og‘irliklangan o‘rtachasi; tanlama dispersiyasi chetlanishlar kvadratlarining o‘rtachasi orqali hisoblanadi.",
            "Выборочное среднее — взвешенное частотами среднее значений; выборочная дисперсия вычисляется по квадратам отклонений.",
            "The sample mean is a frequency-weighted mean; sample variance is computed from squared deviations."), "x̄=(1/n)Σnᵢxᵢ"),
        LectureSection(TriText("Nuqtaviy baholash", "Точечное оценивание", "Point estimation"), TriText(
            "θ parametrning tanlama orqali hisoblangan θ̂ₙ funksiyasi nuqtaviy baho deyiladi. Qo‘llanmada asosli, siljimagan va samarali baholar ta’riflanadi.",
            "Функция выборки θ̂ₙ, приближённо оценивающая параметр θ, называется точечной оценкой. В пособии определены состоятельность, несмещённость и эффективность.",
            "A sample statistic θ̂ₙ used to approximate θ is a point estimate. The text defines consistency, unbiasedness and efficiency."), "M[θ̂]=θ  (siljimagan / unbiased)"),
        LectureSection(TriText("Momentlar va maksimal ehtimollik usullari", "Метод моментов и максимального правдоподобия", "Method of moments and maximum likelihood"), TriText(
            "Momentlar usulida nazariy momentlar tanlama momentlariga tenglashtiriladi. Maksimal ehtimollik usulida L=∏f(xᵢ,θ) yoki diskret holatda ∏p(xᵢ,θ) maksimal qilinadi.",
            "В методе моментов теоретические моменты приравниваются выборочным. В методе максимального правдоподобия максимизируется L=∏f(xᵢ,θ), а в дискретном случае ∏p(xᵢ,θ).",
            "The method of moments equates theoretical and sample moments. Maximum likelihood maximizes L=∏f(xᵢ,θ), or ∏p(xᵢ,θ) in the discrete case."), "L(θ)=∏f(xᵢ,θ)"),
        LectureSection(TriText("Ishonchlilik oralig‘i", "Доверительный интервал", "Confidence interval"), TriText(
            "P(θ₁<θ<θ₂)=γ bo‘lsa, (θ₁,θ₂) parametr uchun γ ishonchlilik oralig‘i deyiladi. Qo‘llanmada normal holat uchun γ=0.95 va 0.99 da mos kvantillar 1.96 va 2.58 sifatida berilgan.",
            "Если P(θ₁<θ<θ₂)=γ, то (θ₁,θ₂) — доверительный интервал уровня γ. В пособии для нормального случая приведены квантильные множители 1.96 и 2.58 для γ=0.95 и 0.99.",
            "If P(θ₁<θ<θ₂)=γ, then (θ₁,θ₂) is a γ-level confidence interval. The text uses 1.96 and 2.58 for γ=0.95 and 0.99 in the normal case."), "x̄ ± z·σ/√n")
    )

    val topic41Video = VideoLesson("", null, false)
    val topic42Video = VideoLesson("", null, false)
    val topic43Video = VideoLesson("", null, false)
    val topic44Video = VideoLesson("", null, false)
    val topic45Video = VideoLesson("", null, false)
    val topic46Video = VideoLesson("", null, false)
    val topic47Video = VideoLesson("", null, false)

    private fun t(uz:String, ru:String, en:String)=TriText(uz,ru,en)
    private fun same(s:String)=TriText(s,s,s)
    private fun q(id:String, uz:String, ru:String, en:String, a0:TriText,a1:TriText,a2:TriText,a3:TriText,c:Int,euz:String,eru:String,een:String)=
        QuizQuestion(id,t(uz,ru,en),listOf(a0,a1,a2,a3),c,t(euz,eru,een))

    val quiz41 = listOf(
        q("41q01","Tasodifiy hodisa nima?","Что такое случайное событие?","What is a random event?",t("Yuz berishi ham, bermasligi ham mumkin","Может произойти или не произойти","May or may not occur"),t("Doimo yuz beradi","Происходит всегда","Always occurs"),t("Hech qachon yuz bermaydi","Никогда не происходит","Never occurs"),t("Faqat son","Только число","Only a number"),0,"Ta’rif bo‘yicha tasodifiy hodisa yuz berishi ham, bermasligi ham mumkin.","По определению случайное событие может произойти или нет.","By definition, a random event may or may not occur."),
        q("41q02","Kubik tashlanganda Ω qaysi?","Каково Ω при броске кубика?","What is Ω for a die throw?",same("{1,2,3,4,5,6}"),same("{0,1}"),same("{1,2}"),same("{1,…,10}"),0,"Qo‘llanmadagi 4.1.1-misol.","Пример 4.1.1 пособия.","This is Example 4.1.1 in the text."),
        q("41q03","Klassik ehtimol formulasi?","Формула классической вероятности?","Classical probability formula?",same("P(A)=m/n"),same("P(A)=n/m"),same("P(A)=m+n"),same("P(A)=mn"),0,"m — qulay, n — barcha teng imkoniyatli natijalar soni.","m — число благоприятных, n — всех равновозможных исходов.","m is favorable outcomes, n all equally likely outcomes."),
        q("41q04","A∩B nimani bildiradi?","Что означает A∩B?","What does A∩B mean?",t("Ikkalasi ham yuz berishi","Произошли оба события","Both occur"),t("Kamida bittasi","Хотя бы одно","At least one"),t("A yuz bermasligi","A не происходит","A does not occur"),t("A dan B ni ayirish","Разность A и B","Difference A and B"),0,"Kesishma — ikkala hodisaning birgalikda yuz berishi.","Пересечение означает совместное наступление.","Intersection means both events occur."),
        q("41q05","Tartib muhim bo‘lmasa r ta element tanlash uchun qaysi formula?","Какая формула используется, если порядок не важен?","Which formula is used when order does not matter?",same("Cₙʳ"),same("Aₙʳ"),same("Pₙ"),same("nʳ"),0,"Bu guruhlashlar soni.","Это число сочетаний.","This is the number of combinations."),
        q("41q06","Pₙ nimaga teng?","Чему равно Pₙ?","What is Pₙ?",same("n!"),same("n²"),same("2ⁿ"),same("n/(n−1)"),0,"O‘rin almashtirishlar soni n!.","Число перестановок равно n!.","The number of permutations is n!."),
        q("41q07","Takroriy o‘rinlashtirishlar soni?","Число размещений с повторениями?","Number of arrangements with repetition?",same("nʳ"),same("n!"),same("Cₙʳ"),same("n+r"),0,"Har bir r o‘rinda n tadan tanlov bor.","В каждой из r позиций есть n вариантов.","Each of r positions has n choices."),
        q("41q08","Geometrik ehtimol nimaga asoslanadi?","На чём основана геометрическая вероятность?","What is geometric probability based on?",t("O‘lchovlar nisbatiga","На отношении мер","Ratio of measures"),t("Faqat faktorialga","Только на факториале","Only factorials"),t("Faqat hosilaga","Только на производной","Only derivatives"),t("Qatorga","На ряде","A series"),0,"Qulay soha o‘lchovi barcha soha o‘lchoviga bo‘linadi.","Мера благоприятной области делится на меру всей области.","Divide favorable-region measure by total-region measure."),
        q("41q09","Qutida 6 oq va 5 qora shar bo‘lsa, oq shar ehtimoli?","В урне 6 белых и 5 чёрных шаров. Вероятность белого?","With 6 white and 5 black balls, probability of white?",same("6/11"),same("5/11"),same("6/5"),same("1/2"),0,"m=6, n=11.","m=6, n=11.","m=6, n=11."),
        q("41q10","A hodisaga qarama-qarshi hodisa belgisi?","Обозначение противоположного события A?","Notation for the complement of A?",same("Ā"),same("A∩A"),same("A∪A"),same("2A"),0,"Qo‘llanmada qarama-qarshi hodisa ustki chiziq bilan belgilanadi.","В пособии противоположное событие обозначено чертой сверху.","The text denotes the complement with an overbar."))

    val quiz42 = listOf(
        q("42q01","A va B birgalikda bo‘lmasa P(A∪B)=?","Если A и B несовместны, P(A∪B)=?","If A and B are mutually exclusive, P(A∪B)=?",same("P(A)+P(B)"),same("P(A)P(B)"),same("P(A)−P(B)"),same("1"),0,"Birgalikda bo‘lmagan hodisalar uchun qo‘shish teoremasi.","Теорема сложения для несовместных событий.","Addition rule for mutually exclusive events."),
        q("42q02","Umumiy holda P(A∪B)=?","В общем случае P(A∪B)=?","In general, P(A∪B)=?",same("P(A)+P(B)−P(A∩B)"),same("P(A)+P(B)"),same("P(A)P(B)"),same("P(A∩B)"),0,"Kesishma ikki marta sanalganligi uchun ayiriladi.","Пересечение вычитается, так как было учтено дважды.","Subtract the intersection because it was counted twice."),
        q("42q03","Mustaqil A,B uchun P(A∩B)=?","Для независимых A,B P(A∩B)=?","For independent A,B, P(A∩B)=?",same("P(A)P(B)"),same("P(A)+P(B)"),same("P(A)/P(B)"),same("0"),0,"Mustaqillik ta’rifi.","Определение независимости.","Definition of independence."),
        q("42q04","Shartli ehtimol P(A|B)=?","Условная вероятность P(A|B)=?","Conditional probability P(A|B)=?",same("P(A∩B)/P(B)"),same("P(A)/P(B)"),same("P(B)/P(A)"),same("P(A∪B)"),0,"B yuz bergan shartdagi A ehtimoli.","Вероятность A при условии B.","Probability of A given B."),
        q("42q05","To‘la ehtimol formulasi qaysi?","Какая формула полной вероятности?","Which is the total probability formula?",same("ΣP(Hᵢ)P(A|Hᵢ)"),same("ΣP(Hᵢ|A)"),same("P(A)P(B)"),same("P(A)+P(B)"),0,"Gipotezalar bo‘yicha og‘irliklangan yig‘indi.","Взвешенная сумма по гипотезам.","Weighted sum across hypotheses."),
        q("42q06","Beyes formulasi nimani yangilaydi?","Что обновляет формула Байеса?","What does Bayes' formula update?",t("Gipoteza ehtimolini A kuzatilgandan keyin","Вероятность гипотезы после наблюдения A","Hypothesis probability after observing A"),t("Faqat n ni","Только n","Only n"),t("Faqat integralni","Только интеграл","Only an integral"),t("Hosilani","Производную","A derivative"),0,"Posterior ehtimol hisoblanadi.","Вычисляется апостериорная вероятность.","It computes a posterior probability."),
        q("42q07","P(A)=0.9, P(B)=0.8 mustaqil bo‘lsa P(A∩B)=?","Если P(A)=0.9, P(B)=0.8 независимы, P(A∩B)=?","If P(A)=0.9 and P(B)=0.8 are independent, P(A∩B)=?",same("0.72"),same("0.98"),same("0.17"),same("1.7"),0,"0.9·0.8=0.72.","0.9·0.8=0.72.","0.9·0.8=0.72."),
        q("42q08","Yuqoridagi holatda kamida bittasi yuz berish ehtimoli?","В том же случае вероятность хотя бы одного?","In that case, probability that at least one occurs?",same("0.98"),same("0.72"),same("0.2"),same("0.8"),0,"0.9+0.8−0.72=0.98.","0.9+0.8−0.72=0.98.","0.9+0.8−0.72=0.98."),
        q("42q09","H₁,…,Hₙ to‘la guruh uchun ΣP(Hᵢ)=?","Для полной группы H₁,…,Hₙ чему равно ΣP(Hᵢ)?","For a complete group H₁,…,Hₙ, what is ΣP(Hᵢ)?",same("1"),same("0"),same("n"),same("1/n"),0,"To‘liq guruh barcha imkoniyatlarni qamrab oladi.","Полная группа покрывает все возможности.","A complete group covers all possibilities."),
        q("42q10","Beyes formulasining maxrajida nima turadi?","Что стоит в знаменателе формулы Байеса?","What is the denominator in Bayes' formula?",same("P(A)"),same("P(Hᵢ)"),same("P(A|Hᵢ)"),same("1−P(A)"),0,"Maxraj — kuzatilgan A hodisaning to‘la ehtimoli.","Знаменатель — полная вероятность наблюдаемого события A.","The denominator is the total probability of the observed event A."))

    val quiz43 = listOf(
        q("43q01","Bernulli sxemasida har bir tajribada nechta asosiy natija?","Сколько основных исходов в каждом испытании Бернулли?","How many basic outcomes in each Bernoulli trial?",same("2"),same("1"),same("3"),same("n"),0,"A yoki unga qarama-qarshi hodisa.","A или противоположное событие.","A or its complement."),
        q("43q02","Bernulli formulasida q nimaga teng?","Чему равно q в формуле Бернулли?","What is q in the Bernoulli formula?",same("1−p"),same("1+p"),same("p²"),same("n−p"),0,"q — muvaffaqiyatsizlik ehtimoli.","q — вероятность неуспеха.","q is the failure probability."),
        q("43q03","Aynan k muvaffaqiyat ehtimoli?","Вероятность ровно k успехов?","Probability of exactly k successes?",same("Cₙᵏpᵏqⁿ⁻ᵏ"),same("pᵏ"),same("qⁿ"),same("np"),0,"Bernulli/binomial formula.","Формула Бернулли/биномиальная формула.","Bernoulli/binomial formula."),
        q("43q04","n=6,p=0.2,k=2 uchun q nechaga teng?","Для n=6,p=0.2,k=2 чему равно q?","For n=6,p=0.2,k=2, what is q?",same("0.8"),same("0.2"),same("0.6"),same("1.2"),0,"q=1−p=0.8.","q=1−p=0.8.","q=1−p=0.8."),
        q("43q05","Puasson taqribida λ=?","В приближении Пуассона λ=?","In the Poisson approximation, λ=?",same("np"),same("n/p"),same("p/n"),same("n+p"),0,"Qo‘llanmada λ=np.","В пособии λ=np.","The text uses λ=np."),
        q("43q06","Puasson formulasi qaysi?","Какая формула Пуассона?","Which is the Poisson formula?",same("e⁻λ λᵏ/k!"),same("Cₙᵏpᵏqⁿ⁻ᵏ"),same("φ(x)/√n"),same("1/k"),0,"Kichik p va katta n holati uchun.","Для большого n и малого p.","For large n and small p."),
        q("43q07","Eng ehtimolli k₀ uchun tengsizlik?","Неравенство для наиболее вероятного k₀?","Inequality for the most probable k₀?",same("np−q≤k₀≤np+p"),same("p≤k₀≤q"),same("0≤k₀≤1"),same("k₀=npq"),0,"Qo‘llanmada aynan shu ko‘rinish berilgan.","В пособии дано именно это неравенство.","This is the inequality stated in the text."),
        q("43q08","Muavr–Laplas lokal formulasida x nimaga bog‘liq?","От чего зависит x в локальной формуле Муавра–Лапласа?","What defines x in the local De Moivre–Laplace formula?",same("(k−np)/√(npq)"),same("k/n"),same("npq"),same("k−n"),0,"Standartlashtirish formulasi.","Формула стандартизации.","This is the standardization formula."),
        q("43q09","Integral Muavr–Laplas nimani hisoblaydi?","Что вычисляет интегральная формула Муавра–Лапласа?","What does the integral De Moivre–Laplace formula approximate?",t("k ning intervalda yotish ehtimolini","Вероятность попадания k в интервал","Probability that k lies in an interval"),t("Faqat k=0 ni","Только k=0","Only k=0"),t("Matematik kutilmani","Математическое ожидание","Expectation"),t("Dispersiyani","Дисперсию","Variance"),0,"Formula k₁≤k≤k₂ ehtimoli uchun.","Формула применяется к вероятности k₁≤k≤k₂.","It is used for P(k₁≤k≤k₂)."),
        q("43q10","n katta va p juda kichik bo‘lsa qaysi taqrib qulay?","При большом n и очень малом p какое приближение удобно?","For large n and very small p, which approximation is convenient?",t("Puasson","Пуассона","Poisson"),t("Faqat klassik m/n","Только m/n","Only m/n"),t("Teylor","Тейлора","Taylor"),t("Nyuton–Leybnits","Ньютона–Лейбница","Newton–Leibniz"),0,"Bu Puasson teoremasining holati.","Это условие теоремы Пуассона.","This is the Poisson-theorem regime."))

    val quiz44 = listOf(
        q("44q01","Diskret tasodifiy miqdor qanday qiymatlar qabul qiladi?","Какие значения принимает дискретная случайная величина?","What values can a discrete random variable take?",t("Chekli yoki sanoqli","Конечное или счётное множество","Finite or countable set"),t("Faqat intervaldagi barcha sonlar","Все числа интервала","All values in an interval"),t("Faqat manfiy","Только отрицательные","Only negative"),t("Faqat butun musbat","Только натуральные","Only positive integers"),0,"Qo‘llanmadagi ta’rif.","Определение из пособия.","Definition from the text."),
        q("44q02","Taqsimot qonunida Σpᵢ=?","В законе распределения Σpᵢ=?","In a probability distribution, Σpᵢ=?",same("1"),same("0"),same("n"),same("∞"),0,"Barcha mumkin qiymatlar ehtimollari yig‘indisi 1.","Сумма вероятностей всех возможных значений равна 1.","Probabilities of all possible values sum to 1."),
        q("44q03","F(x) qo‘llanmada qanday aniqlangan?","Как в пособии определена F(x)?","How is F(x) defined in the text?",same("P{X<x}"),same("P{X=x}"),same("P{X>x}"),same("1/P{X<x}"),0,"4.4.3-ta’rif.","Определение 4.4.3.","Definition 4.4.3."),
        q("44q04","Diskret X uchun F(x) odatda qanday?","Как обычно выглядит F(x) для дискретной X?","What is F(x) typically like for discrete X?",t("Pog‘onali","Ступенчатая","Step function"),t("Doimo parabola","Всегда парабола","Always parabolic"),t("Sinusoidal","Синусоидальная","Sinusoidal"),t("Doimo chiziqli","Всегда линейная","Always linear"),0,"Har bir atomda sakrash mavjud.","В атомах распределения происходят скачки.","It jumps at the mass points."),
        q("44q05","Taqsimot poligoni qaysi nuqtalardan quriladi?","По каким точкам строится полигон распределения?","Which points define a distribution polygon?",same("(xᵢ,pᵢ)"),same("(pᵢ,pᵢ)"),same("(xᵢ,xᵢ)"),same("(n,i)"),0,"Qiymat va uning ehtimoli koordinatalar sifatida olinadi.","Координаты — значение и его вероятность.","Coordinates are value and probability."),
        q("44q06","X={0,1,2,3}, P={0.20,0.25,0.31,0.24}. P(X=2)=?","X={0,1,2,3}, P={0.20,0.25,0.31,0.24}. P(X=2)=?","X={0,1,2,3}, P={0.20,0.25,0.31,0.24}. P(X=2)=?",same("0.31"),same("0.24"),same("0.45"),same("0.76"),0,"Jadvaldan to‘g‘ridan-to‘g‘ri olinadi.","Берётся непосредственно из таблицы.","Read directly from the table."),
        q("44q07","Shu jadval uchun F(2)=P(X<2)=?","Для этой таблицы F(2)=P(X<2)=?","For that table, F(2)=P(X<2)=?",same("0.45"),same("0.31"),same("0.76"),same("1"),0,"P(X=0)+P(X=1)=0.20+0.25=0.45.","0.20+0.25=0.45.","0.20+0.25=0.45."),
        q("44q08","F(x) ning eng katta mumkin qiymati?","Максимально возможное значение F(x)?","Largest possible value of F(x)?",same("1"),same("0"),same("∞"),same("n"),0,"Taqsimot funksiyasi 0 va 1 orasida.","Функция распределения лежит между 0 и 1.","A CDF lies between 0 and 1."),
        q("44q09","Diskret taqsimot jadvali nimani bog‘laydi?","Что связывает таблица дискретного распределения?","What does a discrete distribution table pair?",t("xᵢ va pᵢ","xᵢ и pᵢ","xᵢ and pᵢ"),t("x va hosila","x и производную","x and derivative"),t("n va integral","n и интеграл","n and integral"),t("a va b","a и b","a and b"),0,"Har bir qiymatga uning ehtimoli mos qo‘yiladi.","Каждому значению сопоставляется его вероятность.","Each value is paired with its probability."),
        q("44q10","F(x) kamayuvchi bo‘lishi mumkinmi?","Может ли F(x) убывать?","Can a CDF decrease?",t("Yo‘q, u kamaymaydi","Нет, она не убывает","No, it is nondecreasing"),t("Ha, doimo","Да, всегда","Yes, always"),t("Faqat x<0 da","Только при x<0","Only for x<0"),t("Faqat diskret holatda","Только в дискретном случае","Only when discrete"),0,"Taqsimot funksiyasi kamaymaydigan funksiya.","Функция распределения неубывает.","A CDF is nondecreasing."))

    val quiz45 = listOf(
        q("45q01","Uzluksiz X uchun F(x) nimaga teng?","Чему равна F(x) для непрерывной X?","For continuous X, what is F(x)?",same("∫₋∞ˣf(t)dt"),same("f′(x)"),same("1/f(x)"),same("Σf(x)"),0,"Qo‘llanmadagi 4.5.1-ta’rif.","Определение 4.5.1.","Definition 4.5.1."),
        q("45q02","P(a<X<b)=?","P(a<X<b)=?","P(a<X<b)=?",same("F(b)−F(a)"),same("F(a)+F(b)"),same("F(a)F(b)"),same("1"),0,"Taqsimot funksiyasi xossasi.","Свойство функции распределения.","CDF property."),
        q("45q03","Zichlik uchun ∫₋∞∞f(x)dx=?","Для плотности ∫₋∞∞f(x)dx=?","For a density, ∫₋∞∞f(x)dx=?",same("1"),same("0"),same("∞"),same("1/2"),0,"Zichlik normallashgan bo‘lishi kerak.","Плотность должна быть нормирована.","A density must be normalized."),
        q("45q04","Zichlik f(x) uchun qaysi belgi shart?","Какой знак должна иметь плотность f(x)?","What sign condition must a density satisfy?",same("f(x)≥0"),same("f(x)<0"),same("f(x)=0 hamma joyda"),same("f(x)>1"),0,"Ehtimol zichligi nomanfiy.","Плотность вероятности неотрицательна.","A probability density is nonnegative."),
        q("45q05","F differensiallanuvchi bo‘lsa f(x)=?","Если F дифференцируема, f(x)=?","If F is differentiable, f(x)=?",same("F′(x)"),same("∫Fdx"),same("1−F(x)"),same("F²(x)"),0,"Zichlik CDF ning hosilasi.","Плотность — производная функции распределения.","Density is the derivative of the CDF."),
        q("45q06","Eksponensial zichlik f(x)=αe^(−αx) qaysi sohada berilgan?","На какой области задана экспоненциальная плотность αe^(−αx) в пособии?","On what domain is αe^(−αx) used in the text?",same("x>0"),same("x<0"),same("barcha x uchun manfiy"),same("faqat x=0"),0,"Qo‘llanmadagi misolda x>0, α>0.","В примере пособия x>0, α>0.","The text's example uses x>0, α>0."),
        q("45q07","f(x)=2C/(1+x²) zichlik bo‘lsa C?","Если f(x)=2C/(1+x²) — плотность, чему равно C?","If f(x)=2C/(1+x²) is a density, what is C?",same("1/(2π)"),same("1/π"),same("2/π"),same("π/2"),0,"2C·∫dx/(1+x²)=2Cπ=1.","2C·π=1.","2C·π=1."),
        q("45q08","Uzluksiz X uchun P(X=a) odatda nimaga teng?","Для непрерывной X чему равно P(X=a)?","For a continuous X, what is P(X=a)?",same("0"),same("1"),same("f(a)"),same("F(a)"),0,"Bitta nuqtaning uzunligi nol.","Мера одной точки равна нулю.","A single point has zero measure."),
        q("45q09","P(1<X<2) eksponensial zichlikda qaysi?","Для экспоненциальной плотности чему равно P(1<X<2)?","For the exponential density, what is P(1<X<2)?",same("e^(−α)−e^(−2α)"),same("e^(−2α)−e^(−α)"),same("α"),same("1"),0,"αe^(−αx) ni 1 dan 2 gacha integrallang.","Проинтегрируйте αe^(−αx) от 1 до 2.","Integrate αe^(−αx) from 1 to 2."),
        q("45q10","F(+∞) ning limiti?","Предел F(+∞)?","Limit of F(+∞)?",same("1"),same("0"),same("∞"),same("−1"),0,"Barcha mumkin qiymatlar ehtimoli 1.","Вероятность всего пространства равна 1.","Total probability is 1."))

    val quiz46 = listOf(
        q("46q01","Diskret matematik kutilma formulasi?","Формула математического ожидания дискретной величины?","Discrete expectation formula?",same("Σxᵢpᵢ"),same("Σpᵢ²"),same("Σxᵢ"),same("√D"),0,"Qiymatlar ehtimollar bilan og‘irlanadi.","Значения взвешиваются вероятностями.","Values are weighted by probabilities."),
        q("46q02","Dispersiyaning qulay formulasi?","Удобная формула дисперсии?","Convenient variance formula?",same("M[X²]−(M[X])²"),same("M[X]²"),same("M[X²]+M[X]"),same("√M[X]"),0,"Qo‘llanmada (8) formula sifatida keltirilgan.","В пособии приведена как формула (8).","The text gives this as a convenient formula."),
        q("46q03","Standart chetlanish σ=?","Среднее квадратическое отклонение σ=?","Standard deviation σ=?",same("√D[X]"),same("D[X]²"),same("M[X]"),same("1/D[X]"),0,"Ta’rif bo‘yicha dispersiyaning ildizi.","По определению корень из дисперсии.","By definition, the square root of variance."),
        q("46q04","Binomial X uchun M[X]=?","Для биномиальной X M[X]=?","For binomial X, M[X]=?",same("np"),same("npq"),same("p/q"),same("n/p"),0,"Qo‘llanmadagi natija M=np.","В пособии M=np.","The text derives M=np."),
        q("46q05","Binomial X uchun D[X]=?","Для биномиальной X D[X]=?","For binomial X, D[X]=?",same("npq"),same("np"),same("λ"),same("n²p"),0,"Binomial dispersiya npq.","Биномиальная дисперсия npq.","Binomial variance is npq."),
        q("46q06","Puasson X uchun M va D?","Для Пуассона M и D?","For Poisson X, M and D?",same("M=D=λ"),same("M=λ,D=λ²"),same("M=np,D=npq"),same("M=0,D=1"),0,"Puasson taqsimotida ikkalasi λ.","Для распределения Пуассона оба равны λ.","For a Poisson distribution both equal λ."),
        q("46q07","Uzluksiz X uchun M[X]=?","Для непрерывной X M[X]=?","For continuous X, M[X]=?",same("∫xf(x)dx"),same("Σxp"),same("F′(x)"),same("∫F(x)dx faqat 0 dan 1 gacha"),0,"Zichlik bilan og‘irlangan integral.","Интеграл x, взвешенного плотностью.","Integral of x weighted by the density."),
        q("46q08","Moda nima?","Что такое мода?","What is the mode?",t("Zichlik maksimum nuqtasi","Точка максимума плотности","Point where density is maximal"),t("Doimo o‘rtacha","Всегда среднее","Always the mean"),t("Dispersiya","Дисперсия","Variance"),t("Tanlama hajmi","Объём выборки","Sample size"),0,"Qo‘llanmadagi 4.6.7-ta’rif.","Определение 4.6.7.","Definition 4.6.7."),
        q("46q09","Mediana uchun qaysi shart?","Какое условие для медианы?","Which condition defines the median?",same("P(X<xₚ)=P(X>xₚ)=1/2"),same("f(xₚ)=0"),same("M[X]=0"),same("D[X]=1"),0,"Mediana ehtimolni ikki teng qismga bo‘ladi.","Медиана делит вероятность пополам.","A median splits probability into two equal parts."),
        q("46q10","Doimiy c ning dispersiyasi?","Дисперсия константы c?","Variance of a constant c?",same("0"),same("c"),same("c²"),same("1"),0,"Doimiy miqdorda tarqalish yo‘q.","У константы нет разброса.","A constant has no spread."))

    val quiz47 = listOf(
        q("47q01","Tanlamadagi elementlar soni nima deyiladi?","Как называется число элементов выборки?","What is the number of observations in a sample called?",t("Tanlama hajmi","Объём выборки","Sample size"),t("Kenglik","Размах","Range"),t("Moda","Мода","Mode"),t("Parametr","Параметр","Parameter"),0,"n — tanlama hajmi.","n — объём выборки.","n is the sample size."),
        q("47q02","Variatsion qator nima?","Что такое вариационный ряд?","What is a variation series?",t("Tanlamani kamaymaydigan tartibda joylash","Упорядоченная по неубыванию выборка","Sample sorted in nondecreasing order"),t("Faqat o‘rtacha","Только среднее","Only the mean"),t("Integral jadvali","Таблица интегралов","Integral table"),t("Tasodifiy formula","Случайная формула","Random formula"),0,"4.7.3-ta’rif.","Определение 4.7.3.","Definition 4.7.3."),
        q("47q03","Nisbiy chastota pᵢ*=?","Относительная частота pᵢ*=?","Relative frequency pᵢ*=?",same("nᵢ/n"),same("n/nᵢ"),same("nᵢ+n"),same("1/nᵢ"),0,"Chastota tanlama hajmiga bo‘linadi.","Частота делится на объём выборки.","Frequency divided by sample size."),
        q("47q04","Empirik taqsimot Fₙ*(x)=?","Эмпирическая функция Fₙ*(x)=?","Empirical CDF Fₙ*(x)=?",same("nₓ/n"),same("n/nₓ"),same("Σxᵢ/n"),same("s²"),0,"nₓ — x dan kichik kuzatuvlar soni.","nₓ — число наблюдений меньше x.","nₓ is the number of observations below x."),
        q("47q05","Tanlama o‘rtachasi qanday topiladi?","Как находится выборочное среднее?","How is the sample mean computed?",same("(1/n)Σnᵢxᵢ"),same("Σnᵢ/xᵢ"),same("max−min"),same("n²"),0,"Qiymatlar chastotalar bilan og‘irlanadi.","Значения взвешиваются частотами.","Values are weighted by frequencies."),
        q("47q06","Nuqtaviy baho nima?","Что такое точечная оценка?","What is a point estimate?",t("θ ni tanlama statistikasi bilan bitta qiymat orqali baholash","Оценка θ одним значением статистики выборки","Estimating θ by a single sample-statistic value"),t("Faqat interval","Только интервал","Only an interval"),t("Faqat grafik","Только график","Only a graph"),t("Faqat jadval","Только таблица","Only a table"),0,"4.7.12-ta’rif.","Определение 4.7.12.","Definition 4.7.12."),
        q("47q07","Siljimagan baho uchun qaysi shart?","Какое условие для несмещённой оценки?","What condition defines an unbiased estimator?",same("M[θ̂]=θ"),same("D[θ̂]=0"),same("θ̂=0"),same("P=1/2"),0,"Matematik kutilma haqiqiy parametrga teng.","Математическое ожидание равно истинному параметру.","Its expectation equals the true parameter."),
        q("47q08","Maksimal ehtimollik funksiyasi uzluksiz holatda?","Функция правдоподобия в непрерывном случае?","Likelihood in the continuous case?",same("L=∏f(xᵢ,θ)"),same("L=Σf(xᵢ,θ)"),same("L=∫f dx"),same("L=F′"),0,"Qo‘llanmada ko‘paytma ko‘rinishida berilgan.","В пособии дана в виде произведения.","The text gives a product likelihood."),
        q("47q09","P(θ₁<θ<θ₂)=γ bo‘lsa (θ₁,θ₂) nima?","Если P(θ₁<θ<θ₂)=γ, что такое (θ₁,θ₂)?","If P(θ₁<θ<θ₂)=γ, what is (θ₁,θ₂)?",t("Ishonchlilik oralig‘i","Доверительный интервал","Confidence interval"),t("Variatsion qator","Вариационный ряд","Variation series"),t("Moda","Мода","Mode"),t("Taqsimot poligoni","Полигон распределения","Distribution polygon"),0,"4.7.19-ta’rif.","Определение 4.7.19.","Definition 4.7.19."),
        q("47q10","γ=0.95 normal ikki tomonli intervalda qo‘llanmada qaysi koeffitsient berilgan?","Какой коэффициент дан в пособии для γ=0.95?","Which coefficient does the text use for γ=0.95?",same("1.96"),same("2.58"),same("1"),same("0.95"),0,"Qo‘llanmada γ=0.95 uchun 1.96 berilgan.","В пособии для γ=0.95 дано 1.96.","The text uses 1.96 for γ=0.95."))

    val topic41 by lazy { TopicContent(TopicId.TOPIC_4_1, topic41Title, t("Tasodifiy hodisalar, klassik va geometrik ehtimol hamda kombinatorika.","Случайные события, классическая и геометрическая вероятность, комбинаторика.","Random events, classical/geometric probability and combinatorics."), topic41Sections, quiz41, topic41Video) }
    val topic42 by lazy { TopicContent(TopicId.TOPIC_4_2, topic42Title, t("Qo‘shish/ko‘paytirish, shartli va to‘la ehtimol, Beyes yangilanishi.","Сложение/умножение, условная и полная вероятность, обновление по Байесу.","Addition/multiplication, conditional/total probability and Bayesian updating."), topic42Sections, quiz42, topic42Video) }
    val topic43 by lazy { TopicContent(TopicId.TOPIC_4_3, topic43Title, t("Bernulli tajribalari va katta n uchun Puasson hamda normal taqriblar.","Испытания Бернулли и приближения Пуассона и нормальное при больших n.","Bernoulli trials and Poisson/normal approximations for large n."), topic43Sections, quiz43, topic43Video) }
    val topic44 by lazy { TopicContent(TopicId.TOPIC_4_4, topic44Title, t("Diskret tasodifiy miqdor, taqsimot jadvali, poligon va F(x).","Дискретная случайная величина, таблица распределения, полигон и F(x).","Discrete random variables, distribution tables, polygon and F(x)."), topic44Sections, quiz44, topic44Video) }
    val topic45 by lazy { TopicContent(TopicId.TOPIC_4_5, topic45Title, t("Uzluksiz taqsimot, zichlik, normallash va oraliq ehtimollari.","Непрерывное распределение, плотность, нормировка и вероятности интервалов.","Continuous distributions, density, normalization and interval probabilities."), topic45Sections, quiz45, topic45Video) }
    val topic46 by lazy { TopicContent(TopicId.TOPIC_4_6, topic46Title, t("Matematik kutilma, dispersiya, standart chetlanish, moda va mediana.","Математическое ожидание, дисперсия, стандартное отклонение, мода и медиана.","Expectation, variance, standard deviation, mode and median."), topic46Sections, quiz46, topic46Video) }
    val topic47 by lazy { TopicContent(TopicId.TOPIC_4_7, topic47Title, t("Tanlama, statistik qatorlar, empirik taqsimot, nuqtaviy va oraliqli baholash.","Выборка, статистические ряды, эмпирическое распределение, точечное и интервальное оценивание.","Samples, statistical series, empirical distributions, point and interval estimation."), topic47Sections, quiz47, topic47Video) }

    val topics by lazy { listOf(topic41,topic42,topic43,topic44,topic45,topic46,topic47) }
    fun topic(id:TopicId):TopicContent = when(id){
        TopicId.TOPIC_4_1->topic41; TopicId.TOPIC_4_2->topic42; TopicId.TOPIC_4_3->topic43;
        TopicId.TOPIC_4_4->topic44; TopicId.TOPIC_4_5->topic45; TopicId.TOPIC_4_6->topic46; TopicId.TOPIC_4_7->topic47;
        else->error("Not a Chapter 4 topic: $id")
    }

    val glossary = listOf(
        GlossaryTerm("Tasodifiy hodisa","Случайное событие","Random event"),
        GlossaryTerm("Elementar natija","Элементарный исход","Elementary outcome"),
        GlossaryTerm("Hodisalar fazosi","Пространство исходов","Sample space"),
        GlossaryTerm("Muqarrar hodisa","Достоверное событие","Certain event"),
        GlossaryTerm("Mumkin bo‘lmagan hodisa","Невозможное событие","Impossible event"),
        GlossaryTerm("Klassik ehtimol","Классическая вероятность","Classical probability"),
        GlossaryTerm("Geometrik ehtimol","Геометрическая вероятность","Geometric probability"),
        GlossaryTerm("O‘rinlashtirish","Размещение","Arrangement"),
        GlossaryTerm("Guruhlash","Сочетание","Combination"),
        GlossaryTerm("O‘rin almashtirish","Перестановка","Permutation"),
        GlossaryTerm("Mustaqil hodisalar","Независимые события","Independent events"),
        GlossaryTerm("To‘liq guruh","Полная группа событий","Complete group of events"),
        GlossaryTerm("Gipoteza","Гипотеза","Hypothesis"),
        GlossaryTerm("Aposterior ehtimol","Апостериорная вероятность","Posterior probability"),
        GlossaryTerm("Binomial taqsimot","Биномиальное распределение","Binomial distribution"),
        GlossaryTerm("Puasson taqsimoti","Распределение Пуассона","Poisson distribution"),
        GlossaryTerm("Muavr–Laplas formulasi","Формула Муавра–Лапласа","De Moivre–Laplace formula"),
        GlossaryTerm("Diskret tasodifiy miqdor","Дискретная случайная величина","Discrete random variable"),
        GlossaryTerm("Uzluksiz tasodifiy miqdor","Непрерывная случайная величина","Continuous random variable"),
        GlossaryTerm("Taqsimot qonuni","Закон распределения","Distribution law"),
        GlossaryTerm("Taqsimot funksiyasi","Функция распределения","Cumulative distribution function"),
        GlossaryTerm("Zichlik funksiyasi","Плотность распределения","Probability density function"),
        GlossaryTerm("Standart chetlanish","Среднее квадратическое отклонение","Standard deviation"),
        GlossaryTerm("Moda","Мода","Mode"),
        GlossaryTerm("Mediana","Медиана","Median"),
        GlossaryTerm("Bosh to‘plam","Генеральная совокупность","Population"),
        GlossaryTerm("Tanlama","Выборка","Sample"),
        GlossaryTerm("Tanlama hajmi","Объём выборки","Sample size"),
        GlossaryTerm("Variatsion qator","Вариационный ряд","Variation series"),
        GlossaryTerm("Chastota","Частота","Frequency"),
        GlossaryTerm("Nisbiy chastota","Относительная частота","Relative frequency"),
        GlossaryTerm("Statistik qator","Статистический ряд","Statistical series"),
        GlossaryTerm("Gistogramma","Гистограмма","Histogram"),
        GlossaryTerm("Nuqtaviy baho","Точечная оценка","Point estimate"),
        GlossaryTerm("Maksimal ehtimollik usuli","Метод максимального правдоподобия","Maximum likelihood method"),
        GlossaryTerm("Ishonchlilik oralig‘i","Доверительный интервал","Confidence interval"),
        GlossaryTerm("Ishonchlilik darajasi","Уровень доверия","Confidence level")
    )
}
