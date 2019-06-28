package com.learnkotlin.chapter4

interface Interface3{
    fun method1()
    fun method2()
    fun method3(){

    }
}

class Interface3Impl : Interface3{
    override fun method1() {
        println("method1 : Interface3Impl")
    }

    override fun method2() {
        println("method2 : Interface3Impl")
    }

}

class Interface3Impl1(val interface3Impl: Interface3Impl = Interface3Impl()) : Interface3 by interface3Impl {

    override fun method1() {
        println("method1 : Interface3Impl1")
    }
}

fun main() {

    val interface3Impl = Interface3Impl()
    interface3Impl.method1()
    val interface3Impl1 = Interface3Impl1()
    interface3Impl1.method1()
    interface3Impl1.method2()

}