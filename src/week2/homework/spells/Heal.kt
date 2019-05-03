package week2.homework.spells

import week2.homework.character.Character

object Heal : BaseSpell() {
    override val name = "Heal"
    override val cost = 10
    override val damage = 15

    override fun activate(): Int {
        if (Character.energyCurrent >= cost) {
            Character.energyCurrent -= cost
        } else {
            println("Not enough energy!")
            return 0
        }
        Character.healthCurrent += damage
        println("Your spell $name restored your health by $damage to ${Character.healthCurrent}")
        return 0
    }
}