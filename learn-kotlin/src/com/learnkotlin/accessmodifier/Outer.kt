package com.learnkotlin.accessmodifier

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public by default

}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible
    fun printInternalc() = println("the internal c value is  $c")
    fun printprotectedb() = println("the protected b value is  $b")


    override val b = 5   // 'b' is protected
}

fun main(args: Array<String>) {
    val subclass = Subclass()
    subclass.printInternalc()
    subclass.printprotectedb()


}