package com.learnkotlin.variables


val str ="Dilip";
val str1: String ="Dilip";

val num = 42
val answer: Int = 0

var numVar = 42

fun returnStr(flag: Boolean): String {
    val message: String
    if (flag) {
        message = "Success"
        // ... perform the operation
    }
    else {
        message = "Failed"
    }
    return message;
}

fun main(args: Array<String>) {
    numVar=43
    println("str :  $str")
    println("str1 :  $str1")
    println("num: $num")
    println("answer: $answer")
    println("returnStr: ${returnStr(true)}")
    println("numVar :  ${numVar}")
    var str2: String = "S\$abc"
    println("str2 :  $str2")
}