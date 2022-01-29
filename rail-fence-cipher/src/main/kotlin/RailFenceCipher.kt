import kotlin.math.absoluteValue

class RailFenceCipher(private val count: Int) {

    fun getEncryptedData(input: String): String {
        val rails = List(count) { mutableListOf<Char>() }
        val period = (count - 1) * 2
        for ((index, ch) in input.withIndex()) {
            val railIndex = rails.lastIndex - (index % period - count + 1).absoluteValue
            rails[railIndex] += ch
        }
        return rails.flatten().joinToString("")
    }

    fun getDecryptedData(input: String): String {
        return ""
    }
}
