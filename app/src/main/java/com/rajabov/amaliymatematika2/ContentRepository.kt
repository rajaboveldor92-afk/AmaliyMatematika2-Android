package com.rajabov.amaliymatematika2

object ContentRepository {
    val appTitle = TriText("Amaliy matematika 2", "Прикладная математика 2", "Applied Mathematics 2")

    val chapter1 = TriText(
        "1-bob. Aniq integral va uning tatbiqlari",
        "Глава 1. Определённый интеграл и его приложения",
        "Chapter 1. The definite integral and its applications"
    )

    val chapter2 = TriText(
        "2-bob. Sonli va funksional qatorlar nazariyasi",
        "Глава 2. Теория числовых и функциональных рядов",
        "Chapter 2. Theory of numerical and functional series"
    )

    val chapter3 = TriText(
        "3-bob. Oddiy differensial tenglamalar va ularni yechish usullari",
        "Глава 3. Обыкновенные дифференциальные уравнения и методы их решения",
        "Chapter 3. Ordinary differential equations and methods of solution"
    )

    val chapter4 = Chapter4Content.chapterTitle

    val chapters = listOf(
        chapter1,
        chapter2,
        chapter3,
        chapter4
    )

    val topic11Title = TriText(
        "1.1. Aniq integral: ta’rif, xossalar va hisoblash usullari",
        "1.1. Определённый интеграл: определение, свойства и методы вычисления",
        "1.1. Definite integral: definition, properties and methods of evaluation"
    )

    val topic12Title = TriText(
        "1.2. Xosmas integrallar",
        "1.2. Несобственные интегралы",
        "1.2. Improper integrals"
    )

    private val topic11Sections = listOf(
        LectureSection(
            TriText("Integral yig‘indi", "Интегральная сумма", "Integral (Riemann) sum"),
            TriText(
                "[a,b] kesma a=x₀<x₁<…<xₙ=b nuqtalar bilan bo‘linadi. Har bir [xᵢ₋₁,xᵢ] dan ξᵢ tanlanib, f(ξᵢ)Δxᵢ ko‘paytmalar yig‘indisi tuziladi.",
                "Отрезок [a,b] разбивается точками a=x₀<x₁<…<xₙ=b. В каждом [xᵢ₋₁,xᵢ] выбирается ξᵢ и составляется сумма произведений f(ξᵢ)Δxᵢ.",
                "Partition [a,b] by a=x₀<x₁<…<xₙ=b. Choose ξᵢ in each [xᵢ₋₁,xᵢ] and form the sum of products f(ξᵢ)Δxᵢ."
            ),
            "Sₙ = Σᵢ₌₁ⁿ f(ξᵢ)Δxᵢ"
        ),
        LectureSection(
            TriText("Aniq integral ta’rifi", "Определение определённого интеграла", "Definition of the definite integral"),
            TriText(
                "Agar max Δxᵢ→0 da integral yig‘indining limiti mavjud bo‘lib, bo‘linish va ξᵢ nuqtalarning tanlanishiga bog‘liq bo‘lmasa, bu limit f funksiyaning a dan b gacha aniq integrali deyiladi.",
                "Если при max Δxᵢ→0 предел интегральной суммы существует и не зависит от разбиения и выбора ξᵢ, то этот предел называется определённым интегралом f от a до b.",
                "If the integral sums have a limit as max Δxᵢ→0 that is independent of the partition and the choices of ξᵢ, the limit is the definite integral of f from a to b."
            ),
            "∫ₐᵇ f(x) dx = lim Sₙ"
        ),
        LectureSection(
            TriText("Asosiy xossalar", "Основные свойства", "Main properties"),
            TriText(
                "Qo‘llanmada chiziqlilik, kesma bo‘yicha additivlik, f(x)≥0 bo‘lganda integralning nomanfiyligi va f(x)≥g(x) bo‘lganda integrallarni taqqoslash xossalari berilgan.",
                "В пособии приведены линейность, аддитивность по промежутку, неотрицательность интеграла при f(x)≥0 и свойство сравнения при f(x)≥g(x).",
                "The text gives linearity, additivity over subintervals, nonnegativity when f(x)≥0, and comparison when f(x)≥g(x)."
            ),
            "∫(λf+μg)=λ∫f+μ∫g"
        ),
        LectureSection(
            TriText("Nyuton–Leybnits formulasi", "Формула Ньютона–Лейбница", "Newton–Leibniz formula"),
            TriText(
                "Agar F funksiyaning hosilasi f ga teng bo‘lsa, aniq integral boshlang‘ich funksiyaning chegaralardagi qiymatlari ayirmasi orqali hisoblanadi.",
                "Если F′=f, определённый интеграл вычисляется как разность значений первообразной на концах промежутка.",
                "If F′=f, the definite integral equals the difference of the antiderivative at the endpoints."
            ),
            "∫ₐᵇ f(x) dx = F(b) − F(a)"
        ),
        LectureSection(
            TriText("O‘zgaruvchini almashtirish", "Замена переменной", "Substitution"),
            TriText(
                "x=φ(t), φ(α)=a, φ(β)=b va φ′ uzluksiz bo‘lsa, integral yangi o‘zgaruvchiga o‘tkaziladi. Chegaralar ham yangi o‘zgaruvchiga mos almashtiriladi.",
                "Если x=φ(t), φ(α)=a, φ(β)=b и φ′ непрерывна, интеграл переводится к новой переменной. Пределы также заменяются.",
                "For x=φ(t), φ(α)=a, φ(β)=b with continuous φ′, transform the integral to the new variable and transform the limits as well."
            ),
            "∫ₐᵇ f(x)dx = ∫ᵅᵝ f(φ(t))φ′(t)dt"
        ),
        LectureSection(
            TriText("Bo‘laklab integrallash", "Интегрирование по частям", "Integration by parts"),
            TriText(
                "u=u(x) va v=v(x) uzluksiz hosilalarga ega bo‘lganda bo‘laklab integrallash formulasi qo‘llanadi.",
                "Если u=u(x) и v=v(x) имеют непрерывные производные, применяется формула интегрирования по частям.",
                "When u=u(x) and v=v(x) have continuous derivatives, use integration by parts."
            ),
            "∫ₐᵇ u dv = [uv]ₐᵇ − ∫ₐᵇ v du"
        ),
        LectureSection(
            TriText("Qo‘llanmadagi namunaviy misol", "Пример из пособия", "Example from the text"),
            TriText(
                "∫₀¹x²dx integral yig‘indining limiti orqali hisoblanib, 1/3 natija olinadi. Shu misol interaktiv Riman yig‘indisi trenajyorida ham ishlatiladi.",
                "Интеграл ∫₀¹x²dx вычисляется через предел интегральных сумм и даёт 1/3. Этот же пример используется в интерактивном тренажёре сумм Римана.",
                "The integral ∫₀¹x²dx is evaluated through the limit of Riemann sums and equals 1/3. The same example is used in the interactive Riemann-sum trainer."
            ),
            "∫₀¹ x² dx = 1/3"
        )
    )

    private val topic12Sections = listOf(
        LectureSection(
            TriText("Xosmas integral tushunchasi", "Понятие несобственного интеграла", "Concept of an improper integral"),
            TriText(
                "Aniq integral ta’rifida integrallash oralig‘i chekli va integral ostidagi funksiya chegaralangan deb olinadi. Shu shartlardan biri bajarilmasa, xosmas integral tushunchasiga o‘tiladi.",
                "В определении обычного определённого интеграла промежуток конечен, а подынтегральная функция ограничена. Если одно из этих условий нарушено, возникает несобственный интеграл.",
                "For an ordinary definite integral the interval is finite and the integrand is bounded. If either condition fails, one uses an improper integral."
            )
        ),
        LectureSection(
            TriText("1-tur: cheksiz chegara", "Тип I: бесконечный предел", "Type I: infinite limit"),
            TriText(
                "Agar ξ→+∞ da ∫ₐ^ξ f(x)dx chekli limitga intilsa, ∫ₐ^∞f(x)dx yaqinlashuvchi deyiladi. Limit mavjud bo‘lmasa yoki cheksiz bo‘lsa, integral uzoqlashadi.",
                "Если при ξ→+∞ интеграл ∫ₐ^ξ f(x)dx стремится к конечному пределу, то ∫ₐ^∞f(x)dx сходится. Если конечного предела нет, интеграл расходится.",
                "If ∫ₐ^ξ f(x)dx tends to a finite limit as ξ→+∞, then ∫ₐ^∞f(x)dx converges; otherwise it diverges."
            ),
            "∫ₐ^∞ f(x)dx = limξ→∞ ∫ₐ^ξ f(x)dx"
        ),
        LectureSection(
            TriText("Manfiy cheksizlik", "Минус бесконечность", "Negative infinity"),
            TriText(
                "(−∞,a] oraliqda xosmas integral quyi chegarani −∞ ga olib boruvchi limit bilan aniqlanadi.",
                "На промежутке (−∞,a] несобственный интеграл определяется пределом при стремлении нижней границы к −∞.",
                "On (−∞,a], define the improper integral by sending the lower limit to −∞."
            ),
            "∫₋∞ᵃ f(x)dx = limb→−∞ ∫ᵦᵃ f(x)dx"
        ),
        LectureSection(
            TriText("p-integral: [1,∞)", "p-интеграл на [1,∞)", "p-integral on [1,∞)"),
            TriText(
                "Qo‘llanmadagi J(α)=∫₁^∞dx/x^α misolida integral α>1 bo‘lganda yaqinlashadi va qiymati 1/(α−1) ga teng; α≤1 bo‘lganda uzoqlashadi.",
                "В примере J(α)=∫₁^∞dx/x^α интеграл сходится при α>1 и равен 1/(α−1); при α≤1 расходится.",
                "For J(α)=∫₁^∞dx/x^α, the text shows convergence for α>1 with value 1/(α−1), and divergence for α≤1."
            ),
            "∫₁^∞ x⁻ᵅ dx:  α>1 ⇒ 1/(α−1)"
        ),
        LectureSection(
            TriText("2-tur: chegaralanmagan funksiya", "Тип II: неограниченная функция", "Type II: unbounded integrand"),
            TriText(
                "Agar f(x) b nuqtada aniqlanmagan yoki uzilishga ega bo‘lsa, integral b ga chapdan yaqinlashuvchi limit orqali aniqlanadi. Chekli limit mavjud bo‘lsa integral yaqinlashadi.",
                "Если f(x) не определена или имеет разрыв в точке b, интеграл определяется пределом при приближении к b слева. При существовании конечного предела интеграл сходится.",
                "If f(x) is undefined or singular at b, define the integral through a left-hand limit. A finite limit means convergence."
            ),
            "∫ₐᵇ f(x)dx = limε→0+ ∫ₐᵇ⁻ᵋ f(x)dx"
        ),
        LectureSection(
            TriText("Ichki uzilish nuqtasi", "Внутренняя точка разрыва", "Interior singularity"),
            TriText(
                "Agar c∈(a,b) nuqtada uzilish bo‘lsa, integral c ning ikki tomonidagi xosmas integrallarga ajratiladi va ikkalasi ham chekli bo‘lishi kerak.",
                "Если разрыв находится в c∈(a,b), интеграл разбивается на два несобственных интеграла; оба должны иметь конечные значения.",
                "If there is a singularity at c∈(a,b), split the integral at c; both improper integrals must converge."
            ),
            "∫ₐᵇ f = limξ→c−∫ₐ^ξf + limη→c+∫ηᵇf"
        ),
        LectureSection(
            TriText("p-integral: (0,1]", "p-интеграл на (0,1]", "p-integral on (0,1]"),
            TriText(
                "J=∫₀¹dx/x^α misolida integral α<1 bo‘lganda yaqinlashadi va 1/(1−α) ga teng; α≥1 bo‘lganda uzoqlashadi.",
                "Для J=∫₀¹dx/x^α интеграл сходится при α<1 и равен 1/(1−α); при α≥1 расходится.",
                "For J=∫₀¹dx/x^α, the integral converges for α<1 with value 1/(1−α), and diverges for α≥1."
            ),
            "∫₀¹ x⁻ᵅ dx:  α<1 ⇒ 1/(1−α)"
        ),
        LectureSection(
            TriText("Qo‘llanmadagi namunaviy misol", "Пример из пособия", "Example from the text"),
            TriText(
                "∫₀^∞ dx/(1+x²)=π/2 misoli cheksiz chegarali integralni limit orqali aniqlashni ko‘rsatadi.",
                "Пример ∫₀^∞ dx/(1+x²)=π/2 демонстрирует определение интеграла с бесконечным пределом через предел.",
                "The example ∫₀^∞ dx/(1+x²)=π/2 illustrates an infinite-limit integral defined by a limit."
            ),
            "∫₀^∞ dx/(1+x²) = π/2"
        )
    )


    val topic21Title = TriText(
        "2.1. Sonli qatorlar va yaqinlashishning zaruriy sharti",
        "2.1. Числовые ряды и необходимое условие сходимости",
        "2.1. Numerical series and the necessary condition for convergence"
    )
    val topic22Title = TriText(
        "2.2. Musbat hadli qatorlar: taqqoslash, Dalamber va Koshi alomatlari",
        "2.2. Положительные ряды: сравнение, признаки Д’Аламбера и Коши",
        "2.2. Positive-term series: comparison, ratio and root tests"
    )
    val topic23Title = TriText(
        "2.3. Funksional va darajali qatorlar. Yaqinlashish radiusi",
        "2.3. Функциональные и степенные ряды. Радиус сходимости",
        "2.3. Functional and power series. Radius of convergence"
    )
    val topic24Title = TriText(
        "2.4. Teylor va Makloren qatorlari",
        "2.4. Ряды Тейлора и Маклорена",
        "2.4. Taylor and Maclaurin series"
    )

    private val topic21Sections = listOf(
        LectureSection(TriText("Sonli qator", "Числовой ряд", "Numerical series"), TriText(
            "u₁+u₂+…+uₙ+… ifoda cheksiz sonli qator deyiladi. uₙ — qatorning umumiy hadi.",
            "Выражение u₁+u₂+…+uₙ+… называется числовым рядом. uₙ — общий член ряда.",
            "The expression u₁+u₂+…+uₙ+… is a numerical series; uₙ is its general term."), "Σₙ₌₁∞ uₙ"),
        LectureSection(TriText("Qismiy yig‘indi", "Частичная сумма", "Partial sum"), TriText(
            "Qatorning birinchi n ta hadlari yig‘indisi Sₙ=u₁+…+uₙ qismiy yig‘indi deyiladi.",
            "Сумма первых n членов Sₙ=u₁+…+uₙ называется частичной суммой.",
            "The sum of the first n terms Sₙ=u₁+…+uₙ is the partial sum."), "Sₙ = Σₖ₌₁ⁿuₖ"),
        LectureSection(TriText("Yaqinlashish", "Сходимость", "Convergence"), TriText(
            "Agar limₙ→∞Sₙ=S chekli bo‘lsa, qator yaqinlashuvchi va S uning yig‘indisi deyiladi.",
            "Если limₙ→∞Sₙ=S конечен, ряд сходится, а S называется его суммой.",
            "If limₙ→∞Sₙ=S is finite, the series converges and S is its sum."), "limₙ→∞ Sₙ = S"),
        LectureSection(TriText("Zaruriy shart", "Необходимое условие", "Necessary condition"), TriText(
            "Yaqinlashuvchi qator uchun limₙ→∞uₙ=0. Agar limit nolga teng bo‘lmasa, qator uzoqlashadi.",
            "Для сходящегося ряда limₙ→∞uₙ=0. Если предел не равен нулю, ряд расходится.",
            "A convergent series must satisfy limₙ→∞uₙ=0. If the limit is nonzero, the series diverges."), "Σuₙ convergent ⇒ uₙ→0"),
        LectureSection(TriText("Garmonik qator", "Гармонический ряд", "Harmonic series"), TriText(
            "1+1/2+1/3+… garmonik qator bo‘lib, qo‘llanmada uzoqlashuvchi qator sifatida keltirilgan.",
            "1+1/2+1/3+… — гармонический ряд; в пособии он приведён как расходящийся.",
            "1+1/2+1/3+… is the harmonic series, presented in the text as divergent."), "Σₙ₌₁∞ 1/n diverges"),
        LectureSection(TriText("Teleskopik misol", "Телескопический пример", "Telescoping example"), TriText(
            "Qo‘llanmadagi 1/[(2n−1)(2n+1)] qatori oddiy kasrlarga ajratilib, Sₙ orqali yig‘indisi 1/2 ekani ko‘rsatiladi.",
            "В пособии ряд 1/[(2n−1)(2n+1)] раскладывается на простые дроби и через Sₙ получается сумма 1/2.",
            "The text decomposes 1/[(2n−1)(2n+1)] into partial fractions and obtains sum 1/2 via Sₙ."), "Σ 1/[(2n−1)(2n+1)] = 1/2")
    )

