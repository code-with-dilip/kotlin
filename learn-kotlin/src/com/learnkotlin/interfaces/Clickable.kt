package com.learnkotlin.interfaces

interface   Clickable {

    fun click()
    fun click2()

    fun click1() = println("Inside click1 Clickable")

    fun showOff() = println("Inside showOff Clickable")
}