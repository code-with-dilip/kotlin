package com.learnkotlin.classes

import com.learnkotlin.classes.Expr
import com.learnkotlin.classes.Expr.Num
import com.learnkotlin.classes.Expr.Sum

sealed class Expr { // sealed keyword makes sure that all the subclasses should sit in the

    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

//class SumOutside(val left: Expr, val right: Expr) : Expr()

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


fun eval_refacrtored_if_with_when(e: Expr): Int =
        when(e){
            is com.learnkotlin.classes.Expr.Num -> e.value
            is Sum ->  eval_refacrtored_if_with_when(e.left) + eval(e.right)
        }



