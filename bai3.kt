package com.example.myapplication

fun main() {
    println("---- SET Demo ----")
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Set from numbers: $setOfNumbers")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Intersect: ${set1.intersect(set2)}")
    println("Union: ${set1.union(set2)}")

    println("\n---- MAP Demo ----")
    val peopleAges = mutableMapOf(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges["Barbara"] = 42
    peopleAges["Joe"] = 51

    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()

    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Filtered: $filteredNames")

    println("\n---- More collection ops ----")
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println("Filtered words: $filteredWords")

    println("\n---- Lambda Demo ----")
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Triple of 5 = ${triple(5)}")

    println("\n---- Elvis Operator ----")
    var quantity: Int? = null
    println(quantity ?: 0) // 0
    quantity = 4
    println(quantity ?: 0) // 4
}

// let
fun demoLet(args: Map<String, String>?) {
    args?.let {
        val letterId = it["LETTER"].toString()
        println("Letter ID = $letterId")
    }
}

// apply
fun demoApply() {
    val list = mutableListOf<String>()
    list.apply {
        add("one")
        add("two")
    }
    println("List after apply: $list")
}

// backing property + lateinit
class Game {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private lateinit var currentWord: String

    fun setWord(word: String) {
        currentWord = word
    }

    fun printWord() {
        if (::currentWord.isInitialized) {
            println("Current word = $currentWord")
        } else {
            println("Word not initialized")
        }
    }
}
