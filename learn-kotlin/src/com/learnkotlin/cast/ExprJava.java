package com.learnkotlin.cast;

public class ExprJava {
/*
    fun eval(e: Expr): Int {
        if(e is Num){
            val n = e as Num;
            return  n.value;
        }

        if(e is Sum){
            val n = eval(e.left) + eval(e.right);
            return  n
        }
        throw IllegalArgumentException("Unknown Expression")
    }*/

public static int eval(Expr expr){

    if(expr instanceof Num){

        return  ((Num) expr).getValue();
    }
    else if(expr instanceof Sum){
        return  (eval((Sum) ((Sum) expr).getLeft()) + eval((Sum) ((Sum) expr).getRight())) ;
    }
    else
        throw  new IllegalArgumentException("Unknown Expression");

}

public void ifCheck(){

    int a =1,b=2;

//    boolean s = if(a>b)

    if(a>b) {

    } else{

    }
}

}
