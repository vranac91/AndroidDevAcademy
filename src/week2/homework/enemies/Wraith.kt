package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class Wraith : BaseEnemy(
        name = "Wraith",
        health = (10..15).random(),
        energy = (15..25).random(),
        experience = (20..30).random(),
        attack = (3..6).random()..(7..8).random(),
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
        if ((1..10).random() > 6) attackMagical()
        else {
            super.attackPhysical()
        }
    }

    override fun attackMagical() {
        if (energy >= 5) {
            energy -= 5
            val attack = attack.random() + 2
            Character.healthCurrent -= attack
            println("$name attacked you with magic and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        } else println("$name failed to attack you with magic")
    }

    override fun block(): Int { return defense.random() }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}

}