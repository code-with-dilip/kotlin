package com.learnkotlin.chapter5

import com.learnkotlin.domain.User

val createUser = ::User

fun User.isDilip() = firstName.equals("dilip")
val predicate = User::isDilip

val name = User::firstName

fun main(args: Array<String>) {
    val user = createUser(1 , "dilip", "sundarraj")
    println("is Dilip : ${predicate(user)}")
    println("first name is : ${name(user)}")
}