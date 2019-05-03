package week2.homework.enemies

import week2.homework.character.Character
import kotlin.system.exitProcess

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
        super.attackPhysical()
        println("$name struck a mighty blow, reducing your health to ${Character.healthCurrent}/${Character.healthMax}")
    }

    override fun attackMagical() {
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