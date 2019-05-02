package week2.homework.ui

import week2.homework.character.Character

class GameplayActions {
    companion object {
        fun printGameplayOptions() {
            var input: String?
            loop@ while(true) {
                println("\nChoose an option:\n" +
                        "[1] Attack the next enemy\n" +
                        "[2] Show character statistics\n" +
                        "[3] Show inventory items\n" +
                        "[4] Show equipped items\n" +
                        "[5] Equip items from inventory")
                input = readLine()?.trim()
                when (input) {
                    "1" -> {
                        BattleActions.attackNextEnemy()
                        break@loop
                    }
                    "2" -> printCharacterData()
                    "3" -> printInventoryData()
                    "4" -> printEquippedItemsData()
                    "5" -> selectItemToEquip()
                }
            }
        }

        fun printCharacterData() {
            println("----------CHARACTER DATA----------")
            println("Name: ${Character.name}" +
                    "\nSex: ${Character.sex}" +
                    "\nClass: ${Character.characterClass}" +
                    "\nLevel: ${Character.level}" +
                    "\nExperience: ${Character.experience}" +
                    "\nHealth: ${Character.health}" +
                    "\nEnergy: ${Character.energy}" +
                    "\nStrength: ${Character.strength}" +
                    "\nDexterity: ${Character.dexterity}" +
                    "\nIntelligence: ${Character.intelligence}" +
                    "\nAttack: ${Character.attack}" +
                    "\nDefense: ${Character.defense}" +
                    "\nGold: ${Character.gold}")
        }

        fun printInventoryData() {
            println("----------INVENTORY DATA----------")
            println("Inventory size: ${Character.inventorySize}")
            println("Inventory size left: ${Character.inventorySize - Character.inventoryUsedSize}")
            if (Character.inventoryItems.isEmpty()) println("No items.")
            for (item in Character.inventoryItems) println(item)
        }

        fun printEquippedItemsData() {
            println("----------EQUIPPED ITEMS DATA----------")
            if (Character.equippedItems.isEmpty()) println("No items.")
            for (item in Character.equippedItems) println(item)
        }

        fun selectItemToEquip() {
            if (Character.inventoryItems.isNotEmpty()) {
                loop@ while (true) {
                    println("\nSelect items to equip:\n")
                    var i = 1
                    for (item in Character.inventoryItems)
                        if (item.canBeEquipped) {
                            println("[$i] $item")
                            i++
                        }
                    println("[$i] Cancel")
                    val num = readLine()?.toInt()
                    if (num != null) {
                        if (num > 0 && num <= Character.inventoryItems.size) {
                            if (Character.inventoryItems[num - 1].isEquipable()) {
                                Character.equipItem(Character.inventoryItems[num - 1])
                                println("Item equipped!")
                                Character.refreshStats()
                            }
                        }
                        else break@loop
                    }
                }
            }
            else println("No items to equip!")
        }
    }
}