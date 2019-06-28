package com.learnkotlin.chapter6


fun initialzeArrayWithLambda() : Array<Int>{

    return Array<Int>(26){it*2}
}

fun primitiveArray(){

    IntArray(5){it*2}
            .forEach { println("primitive int array ${it}") }
}

fun arrayWithIndex(){

    IntArray(5){it*2}
            .forEachIndexed { index, i -> println("index ${index} and the value is ${i}") }
}
fun main(args: Array<String>) {

    println(arrayOf(1,2,3))
    arrayOf(1,null,3).forEach {  println("value arrayOf ${it.toString()}")  }
    arrayOfNulls<Int>(2).forEach { println("value arrayOfNulls ${it.toString()}") }
    initialzeArrayWithLambda().forEach { println("value initialzeArrayWithLambda ${it}") }
    primitiveArray()
    arrayWithIndex()
}