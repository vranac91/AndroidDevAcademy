package week2.homework.enemies

import week2.homework.character.Character
import week2.homework.data.Items
import week2.homework.items.Gold

class Ghoul : BaseEnemy(
        name = "Ghoul",
        health = (8..10).random(),
        energy = 0,
        experience = (10..15).random(),
        attack = (1..2).random()..(2..5).random(),
        defense = 0..2,
        items = listOf(Items.armor.find { it.armorName == "Leather Armor" }, Items.healthPotion, Items.healthPotion, Items.energyPotion, Gold(200))
) {
    override fun attackPhysical() {
        super.attackPhysical()
        println("$name attacked you and reduced your health to ${Character.healthCurrent}")
    }

    override fun attackMagical() {}

    override fun block(): Int {
        return defense.random()
    }

    override fun die() {
        println("You killed the $name!")
    }
}