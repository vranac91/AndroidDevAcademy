package week2.homework.gamemechanics

import week2.homework.character.Character
import week2.homework.data.Enemies
import week2.homework.ui.BattleActions
import week2.homework.ui.GameplayActions

class BattleFlow {
    companion object {
        fun battle() {
            val enemy = Enemies.enemiesList.first()
            while (Character.health > 0 && enemy.health > 0) {
                enemy.health -= BattleActions.printBattleOptions()
                if (enemy.health <= 0) {
                    enemy.die()
                    BattleActions.lootItems(enemy)
                    Enemies.removeDeadEnemy()
                    GameplayActions.printGameplayOptions()
                }
                else {
                    enemy.attackPhysical()
                    if (Character.health <= 0) Character.die()
                }
            }
        }
    }
}