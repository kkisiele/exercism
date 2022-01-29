object PrimeFactorCalculator {

    fun primeFactors(value: Int): List<Int> {
        return primeFactors(value.toLong()).map { it.toInt() }
    }

    fun primeFactors(value: Long): List<Long> {
        if(value < 2) return listOf()
        var current = value
        var result = mutableListOf<Long>()
        do {
            val prime = current.lowestPrimeDivisor()
            current /= prime
            result += prime
        } while (current != 1L)
        return result
    }

    private fun Long.lowestPrimeDivisor(): Long {
        var prime = 2L
        while(this % prime != 0L) {
            prime = prime.nextPrime()
        }
        return prime
    }

    private fun Long.nextPrime(): Long {
        var candidate = this + 1
        while (!candidate.prime()) candidate++
        return candidate
    }

    private fun Long.prime(): Boolean {
        return 2.until(this).all { this % it != 0L }
    }
}
