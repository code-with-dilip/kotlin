package com.learnkotlin.accessors

class LemgthCounter {
    var counter: Int =0
        private  set // this will block this value to be set from any other class.

    fun addCounter(word: String){
        counter += word.length // this is allowed because we are modifying the value from the class itself
    }

}

fun main(args: Array<String>) {
    val lemgthCounter = LemgthCounter()
//    lemgthCounter.counter = 3 // compilation issue
    lemgthCounter.addCounter("dilip")
    lemgthCounter.addCounter("dilip")
    println(lemgthCounter.counter)
}