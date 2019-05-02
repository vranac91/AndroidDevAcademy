package week2.homework.items

class Armor (
        val armorName: String,
        val armorDefenseBoost: Int,
        val armorStrengthBoost: Int,
        val armorSize: Int,
        val armorValue: Int,
        val armorReq : Triple<Int, Int, Int>
): BaseItem() {
    override val strengthBoost = armorStrengthBoost
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = 0
    override val defenseBoost = armorDefenseBoost
    override var isEquipped = false
    override val name = armorName
    override val size = armorSize
    override val value = armorValue
    override val requirements = armorReq
    override var canBeEquipped = true

    override fun toString(): String {
        return "$armorName - size: $armorSize, " +
                "value: $armorValue, " +
                "defense boost: $armorDefenseBoost, " +
                "strength boost: $armorStrengthBoost, " +
                "requirements: strength - ${requirements.first}, dexterity - ${requirements.second}, intelligence - ${requirements.third}"
    }
}