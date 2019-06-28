package com.learnkotlin.chapter4

class InterfaceImpl : Interface1, Interface2 {

    fun invokeInterfaceMethods(){

        super<Interface1>.click2()
        super<Interface2>.click2()
    }

    override fun click() {
        println("Inside click in InterfaceImpl")
    }

    override fun click1(){
        println("Inside click1 in InterfaceImpl")

    }

    override fun click2() {
        println("Inside click2 in InterfaceImpl")
    }
}

fun main() {

    val interface1 = InterfaceImpl()
    interface1.click()
    interface1.click1()
    interface1.click2()
    interface1.invokeInterfaceMethods()

}