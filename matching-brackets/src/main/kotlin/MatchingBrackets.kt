import java.util.*

object MatchingBrackets {
    private val brackets = mapOf('(' to ')', '[' to ']', '{' to '}')

    fun isValid(input: String): Boolean {
        val stack: Deque<Char> = LinkedList()
        for (ch in input) {
            when {
                ch.isOpenBracket() -> stack.push(ch)
                ch.isCloseBracket() -> if (stack.isEmpty() || brackets[stack.pop()] != ch) return false
            }
        }
        return stack.isEmpty()
    }

    private fun Char.isOpenBracket() = brackets.containsKey(this)
    private fun Char.isCloseBracket() = brackets.containsValue(this)
}
