package week2.homework.items

class Staff(
        private val staffName: String,
        private val staffSize: Int,
        private val staffValue: Int,
        private val staffAttackBoost: Int,
        private val staffIntelligenceBoost: Int,
        private val staffRequirements: Triple<Int, Int, Int>
) : BaseItem() {
    override val name: String = staffName
    override val size = staffSize
    override val value = staffValue
    override val requirements = staffRequirements
    override val strengthBoost = 0
    override val dexterityBoost = 0
    override val intelligenceBoost = staffIntelligenceBoost
    override val attackBoost = staffAttackBoost
    override val defenseBoost = 0
    override var isEquipped = false
    override var canBeEquipped = true
}