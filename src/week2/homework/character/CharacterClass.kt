package week2.homework.character

enum class CharacterClass(var strength: Int, var dexterity: Int, var intelligence: Int) {
    WARRIOR (
            strength = 40,
            dexterity = 10,
            intelligence = 5
    ),
    SPELLSWORD (
            strength = 20,
            dexterity = 15,
            intelligence = 15
    ),
    SORCERER (
            strength = 5,
            dexterity = 5,
            intelligence = 40
    );
}