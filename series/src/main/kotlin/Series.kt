object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        if(n <= 0 || n > s.length) throw IllegalArgumentException()
        return s.map { it - '0' }.windowed(n)
    }
}
