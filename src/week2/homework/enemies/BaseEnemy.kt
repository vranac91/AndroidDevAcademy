package week2.homework.enemies

abstract class BaseEnemy (
        val name: String,
        var health: Int,
        var energy: Int,
        val experience: Int,
        val attack: IntRange,
        val defense: IntRange,
        val items: List<Any?>
) {
    override fun toString(): String {
        return "$name - health: $health, " +
                "energy: $energy, " +
                "experience: $experience, " +
                "attack: ${attack.start}-${attack.endInclusive}, " +
                "defense: ${defense.start}-${defense.endInclusive}," +
                "\nitems: $items"
    }
}