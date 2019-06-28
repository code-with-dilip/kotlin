package com.learnkotlin.chapter5

val sum = { x: Int, y: Int ->
    println("input values are $x and $y")
    x + y
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String){
    messages.forEach {

        println("${prefix.plus("dilip")} : $it ")
    }
}

var counter = 0
val inc = { counter+5 }


fun click(){
    println(inc())
}





fun main(args: Array<String>) {
    println(sum(1, 2))
    val list = listOf("dilip", "scooby", "aish")
    printMessagesWithPrefix(list, "name")
    click()
}
