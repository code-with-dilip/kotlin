package com.learnkotlin.accessmodifier

 open class Talkative {
    private fun yell() = println("YELL")
    open protected fun whisper() = println("WHISPER")
    fun speak() = println("SPEAK")
}

fun main(args: Array<String>) {

    val talkative = Talkative()
    talkative.speak()
}