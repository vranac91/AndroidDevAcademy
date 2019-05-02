package week2.homework.items

import week2.homework.character.Character

class HealthPotion : BaseItem() {
    override val strengthBoost = 0
    override val dexterityBoost = 0
    override val intelligenceBoost = 0
    override val attackBoost = 0
    override val defenseBoost = 0
    override val isEquipped = false
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