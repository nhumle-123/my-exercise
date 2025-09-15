package com.example.myapplication
import kotlin.math.PI
//lop truu tuong
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double

    open fun hasRoom(): Boolean {
        return residents < 6
    }
}

// Lớp mở rộng và kế thừa

open class RoundHut(val residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override fun floorArea(): Double {
        return PI * 3 * 3   // giả sử bán kính = 3
    }
}

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override fun floorArea(): Double {
        return 5.0 * 5.0   // giả sử cạnh = 5
    }
}

class RoundTower(residents: Int, val floors: Int) : RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override fun floorArea(): Double {
        return super.floorArea() * floors   // gọi hàm lớp cha
    }
}

//  Danh sách

fun listDemo() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("Size: ${numbers.size}")
    println("First item: ${numbers[0]}")
    println("Reversed: ${listOf("red", "blue", "green").reversed()}")

    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    println(entrees)

    entrees[0] = "lasagna"
    println(entrees)

    entrees.remove("lasagna")
    println(entrees)
}

//Vòng lặp

fun loopDemo(myList: List<String>) {
    println("For loop:")
    for (element in myList) {
        println(element)
    }

    println("While loop:")
    var index = 0
    while (index < myList.size) {
        println(myList[index])
        index++
    }
}

// Chuỗi

fun stringDemo() {
    val name = "Android"
    println("Length: ${name.length}")

    val number = 10
    println("$number people")

    val groups = 5
    println("${number * groups} people")
}

// ---------------- Toán tử tăng cường ----------------

fun operatorDemo() {
    var a = 10
    val b = 5
    a += b
    println("a after += b: $a")

    a -= b
    println("a after -= b: $a")

    a *= b
    println("a after *= b: $a")

    a /= b
    println("a after /= b: $a")
}

// ---------------- with ----------------

fun withDemo() {
    val squareCabin = SquareCabin(3)
    with(squareCabin) {
        println("Capacity: ${hasRoom()}")
        println("Material: $buildingMaterial")
        println("Floor area: ${floorArea()}")
    }
}

// ---------------- Hàm vararg ----------------

fun addToppings(vararg toppings: String) {
    for (topping in toppings) {
        println("Topping: $topping")
    }
}

// ---------------- Main ----------------

fun main() {
    println("---- Abstract & Classes ----")
    val hut = RoundHut(3)
    println("Hut material: ${hut.buildingMaterial}, area: ${hut.floorArea()}")

    val cabin = SquareCabin(4)
    println("Cabin material: ${cabin.buildingMaterial}, area: ${cabin.floorArea()}")

    val tower = RoundTower(4, 3)
    println("Tower material: ${tower.buildingMaterial}, area: ${tower.floorArea()}")

    println("\n---- List Demo ----")
    listDemo()

    println("\n---- Loop Demo ----")
    loopDemo(listOf("apple", "banana", "cherry"))

    println("\n---- String Demo ----")
    stringDemo()

    println("\n---- Operator Demo ----")
    operatorDemo()

    println("\n---- With Demo ----")
    withDemo()

    println("\n---- Vararg Demo ----")
    addToppings("cheese", "olives", "mushrooms")

    println("\n---- Math constant ----")
    val radius = 3.0
    println("Circle area = ${kotlin.math.PI * radius * radius}")
}
