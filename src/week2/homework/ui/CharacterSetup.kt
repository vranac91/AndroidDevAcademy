package week2.homework.ui

import week2.homework.character.Character
import week2.homework.character.CharacterClass
import week2.homework.gamemechanics.SetupCharacterData
import week2.homework.ui.GameplayActions.Companion.printCharacterData

class CharacterSetup {
    companion object {

        /*
        Creates a Character object with parameters given by the player.
        Prints the character data sheet.
         */

        fun start() {
            println("Welcome to the console-based RPG game!\n" +
                    "\nHere is the basic gameplay info:\n" +
                    "\n- When prompted, enter the name of your character using keyboard" +
                    "\n- When prompted, select your character's sex by typing it using keyboard" +
                    "\n- Select the desired action by typing the number before it" +
                    "\n- Battle is turn-based; drinking potions doesn't end your turn" +
                    "\n- Loot from each enemy is different each time you play" +
                    "\n- It is good to check your stats and number of potions before each battle; use appropriate options for it" +
                    "\n- Attack and defense values might vary significantly during the battle; a more complex logic involving " +
                    "\n  chance for blocking and attacking with stronger magic attacks is employed in the background. Keep this in mind!" +
                    "\n- You can equip up to 4 items on your character; to equip new items, you must remove old ones" +
                    "\n- Be sure to clear unneeded items from your inventory regularly" +
                    "\n- Spells cost energy; if you try to cast a spell without enough energy for it, your turn ends. Basic attack doesn't cost a thing" +
                    "\n- Tha being said, Warrior class is unable to cast any spells (don't try to cast them), but has the highest starting health and attack\n" +
                    "\nEnjoy and good luck!\n")
            Character.createCharacter(askForNameInput(), askForSexInput(), askForClassInput())
            printCharacterData()
        }

        /*
        Asks for a name input until a non-null and non-blank input is given.
        Returns the input as a parameter for character creation
         */

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

        /*
        Asks for a sex input until a non-null and non-blank input is given.
        Returns the input as a parameter for character creation
         */

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

        /*
        Asks for a class input until one of the provided classes is selected.
        Sets the character attributes (strength, dexterity, intelligence) according to the selected class.
        Returns the input as a parameter for character creation
         */

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
            println("Your character's class is ${chosenClass.toString().toLowerCase()}!\n")
            SetupCharacterData.setClassAtributes(chosenClass)
            return chosenClass
        }
    }
}