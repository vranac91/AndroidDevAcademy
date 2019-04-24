package week2.homework

import week2.homework.character.Character
import week2.homework.character.CharacterClass
import week2.homework.items.Armor
import week2.homework.items.EnergyPotion
import week2.homework.items.HealthPotion

fun main(args: Array<String>) {
    val player = Character.createCharacter("Dinko", "Male", CharacterClass.SPELLSWORD)

    val armor = Armor("Miracle armor",5,5, Triple(10,10,10))
    val potion = EnergyPotion()
    val potion2 = HealthPotion()
    println(player.energy)
    player.addItemToInventory(potion)
    player.addItemToInventory(armor)
    player.addItemToInventory(potion2)
    player.showInventoryItems()
    potion.drinkPotion()
    println(player.energy)
    player.showInventoryItems()
}