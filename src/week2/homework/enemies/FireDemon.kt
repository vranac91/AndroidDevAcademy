package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class FireDemon : BaseEnemy(
        name = "Fire Demon",
        health = (20..30).random(),
        energy = (25..30).random(),
        experience = (40..50).random(),
        attack = (4..6).random()..(6..9).random(),
        defense = 3..5,
        items = mutableListOf(
                Items.armor.random(),
                Items.axes.random(),
                Items.rings.random(),
                Items.swords.random(),
                Items.staffs.random(),
                Items.healthPotion,
                Items.healthPotion,
                Items.energyPotion,
                Items.energyPotion
        )
) {
    private var attackLow = attack.start
    private var attackHigh = attack.endInclusive
    private var attackRange = attackLow..attackHigh

    override fun attackPhysical() {
        if ((1..10).random() < 7) attackMagical()
        else {
            super.attackPhysical()
        }
    }

    override fun attackMagical() {
        if (energy >= 6) {
            energy -= 6
            attackLow++
            attackHigh++
            Character.healthCurrent -= attackRange.random()
            println("$name attacked you with magic and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        } else {
            Character.healthCurrent -= 5
            println("$name attacked you with magic and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        }
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