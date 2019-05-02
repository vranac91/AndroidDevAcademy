package week2.homework.items

class EnergyPotion : BaseItem() {
    override val strengthBoost = 0
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = 0
    override val defenseBoost = 0
    override var isEquipped = false
    override val name = "Energy Potion"
    override val size = 1
    override val value = 5
    override val requirements = Triple(0,0,0)
    override var canBeEquipped = false

    override fun toString(): String {
        return name
    }
}
