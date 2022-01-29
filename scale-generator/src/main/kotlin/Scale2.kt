import java.lang.IllegalArgumentException

class Scale2(tonic: String) {
    private val sharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val flats = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")
    private val tonic: String

    init {
        val pitch = tonic.toPitch()
        require(sharps.contains(pitch) || flats.contains(pitch))
        this.tonic = pitch
    }

    fun chromatic(): List<String> {
        val scale = when (tonic) {
            "F", "Bb", "Eb", "Ab", "Db", "Gb", "d", "g", "c", "f", "bb", "eb" -> flats
            else-> sharps
        }
        val index = scale.indexOf(tonic)
        return scale.drop(index) + scale.take(index)
    }

    fun interval(intervals: String) = buildList {
        val scale = chromatic()
        var index = 0
        add(scale[0])
        for (i in intervals) {
            index += when (i) {
                'm' -> 1
                'M' -> 2
                'A' -> 3
                else -> throw IllegalArgumentException("Invalid interval: $i")
            }
            scale.getOrNull(index).let { if (it != null) add(it) }
        }
    }
}

private fun String.toPitch(): String {
    return this.lowercase().replaceFirstChar { it.uppercase() }
}
