import java.util.*
import kotlin.collections.HashMap

class Forth {
    fun evaluate(vararg lines: String): List<Int> {
        val program = preprocess(*lines)
        return execute(program)
    }

    private fun preprocess(vararg lines: String): List<String> {
        val definedWords = HashMap<String, String>()
        val program = mutableListOf<String>()
        for (line in lines) {
            val result = Regex(": ([^\\s]+) (.+) ;").matchEntire(line)
            if (result != null) {
                val name = result.groupValues[1]
                require(!name[0].isDigit()) {"illegal operation"}
                definedWords += name to result.groupValues[2].preprocessedWith(definedWords)
            } else {
                program += line.preprocessedWith(definedWords)
            }
        }
        return program
    }

    private fun String.preprocessedWith(words: Map<String, String>): String {
        var result = this
        for (w in words) {
            result = result.replace(w.key, w.value, ignoreCase = true)
        }
        return result
    }

    private fun execute(program: List<String>): List<Int> {
        val stack = Stack<Int>()
        for (word in program.first().splitByWhiteSpaces()) {
            when (word.lowercase()) {
                "+" -> stack.pop2().let { stack.push(it.first + it.second) }
                "-" -> stack.pop2().let { stack.push(it.first - it.second) }
                "*" -> stack.pop2().let { stack.push(it.first * it.second) }
                "/" -> stack.pop2().let {
                    require(it.second != 0, { "divide by zero" });
                    stack.push(it.first / it.second)
                }
                "dup" -> stack.peek().let { stack.push(it) }
                "drop" -> stack.pop()
                "over" -> stack.peek2().let { stack.push(it.first) }
                "swap" -> stack.pop2().let { stack.push(it.second); stack.push(it.first) }
                else -> word.toIntOrNull().let {
                    require(it != null) { "undefined operation" }
                    stack.push(it)
                }
            }
        }
        return stack.toList()
    }

    private fun String.splitByWhiteSpaces() = this.split(Regex("\\s+"))

    private class Stack<T> {
        private val store = LinkedList<T>()

        fun pop(): T {
            val element = peek()
            store.remove(element)
            return element
        }

        fun pop2(): Pair<T, T> {
            var pair = peek2()
            store.removeAll(pair.toList())
            return pair
        }

        fun peek(): T {
            require(store.size > 0) { "empty stack" }
            return store.last
        }

        fun peek2(): Pair<T, T> {
            require(store.size != 1) { "only one value on the stack" }
            require(store.size > 0) { "empty stack" }
            val second = store[store.lastIndex]
            val first = store[store.lastIndex - 1]
            return Pair(first, second)
        }

        fun push(i: T) {
            store.add(i)
        }

        fun toList(): List<T> = Collections.unmodifiableList(store)
    }
}
