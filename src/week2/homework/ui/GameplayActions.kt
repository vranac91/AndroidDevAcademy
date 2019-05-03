package week2.homework.ui

import week2.homework.character.Character
import week2.homework.items.BaseItem
import java.util.*

class GameplayActions {
    companion object {

        /*
        Prints the available options in the non-battle phase:
        - 1 = starts battle with the next living enemy
        - 2 = prints character sheet
        - 3 = prints inventory items, if any
        - 4 = prints equipped items, if any
        - 5 = allows the user to equip inventory item, if there are any
         */

        fun printGameplayOptions() {
            var input: String?
            loop@ while (true) {
                println("\nChoose an option:\n" +
                        "[1] Attack the next enemy\n" +
                        "[2] Show character statistics\n" +
                        "[3] Show inventory items\n" +
                        "[4] Show equipped items\n" +
                        "[5] Equip items from inventory\n" +
                        "[6] Remove items from inventory\n" +
                        "[7] Remove equipped items permanently")
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
                    "6" -> selectItemToRemove()
                    "7" -> removeEquippedItem()
                }
            }
        }

        /*
        Prints the character sheet.
         */

        fun printCharacterData() {
            println("----------CHARACTER DATA----------")
            println("Name: ${Character.name}" +
                    "\nSex: ${Character.sex}" +
                    "\nClass: ${Character.characterClass}" +
                    "\nLevel: ${Character.level}" +
                    "\nExperience: ${Character.experience}" +
                    "\nHealth: ${Character.healthCurrent}/${Character.healthMax}" +
                    "\nEnergy: ${Character.energyCurrent}/${Character.energyMax}" +
                    "\nStrength: ${Character.strength}" +
                    "\nDexterity: ${Character.dexterity}" +
                    "\nIntelligence: ${Character.intelligence}" +
                    "\nAttack: ${Character.attack}" +
                    "\nDefense: ${Character.defense}" +
                    "\nGold: ${Character.gold}")
        }

        /*
        Prints the inventory items.
        If there are none, prints "No items."
         */

        fun printInventoryData() {
            println("----------INVENTORY DATA----------")
            println("Inventory size: ${Character.inventorySize}")
            println("Inventory size left: ${Character.inventorySize - Character.inventoryUsedSize}")
            if (Character.inventoryItems.isEmpty()) println("No items.")
            Character.inventoryItems.sortBy { it.name }
            for (item in Character.inventoryItems) println(item)
        }

        /*
        Prints the equipped items.
        If there are none, prints "No items."
         */

        fun printEquippedItemsData() {
            println("----------EQUIPPED ITEMS DATA----------")
            if (Character.equippedItems.isEmpty()) println("No items.")
            for (item in Character.equippedItems) println(item)
        }

        /*
        Allows the user to select the item to equip:
        - if there are no inventory items, skips the loop and prints the message
        - prints out all equippable items
        - prints out Cancel option, selecting it closes the dialog
        - for selected item, checks if its requirements are matched and puts it to equipped items collection
         */

        fun selectItemToEquip() {
            loop@ while (true) {
                if (Character.inventoryItems.none { it.canBeEquipped }) {
                    println("No items to equip!")
                    break@loop
                }
                println("\nSelect items to equip:\n")
                var i = 1
                var equippableItems = mutableListOf<BaseItem>()
                for (item in Character.inventoryItems)
                    if (item.canBeEquipped) {
                        println("[$i] $item")
                        equippableItems.add(item)
                        i++
                    }
                println("[$i] Cancel")
                val scanner = Scanner(System.`in`)
                while (!scanner.hasNextInt()) {
                    println("Please input a valid number!")
                    scanner.nextLine()
                }
                val num = scanner.nextInt()
                if (num == i) break@loop
                if (num in 1..equippableItems.size) {
                    if (equippableItems[num - 1].isEquipable()) {
                        if (Character.equipItem(equippableItems[num - 1])) println("Item equipped: ${equippableItems[num - 1].name}")
                        Character.refreshStats()
                    } else println("Item cannot be equipped - requirements are not met!")
                }
            }
        }

        fun selectItemToRemove() {
            loop@ while (true) {
                if (Character.inventoryItems.isEmpty()) {
                    println("No items to remove!")
                    break@loop
                }
                println("\nSelect items to remove:\n")
                var i = 1
                for (item in Character.inventoryItems) {
                    println("[$i] $item")
                    i++
                }
                println("[$i] Cancel")
                val scanner = Scanner(System.`in`)
                while (!scanner.hasNextInt()) {
                    println("Please input a valid number!")
                    scanner.nextLine()
                }
                val num = scanner.nextInt()
                if (num == i) break@loop
                if (num > 0 && num <= Character.inventoryItems.size) {
                    Character.inventoryUsedSize -= Character.inventoryItems[num - 1].size
                    Character.inventoryItems.removeAt(num - 1)
                    println("Item removed!")
                }
            }
        }

        fun removeEquippedItem() {
            loop@ while (true) {
                if (Character.equippedItems.isNotEmpty()) {
                    println("\nSelect items to remove:\n")
                    var i = 1
                    for (item in Character.equippedItems) {
                        println("[$i] $item")
                        i++
                    }
                    println("[$i] Cancel")
                    val scanner = Scanner(System.`in`)
                    while (!scanner.hasNextInt()) {
                        println("Please input a valid number!")
                        scanner.nextLine()
                    }
                    val num = scanner.nextInt()
                    if (num == i) break@loop
                    if (num > 0 && num <= Character.equippedItems.size) {
                        Character.equippedItems.removeAt(num - 1)
                        println("Item removed permanently!")
                        Character.refreshStats()
                    }
                }
                else println("No items to remove!")
                break@loop
            }
        }
    }
}