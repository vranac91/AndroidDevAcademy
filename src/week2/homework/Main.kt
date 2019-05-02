package week2.homework

import week2.homework.ui.BattleActions
import week2.homework.ui.CharacterSetup
import week2.homework.ui.GameplayActions

fun main() {
    CharacterSetup.start()
    BattleActions.printListOfEnemies()
    GameplayActions.printGameplayOptions()
}