    private val topic22Sections = listOf(
        LectureSection(TriText("Musbat hadli qator", "Положительный ряд", "Positive-term series"), TriText(
            "aₙ≥0 bo‘lgan qatorlarda qismiy yig‘indilar monoton o‘sadi. Ularning yuqoridan chegaralanganligi yaqinlashish uchun zarur va yetarli shart sifatida berilgan.",
            "Для aₙ≥0 частичные суммы монотонно возрастают. Их ограниченность сверху дана как необходимое и достаточное условие сходимости.",
            "For aₙ≥0, partial sums are increasing; boundedness above is given as necessary and sufficient for convergence.")),
        LectureSection(TriText("Taqqoslash alomati", "Признак сравнения", "Comparison test"), TriText(
            "Agar 0≤aₙ≤bₙ bo‘lsa va Σbₙ yaqinlashsa, Σaₙ ham yaqinlashadi. Katta qator uzoqlashsa, mos teskari xulosa qo‘llanadi.",
            "Если 0≤aₙ≤bₙ и Σbₙ сходится, то Σaₙ также сходится. Используется и соответствующее утверждение о расходимости.",
            "If 0≤aₙ≤bₙ and Σbₙ converges, then Σaₙ converges; the corresponding divergence comparison is also used.")),
        LectureSection(TriText("Dalamber alomati", "Признак Д’Аламбера", "Ratio test"), TriText(
            "l=lim|aₙ₊₁/aₙ| mavjud bo‘lsa: l<1 da qator yaqinlashadi, l>1 da uzoqlashadi; l=1 da alomat xulosa bermaydi.",
            "Если l=lim|aₙ₊₁/aₙ| существует: при l<1 ряд сходится, при l>1 расходится; при l=1 признак не даёт ответа.",
            "If l=lim|aₙ₊₁/aₙ| exists: l<1 implies convergence, l>1 divergence, and l=1 is inconclusive."), "l = lim |aₙ₊₁/aₙ|"),
        LectureSection(TriText("Koshi radikal alomati", "Радикальный признак Коши", "Root test"), TriText(
            "l=lim ⁿ√aₙ uchun l<1 da qator yaqinlashadi, l>1 da uzoqlashadi.",
            "Для l=lim ⁿ√aₙ: при l<1 ряд сходится, при l>1 расходится.",
            "For l=lim ⁿ√aₙ, l<1 implies convergence and l>1 divergence."), "l = lim ⁿ√aₙ"),
        LectureSection(TriText("Koshi integral alomati", "Интегральный признак Коши", "Integral test"), TriText(
            "Musbat, uzluksiz va monoton kamayuvchi f uchun aₙ=f(n) bo‘lsa, Σaₙ va ∫₁∞f(x)dx bir vaqtda yaqinlashadi yoki uzoqlashadi.",
            "Для положительной непрерывной убывающей f при aₙ=f(n) ряд Σaₙ и интеграл ∫₁∞f(x)dx сходятся или расходятся одновременно.",
            "For positive continuous decreasing f with aₙ=f(n), Σaₙ and ∫₁∞f(x)dx have the same convergence behavior.")),
        LectureSection(TriText("Umumlashgan garmonik qator", "Обобщённый гармонический ряд", "p-series"), TriText(
            "Σ1/nᵖ qatori p>1 da yaqinlashadi, p≤1 da uzoqlashadi.",
            "Ряд Σ1/nᵖ сходится при p>1 и расходится при p≤1.",
            "The p-series Σ1/nᵖ converges for p>1 and diverges for p≤1."), "Σ1/nᵖ: p>1 ⇔ convergence")
    )

    private val topic23Sections = listOf(
        LectureSection(TriText("Funksional qator", "Функциональный ряд", "Functional series"), TriText(
            "Hadlari x ning funksiyalaridan iborat Σuₙ(x) funksional qator deyiladi. Yaqinlashish sohasi — qator yaqinlashadigan x lar to‘plami.",
            "Ряд Σuₙ(x), члены которого являются функциями x, называется функциональным. Область сходимости — множество x, где ряд сходится.",
            "A series Σuₙ(x) whose terms are functions of x is a functional series; its convergence set is the set of x where it converges.")),
        LectureSection(TriText("Tekis yaqinlashish", "Равномерная сходимость", "Uniform convergence"), TriText(
            "S(x)=Sₙ(x)+Rₙ(x). Agar har bir ε>0 uchun barcha x lar bo‘yicha |Rₙ(x)|<ε bo‘ladigan N topilsa, qator tekis yaqinlashadi.",
            "S(x)=Sₙ(x)+Rₙ(x). Если для любого ε>0 существует N, после которого |Rₙ(x)|<ε для всех x, ряд сходится равномерно.",
            "Write S(x)=Sₙ(x)+Rₙ(x). Uniform convergence means that for every ε>0, one N works so that |Rₙ(x)|<ε for all x.")),
        LectureSection(TriText("Darajali qator", "Степенной ряд", "Power series"), TriText(
            "a₀+a₁(x−α)+a₂(x−α)²+… ko‘rinishdagi qator darajali qator deyiladi.",
            "Ряд a₀+a₁(x−α)+a₂(x−α)²+… называется степенным.",
            "A series a₀+a₁(x−α)+a₂(x−α)²+… is a power series."), "Σ aₙ(x−α)ⁿ"),
        LectureSection(TriText("Yaqinlashish radiusi", "Радиус сходимости", "Radius of convergence"), TriText(
            "Darajali qator |x−α|<R ichida absolyut yaqinlashadi, tashqarida uzoqlashadi; uchlar alohida tekshiriladi.",
            "Степенной ряд абсолютно сходится при |x−α|<R и расходится вне этого интервала; концы проверяются отдельно.",
            "A power series converges absolutely for |x−α|<R and diverges outside; endpoints are checked separately."), "|x−α|<R"),
        LectureSection(TriText("Radius formulasi", "Формула радиуса", "Radius formula"), TriText(
            "Ketma-ket koeffitsientlar nol bo‘lmaganda qo‘llanmada R=lim|aₙ/aₙ₊₁| formulasi ishlatiladi.",
            "При ненулевых последовательных коэффициентах в пособии используется R=lim|aₙ/aₙ₊₁|.",
            "For nonzero consecutive coefficients, the text uses R=lim|aₙ/aₙ₊₁|."), "R = lim |aₙ/aₙ₊₁|"),
        LectureSection(TriText("Namunalar", "Примеры", "Examples"), TriText(
            "Σxⁿ/n uchun R=1 va yaqinlashish sohasi −1≤x<1; Σxⁿ/n! uchun R=∞; Σn!(x−5)ⁿ uchun R=0.",
            "Для Σxⁿ/n: R=1 и область −1≤x<1; для Σxⁿ/n!: R=∞; для Σn!(x−5)ⁿ: R=0.",
            "For Σxⁿ/n, R=1 with −1≤x<1; for Σxⁿ/n!, R=∞; for Σn!(x−5)ⁿ, R=0."))
    )

    private val topic24Sections = listOf(
        LectureSection(TriText("Teylor qatori", "Ряд Тейлора", "Taylor series"), TriText(
            "Cheksiz differensiallanuvchi f funksiya x₀ atrofida hosilalari orqali darajali qatorga yoyiladi.",
            "Бесконечно дифференцируемая функция f раскладывается в степенной ряд около x₀ через свои производные.",
            "An infinitely differentiable function f is expanded around x₀ using its derivatives."), "f(x)=Σ f⁽ⁿ⁾(x₀)(x−x₀)ⁿ/n!"),
        LectureSection(TriText("Makloren qatori", "Ряд Маклорена", "Maclaurin series"), TriText(
            "x₀=0 bo‘lgandagi Teylor qatori Makloren qatori deyiladi.",
            "Ряд Тейлора при x₀=0 называется рядом Маклорена.",
            "The Taylor series centered at x₀=0 is the Maclaurin series."), "f(x)=Σ f⁽ⁿ⁾(0)xⁿ/n!"),
        LectureSection(TriText("Lagranj qoldiq hadi", "Остаток Лагранжа", "Lagrange remainder"), TriText(
            "Qo‘llanmada Rₙ(x)=f⁽ⁿ⁺¹⁾(c)(x−x₀)ⁿ⁺¹/(n+1)! ko‘rinish berilgan; qator f ga yaqinlashishi uchun Rₙ→0 talab qilinadi.",
            "В пособии дано Rₙ(x)=f⁽ⁿ⁺¹⁾(c)(x−x₀)ⁿ⁺¹/(n+1)!; для сходимости разложения к f требуется Rₙ→0.",
            "The text gives Rₙ(x)=f⁽ⁿ⁺¹⁾(c)(x−x₀)ⁿ⁺¹/(n+1)!; convergence to f requires Rₙ→0.")),
        LectureSection(TriText("Asosiy yoyilmalar", "Основные разложения", "Standard expansions"), TriText(
            "Qo‘llanmada eˣ, sin x, cos x, sh x, ch x, (1+x)ᵐ, ln(1+x) va arctan x uchun qatorlar keltirilgan.",
            "В пособии приведены ряды для eˣ, sin x, cos x, sh x, ch x, (1+x)ᵐ, ln(1+x) и arctan x.",
            "The text lists series for eˣ, sin x, cos x, sh x, ch x, (1+x)ᵐ, ln(1+x), and arctan x.")),
        LectureSection(TriText("eˣ, sin x, cos x", "eˣ, sin x, cos x", "eˣ, sin x, cos x"), TriText(
            "eˣ=1+x+x²/2!+…; sin x=x−x³/3!+x⁵/5!−…; cos x=1−x²/2!+x⁴/4!−… .",
            "eˣ=1+x+x²/2!+…; sin x=x−x³/3!+x⁵/5!−…; cos x=1−x²/2!+x⁴/4!−… .",
            "eˣ=1+x+x²/2!+…; sin x=x−x³/3!+x⁵/5!−…; cos x=1−x²/2!+x⁴/4!−… .")),
        LectureSection(TriText("Qo‘llanmadagi misollar", "Примеры из пособия", "Examples from the text"), TriText(
            "2ˣ, sin²x, e^(−x²), ln x ning (x−1) bo‘yicha va 1/x ning (x−2) bo‘yicha yoyilmalari yechilgan.",
            "Разобраны разложения 2ˣ, sin²x, e^(−x²), ln x по степеням (x−1) и 1/x по степеням (x−2).",
            "Worked examples include expansions of 2ˣ, sin²x, e^(−x²), ln x in powers of (x−1), and 1/x in powers of (x−2)."))
    )


    val topic31Title = TriText(
        "3.1. Differensial tenglamalar: asosiy tushunchalar va Koshi masalasi",
        "3.1. Дифференциальные уравнения: основные понятия и задача Коши",
        "3.1. Differential equations: basic concepts and the Cauchy problem"
    )
    val topic32Title = TriText(
        "3.2. O‘zgaruvchilari ajraladigan differensial tenglamalar",
        "3.2. Дифференциальные уравнения с разделяющимися переменными",
        "3.2. Separable differential equations"
    )
    val topic33Title = TriText(
        "3.3. Bir jinsli, chiziqli va Bernulli tenglamalari",
        "3.3. Однородные, линейные уравнения и уравнение Бернулли",
        "3.3. Homogeneous, linear and Bernoulli equations"
    )
    val topic34Title = TriText(
        "3.4. O‘zgarmas koeffitsientli yuqori tartibli chiziqli tenglamalar",
        "3.4. Линейные уравнения высших порядков с постоянными коэффициентами",
        "3.4. Higher-order linear equations with constant coefficients"
    )

    private val topic31Sections = listOf(
        LectureSection(TriText("Differensial tenglama", "Дифференциальное уравнение", "Differential equation"), TriText(
            "Differensial tenglama erkli o‘zgaruvchi, noma’lum funksiya va uning hosilalari (yoki differensiallari) orasidagi bog‘lanishni ifodalaydi. Bitta erkli o‘zgaruvchili holat oddiy differensial tenglama deyiladi.",
            "Дифференциальное уравнение выражает связь между независимой переменной, неизвестной функцией и её производными (или дифференциалами). При одной независимой переменной уравнение называется обыкновенным.",
            "A differential equation relates an independent variable, an unknown function and its derivatives (or differentials). With one independent variable it is an ordinary differential equation."), "F(x,y,y′)=0"),
        LectureSection(TriText("Tenglama tartibi", "Порядок уравнения", "Order of an equation"), TriText(
            "Differensial tenglamaning tartibi — unda qatnashgan eng yuqori tartibli hosilaning tartibi.",
            "Порядок дифференциального уравнения — порядок старшей производной, входящей в уравнение.",
            "The order of a differential equation is the order of the highest derivative occurring in it.")),
        LectureSection(TriText("Birinchi tartibli tenglama", "Уравнение первого порядка", "First-order equation"), TriText(
            "Qo‘llanmada birinchi tartibli tenglama F(x,y,y′)=0 yoki y′=f(x,y) ko‘rinishida qaraladi.",
            "В пособии уравнение первого порядка рассматривается в виде F(x,y,y′)=0 или y′=f(x,y).",
            "The text treats a first-order equation as F(x,y,y′)=0 or y′=f(x,y)."), "y′=f(x,y)"),
        LectureSection(TriText("Umumiy va xususiy yechim", "Общее и частное решение", "General and particular solution"), TriText(
            "y=φ(x,C) oilasi C ning ixtiyoriy qiymatida tenglamani qanoatlantirsa va boshlang‘ich shart orqali yagona C tanlansa, u umumiy yechimdir. C=C₀ tanlangandagi yechim xususiy yechim deyiladi.",
            "Семейство y=φ(x,C), удовлетворяющее уравнению при любом C и позволяющее однозначно выбрать C по начальному условию, является общим решением. При C=C₀ получается частное решение.",
            "A family y=φ(x,C) is a general solution when it solves the equation for arbitrary C and an initial condition selects a unique C. Fixing C=C₀ gives a particular solution."), "y=φ(x,C)"),
        LectureSection(TriText("Koshi masalasi", "Задача Коши", "Cauchy problem"), TriText(
            "y′=f(x,y) tenglamaning y(x₀)=y₀ boshlang‘ich shartni qanoatlantiruvchi yechimini topish Koshi masalasi deyiladi.",
            "Нахождение решения y′=f(x,y), удовлетворяющего начальному условию y(x₀)=y₀, называется задачей Коши.",
            "Finding a solution of y′=f(x,y) satisfying y(x₀)=y₀ is the Cauchy initial-value problem."), "y′=f(x,y),  y(x₀)=y₀"),
        LectureSection(TriText("Integral egri chiziq va yagonalik", "Интегральная кривая и единственность", "Integral curve and uniqueness"), TriText(
            "Yechimning Oxy tekislikdagi grafigi integral egri chiziq deyiladi. Qo‘llanmada f va ∂f/∂y uzluksiz bo‘lsa, boshlang‘ich nuqtadan yagona integral egri chiziq o‘tishi haqidagi Koshi teoremasi keltirilgan.",
            "График решения на плоскости Oxy называется интегральной кривой. В пособии приведена теорема Коши: при непрерывности f и ∂f/∂y через начальную точку проходит единственная интегральная кривая.",
            "The graph of a solution in the Oxy plane is an integral curve. The text states Cauchy's theorem: if f and ∂f/∂y are continuous, a unique integral curve passes through the initial point."))
    )

    private val topic32Sections = listOf(
        LectureSection(TriText("Ajraladigan ko‘rinish", "Разделяющийся вид", "Separable form"), TriText(
            "f₁(x)φ₁(y)dx+f₂(x)φ₂(y)dy=0 tenglama o‘zgaruvchilari ajraladigan turga kiradi.",
            "Уравнение f₁(x)φ₁(y)dx+f₂(x)φ₂(y)dy=0 относится к уравнениям с разделяющимися переменными.",
            "An equation f₁(x)φ₁(y)dx+f₂(x)φ₂(y)dy=0 is separable.")),
        LectureSection(TriText("O‘zgaruvchilarni ajratish", "Разделение переменных", "Separating variables"), TriText(
            "Mos ko‘paytuvchiga bo‘lgandan so‘ng x ga bog‘liq hadlar dx bilan, y ga bog‘liq hadlar dy bilan bir tomonga ajratiladi.",
            "После деления на подходящий множитель члены, зависящие от x, собираются с dx, а зависящие от y — с dy.",
            "After division by a suitable factor, x-dependent terms are grouped with dx and y-dependent terms with dy."), "f₁(x)/f₂(x) dx + φ₂(y)/φ₁(y) dy = 0"),
        LectureSection(TriText("Integrallash", "Интегрирование", "Integration"), TriText(
            "Ajratilgan tenglama hadma-had integrallanadi va oshkormas ko‘rinishdagi umumiy integral olinadi.",
            "Разделённое уравнение интегрируется почленно, и получается общий интеграл в неявном виде.",
            "Integrate the separated equation term by term to obtain an implicit general integral."), "∫ f₁/f₂ dx + ∫ φ₂/φ₁ dy = C"),
        LectureSection(TriText("Namunaviy misol", "Типовой пример", "Representative example"), TriText(
            "x(y²−4)dx+y dy=0 misolida o‘zgaruvchilar ajratilib x²+ln|y²−4|=C₁ va y²−4=Ce^(−x²) yechimlari olinadi.",
            "В примере x(y²−4)dx+y dy=0 переменные разделяются и получают x²+ln|y²−4|=C₁, затем y²−4=Ce^(−x²).",
            "For x(y²−4)dx+y dy=0, separation gives x²+ln|y²−4|=C₁ and then y²−4=Ce^(−x²)."), "y²−4=Ce^(−x²)"),
        LectureSection(TriText("Boshlang‘ich shart", "Начальное условие", "Initial condition"), TriText(
            "Umumiy yechim olingach, y(x₀)=y₀ orqali C aniqlanib xususiy yechim topiladi. Qo‘llanmada (1+x²)dy+y dx=0, y(1)=1 misoli y=e^(π/4−arctg x) yechimiga olib keladi.",
            "После получения общего решения константа C определяется из y(x₀)=y₀. В пособии для (1+x²)dy+y dx=0, y(1)=1 получено y=e^(π/4−arctg x).",
            "After finding the general solution, use y(x₀)=y₀ to determine C. The text obtains y=e^(π/4−arctan x) for (1+x²)dy+y dx=0, y(1)=1."), "y=e^(π/4−arctg x)"),
        LectureSection(TriText("Trigonometrik misol", "Тригонометрический пример", "Trigonometric example"), TriText(
            "y′=tg x·tg y tenglamasi ctg y dy=tg x dx ko‘rinishga ajraladi va sin y cos x=C umumiy integralga keladi.",
            "Уравнение y′=tg x·tg y разделяется как ctg y dy=tg x dx и приводит к общему интегралу sin y cos x=C.",
            "The equation y′=tan x·tan y separates as cot y dy=tan x dx and gives sin y cos x=C."), "sin y cos x=C")
    )

