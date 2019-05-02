package week2.homework.ui

import week2.homework.data.Enemies

class BattleActions {
    companion object {
        fun printListOfEnemies() {
            println("\nThese are the enemies that you need to defeat in order to win the game:\n")
            for (enemy in Enemies.getEnemies()) println(enemy)
        }
    }
}