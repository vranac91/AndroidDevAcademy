package week2.homework.gamemechanics

import week2.homework.character.Character
import week2.homework.character.CharacterClass
import week2.homework.spells.Earthquake
import week2.homework.spells.Fireball
import week2.homework.spells.IceStorm

class SetupCharacterData {
    companion object {

        /*
        Assigns chosen class's attributes to the character attributes on game start.
        Refreshes the statistics.
         */

        fun setClassAtributes(chosenClass : CharacterClass) {
            if (chosenClass == CharacterClass.SORCERER) {
                Character.spells.add(Earthquake)
                Character.spells.add(Fireball)
                Character.spells.add(IceStorm)
            }
            Character.strength = chosenClass.strength
            Character.dexterity = chosenClass.dexterity
            Character.intelligence = chosenClass.intelligence
            Character.refreshStats()
            setInitialHealthAndEnergy()
        }

        /*
        Sets initial health and energy to be equal to their max values.
        Called only on character creation!
         */

        private fun setInitialHealthAndEnergy() {
            Character.healthCurrent = Character.healthMax
            Character.energyCurrent = Character.energyMax
        }
    }
}
