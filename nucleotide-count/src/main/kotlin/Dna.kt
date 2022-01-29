class Dna(s: String) {
    private val nucleotides: Map<Char, Int>

    init {
        nucleotides = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
        for (ch in s) {
            nucleotides[ch] = 1 + nucleotides.computeIfAbsent(ch) { throw IllegalArgumentException() }
        }
    }

    val nucleotideCounts: Map<Char, Int> = nucleotides.toMap()
}
