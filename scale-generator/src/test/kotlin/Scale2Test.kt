import kotlin.test.asserter
import kotlin.test.Test

class Scale2Test {

    // Test chromatic scales
    @Test
    fun `chromatic scale with sharps`() {
        val expected = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        assertScalesEqual(expected, Scale2("C").chromatic())
    }

    @Test
    fun `chromatic scale with flats`() {
        val expected = listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")
        assertScalesEqual(expected, Scale2("F").chromatic())
    }

    @Test
    fun `simple major scale`() {
        val expected = listOf("C", "D", "E", "F", "G", "A", "B")
        assertScalesEqual(expected, Scale2("C").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with sharps`() {
        val expected = listOf("G", "A", "B", "C", "D", "E", "F#")
        assertScalesEqual(expected, Scale2("G").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with flats`() {
        val expected = listOf("F", "G", "A", "Bb", "C", "D", "E")
        assertScalesEqual(expected, Scale2("F").interval("MMmMMMm"))
    }

    @Test
    fun `minor scale with sharps`() {
        val expected = listOf("F#", "G#", "A", "B", "C#", "D", "E")
        assertScalesEqual(expected, Scale2("f#").interval("MmMMmMM"))
    }

    @Test
    fun `minor scale with flats`() {
        val expected = listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab")
        assertScalesEqual(expected, Scale2("bb").interval("MmMMmMM"))
    }

    @Test
    fun `dorian mode`() {
        val expected = listOf("D", "E", "F", "G", "A", "B", "C")
        assertScalesEqual(expected, Scale2("d").interval("MmMMMmM"))
    }

    @Test
    fun `mixolydian mode`() {
        val expected = listOf("Eb", "F", "G", "Ab", "Bb", "C", "Db")
        assertScalesEqual(expected, Scale2("Eb").interval("MMmMMmM"))
    }

    @Test
    fun `lydian mode`() {
        val expected = listOf("A", "B", "C#", "D#", "E", "F#", "G#")
        assertScalesEqual(expected, Scale2("a").interval("MMMmMMm"))
    }

    @Test
    fun `phrygian mode`() {
        val expected = listOf("E", "F", "G", "A", "B", "C", "D")
        assertScalesEqual(expected, Scale2("e").interval("mMMMmMM"))
    }

    @Test
    fun `locrian mode`() {
        val expected = listOf("G", "Ab", "Bb", "C", "Db", "Eb", "F")
        assertScalesEqual(expected, Scale2("g").interval("mMMmMMM"))
    }

    @Test
    fun `harmonic minor`() {
        val expected = listOf("D", "E", "F", "G", "A", "Bb", "Db")
        assertScalesEqual(expected, Scale2("d").interval("MmMMmAm"))
    }

    @Test
    fun octatonic() {
        val expected = listOf("C", "D", "D#", "F", "F#", "G#", "A", "B")
        assertScalesEqual(expected, Scale2("C").interval("MmMmMmMm"))
                                            //C, C#, D, D#,   E, F, F#  , G, G#, A,  A#, B,
    }

    @Test
    fun hexatonic() {
        val expected = listOf("Db", "Eb", "F", "G", "A", "B")
        assertScalesEqual(expected, Scale2("Db").interval("MMMMMM"))
    }

    @Test
    fun pentatonic() {
        val expected = listOf("A", "B", "C#", "E", "F#")
        assertScalesEqual(expected, Scale2("A").interval("MMAMA"))
    }

    @Test
    fun enigmatic() {
        val expected = listOf("G", "G#", "B", "C#", "D#", "F", "F#")
        assertScalesEqual(expected, Scale2("G").interval("mAMMMmm"))
    }

    fun assertScalesEqual(expected: List<String>, actual: List<String>) {
        asserter.assertTrue(
            { "Scales should be equal. Expected <$expected>, actual <$actual>" },
            scalesAreEqual(expected, actual))
    }

    fun scalesAreEqual(expected: List<String>, actual: List<String>): Boolean {
        if (expected.size != actual.size) return false
        return expected.zip(actual, this::notesEqual).all { it }
    }

    // Few enough equal notes that we can just list them all
    fun notesEqual(left: String, right: String) = left.equals(right) || when(left) {
        // A# == Bb
        "A#" -> right.equals("Bb")
        "Bb" -> right.equals("A#")
        // C# == Db
        "C#" -> right.equals("Db")
        "Db" -> right.equals("C#")
        // D# == Eb
        "D#" -> right.equals("Eb")
        "Eb" -> right.equals("D#")
        // F# == Gb
        "F#" -> right.equals("Gb")
        "Gb" -> right.equals("F#")
        // G# == Ab
        "G#" -> right.equals("Ab")
        "Ab" -> right.equals("G#")
        else -> false
    }
}
