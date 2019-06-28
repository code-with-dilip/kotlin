package com.learnkotlin.interfaces

class ClickableImpl(val button : Button = Button()) : Clickable by button { // Button is the other implementation class.
    override fun click() {
        println("Inside ClickableImpl click")
    }
}

fun main(args: Array<String>) {

    val clickable = ClickableImpl()
    println(clickable.click())
    println(clickable.click1())

}