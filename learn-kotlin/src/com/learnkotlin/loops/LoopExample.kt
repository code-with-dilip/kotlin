package com.learnkotlin.loops

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun iterateForward() {
    println("iterateForward")
    for (i in 1..100) {
        print("${fizzBuzz(i)}")
    }
}

fun iterateReverse() {
    println("iterateReverse")
    for (i in 100 downTo 1) {
        print("${fizzBuzz(i)}")
    }
    println()
    for (i in 100 downTo 1 step 2) { // step 2 here considers only the even numbers
        print("${fizzBuzz(i)}")
    }
}

fun iterateReverse_onlynumbersmultiplyby5() {
    println("iterateReverse_onlynumbersmultiplyby5")
    for (i in 100 downTo 1 step 5) { // step 5 here considers only that are divisible by 5
        print("$i ")
    }
    println()
}


fun untilExample(){
    println( "until starts" )

    for (i in 90 until 100){
        print(""" $i  """ )
    }
}


fun iterateOverMap() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt()) // populate a map with key and value
       // binaryReps.put(c, Integer.toBinaryString(c.toInt())) //Java Equivalent

    }
    for ((letter, binary) in binaryReps) { // accessing the key and value.
        println("$letter - $binary")
    }
}

fun iterateOverList() {
    val list = arrayListOf("10","11","12") // creates a list of elements.
    for(element in list){
        println("$element")
    }
    for((index, element) in list.withIndex()){ // withIndex willl give you access to the index and actual value
        println("$index - $element")
    }
}

fun isValueAvailable(input: String) = input in "A".."C"

fun isLanguageAvailable(input: String) = input in arrayListOf("JAVA", "SCALA","GROOVY")

fun isNotDigit(c: Char) = c !in '0'..'9' // Under the hood it checks c<=0 amd c<=9


fun main(args: Array<String>) {
    println("${fizzBuzz(1)}")
    println("${fizzBuzz(15)}")
    iterateForward()
    println()
    iterateReverse()
    iterateOverMap()
    iterateOverList()
    println("${isValueAvailable("C")}")
    println("${isValueAvailable("D")}")
    println("isLanguageAvailable : ${isLanguageAvailable("JAVA")}")
    println("isLanguageAvailable : ${isLanguageAvailable("C")}")
    println("${isNotDigit('0')}")
    iterateReverse_onlynumbersmultiplyby5()
    untilExample()
}