import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String) = buildString {
        val normalized = normalized(plaintext).ifEmpty { return "" }
        var columns = ceil(sqrt(normalized.length.toDouble())).toInt()
        val chunks = normalized.chunked(columns)
        for (c in 0.until(columns)) {
            if (c > 0) append(" ")
            for (chunk in chunks) append(chunk.getOrElse(c) { ' ' })
        }
    }

    private fun normalized(plaintext: String) =
        plaintext.filter(Char::isLetterOrDigit).map(Char::lowercase).joinToString("")
}
