package com.learnkotlin.chapter4


data class Order(val id: Int, val name : String)

fun isSameOrder( o1 : Order,  o2 : Order) : Boolean{

    return o1.equals(o2);
}

fun orderExists(o1 : Order) : Boolean{

    val orders = arrayListOf(Order(1, "dilip"), Order(2, "dilip1"))

    return orders.contains(o1);

}

fun main() {

    val o1 = Order(1, "dilip")
    val o2 = Order(1, "dilip")
    println("Are orders equal : ${isSameOrder(o1,o2)}")
    println("Does Master Order contains this one : ${orderExists(o1)}")
    val o3 = o1.copy(id = 2)
    println("o3 $o3")
}