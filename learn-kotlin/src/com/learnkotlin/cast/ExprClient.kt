package com.learnkotlin.cast

fun main(args: Array<String>) {

    println ("Actual Result : ${eval(Sum(Sum(Num(1), Num(2)), Num (4)))}");
    println ("Refactored result : ${eval1(Sum(Sum(Num(1), Num(2)), Num (4)))}");
    println ("Refactored result with logging: ${eval_refacrtored_if_with_when_logging(Sum(Sum(Num(1), Num(2)), Num (4)))}");
}
