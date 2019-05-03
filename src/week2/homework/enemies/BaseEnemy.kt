package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.items.BaseItem

abstract class BaseEnemy (
        val name: String,
        var health: Int,
        var energy: Int,
        val experience: Int,
        val attack: IntRange,
        val defense: IntRange,
        val items: List<BaseItem?>
) {
    override fun toString(): String {
        return "$name - health: $health, " +
                "energy: $energy, " +
                "experience: $experience, " +
                "attack: ${attack.start}-${attack.endInclusive}, " +
                "defense: ${defense.start}-${defense.endInclusive}"
    }

    open fun attackPhysical() {
        Character.healthCurrent -= attack.random() + Character.block()
    }
    abstract fun attackMagical()
    abstract fun block() : Int
    abstract fun die()
}