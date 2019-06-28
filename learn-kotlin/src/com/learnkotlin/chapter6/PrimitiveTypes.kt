package com.learnkotlin.chapter6


fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

val i : Int = 1;
val j : Long = i.toLong();

fun explicitConversion(){
    val intList = listOf(1,2,3)
    val longVal= 1L
    println(longVal.toInt() in intList)
}

fun anyTest(){
    val answer: Any = 42
    println(answer)
}

fun f(): Unit { println("inside f") }

fun f1()  { println("inside f1") }

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}



fun main(args: Array<String>) {
    showProgress(190)
    showProgress(90)
    explicitConversion()
    println("56".toInt())
    anyTest()
    f()
    f1()
    fail("s")
}