package com.learnkotlin.chapter7

class PointNonData(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

data class NameComponents(val name : String, val extension: String)

fun splitNameExtension( name : String) : NameComponents{
    val result = name.split(".")
    return  NameComponents(result[0], result[1])
}

fun destructureMap(map : Map<Int, String>) {
    for((key,value) in map){
        println("""Key is $key and the value is $value""")
    }

}

fun main(args: Array<String>) {

    val p = Point(10,3)
    val (x,y) = p
    println("$x and $y")
    val (name, ext)  = splitNameExtension("example.txt")
    println("""File name is "$name" and the extension is "$ext" """)
    val map = mutableMapOf<Int, String>(0 to "Zero",1 to "One", 2 to "two")
    destructureMap(map)

}