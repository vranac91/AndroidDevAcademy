package week2.homework.items

import week2.homework.character.Character

abstract class BaseItem {
    abstract val name: String
    abstract val size: Int
    abstract val value: Int
    abstract val requirements: Triple<Int, Int, Int>
    abstract val strengthBoost: Int
    abstract val dexterityBoost: Int
    abstract val intelligenceBoost: Int
    abstract val attackBoost: Int
    abstract val defenseBoost: Int
    abstract val isEquipped: Boolean

    fun isEquipable() : Boolean {
        val (strength, dexterity, intelligence) = requirements
        return Character.strength >= strength && Character.dexterity >= dexterity && Character.intelligence >= intelligence
    }

    override fun toString(): String {
        return "$name - size: $size, " +
                "value: $value, " +
                "requirements: strength - {${requirements.first}, dexterity - ${requirements.second}, intelligence - ${requirements.third}"
    }

    fun printItemInfo() {
        println("----------$name----------\n" +
                "Size: $size\n" +
                "Value: $value\n" +
                "Requirements: strength - {${requirements.first}, dexterity - ${requirements.second}, intelligence - ${requirements.third}\n" +
                "Strength Boost: $strengthBoost\n" +
                "Dexterity Boost: $dexterityBoost\n" +
                "Intelligence Boost: $intelligenceBoost\n" +
                "Attack Boost: $attackBoost\n" +
                "Defense Boost: $defenseBoost")
    }
}