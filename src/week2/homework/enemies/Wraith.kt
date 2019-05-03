package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class Wraith : BaseEnemy(
        name = "Wraith",
        health = (10..15).random(),
        energy = (15..25).random(),
        experience = (20..30).random(),
        attack = (1..3).random()..(4..6).random(),
        defense = 2..4,
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
    override fun attackPhysical() {
        super.attackPhysical()
        println("$name attacked you and reduced your health to ${Character.healthCurrent}")
    }

    override fun attackMagical() {
        if (energy >= 5) {
            energy -= 5
            Character.healthCurrent -= attack.random() + 1
        }
    }

    override fun block(): Int { return defense.random() }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}

}