package com.learnkotlin.classes

open class RichInputBox : InputBox() {

    override fun input(){
        println("input method in InputBox")
    }
    open fun input1(){
        println("input1 method in InputBox")
    }



}