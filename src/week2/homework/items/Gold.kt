package week2.homework.items

class Gold (
        val amount: Int
) : BaseItem() {
    override val name = "Gold"
    override val size = 0
    override val value = amount
    override val requirements = Triple(0,0,0)
    override val strengthBoost = 0
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = 0
    override val defenseBoost = 0
    override var isEquipped = false
    override var canBeEquipped = false

    override fun toString(): String {
        return "$name - amount: $amount"
    }
}