import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(input: LocalDateTime) {
    val date: LocalDateTime = input.plusSeconds(1e9.toLong())

    constructor(input: LocalDate) : this(input.atStartOfDay())
}