    private val topic33Sections = listOf(
        LectureSection(TriText("Bir jinsli funksiya", "Однородная функция", "Homogeneous function"), TriText(
            "f(λx,λy)=λᵐf(x,y) bo‘lsa, f m-o‘lchovli bir jinsli funksiya deyiladi. Pdx+Qdy tenglamada P va Q bir xil o‘lchovli bir jinsli bo‘lsa, tenglama bir jinsli hisoblanadi.",
            "Если f(λx,λy)=λᵐf(x,y), функция f называется однородной степени m. Уравнение Pdx+Qdy однородно, если P и Q однородны одной степени.",
            "If f(λx,λy)=λᵐf(x,y), f is homogeneous of degree m. An equation Pdx+Qdy is homogeneous when P and Q are homogeneous of the same degree.")),
        LectureSection(TriText("y=tx almashtirish", "Подстановка y=tx", "Substitution y=tx"), TriText(
            "Bir jinsli birinchi tartibli tenglama y′=f(y/x) ko‘rinishiga keltiriladi. y=tx, dy=xdt+t dx almashtirish uni ajraladigan tenglamaga aylantiradi.",
            "Однородное уравнение первого порядка приводится к y′=f(y/x). Подстановка y=tx, dy=xdt+t dx превращает его в уравнение с разделяющимися переменными.",
            "A homogeneous first-order equation is reduced to y′=f(y/x). Substituting y=tx, dy=xdt+t dx makes it separable."), "y=tx,  dy=xdt+t dx"),
        LectureSection(TriText("Birinchi tartibli chiziqli tenglama", "Линейное уравнение первого порядка", "First-order linear equation"), TriText(
            "y′+P(x)y=Q(x) ko‘rinishidagi tenglama chiziqli deyiladi. Q≡0 bo‘lsa bir jinsli, Q≠0 bo‘lsa bir jinsli bo‘lmagan.",
            "Уравнение y′+P(x)y=Q(x) называется линейным. При Q≡0 оно однородно, при Q≠0 — неоднородно.",
            "An equation y′+P(x)y=Q(x) is linear. It is homogeneous for Q≡0 and nonhomogeneous for Q≠0."), "y′+P(x)y=Q(x)"),
        LectureSection(TriText("Chiziqli bir jinsli yechim", "Решение линейного однородного уравнения", "Homogeneous linear solution"), TriText(
            "y′+P(x)y=0 uchun o‘zgaruvchilar ajratilib y=Ce^(−∫Pdx) olinadi.",
            "Для y′+P(x)y=0 разделением переменных получают y=Ce^(−∫Pdx).",
            "For y′+P(x)y=0, separation gives y=Ce^(−∫Pdx)."), "y=Ce^(−∫Pdx)"),
        LectureSection(TriText("O‘zgarmasni variatsiyalash", "Вариация постоянной", "Variation of the constant"), TriText(
            "C ni C(x) bilan almashtirish natijasida chiziqli tenglamaning umumiy yechimi y=e^(−∫Pdx)[∫Qe^(∫Pdx)dx+C] ko‘rinishda olinadi.",
            "При замене C на C(x) получают общее решение y=e^(−∫Pdx)[∫Qe^(∫Pdx)dx+C].",
            "Replacing C by C(x) gives the general solution y=e^(−∫Pdx)[∫Qe^(∫Pdx)dx+C]."), "y=e^(−∫Pdx)[∫Qe^(∫Pdx)dx+C]"),
        LectureSection(TriText("Bernulli tenglamasi", "Уравнение Бернулли", "Bernoulli equation"), TriText(
            "Qo‘llanmada y′+P(x)y=Q(x)yⁿ (n≥2) Bernulli tenglamasi deb beriladi. z=y^(1−n) almashtirish uni chiziqli tenglamaga keltiradi.",
            "В пособии y′+P(x)y=Q(x)yⁿ (n≥2) называется уравнением Бернулли. Подстановка z=y^(1−n) сводит его к линейному.",
            "The text defines y′+P(x)y=Q(x)yⁿ (n≥2) as a Bernoulli equation. The substitution z=y^(1−n) reduces it to a linear equation."), "z=y^(1−n)"),
        LectureSection(TriText("Bernulli misoli", "Пример Бернулли", "Bernoulli example"), TriText(
            "y′+xy=xy³ misolida n=3, z=y⁻² olinib z′−2xz=−2x chiziqli tenglama hosil qilinadi; natija y²(1+Ce^(x²))=1.",
            "В примере y′+xy=xy³ берут n=3, z=y⁻² и получают линейное уравнение z′−2xz=−2x; итог y²(1+Ce^(x²))=1.",
            "For y′+xy=xy³, take n=3 and z=y⁻² to obtain z′−2xz=−2x; the result is y²(1+Ce^(x²))=1."), "y²(1+Ce^(x²))=1")
    )

    private val topic34Sections = listOf(
        LectureSection(TriText("Xarakteristik tenglama", "Характеристическое уравнение", "Characteristic equation"), TriText(
            "O‘zgarmas koeffitsientli chiziqli bir jinsli tenglamada hosilalar k darajalari bilan almashtirilib algebraik xarakteristik tenglama tuziladi.",
            "Для линейного однородного уравнения с постоянными коэффициентами производные заменяются степенями k и строится алгебраическое характеристическое уравнение.",
            "For a homogeneous linear equation with constant coefficients, derivatives are replaced by powers of k to form the algebraic characteristic equation."), "kⁿ+a₁kⁿ⁻¹+…+aₙ=0"),
        LectureSection(TriText("Turli haqiqiy ildizlar", "Различные действительные корни", "Distinct real roots"), TriText(
            "Har bir oddiy haqiqiy k ildizga Ce^(kx) had mos keladi. Masalan, y′′−7y′+6y=0 uchun k=6 va k=1, shuning uchun y=C₁e^(6x)+C₂e^x.",
            "Каждому простому действительному корню k соответствует слагаемое Ce^(kx). Для y′′−7y′+6y=0 корни 6 и 1, поэтому y=C₁e^(6x)+C₂e^x.",
            "Each simple real root k contributes Ce^(kx). For y′′−7y′+6y=0 the roots are 6 and 1, hence y=C₁e^(6x)+C₂e^x.")),
        LectureSection(TriText("Karrali haqiqiy ildiz", "Кратный действительный корень", "Repeated real root"), TriText(
            "m karrali haqiqiy k ildiz uchun (C₁+C₂x+…+Cₘx^(m−1))e^(kx) ko‘rinish hosil bo‘ladi.",
            "Для действительного корня k кратности m получается (C₁+C₂x+…+Cₘx^(m−1))e^(kx).",
            "A real root k of multiplicity m gives (C₁+C₂x+…+Cₘx^(m−1))e^(kx).")),
        LectureSection(TriText("Kompleks ildizlar", "Комплексные корни", "Complex roots"), TriText(
            "α±βi oddiy qo‘shma kompleks ildizlar uchun yechim e^(αx)(C₁cosβx+C₂sinβx). Qo‘llanmada y′′−4y′+13y=0 uchun α=2, β=3 misoli berilgan.",
            "Для простых сопряжённых корней α±βi решение имеет вид e^(αx)(C₁cosβx+C₂sinβx). В пособии приведён пример y′′−4y′+13y=0 с α=2, β=3.",
            "For simple conjugate roots α±βi, the solution is e^(αx)(C₁cosβx+C₂sinβx). The text gives y′′−4y′+13y=0 with α=2, β=3."), "y=e^(αx)(C₁cosβx+C₂sinβx)"),
        LectureSection(TriText("Boshlang‘ich va chegaraviy shartlar", "Начальные и краевые условия", "Initial and boundary conditions"), TriText(
            "Umumiy yechim topilgach, boshlang‘ich yoki chegaraviy shartlar C₁,C₂,… o‘zgarmaslarni aniqlash uchun tenglamalar sistemasini beradi.",
            "После нахождения общего решения начальные или краевые условия дают систему для определения C₁,C₂,… .",
            "After finding the general solution, initial or boundary conditions provide a system for determining C₁,C₂,… .")),
        LectureSection(TriText("Bir jinsli bo‘lmagan tenglama", "Неоднородное уравнение", "Nonhomogeneous equation"), TriText(
            "Qo‘llanmada o‘ng tomoni e^(αx), sinus-kosinus, ko‘phad yoki ularning ko‘paytmalari bo‘lgan holatlar uchun xususiy yechimning maxsus ko‘rinishini tanlash usuli qo‘llanadi.",
            "В пособии для правых частей вида e^(αx), синус-косинус, полиномов и их произведений используется подбор специального вида частного решения.",
            "For forcing terms such as e^(αx), sine/cosine, polynomials and their products, the text uses an undetermined-coefficients ansatz for a particular solution.")),
        LectureSection(TriText("Rezonans holati", "Резонансный случай", "Resonance case"), TriText(
            "Agar majburlovchi funksiyaga mos α+βi xarakteristik tenglama ildizi bo‘lsa, xususiy yechim ansatzi kerakli darajadagi x ko‘paytuvchisi bilan ko‘paytiriladi. y′′+y=3sin x misolida x(Acos x+Bsin x) olinadi.",
            "Если соответствующее α+βi является корнем характеристического уравнения, пробное частное решение умножают на нужную степень x. В примере y′′+y=3sin x берут x(Acos x+Bsin x).",
            "If the corresponding α+βi is a characteristic root, multiply the particular-solution ansatz by an appropriate power of x. For y′′+y=3sin x the text uses x(Acos x+Bsin x)."), "u=x(Acos x+Bsin x)")
    )

