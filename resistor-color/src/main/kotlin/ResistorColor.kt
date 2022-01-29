object ResistorColor {
    private val colors = mapOf("black" to 0, "brown" to 1, "red" to 2, "orange" to 3, "yellow" to 4, "green" to 5, "blue" to 6, "violet" to 7, "grey" to 8, "white" to 9)

    fun colorCode(color: String): Int = colors.getValue(color)

    fun colors(): List<String> = colors.keys.toList()

}
