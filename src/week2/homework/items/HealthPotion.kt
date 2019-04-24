package week2.homework.items

import week2.homework.character.Character

class HealthPotion : BaseItem() {
    override val name = "Health Potion"
    override val size = 1
    override val value = 5
    override val requirements = Triple(0,0,0)

    fun drinkPotion() {
        if (Character.inventoryItems.contains(this)) {
            Character.health += 10
            Character.inventoryItems.remove(this)
        }
    }
}