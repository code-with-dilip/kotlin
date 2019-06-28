package com.learnkotlin.enums_when

fun main(args: Array<String>) {

    println("Actual color is ${getNameFromColor(Color.RED)}")
    println("Mix color is ${mix(Color.BLUE, Color.RED)}")
    println("Mix color is ${mix(Color.RED, Color.BLUE)}")
    println("Mix color is ${mix(Color.RED, Color.BLUE)}")
    println("Mix color is ${mixThreeColors(Color.GREEN, Color.ORANGE,Color.RED)}")
    println("Mix color Optimized is ${mixOptimized(Color.ORANGE, Color.GREEN)}")


    try {
        println("Mix color is ${mix(Color.RED, Color.RED)}")
    }catch (e : Exception ){
        println("Exception is ${e.message}")
    }
}