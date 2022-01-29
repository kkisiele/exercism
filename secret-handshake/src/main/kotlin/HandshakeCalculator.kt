import Signal.*

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> = buildList() {
        if (number.bitmaskSet(1)) add(WINK)
        if (number.bitmaskSet(2)) add(DOUBLE_BLINK)
        if (number.bitmaskSet(4)) add(CLOSE_YOUR_EYES)
        if (number.bitmaskSet(8)) add(JUMP)
        if (number.bitmaskSet(16)) reverse()
    }
}

private fun Int.bitmaskSet(bitmask: Int): Boolean {
    return (this and bitmask) == bitmask
}
