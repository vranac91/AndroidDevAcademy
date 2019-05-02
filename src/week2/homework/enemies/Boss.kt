package week2.homework.enemies

import week2.homework.gamemechanics.Battle

object Boss : BaseEnemy(
        name = "Arkhanu Amun",
        experience = 500,
        health = 100,
        energy = 150,
        attack = 10..20,
        defense = 0..10,
        items = listOf()
), Battle {
    override fun attackPhysical(): Int {
        return attack.random()
    }

    override fun attackMagical(): Int {
        return 0
    }

    override fun block() : Int {
        return defense.random()
    }

    override fun die() {

    }

}