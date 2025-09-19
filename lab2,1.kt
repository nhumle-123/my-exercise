package com.example.myapplication

// Lớp cha SmartDevice
open class SmartDevice(
    val name: String,
    val category: String,
    val deviceType: String
) {
    var deviceStatus: String = "off"
    var deviceTurnOnCount: Int = 0

    fun turnOn() {
        if (deviceStatus != "on") {
            deviceStatus = "on"
            deviceTurnOnCount++
        }
    }

    fun turnOff() {
        deviceStatus = "off"
    }

    open fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Smart TV
class SmartTvDevice(
    name: String,
    category: String,
    deviceType: String
) : SmartDevice(name, category, deviceType) {

    private var volume: Int = 50
    private var channel: Int = 1

    fun decreaseVolume() {
        if (deviceStatus == "on" && volume > 0) {
            volume--
            println("TV volume decreased to $volume")
        } else {
            println("TV is off or volume is already at minimum.")
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on" && channel > 1) {
            channel--
            println("TV channel changed to $channel")
        } else {
            println("TV is off or already at the first channel.")
        }
    }

    override fun printDeviceInfo() {
        super.printDeviceInfo()
        println("TV current volume: $volume, current channel: $channel")
    }
}

// Smart Light
class SmartLightDevice(
    name: String,
    category: String,
    deviceType: String
) : SmartDevice(name, category, deviceType) {

    private var brightness: Int = 100

    fun decreaseBrightness() {
        if (deviceStatus == "on" && brightness > 0) {
            brightness--
            println("Light brightness decreased to $brightness")
        } else {
            println("Light is off or brightness is already at minimum.")
        }
    }

    override fun printDeviceInfo() {
        super.printDeviceInfo()
        println("Light current brightness: $brightness")
    }
}

// Smart Home
class SmartHome(
    private val tv: SmartTvDevice,
    private val light: SmartLightDevice
) {

    fun decreaseTvVolume() {
        if (tv.deviceStatus == "on") tv.decreaseVolume()
        else println("TV is off, cannot decrease volume.")
    }

    fun changeTvChannelToPrevious() {
        if (tv.deviceStatus == "on") tv.previousChannel()
        else println("TV is off, cannot change channel.")
    }

    fun printSmartTvInfo() {
        if (tv.deviceStatus == "on") tv.printDeviceInfo()
        else println("TV is off, cannot show info.")
    }

    fun printSmartLightInfo() {
        if (light.deviceStatus == "on") light.printDeviceInfo()
        else println("Light is off, cannot show info.")
    }

    fun decreaseLightBrightness() {
        if (light.deviceStatus == "on") light.decreaseBrightness()
        else println("Light is off, cannot decrease brightness.")
    }
}

// Hàm main để test
fun main() {
    val smartTv = SmartTvDevice("Samsung QLED", "Entertainment", "TV")
    val smartLight = SmartLightDevice("Philips Hue", "Lighting", "LED Bulb")

    val smartHome = SmartHome(smartTv, smartLight)

    // Bật TV và Light
    smartTv.turnOn()
    smartLight.turnOn()

    println("Turn on count for TV: ${smartTv.deviceTurnOnCount}")
    println("Turn on count for Light: ${smartLight.deviceTurnOnCount}")

    // Gọi các phương thức
    smartHome.printSmartTvInfo()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()

    smartHome.printSmartLightInfo()
    smartHome.decreaseLightBrightness()
}
