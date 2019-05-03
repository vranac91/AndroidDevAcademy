package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class FireDemon : BaseEnemy(
        name = "Fire Demon",
        health = (20..30).random(),
        energy = (25..30).random(),
        experience = (40..50).random(),
        attack = (2..4).random()..(4..8).random(),
        defense = 3..5,
        items = mutableListOf(
                Items.armor.random(),
                Items.axes.random(),
                Items.rings.random(),
                Items.swords.random(),
                Items.staffs.random(),
                Items.healthPotion,
                Items.energyPotion
        )
) {
    var attackLow = attack.start
    var attackHigh = attack.endInclusive
    var attackRange = attackLow..attackHigh

    override fun attackPhysical() {
        super.attackPhysical()
        println("$name attacked you and reduced your health to ${Character.healthCurrent}")
    }

    override fun attackMagical() {
        if (energy >= 6) {
            energy -= 6
            attackLow++
            attackHigh++
            Character.healthCurrent -= attackRange.random()
        } else attackPhysical()
    }

    fun restoreEnergy() {
        energy += 10
    }

    override fun block(): Int {
        if (energy <= 10) return 6
        return defense.random()
    }

    override fun die() {println("You killed the $name!")}
}