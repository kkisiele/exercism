object Pangram {

    fun isPangram(input: String): Boolean {
        val letters = input.lowercase()
            .filter { it.isLetter() }
            .toSet()
        return letters.size == 26
    }
}
