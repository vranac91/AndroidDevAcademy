package week2.homework.gamemechanics

import week2.homework.character.Character
import week2.homework.character.CharacterClass

class SetupCharacterData {
    companion object {
        fun setClassAtributes(chosenClass : CharacterClass) {
            Character.strength = chosenClass.strength
            Character.dexterity = chosenClass.dexterity
            Character.intelligence = chosenClass.intelligence
        }
    }
}
