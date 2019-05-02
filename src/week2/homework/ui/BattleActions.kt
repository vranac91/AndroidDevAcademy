package week2.homework.ui

import week2.homework.character.Character
import week2.homework.data.Enemies
import week2.homework.enemies.BaseEnemy
import week2.homework.enemies.Ghoul
import week2.homework.gamemechanics.BattleFlow

class BattleActions {
    companion object {
        fun printListOfEnemies() {
            println("\nThese are the enemies that you need to defeat in order to win the game:\n")
            for (enemy in Enemies.getEnemies()) println(enemy)
        }

        fun attackNextEnemy() {
            val enemy = Enemies.enemiesList.find { it == Ghoul() }
            println("You are attacking ${Enemies.enemiesList.first().name}!")
            BattleFlow.battle()
        }

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

        fun selectSpell(): Int {
            if (Character.spells.isNotEmpty()) {
                loop@ while (true) {
                    println("Choose the spell for attack:\n")
                    var i = 1
                    for (spell in Character.spells) {
                        println("[$i] $spell\n")
                        i++
                    }
                    val spell = readLine()?.toInt()
                    if (spell != null) {
                        if (spell > 0 && spell <= Character.spells.size) {
                            Character.spells[spell - 1].activate()
                            return Character.spells[spell - 1].damage
                        }
                    }
                }
            } else println("No spells available!")
            return 0
        }

        fun printBattleOptions(): Int {
            var input: String?
            loop@ while (true) {
                println("[1] Attack with weapon\n" +
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