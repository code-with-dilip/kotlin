package com.learnkotlin.chapter4

class AbstractClassImpl : AbstractClass() {
    override fun click() {
        println("inside click -> AbstractClassImpl")
    }
    override fun click2(){
        println("inside click2 -> AbstractClassImpl")
    }


}

fun main() {
    val abstractClassImpl = AbstractClassImpl()
    abstractClassImpl.click()
    abstractClassImpl.click1()
    abstractClassImpl.click2()

}