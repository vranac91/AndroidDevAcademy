package week2.homework.gamemechanics

import week2.homework.character.Character
import week2.homework.data.Enemies
import week2.homework.ui.BattleActions
import week2.homework.ui.GameplayActions

class BattleFlow {
    companion object {

        /*
        Handles battle logic:
        - turn-based principle: each participant has one action to perform
        - reduces enemy health by character's physical or magical damage
        - if enemy's health is <= 0, enemy is killed
        - removes the enemy from the generated enemies list, allow the user to loot the items and
        prints gameplay options
        - reduces character's health by enemy's physical or magical damage
        - if character's health is <=, ends the game
         */

        fun battle() {
            val enemy = Enemies.enemiesList.first()
            while (Character.healthCurrent > 0 && enemy.health > 0) {
                enemy.health -= BattleActions.printBattleOptions()
                if (enemy.health <= 0) {
                    enemy.die()
                    Character.experience += enemy.experience
                    BattleActions.lootItems(enemy)
                    Enemies.removeDeadEnemy()
                    GameplayActions.printGameplayOptions()
                }
                else {
                    enemy.attackPhysical()
                    if (Character.healthCurrent <= 0) Character.die()
                }
            }
        }
    }
}