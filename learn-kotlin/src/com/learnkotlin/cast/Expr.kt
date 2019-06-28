package com.learnkotlin.cast


fun eval(e: Expr): Int {
    if(e is Num){
        return  e.value;
    } else if(e is Sum){
        val n = eval(e.left) + eval(e.right);
        return  n
    }
    else
    throw IllegalArgumentException("Unknown Expression")
}

fun eval1(e: Expr): Int =
    if(e is Num)
        e.value
     else if(e is Sum)
        eval(e.left) + eval(e.right)
    else
        throw IllegalArgumentException("Unknown Expression")

fun eval_refacrtored_if_with_when(e: Expr): Int =
        when(e){
            is Num -> e.value
            is Sum ->  eval_refacrtored_if_with_when(e.left) + eval(e.right)
            else -> throw IllegalArgumentException("Unknown Expression")
        }

fun eval_refacrtored_if_with_when_logging(e: Expr): Int =
        when(e){
            is Num -> {
                println("${e.value}")
                e.value
            }
            is Sum -> {
                println("${eval_refacrtored_if_with_when_logging(e.left)}")
                println("${eval_refacrtored_if_with_when_logging(e.right)}")
                eval_refacrtored_if_with_when(e.left) + eval(e.right)
            }
            else -> throw IllegalArgumentException("Unknown Expression")
        }



fun ifCheck() {

    val a = 1
    val b = 2

    val c = if(a>b) a else b

}


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right:  Expr) : Expr