    val topic11Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic12Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)

    val topic11 by lazy { TopicContent(
        TopicId.TOPIC_1_1,
        topic11Title,
        TriText(
            "Integral yig‘indi, aniq integral, xossalar, Nyuton–Leybnits, almashtirish va bo‘laklab integrallash.",
            "Интегральная сумма, определённый интеграл, свойства, Ньютон–Лейбниц, замена переменной и интегрирование по частям.",
            "Riemann sums, definite integrals, properties, Newton–Leibniz, substitution and integration by parts."
        ),
        topic11Sections,
        quiz11,
        topic11Video
    ) }

    val topic12 by lazy { TopicContent(
        TopicId.TOPIC_1_2,
        topic12Title,
        TriText(
            "1- va 2-tur xosmas integrallar, yaqinlashish va p-integrallar.",
            "Несобственные интегралы I и II рода, сходимость и p-интегралы.",
            "Type I and II improper integrals, convergence and p-integrals."
        ),
        topic12Sections,
        quiz12,
        topic12Video
    ) }


    val topic21Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic22Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic23Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic24Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic31Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic32Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic33Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)
    val topic34Video = VideoLesson(manifestUrl = "", drmLicenseUrl = null, isDash = false)

    val topic21 by lazy { TopicContent(TopicId.TOPIC_2_1, topic21Title,
        TriText("Sonli qator, qismiy yig‘indi, yaqinlashish, zaruriy shart va garmonik qator.", "Числовой ряд, частичные суммы, сходимость, необходимое условие и гармонический ряд.", "Numerical series, partial sums, convergence, necessary condition, and harmonic series."),
        topic21Sections, quiz21, topic21Video) }
    val topic22 by lazy { TopicContent(TopicId.TOPIC_2_2, topic22Title,
        TriText("Musbat hadli qatorlar va asosiy yaqinlashish alomatlari.", "Положительные ряды и основные признаки сходимости.", "Positive-term series and major convergence tests."),
        topic22Sections, quiz22, topic22Video) }
    val topic23 by lazy { TopicContent(TopicId.TOPIC_2_3, topic23Title,
        TriText("Funksional qatorlar, darajali qatorlar, radius va uchlarni tekshirish.", "Функциональные и степенные ряды, радиус и проверка концов.", "Functional and power series, radius of convergence, and endpoint checks."),
        topic23Sections, quiz23, topic23Video) }
    val topic24 by lazy { TopicContent(TopicId.TOPIC_2_4, topic24Title,
        TriText("Teylor va Makloren formulalari, qoldiq had va asosiy yoyilmalar.", "Формулы Тейлора и Маклорена, остаточный член и основные разложения.", "Taylor and Maclaurin formulas, remainder, and standard expansions."),
        topic24Sections, quiz24, topic24Video) }


    val topic31 by lazy { TopicContent(TopicId.TOPIC_3_1, topic31Title,
        TriText("Differensial tenglama, tartib, umumiy/xususiy yechim, Koshi masalasi va yagonalik.", "Дифференциальное уравнение, порядок, общее/частное решение, задача Коши и единственность.", "Differential equations, order, general/particular solutions, the Cauchy problem and uniqueness."),
        topic31Sections, quiz31, topic31Video) }
    val topic32 by lazy { TopicContent(TopicId.TOPIC_3_2, topic32Title,
        TriText("O‘zgaruvchilarni ajratish, integrallash va boshlang‘ich shartlar.", "Разделение переменных, интегрирование и начальные условия.", "Separation of variables, integration and initial conditions."),
        topic32Sections, quiz32, topic32Video) }
    val topic33 by lazy { TopicContent(TopicId.TOPIC_3_3, topic33Title,
        TriText("Bir jinsli almashtirish, chiziqli tenglama, o‘zgarmasni variatsiyalash va Bernulli usuli.", "Однородная подстановка, линейное уравнение, вариация постоянной и метод Бернулли.", "Homogeneous substitution, linear equations, variation of constants and Bernoulli equations."),
        topic33Sections, quiz33, topic33Video) }
    val topic34 by lazy { TopicContent(TopicId.TOPIC_3_4, topic34Title,
        TriText("Xarakteristik tenglama, ildiz turlari, boshlang‘ich shartlar va maxsus o‘ng tomonlar.", "Характеристическое уравнение, типы корней, начальные условия и специальные правые части.", "Characteristic equations, root types, initial conditions and special forcing terms."),
        topic34Sections, quiz34, topic34Video) }

    val chapter1Topics by lazy { listOf(topic11, topic12) }
    val chapter2Topics by lazy { listOf(topic21, topic22, topic23, topic24) }
    val chapter3Topics by lazy { listOf(topic31, topic32, topic33, topic34) }
    val chapter4Topics by lazy { Chapter4Content.topics }

    fun topic(id: TopicId): TopicContent = when (id) {
        TopicId.TOPIC_1_1 -> topic11
        TopicId.TOPIC_1_2 -> topic12
        TopicId.TOPIC_2_1 -> topic21
        TopicId.TOPIC_2_2 -> topic22
        TopicId.TOPIC_2_3 -> topic23
        TopicId.TOPIC_2_4 -> topic24
        TopicId.TOPIC_3_1 -> topic31
        TopicId.TOPIC_3_2 -> topic32
        TopicId.TOPIC_3_3 -> topic33
        TopicId.TOPIC_3_4 -> topic34
        TopicId.TOPIC_4_1, TopicId.TOPIC_4_2, TopicId.TOPIC_4_3, TopicId.TOPIC_4_4,
        TopicId.TOPIC_4_5, TopicId.TOPIC_4_6, TopicId.TOPIC_4_7 -> Chapter4Content.topic(id)
    }

    val glossary = listOf(
        GlossaryTerm("Aniq integral", "Определённый интеграл", "Definite integral"),
        GlossaryTerm("Integral yig‘indi", "Интегральная сумма", "Integral sum / Riemann sum"),
        GlossaryTerm("Bo‘linish diametri", "Диаметр разбиения", "Mesh / partition diameter"),
        GlossaryTerm("Quyi chegara", "Нижний предел интегрирования", "Lower limit of integration"),
        GlossaryTerm("Yuqori chegara", "Верхний предел интегрирования", "Upper limit of integration"),
        GlossaryTerm("Integral ostidagi funksiya", "Подынтегральная функция", "Integrand"),
        GlossaryTerm("Boshlang‘ich funksiya", "Первообразная", "Antiderivative"),
        GlossaryTerm("O‘zgaruvchini almashtirish", "Замена переменной", "Substitution / change of variable"),
        GlossaryTerm("Bo‘laklab integrallash", "Интегрирование по частям", "Integration by parts"),
        GlossaryTerm("Xosmas integral", "Несобственный интеграл", "Improper integral"),
        GlossaryTerm("1-tur xosmas integral", "Несобственный интеграл I рода", "Type I improper integral"),
        GlossaryTerm("2-tur xosmas integral", "Несобственный интеграл II рода", "Type II improper integral"),
        GlossaryTerm("Yaqinlashuvchi", "Сходящийся", "Convergent"),
        GlossaryTerm("Uzoqlashuvchi", "Расходящийся", "Divergent"),
        GlossaryTerm("Absolyut yaqinlashish", "Абсолютная сходимость", "Absolute convergence"),
        GlossaryTerm("Shartli yaqinlashish", "Условная сходимость", "Conditional convergence"),
        GlossaryTerm("Sonli qator", "Числовой ряд", "Numerical series"),
        GlossaryTerm("Qismiy yig‘indi", "Частичная сумма", "Partial sum"),
        GlossaryTerm("Garmonik qator", "Гармонический ряд", "Harmonic series"),
        GlossaryTerm("Darajali qator", "Степенной ряд", "Power series"),
        GlossaryTerm("Yaqinlashish radiusi", "Радиус сходимости", "Radius of convergence"),
        GlossaryTerm("Differensial tenglama", "Дифференциальное уравнение", "Differential equation"),
        GlossaryTerm("Boshlang‘ich shart", "Начальное условие", "Initial condition"),
        GlossaryTerm("Shartli ehtimol", "Условная вероятность", "Conditional probability"),
        GlossaryTerm("To‘la ehtimol", "Полная вероятность", "Total probability"),
        GlossaryTerm("Beyes formulasi", "Формула Байеса", "Bayes' formula"),
        GlossaryTerm("Bernulli sxemasi", "Схема Бернулли", "Bernoulli scheme"),
        GlossaryTerm("Tasodifiy miqdor", "Случайная величина", "Random variable"),
        GlossaryTerm("Matematik kutilma", "Математическое ожидание", "Expected value"),
        GlossaryTerm("Dispersiya", "Дисперсия", "Variance"),
        GlossaryTerm("Empirik taqsimot funksiyasi", "Эмпирическая функция распределения", "Empirical distribution function"),
        GlossaryTerm("Umumiy had", "Общий член", "General term"),
        GlossaryTerm("Qator yig‘indisi", "Сумма ряда", "Sum of a series"),
        GlossaryTerm("Teleskopik qator", "Телескопический ряд", "Telescoping series"),
        GlossaryTerm("Taqqoslash alomati", "Признак сравнения", "Comparison test"),
        GlossaryTerm("Dalamber alomati", "Признак Д’Аламбера", "Ratio test"),
        GlossaryTerm("Koshi radikal alomati", "Радикальный признак Коши", "Root test"),
        GlossaryTerm("Koshi integral alomati", "Интегральный признак Коши", "Integral test"),
        GlossaryTerm("Umumlashgan garmonik qator", "Обобщённый гармонический ряд", "p-series"),
        GlossaryTerm("Funksional qator", "Функциональный ряд", "Functional series"),
        GlossaryTerm("Tekis yaqinlashish", "Равномерная сходимость", "Uniform convergence"),
        GlossaryTerm("Yaqinlashish sohasi", "Область сходимости", "Domain of convergence"),
        GlossaryTerm("Teylor qatori", "Ряд Тейлора", "Taylor series"),
        GlossaryTerm("Makloren qatori", "Ряд Маклорена", "Maclaurin series"),
        GlossaryTerm("Qoldiq had", "Остаточный член", "Remainder term"),
        GlossaryTerm("Lagranj qoldiq hadi", "Остаток Лагранжа", "Lagrange remainder"),
        GlossaryTerm("Oddiy differensial tenglama", "Обыкновенное дифференциальное уравнение", "Ordinary differential equation"),
        GlossaryTerm("Tenglama tartibi", "Порядок уравнения", "Order of an equation"),
        GlossaryTerm("Umumiy yechim", "Общее решение", "General solution"),
        GlossaryTerm("Xususiy yechim", "Частное решение", "Particular solution"),
        GlossaryTerm("Koshi masalasi", "Задача Коши", "Cauchy problem / initial-value problem"),
        GlossaryTerm("Integral egri chiziq", "Интегральная кривая", "Integral curve"),
        GlossaryTerm("O‘zgaruvchilari ajraladigan tenglama", "Уравнение с разделяющимися переменными", "Separable differential equation"),
        GlossaryTerm("Bir jinsli differensial tenglama", "Однородное дифференциальное уравнение", "Homogeneous differential equation"),
        GlossaryTerm("Chiziqli differensial tenglama", "Линейное дифференциальное уравнение", "Linear differential equation"),
        GlossaryTerm("O‘zgarmasni variatsiyalash", "Вариация постоянной", "Variation of constants"),
        GlossaryTerm("Bernulli tenglamasi", "Уравнение Бернулли", "Bernoulli equation"),
        GlossaryTerm("Xarakteristik tenglama", "Характеристическое уравнение", "Characteristic equation"),
        GlossaryTerm("Karrali ildiz", "Кратный корень", "Repeated root"),
        GlossaryTerm("Qo‘shma kompleks ildizlar", "Сопряжённые комплексные корни", "Complex conjugate roots"),
        GlossaryTerm("Chegaraviy shart", "Краевое условие", "Boundary condition"),
        GlossaryTerm("Bir jinsli bo‘lmagan tenglama", "Неоднородное уравнение", "Nonhomogeneous equation")
    ) + Chapter4Content.glossary

    private fun same(s: String) = TriText(s, s, s)

    val quiz11 = listOf(
        QuizQuestion("11q01", TriText("Aniq integralning ta’rifi qaysi limit orqali aniqlanadi?", "Каким пределом определяется определённый интеграл?", "Which limit defines the definite integral?"), listOf(same("lim n→∞ Σf(xᵢ)"), same("lim maxΔxᵢ→0 Σf(ξᵢ)Δxᵢ"), same("Σf′(ξᵢ)Δxᵢ"), same("∫ₐᵇf′(x)dx")), 1, TriText("Integral yig‘indining bo‘linish diametri nolga intilgandagi limiti olinadi.", "Берётся предел интегральных сумм при диаметре разбиения, стремящемся к нулю.", "Take the limit of Riemann sums as the mesh tends to zero.")),
        QuizQuestion("11q02", TriText("T bo‘linishning diametri nima?", "Что такое диаметр разбиения T?", "What is the mesh of partition T?"), listOf(same("min Δxᵢ"), same("ΣΔxᵢ"), same("max Δxᵢ"), same("(b−a)/n")), 2, TriText("Diametr — bo‘linishdagi eng katta Δxᵢ.", "Диаметр — наибольшее Δxᵢ в разбиении.", "The mesh is the largest Δxᵢ in the partition.")),
        QuizQuestion("11q03", TriText("Integral yig‘indi qaysi formula bilan ifodalanadi?", "Как выражается интегральная сумма?", "Which formula is an integral sum?"), listOf(same("Σf(xᵢ)"), same("Σf′(ξᵢ)Δxᵢ"), same("Σf(ξᵢ)Δxᵢ"), same("∫f(x)dx")), 2, TriText("Har bir had f(ξᵢ)Δxᵢ ko‘rinishda.", "Каждое слагаемое имеет вид f(ξᵢ)Δxᵢ.", "Each term has the form f(ξᵢ)Δxᵢ.")),
        QuizQuestion("11q04", TriText("[a,b] da integrallanuvchi funksiya uchun zaruriy shart qaysi?", "Какое условие необходимо для интегрируемости на [a,b]?", "Which condition is necessary for integrability on [a,b]?"), listOf(TriText("Uzluksiz", "Непрерывность", "Continuity"), TriText("Monoton", "Монотонность", "Monotonicity"), TriText("Chegaralangan", "Ограниченность", "Boundedness"), TriText("Differensiallanuvchi", "Дифференцируемость", "Differentiability")), 2, TriText("Riman ma’nosida integrallanuvchi funksiya chegaralangan bo‘lishi zarur.", "Риман-интегрируемая функция должна быть ограничена.", "A Riemann-integrable function must be bounded.")),
        QuizQuestion("11q05", TriText("Dirixle funksiyasi [a,b] da:", "Функция Дирихле на [a,b]:", "The Dirichlet function on [a,b] is:"), listOf(TriText("Integrallanuvchi", "Интегрируема", "Integrable"), TriText("Chegaralanmagan", "Неограниченна", "Unbounded"), TriText("Integrallanuvchi emas", "Не интегрируема", "Not Riemann-integrable"), TriText("Monoton", "Монотонна", "Monotone")), 2, TriText("Dirixle funksiyasi Riman ma’nosida integrallanuvchi emas.", "Функция Дирихле не интегрируема по Риману.", "The Dirichlet function is not Riemann-integrable.")),
        QuizQuestion("11q06", TriText("Agar f(x)=C bo‘lsa, ∫ₐᵇf(x)dx nimaga teng?", "Если f(x)=C, чему равен ∫ₐᵇf(x)dx?", "If f(x)=C, what is ∫ₐᵇf(x)dx?"), listOf(same("C"), same("b−a"), same("C(b−a)"), same("0")), 2, TriText("Doimiy funksiyaning integrali to‘g‘ri to‘rtburchak yuziga teng.", "Интеграл постоянной равен площади прямоугольника.", "The integral of a constant equals the rectangle area.")),
        QuizQuestion("11q07", TriText("∫ₐᵃf(x)dx qiymati:", "Значение ∫ₐᵃf(x)dx:", "The value of ∫ₐᵃf(x)dx is:"), listOf(same("f(a)"), same("1"), same("0"), TriText("Aniqlanmagan", "Не определено", "Undefined")), 2, TriText("Chegaralar bir xil bo‘lsa integral 0.", "При одинаковых пределах интеграл равен 0.", "With equal limits, the integral is 0.")),
        QuizQuestion("11q08", TriText("∫ᵦᵃf(x)dx nimaga teng?", "Чему равен ∫ᵦᵃf(x)dx?", "What is ∫ᵦᵃf(x)dx?"), listOf(same("∫ₐᵇf(x)dx"), same("−∫ₐᵇf(x)dx"), same("0"), same("f(b)−f(a)")), 1, TriText("Chegaralar almashtirilsa integral ishorasi o‘zgaradi.", "При перестановке пределов знак интеграла меняется.", "Reversing the limits changes the sign.")),
        QuizQuestion("11q09", TriText("Agar f(x)≥0 bo‘lsa, ∫ₐᵇf(x)dx:", "Если f(x)≥0, то ∫ₐᵇf(x)dx:", "If f(x)≥0, then ∫ₐᵇf(x)dx is:"), listOf(TriText("Manfiy", "Отрицателен", "Negative"), TriText("Musbat yoki nol", "Неотрицателен", "Nonnegative"), TriText("Har doim nol", "Всегда ноль", "Always zero"), TriText("Cheksiz", "Бесконечен", "Infinite")), 1, TriText("Nomanfiy funksiyaning integrali nomanfiy.", "Интеграл неотрицательной функции неотрицателен.", "The integral of a nonnegative function is nonnegative.")),
        QuizQuestion("11q10", TriText("O‘rta qiymat teoremasida c qayerda yotadi?", "Где находится c в теореме о среднем?", "Where does c lie in the mean-value theorem?"), listOf(TriText("(a,b) tashqarisida", "Вне (a,b)", "Outside (a,b)"), TriText("Faqat a da", "Только в a", "Only at a"), TriText("[a,b] ichida", "В [a,b]", "In [a,b]"), TriText("Faqat b da", "Только в b", "Only at b")), 2, TriText("c integrallash oralig‘ida tanlanadi.", "c выбирается на промежутке интегрирования.", "c is chosen within the interval of integration.")),
        QuizQuestion("11q11", TriText("Agar f(x) [a,b] da uzluksiz bo‘lsa, u:", "Если f(x) непрерывна на [a,b], то она:", "If f(x) is continuous on [a,b], it is:"), listOf(TriText("Integrallanuvchi", "Интегрируема", "Integrable"), TriText("Integrallanuvchi emas", "Не интегрируема", "Not integrable"), TriText("Faqat monoton bo‘lsa integrallanuvchi", "Интегрируема только если монотонна", "Integrable only if monotone"), TriText("Faqat chegaralangan bo‘lsa integrallanuvchi", "Интегрируема только если ограничена", "Integrable only if bounded")), 0, TriText("Uzluksiz funksiya yopiq kesmada Riman ma’nosida integrallanuvchi.", "Непрерывная функция на отрезке интегрируема по Риману.", "A continuous function on a closed interval is Riemann-integrable.")),
        QuizQuestion("11q12", TriText("Nyuton–Leybnits formulasi qaysi?", "Какая формула Ньютона–Лейбница?", "Which is the Newton–Leibniz formula?"), listOf(same("∫ₐᵇf(x)dx=f(b)−f(a)"), same("∫ₐᵇf(x)dx=F(b)−F(a)"), same("∫ₐᵇf′(x)dx=F(a)+F(b)"), same("∫f(x)dx=f′(x)")), 1, TriText("F′=f bo‘lganda F(b)−F(a) olinadi.", "При F′=f берётся F(b)−F(a).", "For F′=f, use F(b)−F(a).")),
        QuizQuestion("11q13", TriText("F(x)=∫ₐˣf(t)dt bo‘lsa, F′(x)=?", "Если F(x)=∫ₐˣf(t)dt, то F′(x)=?", "If F(x)=∫ₐˣf(t)dt, then F′(x)=?"), listOf(same("f(a)"), same("f(b)"), same("f(x)"), same("0")), 2, TriText("Integral hisobning asosiy teoremasiga ko‘ra F′(x)=f(x).", "По основной теореме анализа F′(x)=f(x).", "By the fundamental theorem of calculus, F′(x)=f(x).")),
        QuizQuestion("11q14", TriText("O‘zgaruvchini almashtirish formulasini tanlang.", "Выберите формулу замены переменной.", "Choose the substitution formula."), listOf(same("∫ₐᵇf(x)dx=∫ᵅᵝf(φ(t))dt"), same("∫ₐᵇf(x)dx=∫ᵅᵝf(φ(t))φ′(t)dt"), same("∫ₐᵇf′(x)dx=f(b)−f(a)"), same("∫f(x)dx=f′(x)")), 1, TriText("dx=φ′(t)dt ko‘paytuvchisi hisobga olinadi.", "Учитывается множитель dx=φ′(t)dt.", "The factor dx=φ′(t)dt must be included.")),
        QuizQuestion("11q15", TriText("Agar f(x) toq bo‘lsa, ∫₋ₐᵃf(x)dx=?", "Если f(x) нечётная, то ∫₋ₐᵃf(x)dx=?", "If f(x) is odd, what is ∫₋ₐᵃf(x)dx?"), listOf(same("2∫₀ᵃf(x)dx"), same("0"), same("f(a)"), same("a")), 1, TriText("Toq funksiyaning simmetrik kesmadagi integrali nol.", "Интеграл нечётной функции по симметричному промежутку равен нулю.", "An odd function integrates to zero over a symmetric interval.")),
        QuizQuestion("11q16", TriText("Agar f(x) juft bo‘lsa, ∫₋ₐᵃf(x)dx=?", "Если f(x) чётная, то ∫₋ₐᵃf(x)dx=?", "If f(x) is even, what is ∫₋ₐᵃf(x)dx?"), listOf(same("0"), same("f(a)"), same("2∫₀ᵃf(x)dx"), same("a²")), 2, TriText("Juft funksiyada ikki yarimning hissasi teng.", "Для чётной функции вклады двух половин равны.", "For an even function, the two halves contribute equally.")),
        QuizQuestion("11q17", TriText("Bo‘laklab integrallash formulasi qaysi?", "Какая формула интегрирования по частям?", "Which is the integration-by-parts formula?"), listOf(same("∫u dv=uv+∫v du"), same("∫u dv=uv−∫v du"), same("∫u dv=u′v"), same("∫u dv=v′u")), 1, TriText("Bo‘laklab integrallashda ikkinchi integral minus ishora bilan olinadi.", "Во формуле интегрирования по частям второй интеграл берётся со знаком минус.", "Integration by parts uses a minus sign before the second integral.")),
        QuizQuestion("11q18", TriText("Darbu mezoniga mos shartni tanlang.", "Выберите условие критерия Дарбу.", "Choose the condition corresponding to Darboux's criterion."), listOf(same("lim(S(T)+s(T))=0"), same("lim(S(T)−s(T))=0"), same("S(T)=s(T) har doim"), TriText("f uzluksiz bo‘lishi", "f должна быть непрерывна", "f must be continuous")), 1, TriText("Yuqori va quyi Darbu yig‘indilari farqi nolga intilishi kerak.", "Разность верхней и нижней сумм Дарбу должна стремиться к нулю.", "The difference between upper and lower Darboux sums must tend to zero.")),
        QuizQuestion("11q19", TriText("m≤f(x)≤M bo‘lsa, qaysi tengsizlik to‘g‘ri?", "Если m≤f(x)≤M, какое неравенство верно?", "If m≤f(x)≤M, which inequality is correct?"), listOf(same("∫ₐᵇf=m+M"), same("m(b−a)≤∫ₐᵇf≤M(b−a)"), same("∫ₐᵇf≤0"), same("∫ₐᵇf≥M")), 1, TriText("Integral funksiyaning quyi va yuqori baholari orasida yotadi.", "Интеграл лежит между оценками через минимум и максимум.", "The integral is bounded by the lower and upper function bounds times interval length.")),
        QuizQuestion("11q20", TriText("|∫ₐᵇf(x)dx| uchun to‘g‘ri tengsizlikni tanlang.", "Выберите верное неравенство для |∫ₐᵇf(x)dx|.", "Choose the correct inequality for |∫ₐᵇf(x)dx|."), listOf(same("=∫ₐᵇ|f(x)|dx"), same("≤∫ₐᵇ|f(x)|dx"), same("≥∫ₐᵇ|f(x)|dx"), same("=0")), 1, TriText("Integral uchun uchburchak tengsizligi qo‘llanadi.", "Применяется неравенство треугольника для интеграла.", "Use the triangle inequality for integrals."))
    )

    val quiz12 = listOf(
        QuizQuestion("12q01", TriText("∫₁^∞ dx/x² integralni tekshiring.", "Исследуйте ∫₁^∞ dx/x².", "Test ∫₁^∞ dx/x²."), listOf(TriText("Yaqinlashadi, qiymati 1", "Сходится, значение 1", "Converges, value 1"), TriText("Yaqinlashadi, qiymati 0", "Сходится, значение 0", "Converges, value 0"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally")), 0, TriText("p=2>1; ∫₁^∞x⁻²dx=1.", "p=2>1; ∫₁^∞x⁻²dx=1.", "p=2>1; ∫₁^∞x⁻²dx=1.")),
        QuizQuestion("12q02", TriText("∫₁^∞ dx/x integralni tekshiring.", "Исследуйте ∫₁^∞ dx/x.", "Test ∫₁^∞ dx/x."), listOf(TriText("Yaqinlashadi, qiymati 1", "Сходится, значение 1", "Converges, value 1"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Yaqinlashadi, qiymati 0", "Сходится, значение 0", "Converges, value 0"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally")), 1, TriText("p=1 bo‘lganda logarifmik integral cheksiz o‘sadi.", "При p=1 логарифм неограниченно растёт.", "At p=1 the logarithm grows without bound.")),
        QuizQuestion("12q03", TriText("∫₀¹ dx/√x integralni tekshiring.", "Исследуйте ∫₀¹ dx/√x.", "Test ∫₀¹ dx/√x."), listOf(TriText("Yaqinlashadi, qiymati 2", "Сходится, значение 2", "Converges, value 2"), TriText("Yaqinlashadi, qiymati 1", "Сходится, значение 1", "Converges, value 1"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally")), 0, TriText("α=1/2<1 va ∫₀¹x⁻¹ᐟ²dx=2.", "α=1/2<1 и ∫₀¹x⁻¹ᐟ²dx=2.", "α=1/2<1 and ∫₀¹x⁻¹ᐟ²dx=2.")),
        QuizQuestion("12q04", TriText("∫₀¹ dx/x integralni tekshiring.", "Исследуйте ∫₀¹ dx/x.", "Test ∫₀¹ dx/x."), listOf(TriText("Yaqinlashadi", "Сходится", "Converges"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Qiymati 1", "Значение 1", "Value 1"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally")), 1, TriText("α=1 chegaraviy holat va integral uzoqlashadi.", "α=1 — граничный случай, интеграл расходится.", "α=1 is the boundary case and the integral diverges.")),
        QuizQuestion("12q05", TriText("∫₁^∞e⁻ˣdx ni hisoblang.", "Вычислите ∫₁^∞e⁻ˣdx.", "Evaluate ∫₁^∞e⁻ˣdx."), listOf(same("e⁻¹"), same("1"), same("0"), same("∞")), 0, TriText("[-e⁻ˣ]₁^∞=e⁻¹.", "[-e⁻ˣ]₁^∞=e⁻¹.", "[-e⁻ˣ]₁^∞=e⁻¹.")),
        QuizQuestion("12q06", TriText("∫₁^∞cos x dx integralni tekshiring.", "Исследуйте ∫₁^∞cos x dx.", "Test ∫₁^∞cos x dx."), listOf(TriText("Yaqinlashadi", "Сходится", "Converges"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Yaqinlashadi, qiymati 0", "Сходится, значение 0", "Converges, value 0"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally")), 1, TriText("sin b ning b→∞ limiti mavjud emas.", "Предел sin b при b→∞ не существует.", "sin b has no limit as b→∞.")),
        QuizQuestion("12q07", TriText("∫₁^∞dx/x^α qachon yaqinlashadi?", "Когда сходится ∫₁^∞dx/x^α?", "When does ∫₁^∞dx/x^α converge?"), listOf(same("α>1"), same("α≤1"), same("α<0"), TriText("Barcha α uchun", "Для всех α", "For all α")), 0, TriText("[1,∞) dagi p-integral uchun mezon α>1.", "Для p-интеграла на [1,∞) критерий: α>1.", "For the p-integral on [1,∞), the criterion is α>1.")),
        QuizQuestion("12q08", TriText("∫₀¹dx/x^0.5 ni hisoblang.", "Вычислите ∫₀¹dx/x^0.5.", "Evaluate ∫₀¹dx/x^0.5."), listOf(same("1"), same("2"), same("∞"), same("0")), 1, TriText("2√x|₀¹=2.", "2√x|₀¹=2.", "2√x|₀¹=2.")),
        QuizQuestion("12q09", TriText("∫₁^∞dx/x³ ni hisoblang.", "Вычислите ∫₁^∞dx/x³.", "Evaluate ∫₁^∞dx/x³."), listOf(same("1/2"), same("1/3"), same("1"), same("∞")), 0, TriText("1/(α−1)=1/(3−1)=1/2.", "1/(α−1)=1/(3−1)=1/2.", "1/(α−1)=1/(3−1)=1/2.")),
        QuizQuestion("12q10", TriText("Agar ∫ₐ^∞f(x)dx yaqinlashsa, b>a uchun ∫ᵦ^∞f(x)dx haqida nima deyish mumkin?", "Если ∫ₐ^∞f(x)dx сходится, что можно сказать о ∫ᵦ^∞f(x)dx при b>a?", "If ∫ₐ^∞f(x)dx converges, what about ∫ᵦ^∞f(x)dx for b>a?"), listOf(TriText("Faqat uzoqlashadi", "Всегда расходится", "Always diverges"), TriText("Ham yaqinlashadi", "Также сходится", "Also converges"), TriText("Doimo 0", "Всегда 0", "Always 0"), TriText("Doimo bir xil qiymat", "Всегда то же значение", "Always the same value")), 1, TriText("Chekli boshlang‘ich bo‘lakni olib tashlash yaqinlashuvchanlikni o‘zgartirmaydi.", "Удаление конечного начального отрезка не меняет сходимость.", "Removing a finite initial segment does not change convergence.")),
        QuizQuestion("12q11", TriText("Chegarasi ∞ bo‘lgan xosmas integral qaysi turga kiradi?", "К какому типу относится интеграл с бесконечным пределом?", "Which type has an infinite limit of integration?"), listOf(TriText("1-tur", "I рода", "Type I"), TriText("2-tur", "II рода", "Type II"), TriText("3-tur", "III рода", "Type III"), TriText("Oddiy integral", "Обычный интеграл", "Ordinary integral")), 0, TriText("Cheksiz integrallash chegarasi — 1-tur xosmas integral.", "Бесконечный предел интегрирования — несобственный интеграл I рода.", "An infinite integration limit gives a Type I improper integral.")),
        QuizQuestion("12q12", TriText("Integral osti funksiya chegarada cheksiz bo‘lsa, qaysi tur?", "Если подынтегральная функция неограниченна у границы, какой это тип?", "If the integrand is unbounded at an endpoint, which type is it?"), listOf(TriText("1-tur", "I рода", "Type I"), TriText("2-tur", "II рода", "Type II"), TriText("3-tur", "III рода", "Type III"), TriText("Oddiy integral", "Обычный интеграл", "Ordinary integral")), 1, TriText("Chegaralanmagan integrand — 2-tur xosmas integral.", "Неограниченная подынтегральная функция — интеграл II рода.", "An unbounded integrand gives a Type II improper integral.")),
        QuizQuestion("12q13", TriText("Taqqoslash alomatini qo‘llashda asosiy shart qaysi?", "Какое основное условие для признака сравнения?", "What basic condition is used for the comparison test?"), listOf(TriText("f(x)≥0, g(x)≥0", "f(x)≥0, g(x)≥0", "f(x)≥0, g(x)≥0"), same("f(x)=g(x)"), TriText("f ixtiyoriy bo‘lishi mumkin", "f может быть произвольной", "f may be arbitrary"), TriText("Faqat manfiy funksiyalar", "Только отрицательные функции", "Only negative functions")), 0, TriText("Musbat funksiyalar uchun taqqoslash mezoni qo‘llanadi.", "Признак сравнения применяется к неотрицательным функциям.", "The comparison test is applied to nonnegative functions.")),
        QuizQuestion("12q14", TriText("∫₁^∞(sin x)/x dx qanday yaqinlashadi?", "Как сходится ∫₁^∞(sin x)/x dx?", "How does ∫₁^∞(sin x)/x dx converge?"), listOf(TriText("Absolyut", "Абсолютно", "Absolutely"), TriText("Shartli", "Условно", "Conditionally"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Qiymati 0", "Значение 0", "Value 0")), 1, TriText("Bu klassik shartli yaqinlashuvchi tebranuvchi integral.", "Это классический условно сходящийся колебательный интеграл.", "This is a classical conditionally convergent oscillatory integral.")),
        QuizQuestion("12q15", TriText("∫₁^∞|sin x|/x dx qanday?", "Как ведёт себя ∫₁^∞|sin x|/x dx?", "What happens to ∫₁^∞|sin x|/x dx?"), listOf(TriText("Yaqinlashadi", "Сходится", "Converges"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Shartli yaqinlashadi", "Сходится условно", "Converges conditionally"), TriText("Qiymati 1", "Значение 1", "Value 1")), 1, TriText("Absolyut qiymat tebranishni yo‘qotadi va integral uzoqlashadi.", "Модуль устраняет знакопеременность, и интеграл расходится.", "Absolute value removes cancellation and the integral diverges.")),
        QuizQuestion("12q16", TriText("∫₀¹dx/(1−x)^(1/2) integralni tekshiring.", "Исследуйте ∫₀¹dx/(1−x)^(1/2).", "Test ∫₀¹dx/(1−x)^(1/2)."), listOf(TriText("Yaqinlashadi, qiymati 2", "Сходится, значение 2", "Converges, value 2"), TriText("Yaqinlashadi, qiymati 1", "Сходится, значение 1", "Converges, value 1"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Shartli", "Условно", "Conditionally")), 0, TriText("Qo‘llanmadagi misolda limit 2 ga teng.", "В примере пособия предел равен 2.", "In the text's example, the limit equals 2.")),
        QuizQuestion("12q17", TriText("∫₀¹dx/(1−x)² integralni tekshiring.", "Исследуйте ∫₀¹dx/(1−x)².", "Test ∫₀¹dx/(1−x)²."), listOf(TriText("Yaqinlashadi", "Сходится", "Converges"), TriText("Uzoqlashadi", "Расходится", "Diverges"), TriText("Qiymati 1", "Значение 1", "Value 1"), TriText("Shartli", "Условно", "Conditionally")), 1, TriText("Chegara yaqinida daraja 2≥1 bo‘lgani uchun integral uzoqlashadi.", "У границы степень 2≥1, поэтому интеграл расходится.", "Near the endpoint the power is 2≥1, so the integral diverges.")),
        QuizQuestion("12q18", TriText("∫₋∞^∞e^(−x²)dx haqida to‘g‘ri javobni tanlang.", "Выберите верное утверждение о ∫₋∞^∞e^(−x²)dx.", "Choose the correct statement about ∫₋∞^∞e^(−x²)dx."), listOf(TriText("Yaqinlashuvchi", "Сходится", "Convergent"), TriText("Uzoqlashuvchi", "Расходится", "Divergent"), TriText("Shartli yaqinlashuvchi", "Сходится условно", "Conditionally convergent"), TriText("Mavjud emas", "Не существует", "Does not exist")), 0, TriText("Gauss integrali absolyut yaqinlashadi.", "Интеграл Гаусса сходится абсолютно.", "The Gaussian integral converges absolutely.")),
        QuizQuestion("12q19", TriText("Absolyut yaqinlashish ta’rifini tanlang.", "Выберите определение абсолютной сходимости.", "Choose the definition of absolute convergence."), listOf(TriText("∫|f(x)|dx yaqinlashadi", "∫|f(x)|dx сходится", "∫|f(x)|dx converges"), TriText("∫f yaqinlashmasa ham bo‘ladi", "∫f может расходиться", "∫f may diverge"), TriText("∫f doimo 0", "∫f всегда 0", "∫f is always 0"), TriText("f faqat manfiy", "f только отрицательна", "f is only negative")), 0, TriText("Absolyut yaqinlashish |f| ning integrali yaqinlashishini anglatadi.", "Абсолютная сходимость означает сходимость интеграла от |f|.", "Absolute convergence means the integral of |f| converges.")),
        QuizQuestion("12q20", TriText("Abel alomati ko‘proq qaysi integrallarda qo‘llanadi?", "Для каких интегралов чаще применяют признак Абеля?", "For which integrals is Abel's test commonly used?"), listOf(TriText("Tebranuvchi ko‘paytma integrallar", "Колебательные интегралы-произведения", "Oscillatory product integrals"), TriText("Faqat ∫₁∞dx/x^α", "Только ∫₁∞dx/x^α", "Only ∫₁∞dx/x^α"), TriText("Faqat ∫₀¹dx/x^α", "Только ∫₀¹dx/x^α", "Only ∫₀¹dx/x^α"), TriText("Faqat aniq integrallar", "Только обычные определённые интегралы", "Only ordinary definite integrals")), 0, TriText("Abel alomati ko‘paytma va tebranuvchi holatlarda qo‘llanadi.", "Признак Абеля применяется к произведениям, в том числе колебательным.", "Abel's test is used for product-type, often oscillatory, integrals."))
    )

    private fun tq(s: String) = TriText(s, s, s)
    private fun q3(id:String, uz:String, ru:String, en:String, a0:TriText, a1:TriText, a2:TriText, a3:TriText, c:Int, euz:String, eru:String, een:String) =
        QuizQuestion(id, TriText(uz,ru,en), listOf(a0,a1,a2,a3), c, TriText(euz,eru,een))

    val quiz21 = listOf(
        q3("21q01","Sonli qatorning umumiy ko‘rinishi qaysi?","Каков общий вид числового ряда?","What is the general form of a numerical series?", tq("Σuₙ"), tq("∫u(x)dx"), tq("u′ₙ"), tq("lim uₙ"),0,"Qo‘llanmada qator Σuₙ ko‘rinishda yoziladi.","В пособии ряд записан как Σuₙ.","The text writes a series as Σuₙ."),
        q3("21q02","Sₙ nimani bildiradi?","Что обозначает Sₙ?","What does Sₙ denote?", TriText("Birinchi n had yig‘indisi","Сумму первых n членов","Sum of first n terms"), TriText("Faqat n-had","Только n-й член","Only nth term"), TriText("Hosila","Производную","Derivative"), TriText("Integral","Интеграл","Integral"),0,"Sₙ=u₁+…+uₙ.","Sₙ=u₁+…+uₙ.","Sₙ=u₁+…+uₙ."),
        q3("21q03","Qator qachon yaqinlashuvchi deyiladi?","Когда ряд называется сходящимся?","When is a series convergent?", TriText("Sₙ chekli limitga intilsa","Sₙ имеет конечный предел","Sₙ tends to a finite limit"), TriText("uₙ o‘sib borsa","uₙ возрастает","uₙ increases"), TriText("uₙ=1 bo‘lsa","uₙ=1","uₙ=1"), TriText("Sₙ cheksiz bo‘lsa","Sₙ бесконечна","Sₙ is infinite"),0,"Ta’rif qismiy yig‘indilar limitiga asoslanadi.","Определение основано на пределе частичных сумм.","The definition uses the limit of partial sums."),
        q3("21q04","Yaqinlashishning zaruriy sharti qaysi?","Каково необходимое условие сходимости?","What is the necessary condition for convergence?", tq("uₙ→0"), tq("uₙ→1"), tq("Sₙ→∞"), tq("uₙ<0"),0,"Yaqinlashuvchi qator uchun uₙ→0.","Для сходящегося ряда uₙ→0.","A convergent series must have uₙ→0."),
        q3("21q05","Agar lim uₙ≠0 bo‘lsa, qator...","Если lim uₙ≠0, ряд...","If lim uₙ≠0, the series...", TriText("uzoqlashadi","расходится","diverges"), TriText("yaqinlashadi","сходится","converges"), TriText("har doim 0","всегда равен 0","is always 0"), TriText("aniqlanmaydi","не определяется","is undefined"),0,"Zaruriy shart buzilgan.","Нарушено необходимое условие.","The necessary condition fails."),
        q3("21q06","Garmonik qator qaysi?","Какой ряд гармонический?","Which is the harmonic series?", tq("Σ1/n"), tq("Σ1/n²"), tq("Σ2⁻ⁿ"), tq("Σn"),0,"Garmonik qator Σ1/n.","Гармонический ряд — Σ1/n.","The harmonic series is Σ1/n."),
        q3("21q07","Garmonik qatorning xarakteri?","Каков характер гармонического ряда?","What is the behavior of the harmonic series?", TriText("Uzoqlashadi","Расходится","Diverges"), TriText("Yaqinlashadi","Сходится","Converges"), TriText("Yig‘indisi 1","Сумма 1","Sum is 1"), TriText("Yig‘indisi 1/2","Сумма 1/2","Sum is 1/2"),0,"Qo‘llanmada garmonik qator uzoqlashuvchi deb berilgan.","В пособии гармонический ряд указан как расходящийся.","The text states that the harmonic series diverges."),
        q3("21q08","Chekli sondagi boshlang‘ich hadlarni tashlash yaqinlashishga qanday ta’sir qiladi?","Как влияет отбрасывание конечного числа начальных членов?","How does removing finitely many initial terms affect convergence?", TriText("Ta’sir qilmaydi","Не влияет","Does not affect it"), TriText("Har doim yaqinlashtiradi","Всегда делает сходящимся","Always makes it converge"), TriText("Har doim uzoqlashtiradi","Всегда делает расходящимся","Always makes it diverge"), TriText("Yig‘indini nol qiladi","Делает сумму нулевой","Makes sum zero"),0,"Qo‘llanmadagi 2.1.1-teorema shu xossani beradi.","Это свойство дано в теореме 2.1.1.","Theorem 2.1.1 gives this property."),
        q3("21q09","Σ 1/[(2n−1)(2n+1)] qatorining qo‘llanmadagi yig‘indisi?","Какова сумма ряда Σ1/[(2n−1)(2n+1)] в пособии?","What sum is obtained in the text for Σ1/[(2n−1)(2n+1)]?", tq("1/2"), tq("1"), tq("1/4"), tq("∞"),0,"Teleskopik ajratish orqali 1/2 olinadi.","Телескопированием получается 1/2.","Telescoping gives 1/2."),
        q3("21q10","2/3+1/3+1/6+... geometrik qatorning maxraji q?","Каков знаменатель q геометрического ряда 2/3+1/3+1/6+...?","What is the ratio q of 2/3+1/3+1/6+...?", tq("1/2"), tq("2/3"), tq("1/3"), tq("2"),0,"Har bir keyingi had oldingisining yarmi.","Каждый следующий член вдвое меньше предыдущего.","Each next term is half the previous one."))

    val quiz22 = listOf(
        q3("22q01","Musbat hadli qator uchun qaysi shart mos?","Какое условие соответствует положительному ряду?","Which condition describes a positive-term series?", tq("aₙ≥0"), tq("aₙ<0"), tq("aₙ=(-1)ⁿ"), tq("aₙ=0 faqat"),0,"Musbat hadli qatorda hadlar nomanfiy.","В положительном ряду члены неотрицательны.","Positive-term series have nonnegative terms."),
        q3("22q02","Dalamber alomatida l<1 bo‘lsa?","Если в признаке Д’Аламбера l<1?","If l<1 in the ratio test?", TriText("Yaqinlashadi","Сходится","Converges"), TriText("Uzoqlashadi","Расходится","Diverges"), TriText("Xulosa yo‘q","Вывода нет","Inconclusive"), TriText("Faqat shartli","Только условно","Only conditionally"),0,"l<1 yaqinlashishni beradi.","l<1 даёт сходимость.","l<1 implies convergence."),
        q3("22q03","Dalamber alomatida l>1 bo‘lsa?","Если l>1 в признаке Д’Аламбера?","If l>1 in the ratio test?", TriText("Uzoqlashadi","Расходится","Diverges"), TriText("Yaqinlashadi","Сходится","Converges"), TriText("Xulosa yo‘q","Вывода нет","Inconclusive"), tq("0"),0,"l>1 uzoqlashishni beradi.","l>1 даёт расходимость.","l>1 implies divergence."),
        q3("22q04","Dalamber alomatida l=1 bo‘lsa?","Если l=1 в признаке Д’Аламбера?","If l=1 in the ratio test?", TriText("Xulosa qilib bo‘lmaydi","Признак не решает","Inconclusive"), TriText("Yaqinlashadi","Сходится","Converges"), TriText("Uzoqlashadi","Расходится","Diverges"), tq("Σ=0"),0,"Qo‘llanmadagi misolda l=1 bo‘lsa boshqa alomatga o‘tiladi.","В примере пособия при l=1 используют другой признак.","The text switches to another test when l=1."),
        q3("22q05","Koshi radikal alomati nimani tekshiradi?","Что используется в радикальном признаке Коши?","What quantity is used in the root test?", tq("lim ⁿ√aₙ"), tq("lim aₙ₊₁/aₙ"), tq("Σaₙ"), tq("∫aₙdn"),0,"Radikal alomat n-darajali ildiz limitiga asoslanadi.","Радикальный признак основан на пределе корня n-й степени.","The root test uses the nth-root limit."),
        q3("22q06","Σ1/nᵖ qachon yaqinlashadi?","Когда сходится Σ1/nᵖ?","When does Σ1/nᵖ converge?", tq("p>1"), tq("p≤1"), tq("p<0"), tq("barcha p"),0,"Integral alomatdan p>1 mezoni keladi.","По интегральному признаку получаем p>1.","The integral test gives p>1."),
        q3("22q07","Σ1/√n qatori qanday?","Как ведёт себя Σ1/√n?","What happens to Σ1/√n?", TriText("Uzoqlashadi","Расходится","Diverges"), TriText("Yaqinlashadi","Сходится","Converges"), tq("0"), TriText("Absolyut emas, shartli","Условно","Conditionally"),0,"Bu p=1/2≤1 bo‘lgan p-qator.","Это p-ряд с p=1/2≤1.","This is a p-series with p=1/2≤1."),
        q3("22q08","Integral alomat uchun f qanday bo‘lishi kerak?","Какой должна быть f для интегрального признака?","What should f be for the integral test?", TriText("Musbat, uzluksiz, kamayuvchi","Положительная, непрерывная, убывающая","Positive, continuous, decreasing"), TriText("Manfiy va o‘suvchi","Отрицательная и возрастающая","Negative and increasing"), TriText("Periodik","Периодическая","Periodic"), TriText("Ixtiyoriy","Произвольная","Arbitrary"),0,"Qo‘llanmada shu shartlar berilgan.","В пособии указаны эти условия.","These are the conditions stated in the text."),
        q3("22q09","1/(ln(n+1))ⁿ qatoriga Koshi alomatida limit nima bo‘ladi?","Каков предел в радикальном признаке для 1/(ln(n+1))ⁿ?","What is the root-test limit for 1/(ln(n+1))ⁿ?", tq("0"), tq("1"), tq("e"), tq("∞"),0,"ⁿ√aₙ=1/ln(n+1)→0.","ⁿ√aₙ=1/ln(n+1)→0.","ⁿ√aₙ=1/ln(n+1)→0."),
        q3("22q10","Qo‘llanmadagi ((n+1)/n)^(n²) misolida Koshi limiti?","Каков предел Коши в примере ((n+1)/n)^(n²)?","What is the root-test limit in the ((n+1)/n)^(n²) example?", tq("e"), tq("1/e"), tq("0"), tq("1"),0,"ⁿ√aₙ=(1+1/n)ⁿ→e>1, shuning uchun qator uzoqlashadi.","ⁿ√aₙ=(1+1/n)ⁿ→e>1, поэтому ряд расходится.","ⁿ√aₙ=(1+1/n)ⁿ→e>1, so the series diverges."))

    val quiz23 = listOf(
        q3("23q01","Funksional qatorning hadlari nima?","Что являются членами функционального ряда?","What are the terms of a functional series?", TriText("x ning funksiyalari","Функции x","Functions of x"), TriText("Faqat sonlar","Только числа","Only numbers"), TriText("Faqat integrallar","Только интегралы","Only integrals"), TriText("Matritsalar","Матрицы","Matrices"),0,"Ta’rif bo‘yicha uₙ(x) funksiyalar.","По определению это функции uₙ(x).","By definition the terms are functions uₙ(x)."),
        q3("23q02","Darajali qatorning standart ko‘rinishi?","Стандартный вид степенного ряда?","Standard form of a power series?", tq("Σaₙ(x−α)ⁿ"), tq("Σaₙ/xⁿ"), tq("∫aₙdx"), tq("Σaₙn"),0,"Darajali qator markaz α atrofida yoziladi.","Степенной ряд записывается около центра α.","A power series is written around center α."),
        q3("23q03","R nimani bildiradi?","Что обозначает R?","What does R denote?", TriText("Yaqinlashish radiusi","Радиус сходимости","Radius of convergence"), TriText("Qoldiq","Остаток","Remainder"), TriText("Qismiy yig‘indi","Частичную сумму","Partial sum"), TriText("Hosila","Производную","Derivative"),0,"R — yaqinlashish intervalining yarim uzunligi.","R — половина длины интервала сходимости.","R is the radius of convergence."),
        q3("23q04","|x−α|<R da darajali qator odatda qanday yaqinlashadi?","Как сходится степенной ряд при |x−α|<R?","How does a power series converge for |x−α|<R?", TriText("Absolyut","Абсолютно","Absolutely"), TriText("Uzoqlashadi","Расходится","Diverges"), TriText("Faqat shartli","Только условно","Only conditionally"), TriText("Aniqlanmaydi","Не определяется","Undefined"),0,"Qo‘llanmada interval ichida absolyut yaqinlashish aytilgan.","В пособии указана абсолютная сходимость внутри интервала.","The text states absolute convergence inside the interval."),
        q3("23q05","Yaqinlashish intervali uchlari bilan nima qilish kerak?","Что делать с концами интервала сходимости?","What must be done with endpoints of the convergence interval?", TriText("Alohida tekshirish","Проверять отдельно","Check separately"), TriText("Har doim qo‘shish","Всегда включать","Always include"), TriText("Har doim chiqarish","Всегда исключать","Always exclude"), TriText("E’tibor bermaslik","Игнорировать","Ignore"),0,"Uchlarda turli holatlar bo‘lishi mumkin.","На концах возможны разные случаи.","Different endpoint behavior is possible."),
        q3("23q06","Σxⁿ/n uchun qo‘llanmada R nechaga teng?","Каков R для Σxⁿ/n в пособии?","What is R for Σxⁿ/n in the text?", tq("1"), tq("0"), tq("∞"), tq("2"),0,"aₙ=1/n dan R=1.","Из aₙ=1/n получаем R=1.","From aₙ=1/n, R=1."),
        q3("23q07","Σxⁿ/n uchun yaqinlashish sohasi?","Область сходимости Σxⁿ/n?","Convergence set for Σxⁿ/n?", tq("−1≤x<1"), tq("−1<x<1"), tq("−1<x≤1"), tq("barcha x"),0,"x=−1 da Leybnits bo‘yicha yaqinlashadi, x=1 da garmonik qator uzoqlashadi.","При x=−1 ряд сходится по Лейбницу, при x=1 получаем расходящийся гармонический ряд.","At x=−1 it converges by Leibniz; at x=1 it becomes the divergent harmonic series."),
        q3("23q08","Σxⁿ/n! uchun R?","Каков R для Σxⁿ/n!?","What is R for Σxⁿ/n!?", tq("∞"), tq("1"), tq("0"), tq("e"),0,"Qo‘llanmada R=∞ olinadi.","В пособии получено R=∞.","The text obtains R=∞."),
        q3("23q09","Σn!(x−5)ⁿ uchun R?","Каков R для Σn!(x−5)ⁿ?","What is R for Σn!(x−5)ⁿ?", tq("0"), tq("1"), tq("5"), tq("∞"),0,"aₙ/aₙ₊₁=1/(n+1)→0.","aₙ/aₙ₊₁=1/(n+1)→0.","aₙ/aₙ₊₁=1/(n+1)→0."),
        q3("23q10","R=0 bo‘lsa darajali qator qayerda yaqinlashadi?","Если R=0, где сходится степенной ряд?","If R=0, where does a power series converge?", TriText("Faqat x=α da","Только при x=α","Only at x=α"), TriText("Barcha x da","Для всех x","For all x"), TriText("|x−α|<1 da","При |x−α|<1","For |x−α|<1"), TriText("Hech qayerda","Нигде","Nowhere"),0,"Qo‘llanmada R=0 holati faqat markazda yaqinlashish deb tushuntiriladi.","В пособии R=0 означает сходимость только в центре.","The text explains R=0 as convergence only at the center."))

    val quiz24 = listOf(
        q3("24q01","Makloren qatori qaysi markazda olinadi?","В каком центре получается ряд Маклорена?","At what center is the Maclaurin series taken?", tq("x₀=0"), tq("x₀=1"), tq("x₀=−1"), tq("x₀=∞"),0,"Makloren — x₀=0 dagi Teylor qatori.","Маклорен — ряд Тейлора при x₀=0.","Maclaurin is Taylor centered at x₀=0."),
        q3("24q02","Teylor qatoridagi n-had koeffitsienti?","Каков коэффициент n-го члена ряда Тейлора?","What is the nth Taylor coefficient?", tq("f⁽ⁿ⁾(x₀)/n!"), tq("f(x₀)n!"), tq("f′(x)/n"), tq("1/f⁽ⁿ⁾"),0,"Formula f⁽ⁿ⁾(x₀)/n!.","Коэффициент равен f⁽ⁿ⁾(x₀)/n!.","It is f⁽ⁿ⁾(x₀)/n!."),
        q3("24q03","Lagranj qoldiq hadi qaysi tartibli hosilani ishlatadi?","Производную какого порядка использует остаток Лагранжа?","Which derivative order appears in the Lagrange remainder?", tq("n+1"), tq("n"), tq("1"), tq("2n"),0,"Rₙ da f⁽ⁿ⁺¹⁾(c) qatnashadi.","В Rₙ входит f⁽ⁿ⁺¹⁾(c).","Rₙ contains f⁽ⁿ⁺¹⁾(c)."),
        q3("24q04","eˣ ning Makloren qatori?","Ряд Маклорена для eˣ?","Maclaurin series for eˣ?", tq("1+x+x²/2!+x³/3!+…"), tq("1−x²/2!+…"), tq("x−x³/3!+…"), tq("1−x+x²−…"),0,"Qo‘llanmada eˣ uchun standart yoyilma berilgan.","В пособии дано стандартное разложение eˣ.","The text gives the standard expansion of eˣ."),
        q3("24q05","sin x ning Makloren qatori qaysi?","Каков ряд Маклорена для sin x?","Which is the Maclaurin series for sin x?", tq("x−x³/3!+x⁵/5!−…"), tq("1−x²/2!+…"), tq("1+x+x²/2!+…"), tq("x+x²+x³+…"),0,"sin x da faqat toq darajalar va almashinuvchi ishora bor.","Для sin x идут нечётные степени с чередованием знаков.","sin x has odd powers with alternating signs."),
        q3("24q06","cos x ning Makloren qatori qaysi?","Каков ряд Маклорена для cos x?","Which is the Maclaurin series for cos x?", tq("1−x²/2!+x⁴/4!−…"), tq("x−x³/3!+…"), tq("1+x+x²/2!+…"), tq("1/(1−x)"),0,"cos x da juft darajalar qatnashadi.","В cos x участвуют чётные степени.","cos x uses even powers."),
        q3("24q07","ln(1+x) qatori qanday boshlanadi?","Как начинается ряд ln(1+x)?","How does the series for ln(1+x) begin?", tq("x−x²/2+x³/3−…"), tq("1+x+x²+…"), tq("x+x³/3+…"), tq("1−x²/2!+…"),0,"Qo‘llanmadagi formula shu.","Это формула из пособия.","This is the formula in the text."),
        q3("24q08","e^(−x²) yoyilmasining boshlanishi?","Как начинается разложение e^(−x²)?","How does e^(−x²) begin?", tq("1−x²+x⁴/2!−x⁶/3!+…"), tq("1+x²+x⁴/2!+…"), tq("x−x³/3!+…"), tq("1−x+x²/2!−…"),0,"eˣ qatorida x o‘rniga −x² qo‘yiladi.","В ряду eˣ заменяем x на −x².","Substitute −x² for x in the series for eˣ."),
        q3("24q09","1/x ni (x−2) darajalari bo‘yicha yoyishda yaqinlashish sharti?","Условие сходимости разложения 1/x по степеням (x−2)?","Convergence condition for expanding 1/x in powers of (x−2)?", tq("0<x<4"), tq("x>4"), tq("x<0"), tq("barcha x"),0,"|(x−2)/2|<1 dan 0<x<4 keladi.","Из |(x−2)/2|<1 получаем 0<x<4.","|(x−2)/2|<1 gives 0<x<4."),
        q3("24q10","Taqribiy xatolik |f(x)−Sₙ(x)| nimaga teng?","Чему равна ошибка |f(x)−Sₙ(x)|?","What is the approximation error |f(x)−Sₙ(x)|?", tq("|Rₙ(x)|"), tq("|Sₙ(x)|"), tq("|f(x)|"), tq("0 har doim"),0,"f=Sₙ+Rₙ bo‘lgani uchun farq Rₙ.","Так как f=Sₙ+Rₙ, разность равна Rₙ.","Since f=Sₙ+Rₙ, the difference is Rₙ."))


    val quiz31 = listOf(
        q3("31q01","Noma’lum funksiya va uning hosilalarini bog‘lovchi tenglama nima deyiladi?","Как называется уравнение, связывающее неизвестную функцию и её производные?","What is an equation relating an unknown function and its derivatives called?", TriText("Differensial tenglama","Дифференциальное уравнение","Differential equation"), TriText("Algebraik tenglama","Алгебраическое уравнение","Algebraic equation"), TriText("Integral tenglama","Интегральное уравнение","Integral equation"), TriText("Funksional tenglama","Функциональное уравнение","Functional equation"),0,"Bu qo‘llanmadagi asosiy ta’rif.","Это основное определение из пособия.","This is the basic definition in the text."),
        q3("31q02","Bitta erkli o‘zgaruvchili differensial tenglama qanday ataladi?","Как называется дифференциальное уравнение с одной независимой переменной?","What is a differential equation with one independent variable called?", TriText("Oddiy differensial tenglama","Обыкновенное дифференциальное уравнение","Ordinary differential equation"), TriText("Xususiy hosilali tenglama","Уравнение в частных производных","Partial differential equation"), TriText("Algebraik tenglama","Алгебраическое уравнение","Algebraic equation"), TriText("Integral tenglama","Интегральное уравнение","Integral equation"),0,"Bitta erkli o‘zgaruvchi — oddiy differensial tenglama.","Одна независимая переменная — ОДУ.","One independent variable gives an ODE."),
        q3("31q03","Differensial tenglamaning tartibi nima bilan aniqlanadi?","Чем определяется порядок дифференциального уравнения?","What determines the order of a differential equation?", TriText("Eng yuqori hosila tartibi","Порядком старшей производной","Highest derivative order"), TriText("O‘zgaruvchilar soni","Числом переменных","Number of variables"), TriText("Eng katta koeffitsient","Наибольшим коэффициентом","Largest coefficient"), TriText("Yechimlar soni","Числом решений","Number of solutions"),0,"Tartib eng yuqori hosila bilan belgilanadi.","Порядок задаётся старшей производной.","The highest derivative sets the order."),
        q3("31q04","xy′+y′′sin x=0 tenglama nechanchi tartibli?","Какого порядка xy′+y′′sin x=0?","What is the order of xy′+y′′sin x=0?", tq("2"), tq("1"), tq("3"), tq("4"),0,"Eng yuqori hosila y′′.","Старшая производная y′′.","The highest derivative is y′′."),
        q3("31q05","Tenglamani ayniyatga aylantiruvchi y=φ(x) nima?","Что такое y=φ(x), превращающая уравнение в тождество?","What is a function y=φ(x) that makes the equation an identity?", TriText("Yechim","Решение","Solution"), TriText("Argument","Аргумент","Argument"), TriText("Parametr","Параметр","Parameter"), TriText("Hosila","Производная","Derivative"),0,"Bu differensial tenglama yechimining ta’rifi.","Это определение решения дифференциального уравнения.","This is the definition of a solution."),
        q3("31q06","y=φ(x,C) nimani ifodalaydi?","Что выражает y=φ(x,C)?","What does y=φ(x,C) represent?", TriText("Umumiy yechim oilasini","Семейство общего решения","A family of general solutions"), TriText("Faqat bitta nuqtani","Только одну точку","Only one point"), TriText("Faqat hosilani","Только производную","Only the derivative"), TriText("Integralni","Интеграл","An integral"),0,"C parametrli oila umumiy yechim sifatida qaraladi.","Семейство с параметром C является общим решением.","A family with parameter C is the general solution."),
        q3("31q07","y(x₀)=y₀ shartni qanoatlantiruvchi yechimni topish nima deyiladi?","Как называется поиск решения, удовлетворяющего y(x₀)=y₀?","What is finding a solution satisfying y(x₀)=y₀ called?", TriText("Koshi masalasi","Задача Коши","Cauchy problem"), TriText("Darbu masalasi","Задача Дарбу","Darboux problem"), TriText("Teylor masalasi","Задача Тейлора","Taylor problem"), TriText("Abel masalasi","Задача Абеля","Abel problem"),0,"Qo‘llanmada bu Koshi masalasi deb ataladi.","В пособии это называется задачей Коши.","The text calls this the Cauchy problem."),
        q3("31q08","Yechim grafigi geometrik jihatdan nima deyiladi?","Как геометрически называется график решения?","What is the graph of a solution called geometrically?", TriText("Integral egri chiziq","Интегральная кривая","Integral curve"), TriText("Urinma","Касательная","Tangent"), TriText("Vektor","Вектор","Vector"), TriText("Asimptota","Асимптота","Asymptote"),0,"Yechim grafigi integral egri chiziq.","График решения — интегральная кривая.","The graph is an integral curve."),
        q3("31q09","Koshi teoremasida yagonalik uchun qaysi hosila uzluksizligi keltirilgan?","Непрерывность какой производной указана для единственности в теореме Коши?","Continuity of which derivative is stated for uniqueness in Cauchy's theorem?", tq("∂f/∂y"), tq("∂f/∂x"), tq("d²f/dx²"), tq("∂²f/∂x∂y"),0,"Qo‘llanmada f va ∂f/∂y uzluksizligi berilgan.","В пособии указана непрерывность f и ∂f/∂y.","The text states continuity of f and ∂f/∂y."),
        q3("31q10","y=C/x qaysi tenglamani qanoatlantiradi?","Какое уравнение удовлетворяет y=C/x?","Which equation is satisfied by y=C/x?", tq("y′=−y/x"), tq("y′=x/y"), tq("y′=y²"), tq("y′=x+y"),0,"y′=−C/x²=−y/x.","y′=−C/x²=−y/x.","y′=−C/x²=−y/x."),
        q3("31q11","Umumiy yechimdan xususiy yechim olish uchun nima aniqlanadi?","Что определяется для получения частного решения из общего?","What is determined to obtain a particular solution from a general solution?", TriText("O‘zgarmas C","Постоянная C","Constant C"), TriText("Argument x","Аргумент x","Argument x"), TriText("Hosila y′","Производная y′","Derivative y′"), TriText("Tartib","Порядок","Order"),0,"Boshlang‘ich shart C ni belgilaydi.","Начальное условие определяет C.","The initial condition determines C."),
        q3("31q12","y=sin x qaysi tenglamaning yechimi?","Решением какого уравнения является y=sin x?","y=sin x solves which equation?", tq("y′′+y=0"), tq("y′+y=0"), tq("y′′−y=0"), tq("y′=cos²x"),0,"sin x uchun y′′=−sin x.","Для sin x имеем y′′=−sin x.","For sin x, y′′=−sin x."),
        q3("31q13","F(x,y,y′)=0 qaysi tartibdagi tenglamaning umumiy ko‘rinishi sifatida berilgan?","Для какого порядка в пособии приведён вид F(x,y,y′)=0?","F(x,y,y′)=0 is given as the general form of which order?", TriText("Birinchi tartib","Первый порядок","First order"), TriText("Ikkinchi tartib","Второй порядок","Second order"), TriText("Uchinchi tartib","Третий порядок","Third order"), TriText("Nolinchi tartib","Нулевой порядок","Order zero"),0,"Faqat y′ gacha hosila qatnashgan.","Входит производная только до y′.","Only derivatives up to y′ occur."),
        q3("31q14","x=0 da aniqlanmagan y′=−y/x uchun y(0)=5 sharti nega mos emas?","Почему условие y(0)=5 не подходит для y′=−y/x?","Why is y(0)=5 inappropriate for y′=−y/x?", TriText("Tenglama x=0 da aniqlanmagan","Уравнение не определено при x=0","The equation is undefined at x=0"), TriText("y manfiy bo‘la olmaydi","y не может быть отрицательной","y cannot be negative"), tq("C=0"), TriText("Tartib kichik","Порядок мал","Order is too low"),0,"O‘ng tomon x=0 da mavjud emas.","Правая часть не определена при x=0.","The right side is undefined at x=0."),
        q3("31q15","Differensial tenglamani yechimini topish jarayoni qanday ataladi?","Как называется процесс нахождения решения дифференциального уравнения?","What is the process of finding a differential-equation solution called?", TriText("Integrallash","Интегрирование","Integration"), TriText("Differensiallash","Дифференцирование","Differentiation"), TriText("Faktorlash","Факторизация","Factoring"), TriText("Approksimatsiya","Аппроксимация","Approximation"),0,"Qo‘llanmada bu integrallash deb ataladi.","В пособии это называется интегрированием.","The text calls the process integration."))

    val quiz32 = listOf(
        q3("32q01","O‘zgaruvchilari ajraladigan tenglamaning asosiy g‘oyasi nima?","В чём основная идея уравнения с разделяющимися переменными?","What is the central idea of a separable equation?", TriText("x va y hadlarini ajratish","Разделить члены с x и y","Separate x- and y-dependent terms"), TriText("Faqat x ni nol qilish","Положить x=0","Set x=0"), TriText("Faqat y ni nol qilish","Положить y=0","Set y=0"), TriText("Hosilani yo‘qotmaslik","Не устранять производную","Never eliminate derivative"),0,"x-hadlar dx bilan, y-hadlar dy bilan ajratiladi.","Члены x собираются с dx, y — с dy.","Group x terms with dx and y terms with dy."),
        q3("32q02","M(x)dx+N(y)dy=0 qanday yechiladi?","Как решается M(x)dx+N(y)dy=0?","How is M(x)dx+N(y)dy=0 solved?", tq("∫M(x)dx+∫N(y)dy=C"), tq("M(x)N(y)=C"), tq("M′(x)=N′(y)"), tq("y=Mx+N"),0,"Hadma-had integrallash qo‘llanadi.","Применяется почленное интегрирование.","Integrate term by term."),
        q3("32q03","y′=2y/x tenglamaning umumiy yechimi qaysi?","Каково общее решение y′=2y/x?","What is the general solution of y′=2y/x?", tq("y=Cx²"), tq("y=Cx"), tq("y=C/x"), tq("y=x²+C"),0,"dy/y=2dx/x, shundan y=Cx².","dy/y=2dx/x, откуда y=Cx².","dy/y=2dx/x gives y=Cx²."),
        q3("32q04","y′=tg x·tg y uchun ajratilgan ko‘rinish qaysi?","Каков разделённый вид для y′=tg x·tg y?","What is the separated form for y′=tan x·tan y?", tq("ctg y dy=tg x dx"), tq("tg y dy=ctg x dx"), tq("dy=dx"), tq("sin y dy=cos x dx"),0,"Qo‘llanmadagi 3.2.3-misol shu ko‘rinishga keladi.","Пример 3.2.3 сводится именно к этому виду.","Example 3.2.3 reduces to this form."),
        q3("32q05","y′=tg x·tg y ning umumiy integrali?","Общий интеграл y′=tg x·tg y?","General integral of y′=tan x·tan y?", tq("sin y cos x=C"), tq("cos y sin x=C"), tq("y=x+C"), tq("xy=C"),0,"Integrallashdan sin y cos x=C olinadi.","После интегрирования получаем sin y cos x=C.","Integration gives sin y cos x=C."),
        q3("32q06","x(y²−4)dx+y dy=0 misolida qaysi yakuniy ko‘rinish olingan?","Какой итоговый вид получен для x(y²−4)dx+y dy=0?","What final form is obtained for x(y²−4)dx+y dy=0?", tq("y²−4=Ce^(−x²)"), tq("y²+4=Ce^(x²)"), tq("y=Cx"), tq("x²+y²=C"),0,"Qo‘llanmadagi yechim y²−4=Ce^(−x²).","В пособии получено y²−4=Ce^(−x²).","The text obtains y²−4=Ce^(−x²)."),
        q3("32q07","(1+x²)dy+y dx=0 da ajratilgan ko‘rinish?","Каков разделённый вид для (1+x²)dy+y dx=0?","What is the separated form of (1+x²)dy+y dx=0?", tq("dy/y=−dx/(1+x²)"), tq("dy/y=dx/(1+x²)"), tq("y dy=−x dx"), tq("dy=−y dx"),0,"y va x hadlari alohida tomonlarga olinadi.","Члены y и x разделяются.","Separate the y- and x-dependent terms."),
        q3("32q08","(1+x²)dy+y dx=0 ning umumiy yechimi qaysi logarifmik ko‘rinishda?","Каков общий интеграл (1+x²)dy+y dx=0 в логарифмическом виде?","What is the logarithmic general solution of (1+x²)dy+y dx=0?", tq("ln|y|=−arctg x+C"), tq("ln|y|=arctg x+C"), tq("y=x+C"), tq("ln|x|=−y+C"),0,"∫dx/(1+x²)=arctg x.","∫dx/(1+x²)=arctg x.","∫dx/(1+x²)=arctan x."),
        q3("32q09","y(1)=1 shartda (1+x²)dy+y dx=0 uchun yechim?","Каково решение (1+x²)dy+y dx=0 при y(1)=1?","Solution of (1+x²)dy+y dx=0 with y(1)=1?", tq("y=e^(π/4−arctg x)"), tq("y=e^(arctg x−π/4)"), tq("y=1+x²"), tq("y=x"),0,"C=π/4 aniqlanadi.","Получается C=π/4.","The condition gives C=π/4."),
        q3("32q10","Oshkormas ko‘rinishdagi Φ(x,y)=C yechim nima deb ataladi?","Как называется решение в неявном виде Φ(x,y)=C?","What is an implicit solution Φ(x,y)=C called?", TriText("Differensial tenglama integrali","Интеграл дифференциального уравнения","Integral of the differential equation"), TriText("Hosila","Производная","Derivative"), TriText("Argument","Аргумент","Argument"), TriText("Qismiy yig‘indi","Частичная сумма","Partial sum"),0,"Qo‘llanmada oshkormas yechim integral deb ataladi.","В пособии неявное решение называется интегралом уравнения.","The text calls an implicit solution an integral of the equation."),
        q3("32q11","Ajratishdan keyin integrallash o‘zgarmasi qayerda paydo bo‘ladi?","Где появляется постоянная интегрирования после разделения?","Where does the integration constant appear after separation?", TriText("Umumiy integralda","В общем интеграле","In the general integral"), TriText("Hosilada","В производной","In the derivative"), TriText("Faqat boshlang‘ich shartda","Только в начальном условии","Only in the initial condition"), TriText("Paydo bo‘lmaydi","Не появляется","It does not appear"),0,"Ikki integral yig‘indisi C ga tenglashtiriladi.","Сумма интегралов приравнивается C.","The integrated relation is set equal to C."),
        q3("32q12","Boshlang‘ich shart umumiy yechimda nimani aniqlaydi?","Что определяет начальное условие в общем решении?","What does an initial condition determine in a general solution?", tq("C ni"), tq("x ni"), tq("tartibni"), tq("hosila belgisini"),0,"Boshlang‘ich nuqta parametrni belgilaydi.","Начальная точка определяет параметр.","The initial condition determines the parameter."),
        q3("32q13","dy/y=−dx/(1+x²) ni integrallashda o‘ng tomon nima beradi?","Что даёт правая часть при интегрировании dy/y=−dx/(1+x²)?","What does the right side integrate to in dy/y=−dx/(1+x²)?", tq("−arctg x"), tq("ln|x|"), tq("−1/x"), tq("sin x"),0,"∫dx/(1+x²)=arctg x.","∫dx/(1+x²)=arctg x.","∫dx/(1+x²)=arctan x."),
        q3("32q14","ln|sin y|=−ln|cos x|+ln C dan nima kelib chiqadi?","Что следует из ln|sin y|=−ln|cos x|+ln C?","What follows from ln|sin y|=−ln|cos x|+ln C?", tq("sin y cos x=C"), tq("sin y/cos x=C"), tq("sin y+cos x=C"), tq("y+x=C"),0,"Logarifmlarni eksponentlash orqali ko‘paytma hosil bo‘ladi.","После экспоненцирования получаем произведение.","Exponentiating gives the product relation."),
        q3("32q15","O‘zgaruvchilari ajraladigan tenglamani yechishda asosiy amallar ketma-ketligi?","Какова основная последовательность решения разделяющегося уравнения?","What is the basic sequence for solving a separable equation?", TriText("Ajratish → integrallash → C ni aniqlash","Разделение → интегрирование → определение C","Separate → integrate → determine C"), TriText("Differensiallash → limit → qator","Дифференцирование → предел → ряд","Differentiate → limit → series"), TriText("Matritsa → determinant → integral","Матрица → определитель → интеграл","Matrix → determinant → integral"), TriText("Faqat son qo‘yish","Только подстановка числа","Only substitute a number"),0,"Mavzuning yechim algoritmi shu.","Это алгоритм решения темы.","This is the solution workflow for the topic."))

    val quiz33 = listOf(
        q3("33q01","f(λx,λy)=λⁿf(x,y) bo‘lsa f qanday funksiya?","Если f(λx,λy)=λⁿf(x,y), какая это функция?","If f(λx,λy)=λⁿf(x,y), what kind of function is f?", TriText("n-darajali bir jinsli","Однородная степени n","Homogeneous of degree n"), TriText("Davriy","Периодическая","Periodic"), TriText("Chiziqli doimiy","Постоянно линейная","Constant linear"), TriText("Eksponensial","Экспоненциальная","Exponential"),0,"Bu bir jinsli funksiyaning ta’rifi.","Это определение однородной функции.","This is the definition of a homogeneous function."),
        q3("33q02","f(x,y)=xy²+x³ funksiyaning bir jinslilik darajasi?","Степень однородности f(x,y)=xy²+x³?","Degree of homogeneity of f(x,y)=xy²+x³?", tq("3"), tq("1"), tq("2"), tq("0"),0,"Har ikki hadning umumiy darajasi 3.","Оба слагаемых имеют общую степень 3.","Both terms have total degree 3."),
        q3("33q03","Bir jinsli tenglamada qaysi almashtirish ishlatiladi?","Какая подстановка используется в однородном уравнении?","Which substitution is used for a homogeneous equation?", tq("y=tx"), tq("y=u+v"), tq("y=eˣ"), tq("y=x²"),0,"Qo‘llanmada y=tx berilgan.","В пособии используется y=tx.","The text uses y=tx."),
        q3("33q04","y=tx bo‘lsa dy nimaga teng?","Если y=tx, чему равно dy?","If y=tx, what is dy?", tq("xdt+t dx"), tq("t dx"), tq("x dt"), tq("dt+dx"),0,"Ko‘paytma differensiali qo‘llanadi.","Используется дифференциал произведения.","Use the product differential."),
        q3("33q05","y′+P(x)y=Q(x) qanday tenglama?","Что представляет собой y′+P(x)y=Q(x)?","What type of equation is y′+P(x)y=Q(x)?", TriText("Birinchi tartibli chiziqli","Линейное первого порядка","First-order linear"), TriText("Ikkinchi tartibli","Второго порядка","Second order"), TriText("Faqat bir jinsli","Только однородное","Always homogeneous"), TriText("Algebraik","Алгебраическое","Algebraic"),0,"Bu qo‘llanmadagi chiziqli tenglama ta’rifi.","Это определение линейного уравнения в пособии.","This is the text's definition of a linear equation."),
        q3("33q06","Q(x)≡0 bo‘lsa y′+P(x)y=Q(x) qanday?","Какое уравнение y′+P(x)y=Q(x) при Q(x)≡0?","What is y′+P(x)y=Q(x) when Q(x)≡0?", TriText("Bir jinsli chiziqli","Линейное однородное","Homogeneous linear"), TriText("Bernulli","Бернулли","Bernoulli"), TriText("Ikkinchi tartibli","Второго порядка","Second order"), TriText("Xususiy hosilali","В частных производных","Partial differential"),0,"Q=0 — bir jinsli chiziqli holat.","Q=0 — однородный линейный случай.","Q=0 is the homogeneous linear case."),
        q3("33q07","y′+P(x)y=0 ning yechimi?","Решение y′+P(x)y=0?","Solution of y′+P(x)y=0?", tq("y=Ce^(−∫Pdx)"), tq("y=Ce^(∫Pdx)"), tq("y=C+∫Pdx"), tq("y=P/Q"),0,"O‘zgaruvchilarni ajratish orqali olinadi.","Получается разделением переменных.","It follows by separation of variables."),
        q3("33q08","O‘zgarmasni variatsiyalashda C nima bilan almashtiriladi?","Чем заменяют C при вариации постоянной?","What replaces C in variation of the constant?", tq("C(x)"), tq("C²"), tq("1/C"), tq("x+C"),0,"C differensiallanuvchi C(x) funksiyaga aylantiriladi.","C заменяется дифференцируемой функцией C(x).","C is replaced by a differentiable function C(x)."),
        q3("33q09","Chiziqli tenglamada integrallovchi ko‘paytuvchi qaysi ifoda bilan bog‘liq?","С каким выражением связан интегрирующий множитель линейного уравнения?","Which expression is associated with the integrating factor for a linear equation?", tq("e^(∫P(x)dx)"), tq("e^(∫Q(x)dx)"), tq("P(x)Q(x)"), tq("1/P(x)"),0,"Umumiy formula e^(−∫Pdx)[∫Qe^(∫Pdx)dx+C] ko‘rinishida.","Общая формула содержит e^(∫Pdx).","The general formula contains e^(∫Pdx)."),
        q3("33q10","Bernulli tenglamasining ko‘rinishi qaysi?","Каков вид уравнения Бернулли?","Which is the Bernoulli equation form?", tq("y′+Py=Qyⁿ"), tq("y′+Py=Q"), tq("y′=y/x"), tq("Pdx+Qdy=0 faqat"),0,"Qo‘llanmada shu ko‘rinish berilgan.","В пособии дан этот вид.","This is the form stated in the text."),
        q3("33q11","Bernulli tenglamasini chiziqli qilish uchun qaysi almashtirish?","Какая подстановка сводит уравнение Бернулли к линейному?","Which substitution linearizes a Bernoulli equation?", tq("z=y^(1−n)"), tq("z=yⁿ"), tq("z=y/x"), tq("z=eʸ"),0,"Qo‘llanmada z=y^(1−n) ishlatiladi.","В пособии используется z=y^(1−n).","The text uses z=y^(1−n)."),
        q3("33q12","y′+xy=xy³ da Bernulli darajasi n nechaga teng?","Каково n в y′+xy=xy³?","What is n in y′+xy=xy³?", tq("3"), tq("2"), tq("1"), tq("0"),0,"O‘ng tomonda y³ turibdi.","Справа стоит y³.","The right side contains y³."),
        q3("33q13","y′+xy=xy³ uchun z qanday olinadi?","Как выбирается z для y′+xy=xy³?","What substitution z is used for y′+xy=xy³?", tq("z=y⁻²"), tq("z=y²"), tq("z=y³"), tq("z=xy"),0,"1−n=−2.","1−n=−2.","1−n=−2."),
        q3("33q14","y′+xy=xy³ misolining yakuniy ko‘rinishi?","Каков итог примера y′+xy=xy³?","What is the final form in the example y′+xy=xy³?", tq("y²(1+Ce^(x²))=1"), tq("y²(1−Ce^(x²))=1"), tq("y=Ceˣ"), tq("xy=C"),0,"Qo‘llanmadagi 3.3.9-misol natijasi.","Результат примера 3.3.9.","This is the result of Example 3.3.9."),
        q3("33q15","(x²−y²)dx+2xy dy=0 tenglamaning tartibi nechchi?","Каков порядок (x²−y²)dx+2xy dy=0?","What is the order of (x²−y²)dx+2xy dy=0?", tq("1"), tq("0"), tq("2"), tq("3"),0,"dy/dx ga nisbatan birinchi tartibli tenglama.","Это уравнение первого порядка относительно dy/dx.","It is first order in dy/dx."))

    val quiz34 = listOf(
        q3("34q01","O‘zgarmas koeffitsientli chiziqli bir jinsli tenglamada asosiy algebraik vosita nima?","Какой основной алгебраический объект используется для линейного однородного уравнения с постоянными коэффициентами?","What algebraic tool is central for a constant-coefficient homogeneous linear ODE?", TriText("Xarakteristik tenglama","Характеристическое уравнение","Characteristic equation"), TriText("Integral yig‘indi","Интегральная сумма","Riemann sum"), TriText("K-mapa","Карта Карно","Karnaugh map"), TriText("Ehtimol daraxti","Дерево вероятностей","Probability tree"),0,"Hosilalar k darajalariga almashtiriladi.","Производные заменяются степенями k.","Derivatives are replaced by powers of k."),
        q3("34q02","y′′−7y′+6y=0 ning xarakteristik tenglamasi?","Характеристическое уравнение для y′′−7y′+6y=0?","Characteristic equation for y′′−7y′+6y=0?", tq("k²−7k+6=0"), tq("k²+7k+6=0"), tq("k−7+6=0"), tq("k³−7k+6=0"),0,"y′′→k², y′→k, y→1.","y′′→k², y′→k, y→1.","Map y′′→k², y′→k, y→1."),
        q3("34q03","k²−7k+6=0 ildizlari?","Корни k²−7k+6=0?","Roots of k²−7k+6=0?", tq("6 va 1"), tq("−6 va −1"), tq("3 va 2"), tq("7 va 6"),0,"(k−6)(k−1)=0.","(k−6)(k−1)=0.","(k−6)(k−1)=0."),
        q3("34q04","Turli haqiqiy k₁,k₂ ildizlarda umumiy yechim?","Общее решение при различных действительных корнях k₁,k₂?","General solution for distinct real roots k₁,k₂?", tq("C₁e^(k₁x)+C₂e^(k₂x)"), tq("(C₁+C₂x)e^(k₁x)"), tq("C₁cos x+C₂sin x"), tq("C₁+C₂x"),0,"Har bir oddiy haqiqiy ildizga eksponenta mos keladi.","Каждому простому действительному корню соответствует экспонента.","Each simple real root contributes an exponential."),
        q3("34q05","k ikki karrali haqiqiy ildiz bo‘lsa yechim ko‘rinishi?","Каков вид решения при двойном действительном корне k?","Solution form for a double real root k?", tq("(C₁+C₂x)e^(kx)"), tq("C₁e^(kx)+C₂e^(−kx)"), tq("C₁cos kx+C₂sin kx"), tq("C₁+C₂"),0,"Karrali ildizda x ko‘paytuvchili had qo‘shiladi.","При кратном корне появляется множитель x.","A repeated root introduces an x factor."),
        q3("34q06","α±βi ildizlar uchun umumiy yechim?","Общее решение для корней α±βi?","General solution for roots α±βi?", tq("e^(αx)(C₁cosβx+C₂sinβx)"), tq("C₁e^(αx)+C₂e^(βx)"), tq("C₁x+C₂"), tq("e^(βx)(C₁cosαx+C₂sinαx)"),0,"Qo‘shma kompleks ildizlar eksponenta va trigonometrik funksiyalar beradi.","Сопряжённые комплексные корни дают экспоненту и тригонометрические функции.","Complex conjugate roots give exponential-trigonometric solutions."),
        q3("34q07","y′′−4y′+13y=0 ildizlari?","Корни y′′−4y′+13y=0?","Roots for y′′−4y′+13y=0?", tq("2±3i"), tq("2±i"), tq("−2±3i"), tq("4±i"),0,"Diskriminant manfiy va k=2±3i.","Дискриминант отрицателен, k=2±3i.","The discriminant is negative and k=2±3i."),
        q3("34q08","y′′−4y′+13y=0 ning umumiy yechimi?","Общее решение y′′−4y′+13y=0?","General solution of y′′−4y′+13y=0?", tq("e^(2x)(C₁cos3x+C₂sin3x)"), tq("e^(3x)(C₁cos2x+C₂sin2x)"), tq("C₁e^(2x)+C₂e^(3x)"), tq("C₁cos x+C₂sin x"),0,"α=2, β=3 formula qo‘llanadi.","Применяется формула с α=2, β=3.","Use the formula with α=2, β=3."),
        q3("34q09","y′′′−2y′′+y′=0 xarakteristik ko‘paytuvchilarga ajratilishi?","Факторизация характеристического многочлена для y′′′−2y′′+y′=0?","Factorization of the characteristic polynomial for y′′′−2y′′+y′=0?", tq("k(k−1)²"), tq("k(k+1)²"), tq("(k−2)(k−1)"), tq("k³−1"),0,"k³−2k²+k=k(k−1)².","k³−2k²+k=k(k−1)².","k³−2k²+k=k(k−1)²."),
        q3("34q10","y′′′−2y′′+y′=0 umumiy yechim?","Общее решение y′′′−2y′′+y′=0?","General solution of y′′′−2y′′+y′=0?", tq("C₁+C₂eˣ+C₃xeˣ"), tq("C₁eˣ+C₂e^(−x)+C₃"), tq("C₁cos x+C₂sin x+C₃"), tq("C₁+C₂x+C₃x²"),0,"k=0 va k=1 ikki karrali ildiz.","Корни k=0 и двойной k=1.","The roots are k=0 and a double k=1."),
        q3("34q11","Bir jinsli bo‘lmagan tenglamada umumiy yechim qanday tuziladi?","Как строится общее решение неоднородного уравнения?","How is the general solution of a nonhomogeneous equation formed?", TriText("Bir jinsli umumiy yechim + bitta xususiy yechim","Общее решение однородного + одно частное","Homogeneous general solution + one particular solution"), TriText("Faqat xususiy yechim","Только частное решение","Only particular solution"), TriText("Faqat xarakteristik ildiz","Только характеристический корень","Only a characteristic root"), TriText("Integral yig‘indi","Интегральная сумма","Riemann sum"),0,"Qo‘llanmadagi misollarda shu tamoyil ishlatiladi.","В примерах пособия используется этот принцип.","This principle is used throughout the examples."),
        q3("34q12","y′′−2y′−3y=e^(4x) uchun xususiy yechim ansatzi?","Какой вид частного решения берут для y′′−2y′−3y=e^(4x)?","What particular-solution ansatz is used for y′′−2y′−3y=e^(4x)?", tq("Ae^(4x)"), tq("Ax²"), tq("Acos4x+Bsin4x"), tq("Axe^(3x)"),0,"4 xarakteristik ildiz emas, shuning uchun Ae^(4x).","4 не является характеристическим корнем, поэтому Ae^(4x).","Since 4 is not a characteristic root, use Ae^(4x)."),
        q3("34q13","y′′+y′−2y=cos x−3sin x uchun xususiy yechim ansatzi?","Какой вид частного решения для y′′+y′−2y=cos x−3sin x?","Particular-solution ansatz for y′′+y′−2y=cos x−3sin x?", tq("Acos x+Bsin x"), tq("Aeˣ"), tq("Ax²+Bx+C"), tq("x(Acos x+Bsin x)"),0,"i xarakteristik ildiz emas, shuning uchun oddiy trigonometrik ansatz.","i не является характеристическим корнем, берётся обычный тригонометрический вид.","i is not a characteristic root, so use the ordinary trigonometric ansatz."),
        q3("34q14","y′′+y=3sin x da nima uchun x(Acos x+Bsin x) olinadi?","Почему для y′′+y=3sin x берут x(Acos x+Bsin x)?","Why use x(Acos x+Bsin x) for y′′+y=3sin x?", TriText("i xarakteristik ildiz bo‘lgani uchun","Потому что i — характеристический корень","Because i is a characteristic root"), TriText("Tenglama birinchi tartibli","Уравнение первого порядка","Because it is first order"), TriText("sin x nolga teng","sin x равен нулю","Because sin x is zero"), TriText("Koeffitsientlar o‘zgaruvchi","Коэффициенты переменные","Because coefficients vary"),0,"Rezonans sabab ansatz x ga ko‘paytiriladi.","Из-за резонанса пробное решение умножается на x.","Resonance requires multiplying the ansatz by x."),
        q3("34q15","Boshlang‘ich shartlar C₁,C₂ ni topishda nimaga olib keladi?","К чему приводят начальные условия при определении C₁,C₂?","What do initial conditions produce when determining C₁,C₂?", TriText("Algebraik tenglamalar sistemasiga","К системе алгебраических уравнений","A system of algebraic equations"), TriText("Yangi differensial tenglamaga","К новому дифференциальному уравнению","A new differential equation"), TriText("Cheksiz qatorga","К бесконечному ряду","An infinite series"), TriText("Integral yig‘indiga","К интегральной сумме","A Riemann sum"),0,"Umumiy yechim va hosilaga shartlar qo‘yiladi.","Условия подставляются в общее решение и его производные.","Substitute conditions into the general solution and derivatives."))

}
