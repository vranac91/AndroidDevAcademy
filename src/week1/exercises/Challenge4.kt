package exercises

/*
Challenge: Apply Functional Programming for Simple Data Analysis

We decided to gather data on the age of our users.
In this challenge, you'll be presented with this partly faulty data
 of user ages which is based on four input files:
 */

val data = mapOf(
    "users1.csv" to listOf(32, 45, 17, -1, 34),
    "users2.csv" to listOf(19, -1, 67, 22),
    "users3.csv" to listOf(),
    "users4.csv" to listOf(56, 32, 18, 44)
)

/*
Apply the functions you learned about as well as other functions from Kotlin's
standard library to solve the following data analysis tasks:

1. Find the average age of users (use only valid ages for the calculation!)
2. Extract the names of input files that contain faulty data
3. Count the total number of faulty entries across all input files

Hints: map() and flatMap() are often very useful functions for such tasks
Use IntelliJ's autocompletion to explore which other functions, that were not
presented in the lectures, are available (they could simplify the tasks)
 */

fun main() {
    findAverage(cleanData())
    findFaultyFiles()
    countFaultyEntries()
}

fun cleanData() : List<Int> {
    val dataValues = mutableListOf<Int>()
    for (key in data.keys) {
        for (num in data.get(key)!!) {
            dataValues.add(num)
        }
    }
    return dataValues.filter { it > 0 }
}

fun findAverage(validData : List<Int>) {
    val output = "%.2f".format(validData.average())
    println("The average age is $output")
}

fun findFaultyFiles() {
    val fileNames = mutableListOf<String>()
    for (key in data.keys) {
        if (data.get(key).isNullOrEmpty()) fileNames.add(key)
        for (num in data.get(key)!!) {
            if (num <= 0) fileNames.add(key)
        }
    }
    println("The following files have faulty or empty data: $fileNames")
}

fun countFaultyEntries() {
    var faultyValues = 0
    for (key in data.keys) {
        for (num in data.get(key)!!) {
            if (num <= 0) faultyValues++
        }
    }
    println("Number of faulty values: $faultyValues")
}