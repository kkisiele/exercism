object RomanNumerals {
    fun value(n: Int) = buildString {
        if (n % 10 != 0) {
            insert(0, toRoman(n % 10, "I", "V", "X"))
        }
        if (n / 10 != 0) {
            insert(0, toRoman(n / 10, "X", "L", "C"))
        }
        if (n / 100 != 0) {
            insert(0, toRoman(n / 100, "C", "D", "M"))
        }
        if (n / 1000 != 0) {
            insert(0, toRoman(n / 1000, "M"))
        }
    }

    fun toRoman(n: Int, one: String, five: String = "", ten: String = ""): String = when {
        n <= 3 -> one.repeat(n)
        n == 4 -> one + five
        n <= 8 -> five + one.repeat(n - 5)
        n == 9 -> one + ten
        else -> throw IllegalArgumentException()
    }
}
