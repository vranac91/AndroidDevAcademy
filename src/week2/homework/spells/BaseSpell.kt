package week2.homework.spells

import week2.homework.character.Character

abstract class BaseSpell {
    abstract val name: String
    abstract val cost: Int
    abstract val damage: Int

    /*
    Activates the spell:
    - if player has enough energy, returns the spell damage and reduces the energy count
    - if there is not enough energy to cast the spell, returns 0
     */

    open fun activate() : Int {
        if (Character.energyCurrent >= cost) {
            Character.energyCurrent -= cost
        } else {
            println("Not enough energy!")
            return 0
        }
        println("Your spell $name reduced the enemy's health by $damage")
        return damage
    }

    override fun toString(): String {
        return "$name - energy cost: $cost, damage: $damage"
    }
}