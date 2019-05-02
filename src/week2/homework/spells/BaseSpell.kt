package week2.homework.spells

import week2.homework.character.Character

abstract class BaseSpell {
    abstract val name: String
    abstract val cost: Int
    abstract val damage: Int

    open fun activate() : Int {
        if (Character.energy >= cost) {
            Character.energy -= cost
        } else {
            println("Not enough energy!")
            return 0
        }
        return damage
    }

    override fun toString(): String {
        return "$name - cost: $cost"
    }
}