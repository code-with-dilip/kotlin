@file:JvmName("Collections")
package com.learnkotlin.collection
var count=0
const val finalCount = 10;

val set = hashSetOf(1, 7, 53,7) //creates a Set
val list = arrayListOf(1, 7, 53) //creates a List
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") //creates a Map
val linkedMap = linkedMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun getName(name: String = "default") = name


fun getNameAndAge(name: String = "default" , age: Int = 0) = name +"-"+ age

fun iterateMap(){

    for ((number, word) in map){
        println("key ${number} and value is ${word}" )
    }
}

fun main(args: Array<String>) {

    println("$set")
    println(set.javaClass)
    println("$list")
    println("${list.last()}")
    println("${list.max()}") // returns the max element from the list. This is not available in java.
    println("$map")
    println("$linkedMap")
    println(list.joinToString(";", "(", ")"))

    println(list.joinToString( ";", "(", ")"))

    println("${getName()}")

    println("${getNameAndAge(age = 10)}");

    iterateMap()



}