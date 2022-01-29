import MeetupSchedule.*
import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(val month: Int, val year: Int) {
    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        val dates = 0.rangeTo(30)
                .map { LocalDate.of(year, month, 1).plusDays(it.toLong()) }
                .filter { it.dayOfWeek == dayOfWeek && it.monthValue == month && it.year == year }
        return when (schedule) {
            FIRST -> dates[0]
            SECOND -> dates[1]
            THIRD -> dates[2]
            FOURTH -> dates[3]
            LAST -> dates.last()
            TEENTH -> dates.first { it.dayOfMonth > 12 }
        }
    }
}
