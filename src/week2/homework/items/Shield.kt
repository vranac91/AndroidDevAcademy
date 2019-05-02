package week2.homework.items

class Shield(
        val shieldName: String,
        val shieldSize: Int,
        val shieldValue: Int,
        val shieldStrengthBoost: Int,
        val shieldDefenseBoost: Int,
        val shieldReq : Triple<Int, Int, Int>
): BaseItem() {
    override val strengthBoost = shieldStrengthBoost
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = 0
    override val defenseBoost = shieldDefenseBoost
    override var isEquipped = false
    override val name = shieldName
    override val size = shieldSize
    override val value = shieldValue
    override val requirements = shieldReq
    override var canBeEquipped = true
}