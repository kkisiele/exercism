import java.util.*

object MatchingBrackets2 {
    fun isValid(input: String): Boolean {
        val stack: Deque<Char> = LinkedList()
        for (ch in input) {
            when (ch) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                in listOf(')', '}', ']') -> if (stack.isEmpty() || stack.pop() != ch) return false
            }
        }
        return stack.isEmpty()
    }
}
