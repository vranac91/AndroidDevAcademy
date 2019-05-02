package week2.homework.enemies

import week2.homework.gamemechanics.Battle

class BoneDragon : BaseEnemy(
        name = "Bone Dragon",
        health = (50..70).random(),
        energy = (30..40).random(),
        experience = (100..120).random(),
        attack = (9..12).random()..(13..22).random(),
        defense = 5..10,
        items = mutableListOf()
), Battle {
    override fun attackPhysical(): Int {
        return attack.random()
    }

    override fun attackMagical(): Int {
        if (energy >= 10) {
            energy -= 10
            return (attack.random() * 1.5).toInt()
        } else return attackPhysical()
    }

    override fun block(): Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 5) return blockValue + 5
        return block()
    }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}
}