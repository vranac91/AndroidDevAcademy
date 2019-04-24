package week2.homework.items

class Armor (
        val armorName: String,
        val armorSize: Int,
        val armorValue: Int,
        val armorReq : Triple<Int, Int, Int>
): BaseItem() {
    override val name = armorName
    override val size = armorSize
    override val value = armorValue
    override val requirements = armorReq
}