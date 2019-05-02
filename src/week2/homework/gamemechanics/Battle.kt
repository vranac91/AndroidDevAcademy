package week2.homework.gamemechanics

interface Battle {
    fun attackPhysical(): Int
    fun attackMagical(): Int
    fun block(): Int
    fun die()
}