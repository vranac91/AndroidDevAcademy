package week2.homework.enemies

import week2.homework.character.Character

class BoneDragon : BaseEnemy(
        name = "Bone Dragon",
        health = (50..70).random(),
        energy = (30..40).random(),
        experience = (100..120).random(),
        attack = (9..12).random()..(13..22).random(),
        defense = 5..10,
        items = mutableListOf()
) {
    override fun attackPhysical() {
        super.attackPhysical()
        println("$name attacked you and reduced your health to ${Character.healthCurrent}")
    }

    override fun attackMagical() {
        if (energy >= 10) {
            energy -= 10
            Character.healthCurrent = (attack.random() * 1.5).toInt()
        } else attackPhysical()
    }

    override fun block() : Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 6) return blockValue + 5
        return block()
    }

    override fun die() {println("You killed the $name!")}
}