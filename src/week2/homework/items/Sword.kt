package week2.homework.items

class Sword(
        val swordName: String,
        val swordSize: Int,
        val swordValue: Int,
        val swordReq : Triple<Int, Int, Int>
): BaseItem() {
    override val name = swordName
    override val size = swordSize
    override val value = swordValue
    override val requirements = swordReq
}
