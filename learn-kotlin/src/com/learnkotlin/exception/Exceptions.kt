package com.learnkotlin.exception


fun isValuePresent(x: Int): Int {
    if (x !in 1..100)
        throw IllegalArgumentException("Value not present")
    else
        return x;
}

fun tryCatch(x: String): Int {
    try {
        return x.toInt();
    } catch (e: NumberFormatException) {
        throw e
    } finally {
        println("Method execution completed")
    }
}

fun tryCatchSimplified(x: String): Int {
    val number = try {
        return x.toInt();
    } catch (e: NumberFormatException) { // must enclose with curly braces
        throw  e
    } finally {
        println("Method execution completed")
    }
}


fun main(args: Array<String>) {

    println("${isValuePresent(100)}")
    //println("${isValuePresent(101)}")
    println("${tryCatch("123")}")
    println("${tryCatchSimplified("321")}")
    println("${tryCatch("abc")}")

}