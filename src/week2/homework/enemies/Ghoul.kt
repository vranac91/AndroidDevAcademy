package week2.homework.enemies

import week2.homework.data.Items
import week2.homework.items.Gold

class Ghoul : BaseEnemy(
        name = "Ghoul",
        health = (8..10).random(),
        energy = 0,
        experience = (10..15).random(),
        attack = (2..5).random()..(5..8).random(),
        defense = 0..2,
        items = listOf(Items.armor.find { it.armorName == "Leather Armor" }, Items.healthPotion, Items.energyPotion, Gold(200))
) {
    override fun attackPhysical() {
        super.attackPhysical()
    }

    override fun attackMagical() {}

    override fun block(): Int {
        return defense.random()
    }

    override fun die() {
        println("You killed the $name!")
    }
}