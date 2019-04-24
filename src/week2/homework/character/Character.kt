package week2.homework.character

import week2.homework.enemies.BaseEnemy
import week2.homework.items.BaseItem

object Character {
    val name = ""
    val sex = ""
    val characterClass = null
    var level = 1
    var experience = 0
    var health = 100
    var energy = 100
    var strength = 0
    var dexterity = 0
    var intelligence = 0
    var attack = 0..0
    var defense = 0..0
    var equippedItems = mutableListOf<BaseItem>()
    var inventoryItems = mutableListOf<BaseItem>()
    var inventorySize = 50
    var gold = 0

    fun createCharacter(name: String, sex: String, charClass: CharacterClass) = Character

    fun equipItem(item: BaseItem) {
        if (inventoryItems.contains(item) && item.isEquipable()) {
            equippedItems.add(item)
            inventoryItems.remove(item)
        }
    }

    fun showInventoryItems() {
        println("--- Inventory ---")
        for (item in inventoryItems) println(item)
        println("-----------------")
    }

    fun showEquippedItems() {
        println("--- Equipped Items ---")
        for (item in equippedItems) println(item)
        println("----------------------")
    }

    fun addItemToInventory(item: BaseItem) {
        if (item.size <= (inventorySize - inventoryItems.size)) inventoryItems.add(item)
    }

    fun attack(enemy: BaseEnemy) : Int {
        return attack.random()
    }

    fun block() : Int {
        return defense.random()
    }

    fun die() {
        // TODO
    }
}