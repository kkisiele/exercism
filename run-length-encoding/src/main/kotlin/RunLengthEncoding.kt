object RunLengthEncoding {

    fun encode(input: String): String = buildString {
        var offset = 0
        while(offset < input.length) {
            var ch = input[offset]
            var count = 1
            while(++offset < input.length && input[offset] == ch) {
                count++
            }
            if(count > 1) append(count)
            append(ch)
        }
    }

    fun decode(input: String): String = buildString {
        var offset = 0
        while(offset < input.length) {
            var num = ""
            while(input[offset].isDigit()) {
                num += input[offset++]
            }
            append(input[offset].toString().repeat(num.toIntOrNull() ?: 1))
            ++offset
        }
    }
}
