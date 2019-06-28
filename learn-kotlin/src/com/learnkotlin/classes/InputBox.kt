package com.learnkotlin.classes

open class InputBox { // open keyword allows this class to be extended.

    open fun input(){ // open keyword allows this method to be overriden.
        println("input method in InputBox")
    }

    protected fun testProtect(){
        println("inside protect")
    }

    fun type(){
        println("input method in InputBox")
    }
}