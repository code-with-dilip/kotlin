package com.learnkotlin.interfaces

open class Button : Clickable, Focusable {
    override fun click2() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun focus() {
       println("Focus is correct")
    }

    override fun click() {
        println("Button got clicked ")
    }

    override fun click1() = println("Inside click1 Button") //  You can override the default implementation.
}

fun main(args: Array<String>) {
    Button().click()
    Button().click1()
    Button().showOff()
}