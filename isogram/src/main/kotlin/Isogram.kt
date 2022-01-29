object Isogram {

    fun isIsogram(input: String): Boolean = input.lowercase()
        .filter(Char::isLetter)
        .groupBy { it }
        .all { it.value.size == 1 }
}
