package com.learnkotlin.classes

import com.learnkotlin.classes.Expr.Num
import com.learnkotlin.classes.Expr.Sum

fun main(args: Array<String>) {

    println("Actual Result : ${com.learnkotlin.classes.eval(Sum(Sum(Num(1), Num(2)), Num(4)))}");

}