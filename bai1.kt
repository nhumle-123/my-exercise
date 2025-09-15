package com.example.myapplication

fun main() {
    println("Hello, world!")
    println("This is the text to print")
    //Bien
    val age="5"
    val name= "rover"
    //assign and change as needed
    var roll = 6
    var rolledValue:Int = 4

    //In bien voi mau chuoi
    println("You are already ${age}")
    println("You are already ${age} days old, ${name}")
//Goi ham khong doi so

//toan tu logic voi if/else
    val num=4
    if (num >4){
        println("The variable is greater than 4")

    }else if (num == 4){
        println("The variable  is equal to 4")
    }else {
        println("The variable is less than 4")
    }
    // Hàm trả về giá trị
    val diceValue = rollDice()
    println("Rolled: $diceValue")
    // Dùng when
    val rollResult = diceValue
    val luckyNumber = 3
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    // Lớp và thực thể
    val myFirstDice = Dice(6)
    println("My dice roll: ${myFirstDice.roll()}")
}

// ---------------- Hàm và lớp -----------------

fun printHello() {
    println("Hello Kotlin")
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

fun rollDice(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}

// Lớp Dice
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

