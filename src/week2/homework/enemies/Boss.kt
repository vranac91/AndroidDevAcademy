package week2.homework.enemies

import week2.homework.character.Character

object Boss : BaseEnemy(
        name = "Arkhanu Amun",
        experience = 500,
        health = 100,
        energy = 150,
        attack = 10..20,
        defense = 5..10,
        items = listOf()
) {
    override fun attackPhysical() {
        Character.health -= attack.random()
    }

    override fun attackMagical() {
        Character.health -= 15
    }

    override fun block() : Int {
        return defense.random()
    }

    override fun die() {
        println("Congratulations, you've won!")
    }

}