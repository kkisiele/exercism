import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    companion object {
        fun exponential(complex: ComplexNumber): ComplexNumber = ComplexNumber(
            exp(complex.real) * cos(complex.imag),
            exp(complex.real) * sin(complex.imag)
        )
    }

    val abs: Double
        get() = sqrt(real.pow(2) + imag.pow(2))

    operator fun times(complex: ComplexNumber): ComplexNumber = ComplexNumber(
        this.real * complex.real - this.imag * complex.imag,
        this.real * complex.imag + this.imag * complex.real
    )

    operator fun plus(complex: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real + complex.real, this.imag + complex.imag)

    operator fun minus(complex: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real - complex.real, this.imag - complex.imag)

    operator fun div(complex: ComplexNumber): ComplexNumber = ComplexNumber(
        (this.real * complex.real + this.imag * complex.imag) / (complex.real.pow(2) + complex.imag.pow(2)),
        (this.imag * complex.real - this.real * complex.imag) / (complex.real.pow(2) + complex.imag.pow(2))
    )

    fun conjugate(): ComplexNumber = ComplexNumber(real, -imag)
}
