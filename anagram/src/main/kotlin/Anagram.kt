class Anagram(val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams
            .filterNot { it.lowercase() == source.lowercase() }
            .filter { it.normalized() == source.normalized() }
            .toSet()
    }

    private fun String.normalized(): String = this.lowercase().toCharArray().sortedArray().concatToString()
}
