import java.math.RoundingMode

class SpaceAge(seconds: Int) {
    private val earth = seconds / 31557600.0

    fun onEarth(): Double = round(earth)
    fun onMercury(): Double = round(earth / 0.2408467)
    fun onVenus(): Double = round(earth / 0.61519726)
    fun onMars(): Double = round(earth / 1.8808158)
    fun onJupiter(): Double = round(earth / 11.862615)
    fun onSaturn(): Double = round(earth / 29.447498)
    fun onUranus(): Double = round(earth / 84.016846)
    fun onNeptune(): Double = round(earth / 164.79132)

    private fun round(d: Double): Double {
        return d.toBigDecimal().setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }
}
