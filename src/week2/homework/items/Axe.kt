package week2.homework.items

import week2.homework.character.Character

class Axe(
        private val axeName: String,
        private val axeSize: Int,
        private val axeValue: Int,
        private val axeAttackBoost: Int,
        private val axeRequirements: Triple<Int, Int, Int>
): BaseItem() {
    override val name = axeName
    override val size = axeSize
    override val value = axeValue
    override val requirements = axeRequirements
    override val strengthBoost = 0
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = axeAttackBoost
    override val defenseBoost = 0
    override var isEquipped = false
    override var canBeEquipped = true

    override fun increaseAttribute() {
        if (isEquipped) Character.attack += axeAttackBoost

    }
}