package week2.homework.data

import week2.homework.items.*

object Items {
    val armor = listOf(
            Armor("Leather Armor",
                    2,
                    2,
                    3,
                    20,
                    Triple(0,0,0)
            ),
            Armor("Magician's Armor",
                    4,
                    0,
                    3,
                    50,
                    Triple(5,5,35)
            ),
            Armor("Berserker's Skin",
                    4,
                    4,
                    4,
                    80,
                    Triple(30, 10, 0)
            ),
            Armor("Spellbreaker Coat",
                    4,
                    4,
                    2,
                    90,
                    Triple(20,10,10)
            )
    )

    val axes = listOf(
            Axe("Steel Hatchet",
                    3,
                    10,
                    2,
                    Triple(20, 10, 0)
            ),
            Axe("Tearjerker",
                    4,
                    40,
                    4,
                    Triple(35, 10, 0)
            ),
            Axe("Vanquisher",
                    5,
                    80,
                    5,
                    Triple(40, 10, 0)
            )
    )

    val rings = listOf(
            Ring("Enchanted Ring",
                    3,
                    Triple(5,5,5),
                    1,
                    1,
                    1,
                    1,
                    1
            ),
            Ring("Trapped Soul Ring",
                    20,
                    Triple(5, 5, 15),
                    0,
                    0,
                    3,
                    2,
                    1
            ),
            Ring("Warrior Cry",
                    40,
                    Triple(20, 5, 0),
                    3,
                    1,
                    0,
                    2,
                    1
            ),
            Ring("Serpent Song",
                    60,
                    Triple(10,10,10),
                    2,
                    2,
                    2,
                    2,
                    2
            )
    )

    val shields = listOf(
            Shield("Wooden Shield",
                    3,
                    10,
                    2,
                    2,
                    Triple(20,10,0)
            ),
            Shield("Heart Of Oak",
                    3,
                    20,
                    2,
                    3,
                    Triple(20,10,0)
            ),
            Shield("The Keeper",
                    4,
                    50,
                    3,
                    3,
                    Triple(30,10,0)
            )
    )

    val staffs = listOf(
            Staff("Orbed Staff",
                    4,
                    20,
                    3,
                    2,
                    Triple(0,0,20)
            ),
            Staff("Staff of Storms",
                    4,
                    40,
                    4,
                    4,
                    Triple(0,5,30)
            ),
            Staff("Mind Bender",
                    4,
                    60,
                    5,
                    5,
                    Triple(0,5,40)
            )
    )

    val swords = listOf(
            Sword("Iron Claymore",
                    4,
                    20,
                    2,
                    2,
                    0,
                    Triple(20,5,0)
            ),
            Sword("Frostburn",
                    5,
                    50,
                    3,
                    2,
                    2,
                    Triple(30,10,0)
            ),
            Sword("The Widower",
                    5,
                    90,
                    4,
                    5,
                    3,
                    Triple(40,10,0)
            )
    )
}