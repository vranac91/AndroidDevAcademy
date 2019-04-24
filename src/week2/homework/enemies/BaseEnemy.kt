package week2.homework.enemies

import week2.homework.items.BaseItem

abstract class BaseEnemy {
    abstract val name: String
    abstract var health: Int
    abstract var energy: Int
    abstract val experience: Int
    abstract val attack: IntRange
    abstract val defense: IntRange
    abstract val items: List<BaseItem>

    abstract fun attack(): Int
    abstract fun block() : Int
    abstract fun die()
}