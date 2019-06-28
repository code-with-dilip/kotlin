package com.learnkotlin.chapter4

class VisibilityModifiers{

    private val name : String?=""
    val count: Int=0
    protected val  flag:Boolean=false
    internal val price: Double = 0.0;

}

fun main() {

    val visibilityModifiers = VisibilityModifiers()
    println(visibilityModifiers.count)
    visibilityModifiers.price
}