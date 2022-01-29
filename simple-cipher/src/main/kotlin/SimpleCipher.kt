import kotlin.random.Random

data class Cipher(val key: String = generateKey()) {
    init {
        require(valid(key))
    }

    private fun valid(key: String): Boolean = Regex("^\\p{Lower}+$").matches(key)

    fun encode(input: String): String = input
        .mapIndexed { index, ch -> ch.encode(index) }
        .joinToString("")

    fun decode(input: String): String = input
        .mapIndexed { index, ch -> ch.decode(index) }
        .joinToString("")

    private fun Char.encode(index: Int): Char = 'a' + ((this - 'a' + (key[index % key.length] - 'a')) % 26)
    private fun Char.decode(index: Int): Char = 'a' + ((26 + (this - 'a') - (key[index % key.length] - 'a')) % 26)
}

private fun generateKey(): String {
    return (1..100).map { 'a' + Random.nextInt(0, 26) }.joinToString("")
}
