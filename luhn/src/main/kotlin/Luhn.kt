object Luhn {

    fun isValid(candidate: String): Boolean {
        if (!"[\\d ]+".toRegex().matches(candidate)) {
            return false
        }
        val numbers = candidate.filter(Char::isDigit).map { it - '0' }
        if (numbers.size < 2) return false
        val sum = numbers
            .reversed()
            .mapIndexed { index, value -> if (index % 2 != 0) 2 * value else value }
            .sumOf { if (it < 10) it else it - 9 }
        return sum % 10 == 0
    }

}
