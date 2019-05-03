package week2.homework.character

import week2.homework.data.Items
import week2.homework.enemies.BaseEnemy
import week2.homework.items.BaseItem
import week2.homework.spells.BaseSpell
import week2.homework.ui.BattleActions
import kotlin.system.exitProcess

object Character {
    var name: String? = null
    var sex: String? = null
    var characterClass: CharacterClass = CharacterClass.WARRIOR
    var level = 1
    var experience = 0
    var healthMax = 0
    var healthCurrent = 0
    var energyMax = 0
    var energyCurrent = 0
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

    /*
    Creates the character with the given user input.
     */

    fun createCharacter(name: String?, sex: String?, charClass: CharacterClass) {
        this.name = name
        this.sex = sex
        this.characterClass = charClass
    }

    /*
    Calculates health value based on selected class properties.
     */

    fun setMaxHealth() {
        healthMax += (strength + dexterity + intelligence) * 2
    }

    /*
    Calculates energy value based on selected class properties.
     */

    fun setMaxEnergy() {
        energyMax += intelligence * 2
    }

    /*
    Calculates attack value based on selected class properties.
     */

    fun setAttack() {
        attack += (strength + dexterity + intelligence) / 10
    }

    /*
    Calculates defense value based on selected class properties.
     */

    fun setDefense() {
        defense += (strength + dexterity + intelligence) / 10
    }

    /*
    Equips item from the inventory if it can be equipped.
     */

    fun equipItem(item: BaseItem): Boolean {
        if (equippedItems.size < 4) {
            if (inventoryItems.contains(item) && item.isEquipable()) {
                equippedItems.add(item)
                item.isEquipped = true
                inventoryItems.remove(item)
                inventoryUsedSize -= item.size
                return true
            }
        }
        else println("Too many items equipped!")
        return false
    }

    /*
    Adds item to inventory if there is enough space for it.
     */

    fun addItemToInventory(item: BaseItem?) {
        if (item!!.size <= inventorySize - inventoryUsedSize) {
            inventoryItems.add(item)
            inventoryUsedSize += item.size
        }
    }

    /*
    Drinks health potion if there is one in the inventory.
     */

    fun drinkHealthPotion() {
        if (Character.inventoryItems.contains(Items.healthPotion)) {
            healthCurrent += 10
            if (healthCurrent > healthMax) healthCurrent = healthMax
            inventoryItems.remove(Items.healthPotion)
            println("Increased health by 10 to $healthCurrent")
        } else println("No health potion in the inventory!")
    }

    /*
    Drinks energy potion if there is one in the inventory.
     */

    fun drinkEnergyPotion() {
        if (Character.inventoryItems.contains(Items.energyPotion)) {
            energyCurrent += 10
            if (energyCurrent > energyMax) energyCurrent = energyMax
            inventoryItems.remove(Items.energyPotion)
            println("Increased energy by 10 to $energyCurrent")
        } else println("No energy potion in the inventory!")
    }

    /*
    Returns the amount of dealt physical damage.
     */

    fun attackPhysical(enemy: BaseEnemy) : Int {
        val attackValue = attack - enemy.block()
        println("You've reduced the ${enemy.name}'s health by $attackValue to ${enemy.health - attackValue}")
        return attackValue
    }

    /*
    Returns the amount of dealt magical damage.
     */

    fun attackMagical() : Int {
        return BattleActions.selectSpell()
    }

    /*
    Calculates the chance to block attack
     */

    fun block() : Int {
        val chance = 1..10
        val pick = chance.random()
        if (pick >= 8) return defense / 2
        return 0
    }

    /*
    Ends the game.
     */

    fun die() {
        println("You died! Keep on trying!")
        exitProcess(0)
    }

    /*
    Increases the corresponding attribute for every equipped item
     */

    fun setAttributesFromEquippedItems() {
        for (item in equippedItems) item.increaseAttribute()
    }

    /*
    Resets main attributes to zero.
     */

    fun resetAttributes() {
        healthMax = 0
        energyMax = 0
        attack = 0
        defense = 0
    }

    /*
    Resets all attributes and recalculates them.
    Triggered when equipping a new item.
     */

    fun refreshStats() {
        resetAttributes()
        setAttributesFromEquippedItems()
        setAttack()
        setDefense()
        setMaxEnergy()
        setMaxHealth()
    }

    fun regenerate(healthAmount: Int = 2, energyAmount: Int = 1) {
        healthCurrent += healthAmount
        energyCurrent += energyAmount
    }
}