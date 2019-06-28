package com.learnkotlin.functions

import com.learnkotlin.domain.User
import java.lang.IllegalArgumentException
import java.lang.StringBuilder

fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastCharSimple(): Char = get(length - 1)
infix fun String.stringConcat(str: String) = this+"-"+str



val String.lastChar1: Char
    get() = get(length - 1)

var StringBuilder.lastChar2: Char
    get() = get(length - 1)
    set(value: Char){
        this.setCharAt(length-1, value)
    }

fun validateUser(user : User): User{

    fun validateBeforeSave(value: String, fieldName : String){
        if(value.isEmpty())
            throw IllegalArgumentException("$fieldName is not present for the $user.id")
    }

    validateBeforeSave(user.firstName, "firstName")
    validateBeforeSave(user.lastName, "lastName")

    return user
}




fun main(args: Array<String>) {
    println("The Last Char is : ${"Dilip".lastChar()}")
    println("The Last Char is : ${"Dilip".lastCharSimple()}")
    var arrayElements = arrayOf("A","B","C")
    var list = listOf(*arrayElements)
    println("List :  $list")
    var output = "dilip" stringConcat "aish"
    println("output is : $output")
    val user = validateUser(User(1, "Dilip","Sundarraj"))
    println("User is ${user.id} - ${user.firstName} - ${user.lastName}")
    val user1 = validateUser(User(1, "",""))
    println("User is ${user1.id} - ${user1.firstName} - ${user1.lastName}")

}