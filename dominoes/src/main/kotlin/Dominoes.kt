class ChainNotFoundException : RuntimeException("Not found the chain")

data class Domino(val left: Int, val right: Int) {
    fun anySideEqualsTo(dots: Int): Boolean = dots in listOf(left, right)

    fun rotateToMatch(domino: Domino): Domino {
        require(anySideEqualsTo(domino.right))
        if (left == domino.right) return this
        return this.rotated()
    }

    fun rotated(): Domino = Domino(right, left)
    fun double(): Boolean = left == right
}

private class DominoSolver(private val first: Domino, private val remaining: List<Domino>) {
    fun solution(): List<Domino>? {
        return listOf(first, first.rotated()).firstNotNullOfOrNull { solution(listOf(it), remaining) }
    }

    private fun solution(formed: List<Domino>, remaining: List<Domino>): List<Domino>? {
        val last = formed.last()

        if (remaining.isEmpty()) {
            if (formed.size == 1 && formed.first().double()) return formed
            else if (formed.size > 1 && last.right == formed.first().left) return formed
        }

        return remaining.filter { it.anySideEqualsTo(last.right) }
            .firstNotNullOfOrNull { candidate -> solution(formed + candidate.rotateToMatch(last), remaining.minus(candidate)) }
    }
}

object Dominoes {
    fun formChain(dominoes: List<Domino>): List<Domino> {
        if (dominoes.isEmpty()) return emptyList()
        return dominoes.firstNotNullOfOrNull { DominoSolver(it, dominoes.minus(it)).solution() } ?: throw ChainNotFoundException()
    }

    fun formChain(vararg dominoes: Domino): List<Domino> {
        return formChain(dominoes.toList())
    }
}
