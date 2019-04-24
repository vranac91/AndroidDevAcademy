package week2.homework.items

import week2.homework.character.Character

abstract class BaseItem {
    abstract val name: String
    abstract val size: Int
    abstract val value: Int
    abstract val requirements: Triple<Int, Int, Int>

    fun isEquipable() : Boolean {
        val (strength, dexterity, intelligence) = requirements
        return Character.strength >= strength && Character.dexterity >= dexterity && Character.intelligence >= intelligence
    }

    override fun toString(): String {
        return "$name - size: $size, value: $value"
    }
}