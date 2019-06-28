package com.learnkotlin.chapter4

sealed  class Calculator{
    class Sum(val number1: Int, val number2: Int): Calculator()
    class Sub(val number1: Int, val number2: Int): Calculator()
}

fun sum(number1: Int, number2: Int): Int{
    return number1.plus(number2)
}

fun substract(number1: Int, number2: Int): Int{
    return number1.minus(number2)
}

fun performCalculation(calculator : Calculator) : Int =
    when(calculator){
        is Calculator.Sum -> sum(calculator.number1,calculator.number2)
        is Calculator.Sub -> substract(calculator.number1,calculator.number2)
}

fun performCalculation1(calculator : Calculator) : Int {
    when(calculator){
        is Calculator.Sum -> return sum(calculator.number1,calculator.number2)
        is Calculator.Sub -> return substract(calculator.number1,calculator.number2)
    }
}

fun main() {

    val sum = Calculator.Sum(1, 2);
    val substract = Calculator.Sub(1, 2);
    val result = performCalculation(sum)

    val result1 = performCalculation1(sum)
    println("Sum is $result")
    println("Substraction is ${performCalculation(substract)}")
    println("Sum using the different approach $result1")


}