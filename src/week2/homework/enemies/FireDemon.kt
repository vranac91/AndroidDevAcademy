package week2.homework.enemies

import week2.homework.gamemechanics.Battle

class FireDemon : BaseEnemy(
        name = "Fire Demon",
        health = (20..30).random(),
        energy = (25..30).random(),
        experience = (40..50).random(),
        attack = (2..4).random()..(4..8).random(),
        defense = 3..5,
        items = mutableListOf()
), Battle {
    var attackLow = attack.start
    var attackHigh = attack.endInclusive
    var attackRange = attackLow..attackHigh

    override fun attackPhysical(): Int {
        return 0
    }

    override fun attackMagical(): Int {
        if (energy >= 6) {
            energy -= 6
            attackLow++
            attackHigh++
            return attackRange.random()
        } else return attackPhysical()
    }

    fun restoreEnergy() {
        energy += 10
    }

    override fun block(): Int {
        if (energy <= 10) return 6
        return defense.random()
    }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}
}