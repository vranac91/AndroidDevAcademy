package week2.homework.enemies

import week2.homework.items.BaseItem

object Boss : BaseEnemy() {
    override val name = "Arkhanu Amun"
    override val experience = 500
    override var health = 100
    override var energy = 150
    override val attack = 10..20
    override val defense = 0..10
    override val items: List<BaseItem> = listOf()

    override fun attack() : Int {
        return attack.random()
    }

    override fun block() : Int {
        return defense.random()
    }

    override fun die() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}