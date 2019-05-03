package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class SpectralHydra : BaseEnemy(
        name = "Spectral Hydra",
        health = (30..40).random(),
        energy = (30..40).random(),
        experience = (50..70).random(),
        attack = (4..7).random()..(8..15).random(),
        defense = 3..6,
        items = mutableListOf(
                Items.axes.random(),
                Items.swords.random(),
                Items.staffs.random(),
                Items.healthPotion,
                Items.healthPotion,
                Items.healthPotion,
                Items.energyPotion
        )
) {
    override fun attackPhysical() {
        if ((1..10).random() >= 8) attackMagical()
        else {
            super.attackPhysical()
        }
    }

    override fun attackMagical() {
        if (energy >= 10) {
            energy -= 10
            val amount = attack.random() + 3
            Character.healthCurrent -= amount
            println("$name attacked you with magic and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        } else {
            energy += 10
            println("$name increased its energy for 10 points")
        }
    }

    override fun block(): Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 5) return blockValue + 2
        return block()
    }

    override fun die() {println("You killed the $name!")}
}