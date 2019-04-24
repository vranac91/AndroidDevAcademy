package week2.homework.spells

abstract class BaseSpell {
    abstract val name: String
    abstract val cost: Int

    abstract fun activateSpell()
}