package week2.homework.items

import week2.homework.character.Character

class Ring(
        private val ringName: String,
        private val ringValue: Int,
        private val ringRequirements: Triple<Int, Int, Int>,
        private val ringStrengthBoost: Int,
        private val ringDexterityBoost: Int,
        private val ringIntelligenceBoost: Int,
        private val ringAttackBoost: Int,
        private val ringDefenseBoost: Int
) : BaseItem() {
    override val name = ringName
    override val size = 1
    override val value = ringValue
    override val requirements = ringRequirements
    override val strengthBoost = ringStrengthBoost
    override val dexterityBoost = ringDexterityBoost
    override val intelligenceBoost = ringIntelligenceBoost
    override val attackBoost = ringAttackBoost
    override val defenseBoost = ringDefenseBoost
    override var isEquipped = false
    override var canBeEquipped = true

    override fun increaseAttribute() {
        if (isEquipped) {
            Character.strength += ringStrengthBoost
            Character.dexterity += ringDexterityBoost
            Character.intelligence += ringIntelligenceBoost
            Character.attack += ringAttackBoost
            Character.defense += ringDefenseBoost
        }
    }
}