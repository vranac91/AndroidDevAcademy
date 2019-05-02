package week2.homework.data

import week2.homework.enemies.*

object Enemies {
    private val ghouls = mutableListOf<Ghoul>()
    private val wraiths = mutableListOf<Wraith>()
    private val fireDemons = mutableListOf<FireDemon>()
    private val spectralHydras = mutableListOf<SpectralHydra>()
    private val boneDragons = mutableListOf<BoneDragon>()
    val enemiesList = getEnemies()

    private fun generate() {
        for (i in 0..4) {
            ghouls.add(Ghoul())
            wraiths.add(Wraith())
            fireDemons.add(FireDemon())
            spectralHydras.add(SpectralHydra())
            boneDragons.add(BoneDragon())
        }
    }

    fun getEnemies(): MutableList<BaseEnemy> {
        generate()
        var enemies = mutableListOf<BaseEnemy>()
        enemies.add(ghouls.random())
        enemies.add(wraiths.random())
        enemies.add(fireDemons.random())
        enemies.add(spectralHydras.random())
        enemies.add(boneDragons.random())
        enemies.add(Boss)
        return enemies
    }

    fun removeDeadEnemy() {
        enemiesList.removeAt(0)
    }
}