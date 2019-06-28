package com.learnkotlin.chapter8

import java.lang.StringBuilder

var canReturnNull: (Int, Int) -> Int? = { i: Int, i1: Int -> null}

var funOrNull: ((Int, Int) -> Int)? = null

//val operation =  (Int, Int) -> Int

val sum: (Int, Int) -> Int  = { x,y -> x+y}
val sum1 : (Int,Int) -> Int = { x,y -> x+y}

fun calculator( operation : (Int, Int) -> Int){
    val result = operation(2,3)
    println("The result from calculator is :  $result")
}

fun String.filter(predicate : (Char) -> Boolean): String {
    var sb = StringBuilder()
    for (index in 0 until length){
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return sb.toString()
}


fun main(args: Array<String>) {
    println("The sum is : ${sum1(2,3)}")
    println("The sum using invoke is : ${sum1.invoke(1,3)}")
    calculator{x,y -> x+y }
    calculator{x,y -> x*y }
    println("abc".filter { it in 'a'..'z' })
}