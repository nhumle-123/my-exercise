package com.example.myapplication

import kotlinx.coroutines.*

// 1. Khai báo hàm tạm ngưng
suspend fun getValue(): Double {
    delay(500) // giả lập công việc tốn thời gian
    return 42.0
}

// 2. Gọi từ hàm tạm ngưng khác
suspend fun processValue() {
    val value = getValue()
    val modified = value * 2
    println("Modified value: $modified")
}

// 7. Khai báo object (singleton)
object DataProviderManager {
    fun provideData(): String = "Some data"
}

// 9. Tạo enum class
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() = runBlocking {
    println("=== Coroutine demo ===")

    // 2. GlobalScope.launch
    GlobalScope.launch {
        val output = getValue()
        println("GlobalScope output: $output")
    }

    // 3. Gọi hàm tạm ngưng khác
    processValue()

    // 4. Truy cập Job và hủy
    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("Job output: $output")
    }
    delay(100) // cho job chạy một chút
    job.cancel()
    println("Job cancelled")

    // 5. runBlocking để chặn luồng
    val blockingOutput = getValue()
    println("Blocking output: $blockingOutput")

    // 6. async / await
    val deferred = async { getValue() }
    println("Async/Await output: ${deferred.await()}")

    // 7. Truy cập object
    println("Data from DataProviderManager: ${DataProviderManager.provideData()}")

    // 8. Xử lý ngoại lệ
    try {
        val risky = 10 / 0
    } catch (exception: Exception) {
        println("Caught an exception: ${exception.message}")
    }

    // 10. Enum và when
    val direction = Direction.NORTH
    when (direction) {
        Direction.NORTH -> println("Going North")
        Direction.SOUTH -> println("Going South")
        Direction.WEST  -> println("Going West")
        Direction.EAST  -> println("Going East")
    }
}