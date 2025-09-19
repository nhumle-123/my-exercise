package com.example.myapplication

class SinhVien {
    private var ma: Int = 0
    private var ten: String = ""

    // property công khai
    var Ma: Int
        get() = ma
        set(value) {
            ma = value
        }

    var Ten: String
        get() = ten
        set(value) {
            ten = value
        }

    // Constructor không đối số
    constructor() {
        println("Day la secondary constructor 0 doi so")
    }

    // Constructor có 2 đối số
    constructor(ma: Int, ten: String) {
        this.ma = ma
        this.ten = ten
        println("Day la secondary constructor 2 doi so")
        println("Ma=$ma ; Ten=$ten")
    }

    fun xuatThongTin() {
        println("Thong tin chi tiet:")
        println("Ma = $ma")
        println("Ten= $ten")
    }

    fun chiTiet(): String {
        var s = "Thong tin chi tiet:"
        s = s.plus("\nMa=$ma")
        s = s.plus("\n")
        s = s.plus("Ten=$ten")
        return s
    }

    override fun toString(): String {
        var s = "Thong tin chi tiet:"
        s = s.plus("\nMa=$ma")
        s = s.plus("\n")
        s = s.plus("Ten=$ten")
        return s
    }
}

fun main() {
    // Tạo đối tượng bằng constructor 0 tham số
    val sv1 = SinhVien()
    sv1.Ma = 100
    sv1.Ten = "Tran Van B"

    // Tạo đối tượng bằng constructor 2 tham số
    val sv2 = SinhVien(1, "Nguyen Van A")

    // Xuất thông tin
    println("===== SV1 =====")
    sv1.xuatThongTin()
    println(sv1.chiTiet())
    println(sv1.toString())

    println("===== SV2 =====")
    sv2.xuatThongTin()
    println(sv2.chiTiet())
    println(sv2.toString())
}
