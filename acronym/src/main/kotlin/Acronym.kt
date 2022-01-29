object Acronym {
    fun generate(phrase: String) : String = phrase
        .split("[\\s,-]+".toRegex())
        .map { it.first(Char::isLetter) }
        .joinToString("", transform = Char::uppercase)

}
