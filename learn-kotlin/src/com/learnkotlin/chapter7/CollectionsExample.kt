package com.learnkotlin.chapter7


fun main(args: Array<String>) {
    val map = mutableMapOf<Int, String>(0 to "Zero",1 to "One", 2 to "two")
    println(map[0])// accessing an element
    map[0] = "zero" // setting a new value
    println(map)
}