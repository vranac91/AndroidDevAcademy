package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items

class BoneDragon : BaseEnemy(
        name = "Bone Dragon",
        health = (50..70).random(),
        energy = (30..40).random(),
        experience = (100..120).random(),
        attack = (9..12).random()..(13..15).random(),
        defense = 5..10,
        items = mutableListOf(
                Items.healthPotion,
                Items.healthPotion,
                Items.healthPotion,
                Items.healthPotion,
                Items.healthPotion,
                Items.energyPotion,
                Items.energyPotion,
                Items.energyPotion
        )
) {
    override fun attackPhysical() {
        attackMagical()
    }

    override fun attackMagical() {
        if (energy >= 10) {
            energy -= 10
            Character.healthCurrent -= (attack.random() * 1.2).toInt()
            println("$name attacked you with magic and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        } else {
            val attack = attack.random()
            Character.healthCurrent -= attack
            println("$name attacked you and reduced your health to ${Character.healthCurrent}/${Character.healthMax}")
        }
    }

    override fun block() : Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 8) return blockValue + 2
        return blockValue
    }

    override fun die() {println("You killed the $name!")}
}