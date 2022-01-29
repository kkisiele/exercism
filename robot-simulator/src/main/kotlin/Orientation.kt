enum class Orientation {

    NORTH, EAST, SOUTH, WEST;

    fun turnRight(): Orientation {
        return values()[if (ordinal == 3) 0 else ordinal + 1]
    }

    fun left(): Orientation {
        return values()[if (ordinal == 0) 3 else ordinal - 1]
    }

}
