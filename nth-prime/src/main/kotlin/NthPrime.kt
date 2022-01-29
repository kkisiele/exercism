object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(2) { it.nextPrime() }.elementAt(n - 1)
    }

    private fun Int.nextPrime(): Int {
        var candidate = this + 1
        while (!candidate.prime()) candidate++
        return candidate
    }

    private fun Int.prime(): Boolean {
        return 2.until(this).all { this % it != 0 }
    }
}
