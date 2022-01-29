class IsbnVerifier {

    fun isValid(number: String): Boolean {

        val normalized = number.replace("[\\s-]+".toRegex(), "")
        if("[\\d]{9}[\\dX]".toRegex().matches(normalized)) {
            return normalized
                .map { if (it == 'X') 10 else it - '0' }
                .mapIndexed { index, value -> value * (10 - index) }
                .sum()
                .rem(11) == 0
        }
        return false
    }
}
