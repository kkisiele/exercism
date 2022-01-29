class NumberSpeller {
    private val numbers = mapOf(
        0L to "zero",
        1L to "one",
        2L to "two",
        3L to "three",
        4L to "four",
        5L to "five",
        6L to "six",
        7L to "seven",
        8L to "eight",
        9L to "nine",
        10L to "ten",
        11L to "eleven",
        12L to "twelve",
        13L to "thirteen",
        14L to "fourteen",
        15L to "fifteen",
        16L to "sixteen",
        17L to "seventeen",
        18L to "eighteen",
        19L to "nineteen",
        20L to "twenty",
        30L to "thirty",
        40L to "forty",
        50L to "fifty",
        60L to "sixty",
        70L to "seventy",
        80L to "eighty",
        90L to "ninety",
    )

    private val bigNumbers = mapOf(
        100 to "hundred",
        1000 to "thousand",
        1000000 to "million",
        1000000000 to "billion"
    )

    fun say(input: Long): String = buildString {
        require(input in 0.until(1000000000000))
        when (input) {
            in 0.until(20) -> append(numbers.getValue(input))
            in 20.until(100) -> {
                val tens = input / 10 * 10
                val units = input % 10
                append(numbers.getValue(tens))
                if (units > 0) append("-${say(units)}")
            }
            else -> bigNumbers.toList().sortedByDescending { it.first }
                .first { input / it.first > 0 }
                .let {
                    val number = it.first
                    append("${say(input / number)} ${it.second}")
                    if (input % number > 0) append(" ${say(input % number)}")
                }
        }
    }
}
