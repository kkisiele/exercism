class Clock(hour: Int, minute: Int) {
    private var minutesSinceMidnight: Int = 0

    init {
        add(hour * 60 + minute)
    }

    fun add(minutes: Int) {
        minutesSinceMidnight = (24 * 60 + minutesSinceMidnight + (minutes % (24 * 60))) % (24 * 60)
    }

    fun subtract(minutes: Int) = add(-minutes)

    override fun toString(): String = "%02d:%02d".format(minutesSinceMidnight / 60, minutesSinceMidnight % 60)
    override fun equals(other: Any?): Boolean = if (other is Clock) minutesSinceMidnight == other.minutesSinceMidnight else false
    override fun hashCode(): Int = minutesSinceMidnight
}
