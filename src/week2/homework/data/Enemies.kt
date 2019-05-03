package week2.homework.data

import week2.homework.enemies.*

object Enemies {
    private val ghouls = mutableListOf<Ghoul>()
    private val wraiths = mutableListOf<Wraith>()
    private val fireDemons = mutableListOf<FireDemon>()
    private val spectralHydras = mutableListOf<SpectralHydra>()
    private val boneDragons = mutableListOf<BoneDragon>()
    val enemiesList = getEnemies()

    /*
    Generates 5 enemies of each kind with various properties.
    Saves them to appropriate collections.
     */

    private fun generate() {
        for (i in 0..4) {
            ghouls.add(Ghoul())
            wraiths.add(Wraith())
            fireDemons.add(FireDemon())
            spectralHydras.add(SpectralHydra())
            boneDragons.add(BoneDragon())
        }
    }

    /*
    Fetches one enemy of each kind and saves them to a collection.
    This collection is the list of enemies for the gameplay (increases randomness).
     */

    fun getEnemies(): MutableList<BaseEnemy> {
        generate()
        val enemies = mutableListOf<BaseEnemy>()
        enemies.add(ghouls.random())
        enemies.add(wraiths.random())
        enemies.add(fireDemons.random())
        enemies.add(spectralHydras.random())
        enemies.add(boneDragons.random())
        enemies.add(Boss)
        return enemies
    }

    /*
    Called when the enemy is killed.
    Removes the first enemy from the gameplay enemies collection.
     */

    fun removeDeadEnemy() {
        enemiesList.removeAt(0)
    }
}