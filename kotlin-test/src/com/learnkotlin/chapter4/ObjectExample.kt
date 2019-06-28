package com.learnkotlin.chapter4

interface InterFace4{
    fun interface4()
}

object Order1{

    val id : Int=0
    val items = arrayListOf<String>()

    fun addItem(item : String){
        items.add(item)
    }
}

data class Companion(val id : Int){

    companion object {

        fun companionMethod(){
            println("Inside companionMethod")
        }
    }

}

data class Companion1(val id : Int){

    companion object Companion1Frd: InterFace4 {
        override fun interface4() {
            println("Inside companionMethod interface implementation")

        }

        fun companionMethod(){
            println("Inside companionMethod")
        }
    }

}

fun Companion1.Companion1Frd.method2(){
    println("Extension function of companion")

}


fun main() {

    Order1.addItem("Samsumg TV")
    Order1.addItem("LG TV")

    println("items are ${Order1.items}")

    val companion = Companion(1)
    Companion.companionMethod()
    Companion1.Companion1Frd.companionMethod()
    Companion1.Companion1Frd.method2()
    Companion1.interface4()
}