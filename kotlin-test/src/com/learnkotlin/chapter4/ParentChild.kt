package com.learnkotlin.chapter4

open class Parent{

    open fun parentmethod(){

        println("Inside ParentMethod")

    }
}

class Child : Parent(){


    override fun parentmethod(){

       super<Parent>.parentmethod()
        println("inside child implementation of parentmethod")
    }

}

fun main() {

    val parent= Parent()
    parent.parentmethod()

    val child = Child()
    child.parentmethod()
}