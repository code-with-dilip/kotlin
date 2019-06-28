package com.learnkotlin.chapter5

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabetusingWith() : String{

    val result = StringBuilder()
    return with(result){
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow using with")
        this.toString()
    }
}

fun alphabetusingWithSimplified() : String{

    return with(StringBuilder()){
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow using with Simplified")
        toString()
    }
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet using apply!")
}.toString()

fun alphabetusingBuildString() = buildString{
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow using with Simplified")
    toString()
}


fun main(args: Array<String>) {
    println(alphabet())
    println(alphabetusingWith())
    println(alphabetusingWithSimplified())
    println(alphabetApply())
    println(alphabetusingBuildString())
}


