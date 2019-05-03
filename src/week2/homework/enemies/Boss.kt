package week2.homework.enemies

import week2.homework.character.Character
import kotlin.system.exitProcess

object Boss : BaseEnemy(
        name = "Arkhanu Amun",
        experience = 500,
        health = 80,
        energy = 1000,
        attack = 10..15,
        defense = 5..10,
        items = listOf()
) {
    override fun attackPhysical() {
        if ((1..10).random() > 7) attackMagical()
        else {
            super.attackPhysical()
        }
    }

    override fun attackMagical() {
        energy -= 20
        Character.healthCurrent -= 15
        println("$name hits you with magic bolt, reducing your health to ${Character.healthCurrent}/${Character.healthMax}")
    }

    override fun block() : Int {
        return defense.random()
    }

    override fun die() {
        println("Congratulations, you've won! Thanks for playing!")
        exitProcess(0)
    }

}