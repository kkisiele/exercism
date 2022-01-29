import java.lang.IllegalArgumentException

class Scale(tonic: String) {
    private val chromatic = chromaticScale(tonic)

    private fun chromaticScale(tonic: String) =
        when (tonic) {
            "F", "Bb", "Eb", "Ab", "Db", "Gb", "d", "g", "c", "f", "bb", "eb" ->
                listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")
            else -> listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
        }.run {
            dropWhile { it.lowercase() != tonic.lowercase() } + takeWhile { it.lowercase() != tonic.lowercase() }
        }

    fun chromatic(): List<String> = chromatic

    fun interval(intervals: String) = intervals
        .scan(0) { position, interval -> position + interval.offset() }
        .mapNotNull { chromatic.getOrNull(it) }

    private fun Char.offset(): Int = when (this) {
        'm' -> 1
        'M' -> 2
        'A' -> 3
        else -> throw IllegalArgumentException("Invalid interval: $this")
    }
}
