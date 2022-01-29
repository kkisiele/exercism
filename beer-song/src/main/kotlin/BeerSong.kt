object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String =
        startBottles.downTo(takeDown).joinToString("\n") {
            when (it) {
                1 -> "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n"
                0 -> "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
                else -> "${bottles(it)} of beer on the wall, ${bottles(it)} of beer.\n" +
                        "Take one down and pass it around, ${bottles(it - 1)} of beer on the wall.\n"
            }
        }

    private fun bottles(bottles: Int): String = when {
        bottles > 1 -> "$bottles bottles"
        else -> "1 bottle"
    }
}
