class Robot {
    var name: String

    companion object {
        private val counter: CharArray = charArrayOf('A', 'A', '0', '0', '0')

        private fun nextNumber(): String {
            val result = counter.concatToString()
            for(idx in 4.downTo(0)) {
                when {
                    counter[idx] == '9' -> counter[idx] = '0'
                    counter[idx] == 'Z' -> counter[idx] = 'A'
                    else -> {
                        counter[idx]++
                        break
                    }
                }
            }
            return result
        }
    }

    init {
        name = nextNumber()
    }


    fun reset() {
        name = nextNumber()
    }
}
