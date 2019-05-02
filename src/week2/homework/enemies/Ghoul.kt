package week2.homework.enemies

import week2.homework.data.Items
import week2.homework.gamemechanics.Battle
import week2.homework.items.EnergyPotion
import week2.homework.items.Gold
import week2.homework.items.HealthPotion

class Ghoul : BaseEnemy(
        name = "Ghoul",
        health = (8..10).random(),
        energy = 0,
        experience = (10..15).random(),
        attack = (1..2).random()..(2..5).random(),
        defense = 0..2,
        items = mutableListOf(Items.armor.find { it.armorName == "Leather Armor" }, HealthPotion(), EnergyPotion(), Gold(200))
), Battle {
    override fun attackPhysical(): Int { return attack.random() }

    override fun attackMagical(): Int { return 0 }

    override fun block(): Int { return defense.random() }

    override fun die() { if (this.health <= 0) println("You killed the $name!") }
}