package week2.homework.character

import week2.homework.items.BaseItem
import week2.homework.items.EnergyPotion
import week2.homework.items.HealthPotion
import week2.homework.spells.BaseSpell
import week2.homework.ui.BattleActions
import kotlin.system.exitProcess

object Character {
    var name: String? = null
    var sex: String? = null
    var characterClass: CharacterClass = CharacterClass.WARRIOR
    var level = 1
    var experience = 0
    var health = 0
    var energy = 0
    var strength = 0
    var dexterity = 0
    var intelligence = 0
    var attack = 0
    var defense = 0
    var spells = mutableListOf<BaseSpell>()
    var equippedItems = mutableListOf<BaseItem>()
    var inventoryItems = mutableListOf<BaseItem>()
    var inventorySize = 50
    var inventoryUsedSize = 0
    var gold = 0

    fun createCharacter(name: String?, sex: String?, charClass: CharacterClass) {
        this.name = name
        this.sex = sex
        this.characterClass = charClass
    }

    fun setHealth() {
        health = (strength + dexterity + intelligence) * 2
    }

    fun setEnergy() {
        energy = intelligence * 2
    }

    fun setAttack() {
        attack = (strength + dexterity + intelligence) / 10
    }

    fun setDefense() {
        defense = (strength + dexterity + intelligence) / 10
    }

    fun equipItem(item: BaseItem) {
        if (inventoryItems.contains(item) && item.isEquipable()) {
            equippedItems.add(item)
            item.isEquipped = true
            inventoryItems.remove(item)
        }
    }

    fun addItemToInventory(item: BaseItem?) {
        if (item!!.size <= inventorySize - inventoryUsedSize) {
            inventoryItems.add(item)
            inventoryUsedSize += item.size
        }
    }

    fun drinkHealthPotion() {
        val potion = HealthPotion()
        if (inventoryItems.contains(potion)) {
            health += 10
            inventoryItems.remove(potion)
            println("Increased health by 10 to $health")
        } else println("No health potion in the inventory!")
    }

    fun drinkEnergyPotion() {
        val potion = EnergyPotion()
        if (inventoryItems.contains(potion)) {
            energy += 10
            inventoryItems.remove(potion)
            println("Increased energy by 10 to $energy")
        } else println("No energy potion in the inventory!")
    }

    fun attackPhysical() : Int {
        println("You've reduced the enemy's health by $attack")
        return attack
    }

    fun attackMagical() : Int {
        return BattleActions.selectSpell()
    }

    fun block() : Int {
        val chance = 1..10
        val pick = chance.random()
        if (pick >= 8) return defense
        return 0
    }

    fun die() {
        println("You died! Keep on trying!")
        exitProcess(0)
    }

    fun refreshStats() {
        setAttack()
        setDefense()
        setEnergy()
        setHealth()
    }

    fun regenerate(healthAmount: Int = 2, energyAmount: Int = 1) {
        health += healthAmount
        energy += energyAmount
    }
}