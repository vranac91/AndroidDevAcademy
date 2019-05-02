package week2.homework.enemies

import week2.homework.gamemechanics.Battle

class Wraith : BaseEnemy(
        name = "Wraith",
        health = (10..15).random(),
        energy = (15..25).random(),
        experience = (20..30).random(),
        attack = (1..3).random()..(4..6).random(),
        defense = 2..4,
        items = mutableListOf()
), Battle {
    override fun attackPhysical(): Int {
        return attack.random() - 1
    }

    override fun attackMagical(): Int {
        if (energy >= 5) {
            energy -= 5
            return attack.random() + 1
        } else return 0
    }

    override fun block(): Int { return defense.random() }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}

}