object AffineCipher {
    private const val M = 26
    private const val START_CHAR = 'a'

    fun encode(input: String, a: Int, b: Int): String {
        require(coprime(a, M)) { "a and m must be coprime." }
        return input
            .mapNotNull { it.encode(a, b) }
            .chunked(5) { it.joinToString("") }
            .joinToString(" ")
    }

    private fun Char.encode(a: Int, b: Int): Char? = when {
        this.isLetter() -> START_CHAR + ((a * (this.lowercaseChar() - START_CHAR) + b) % M)
        this.isDigit() -> this
        else -> null
    }

    fun decode(input: String, a: Int, b: Int): String {
        require(coprime(a, M)) { "a and m must be coprime." }
        val mmi = mmi(a)
        return input
            .mapNotNull { it.decode(mmi, b) }
            .joinToString("")
    }

    private fun Char.decode(mmi: Int, b: Int): Char? = when {
        this.isLowerCase() -> START_CHAR + (mmi * (this - START_CHAR - b) % M + M) % M
        this.isDigit() -> this
        else -> null
    }

    private fun mmi(a: Int): Int = generateSequence(1) { it + 1 }
        .filter { (a % M * it) % M == 1 }
        .first()

    private fun coprime(a: Int, b: Int): Boolean = Pair(a, b).coprime

    private val Pair<Int, Int>.coprime: Boolean
        get() = this.gcd() == Pair(1, 1)

    private fun Pair<Int, Int>.gcd(): Pair<Int, Int> =
        when {
            first > second -> Pair(first - second, second).gcd()
            first < second -> Pair(first, second - first).gcd()
            else -> this
        }
}
