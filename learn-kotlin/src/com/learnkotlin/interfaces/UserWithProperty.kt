package com.learnkotlin.interfaces

interface User {
    val nickname: String
        get() = nickname.capitalize()
}

class PrivateUser(override val nickname: String) : User // setting the interface property

class SubscribeUser(val _name : String) : User {

    override val nickname : String //// setting the interface property using a different syntax
        get() = _name
}

fun main(args: Array<String>) {
    var user = SubscribeUser("Dilip")
    println("User is ${user}")
}