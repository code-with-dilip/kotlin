package com.learnkotlin.functions


fun max(a: Int, b: Int): Int {

    return if (a>b) a else b
}

fun max1(a: Int, b: Int): Int = if (a>b) a else b

fun max2(a: Int, b: Int) = if (a>b) a else b // type Inference. Kotlin determines the type based on the expression body

fun max3(a: Int, b: Int) {// type Inference. Kotlin determines the type based on the expression body
    if (a>b) a else b
}



fun main(args : Array<String>) {
    println(" max : " +max(1,2))
    println(" max1 : " + max1(1,2))
    println(" max2 : " + max2(1,2))
}