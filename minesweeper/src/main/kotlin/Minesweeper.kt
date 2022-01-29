class MinesweeperBoard(board: List<String>) {
    private val board: List<List<Cell>>

    init {
         this.board = board.map {
            it.map(::Cell)
        }
    }

    fun withNumbers(): List<String> {
        return board.map {
            it.joinToString("") {
                when {
                    it.hasMine() -> "*"
                    it.numberOfAdjacentMines() > 0 -> it.numberOfAdjacentMines().toString()
                    else -> " "
                }
            }
        }
    }

    inner class Cell(val ch: Char) {
        fun hasMine() = ch == '*'

        fun numberOfAdjacentMines(): Int {
            return adjacentCells().map { if(it.hasMine()) 1 else 0  }.sum()
        }

        private fun location() = board.mapIndexedNotNull { row, cells ->
            if (cells.contains(this)) Pair(row, cells.indexOf(this))
            else null
        }.first()

        private fun adjacentCells(): List<Cell> {
            return board.flatten().filter { it.adjacentTo(this) }
        }

        private fun adjacentTo(cell: Cell): Boolean {
            val loc1 = this.location()
            val loc2 = cell.location()
            return (loc1.first - loc2.first) in -1..1 && (loc1.second - loc2.second) in -1..1
        }
    }
}
