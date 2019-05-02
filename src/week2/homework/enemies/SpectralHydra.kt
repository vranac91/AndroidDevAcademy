package week2.homework.enemies

import week2.homework.gamemechanics.Battle

class SpectralHydra : BaseEnemy(
        name = "Spectral Hydra",
        health = (30..40).random(),
        energy = (30..40).random(),
        experience = (50..70).random(),
        attack = (4..7).random()..(8..15).random(),
        defense = 3..6,
        items = mutableListOf()
), Battle {
    override fun attackPhysical(): Int {
        return attack.random()
    }

    override fun attackMagical(): Int {
        if (energy >= 7) {
            energy -= 7
            return attack.random() + 3
        } else return attackPhysical()
    }

    override fun block(): Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 5) return blockValue + 2
        return block()
    }

    override fun die() {if (this.health <= 0) println("You killed the $name!")}
}