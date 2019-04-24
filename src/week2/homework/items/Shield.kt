package week2.homework.items

class Shield(
        val shieldName: String,
        val shieldSize: Int,
        val shieldValue: Int,
        val shieldReq : Triple<Int, Int, Int>
): BaseItem() {
    override val name = shieldName
    override val size = shieldSize
    override val value = shieldValue
    override val requirements = shieldReq
}