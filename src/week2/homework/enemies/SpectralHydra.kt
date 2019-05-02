package week2.homework.enemies

import week2.homework.character.Character

class SpectralHydra : BaseEnemy(
        name = "Spectral Hydra",
        health = (30..40).random(),
        energy = (30..40).random(),
        experience = (50..70).random(),
        attack = (4..7).random()..(8..15).random(),
        defense = 3..6,
        items = mutableListOf()
) {
    override fun attackPhysical() {
        val damage = super.attackPhysical()
        println("$name attacked you and reduced your health by $damage to ${Character.health}")
    }

    override fun attackMagical() {
        if (energy >= 7) {
            energy -= 7
            Character.health -= attack.random() + 3
        } else attackPhysical()
    }

    override fun block(): Int {
        val range = 1..10
        val blockValue = defense.random()
        if (range.random() > 5) return blockValue + 2
        return block()
    }

    override fun die() {println("You killed the $name!")}
}