package week2.homework.character

import week2.homework.enemies.BaseEnemy
import week2.homework.items.BaseItem

object Character {
    var name: String? = null
    var sex: String? = null
    var characterClass: CharacterClass = CharacterClass.WARRIOR
    var level = 1
    var experience = 0
    var health = setHealth()
    var energy = setEnergy()
    var strength = 0
    var dexterity = 0
    var intelligence = 0
    var attack = 0
    var defense = 0
    var equippedItems = mutableListOf<BaseItem>()
    var inventoryItems = mutableListOf<BaseItem>()
    var inventorySize = 50
    var gold = 0

    fun createCharacter(name: String?, sex: String?, charClass: CharacterClass) {
        this.name = name
        this.sex = sex
        this.characterClass = charClass
    }

    fun setHealth(): Int {
        return (strength + dexterity + intelligence) * 2
    }

    fun setEnergy(): Int {
        return intelligence * 2
    }

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
        return attack
    }

    fun block() : Int {
        return defense
    }

    fun die() {
        // TODO
    }

    fun regenerate(healthAmount: Int = 2, energyAmount: Int = 1) {
        health += healthAmount
        energy += energyAmount
    }
}