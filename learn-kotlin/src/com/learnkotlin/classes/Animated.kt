package com.learnkotlin.classes

abstract class Animated {

    abstract fun animate() // the class that extends this abstract should implement this method.

    open fun animating(){ // Feel free to override this method
        println("Inside animating")
    }

    fun animateTwice(){ // methods in kotlin is final by default. This cant be overridden.
        println("Inside animateTwice")
    }
}