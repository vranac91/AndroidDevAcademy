package exercises

/*
Create a collection of integers

Use Random to fill the collection with 100 random numbers between 1 and 100.

Go through the collection from start to end and print its elements up to the point where an element is less than or equal to 10
 */

fun main(args: Array<String>) {
    val intList = mutableListOf<Int>()

    for (i in 1..100) intList.add((1..100).random())
    println("Created list of ${intList.size} random integers.")

    for (number in intList) if (number > 10) println(number) else {
        print("Stopping, got to number $number")
        break
    }
}
