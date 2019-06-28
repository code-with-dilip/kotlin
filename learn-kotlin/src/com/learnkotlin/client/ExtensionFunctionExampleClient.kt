package com.learnkotlin.client

import com.learnkotlin.functions.lastCharSimple
import java.lang.StringBuilder
import com.learnkotlin.functions.lastChar as last
import com.learnkotlin.functions.lastChar1 as last1
import com.learnkotlin.functions.lastChar2 as last2

fun main(args: Array<String>) {

    println("${"Dilip".last()}")
    println("The Last Char is : ${"Dilip".last1}")
    var sb: StringBuilder = StringBuilder("Dilip")
    sb.last2 = 'A'
    println("The Last Char is : ${sb.last2}")
}