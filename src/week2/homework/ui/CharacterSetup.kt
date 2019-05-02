package week2.homework.ui

import week2.homework.character.Character
import week2.homework.character.CharacterClass
import week2.homework.gamemechanics.SetupCharacterData
import week2.homework.ui.GameplayActions.Companion.printCharacterData

class CharacterSetup {
    companion object {
        fun start() {
            println("Welcome to the console-based RPG game!\n")
            Character.createCharacter(askForNameInput(), askForSexInput(), askForClassInput())
            printCharacterData()
        }

        private fun askForNameInput(): String? {
            var input: String?
            while (true) {
                println("Please enter your character's name:")
                input = readLine()?.trim()
                if (!input.isNullOrBlank()) break
            }
            println("Hello, $input!\n")
            return input
        }

        private fun askForSexInput(): String? {
            var input: String?
            loop@ while (true) {
                println("Is your character a male or a female?")
                input = readLine()?.trim()
                when (input?.toLowerCase()) {
                    "male" -> break@loop
                    "female" -> break@loop
                }
            }
            input = input?.toLowerCase()
            println("Your character is a $input!\n")
            return input
        }

        private fun askForClassInput(): CharacterClass {
            var input: String?
            val chosenClass: CharacterClass
            loop@ while (true) {
                println("Choose your character's class:\n" +
                        "\n[1] Warrior - particularly adept at close combat, but weak in magic practice" +
                        "\n[2] Spellsword - equally skilled in both combat and magic" +
                        "\n[3] Sorcerer - extremely skilled in all kinds of magic, but lacks close combat knowledge")
                input = readLine()?.trim()
                when (input) {
                    "1" -> {
                        chosenClass = CharacterClass.WARRIOR
                        break@loop
                    }
                    "2" -> {
                        chosenClass = CharacterClass.SPELLSWORD
                        break@loop
                    }
                    "3" -> {
                        chosenClass = CharacterClass.SORCERER
                        break@loop
                    }
                }
            }
            println("Your character's class is $chosenClass!\n")
            SetupCharacterData.setClassAtributes(chosenClass)
            return chosenClass
        }
    }
}