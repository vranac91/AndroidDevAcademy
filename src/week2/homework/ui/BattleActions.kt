package week2.homework.ui

import week2.homework.character.Character
import week2.homework.data.Enemies
import week2.homework.enemies.BaseEnemy
import week2.homework.gamemechanics.BattleFlow

class BattleActions {
    companion object {

        /*
        Prints the list of generated enemies.
        Enemy properties are different on every run.
         */

        fun printListOfEnemies() {
            println("\nThese are the enemies that you need to defeat in order to win the game:\n")
            for (enemy in Enemies.getEnemies()) println(enemy)
        }

        /*
        Starts the battle with the next living enemy from the generated list.
         */

        fun attackNextEnemy() {
            println("You are attacking ${Enemies.enemiesList.first().name}!")
            BattleFlow.battle()
        }

        /*
        Allows the player to pick up items dropped by the killed enemy:
        - if the enemy didn't have any items, it skips the loop and prints the message
        - if there were items, it prints each one of them along with the Close option
        - selecting any item adds it to the inventory if there is enough room in it,
        and removes it from the enemy's items
        - selecting Cancel closes the dialog
         */

        fun lootItems(enemy: BaseEnemy) {
            val items = enemy.items.toMutableList()
            if (!items.isNullOrEmpty()) {
                loop@ while (true) {
                    println("\nYou've found some items on the dead body! Select what to take:\n")
                    var i = 1
                    for (item in items) {
                        println("[$i] $item")
                        i++
                    }
                    println("[$i] Close\n")
                    val num = readLine()?.toInt()
                    if (num != null) {
                        if (num > 0 && num <= items.size) {
                            Character.addItemToInventory(items.get(num - 1))
                            items.removeAt(num - 1)
                        } else if (num == i) break@loop
                    }
                }
            } else println("No items available!")
        }

        /*
        Allows the player to select the spell for attack:
        - if there are no spells available, skips the loop and prints the message
        - if there are spells, prints each of them
        - selecting the spell returns its damage value, if the user has enough energy to activate it
         */

        fun selectSpell(): Int {
            if (Character.spells.isNotEmpty()) {
                loop@ while (true) {
                    println("Choose the spell for attack:\n")
                    var i = 1
                    for (spell in Character.spells) {
                        println("[$i] $spell")
                        i++
                    }
                    val spell = readLine()?.toInt()
                    if (spell != null) {
                        if (spell > 0 && spell <= Character.spells.size) {
                            return Character.spells[spell - 1].activate()
                        }
                    }
                }
            } else println("No spells available!")
            return 0
        }

        /*
        Prints available actions during the battle phase:
        - 1 = attack the enemy with physical damage
        - 2 = attack the enemy with magical damage
        - 3 = drink health potion, if there is one in the inventory
        - 4 = drink energy potion, if there is one in the inventory
        Drinking potions does not end the turn.
         */

        fun printBattleOptions(): Int {
            var input: String?
            loop@ while (true) {
                println("\n[1] Attack with weapon\n" +
                        "[2] Attack with spell\n" +
                        "[3] Drink health potion\n" +
                        "[4] Drink energy potion")
                input = readLine()?.trim()
                when (input) {
                    "1" -> {
                        return Character.attackPhysical()
                    }
                    "2" -> {
                        return Character.attackMagical()
                    }
                    "3" -> {
                        Character.drinkHealthPotion()
                    }
                    "4" -> {
                        Character.drinkEnergyPotion()
                    }
                }
            }
        }
    }
}