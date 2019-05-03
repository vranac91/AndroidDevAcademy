package week2.homework.items

import week2.homework.character.Character

class Sword(
        val swordName: String,
        val swordSize: Int,
        val swordValue: Int,
        val swordAttackBoost: Int,
        val swordStrengthBoost: Int,
        val swordDexterityBoost: Int,
        val swordReq : Triple<Int, Int, Int>
): BaseItem() {
    override val strengthBoost = swordStrengthBoost
    override val dexterityBoost = swordDexterityBoost
    override val intelligenceBoost = 0
    override val attackBoost = swordAttackBoost
    override val defenseBoost = 0
    override var isEquipped = false
    override val name = swordName
    override val size = swordSize
    override val value = swordValue
    override val requirements = swordReq
    override var canBeEquipped = true

    override fun increaseAttribute() {
        if (isEquipped) {
            Character.attack += swordAttackBoost
            Character.strength += swordStrengthBoost
            Character.dexterity += swordDexterityBoost
        }
    }
}
