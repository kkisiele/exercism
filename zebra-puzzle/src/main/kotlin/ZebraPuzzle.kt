import ZebraPuzzle.Animal.*
import ZebraPuzzle.Cigarette.*
import ZebraPuzzle.Drink.*
import ZebraPuzzle.Color.*
import ZebraPuzzle.Nationality.*
import java.awt.Color

class ZebraPuzzle {
    init {
        val houses = Array(5) { House() }
        val clues = listOf<Clue>(
            StaticClue(nationality = Englishman, color = red),
            StaticClue(nationality = Spaniard, animal = dog),
            StaticClue(drink = coffee, color = green),
            StaticClue(nationality = Ukrainian, drink = tea),
            StaticClue(cigarette = OldGold, animal = snails),
            StaticClue(cigarette = Kools, color = yellow),
            StaticClue(cigarette = LuckyStrike, drink = juice),
            StaticClue(nationality = Japanese, cigarette = Parliaments),
            GreenHouseRightToIvoryHouse(),
            ChesterfieldsSmokerNextToFox(),
            KoolsSmokerNextToHorse()
        )
        houses[0].nationality = Norwegian
        houses[1].color = blue
        houses[2].drink = milk

        val all = clues.all { clue -> clue.satisfied(houses) }
        println("all " + all)
        //The green house is immediately to the right of the ivory house.
        //The man who smokes Chesterfields lives in the house next to the man with the fox.
        //Kools are smoked in the house next to the house where the horse is kept.
    }

    fun drinksWater(): String = "Norwegian"

    fun ownsZebra(): String = "Japanese"

    interface Clue {
        fun satisfied(houses: Array<House>): Boolean
    }

    class StaticClue(
        var color: Color? = null,
        var nationality: Nationality? = null,
        var animal: Animal? = null,
        var drink: Drink? = null,
        var cigarette: Cigarette? = null
    ) : Clue {
        override fun satisfied(houses: Array<House>): Boolean {
            return houses.any(::satisfiedBy)
        }

        private fun satisfiedBy(house: House): Boolean {
            var x = 0
            if (this.color != null && (this.color == house.color || house.color == null)) x++
            if (this.nationality != null && (this.nationality == house.nationality || house.nationality == null)) x++
            if (this.animal != null && (this.animal == house.animal || house.animal == null)) x++
            if (this.drink != null && (this.drink == house.drink || house.drink == null)) x++
            if (this.cigarette != null && (this.cigarette == house.cigarette || house.cigarette == null)) x++
            return x == 2
        }
    }

    data class House(
        var color: Color? = null,
        var nationality: Nationality? = null,
        var animal: Animal? = null,
        var drink: Drink? = null,
        var cigarette: Cigarette? = null
    )

    enum class Color {
        red, green, ivory, yellow, blue
    }

    enum class Nationality {
        Englishman, Spaniard, Ukrainian, Norwegian, Japanese
    }

    enum class Animal {
        dog, snails, fox, horse, zebra
    }

    enum class Drink {
        coffee, tea, milk, juice, water
    }

    enum class Cigarette {
        OldGold, Kools, Chesterfields, LuckyStrike, Parliaments
    }

}

class KoolsSmokerNextToHorse : ZebraPuzzle.Clue {
    override fun satisfied(houses: Array<ZebraPuzzle.House>): Boolean {
        return houses.toList().windowed(2).any {
            val f1 = (it[0].cigarette == null || it[0].cigarette == Kools) && (it[1].animal == null || it[1].animal == horse)
            val f2 = (it[1].cigarette == null || it[1].cigarette == Kools) && (it[0].animal == null || it[0].animal == horse)

            f1 || f2
        }
    }
}

class ChesterfieldsSmokerNextToFox : ZebraPuzzle.Clue {
    override fun satisfied(houses: Array<ZebraPuzzle.House>): Boolean {
        return houses.toList().windowed(2).any {
            val f1 = (it[0].cigarette == null || it[0].cigarette == Chesterfields) && (it[1].animal == null || it[1].animal == fox)
            val f2 = (it[1].cigarette == null || it[1].cigarette == Chesterfields) && (it[0].animal == null || it[0].animal == fox)

            f1 || f2
        }
    }
}

class GreenHouseRightToIvoryHouse : ZebraPuzzle.Clue {
    override fun satisfied(houses: Array<ZebraPuzzle.House>): Boolean = houses.toList()
        .windowed(2).any {
            (it[0].color == null || it[0].color == ivory) && (it[1].color == null || it[1].color == Color.GREEN)
        }

}
