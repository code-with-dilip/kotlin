package com.learnkotlin.chapter2

class Square(val height: Int, val width: Int) {

    val isSquare: Boolean
        get() {
             return height ==width
        }

}