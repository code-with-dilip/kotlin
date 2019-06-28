package com.learnkotlin.accessors

class User(val name: String, val height: String) {

    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed from $name: "$field" -> "$value".""".trimIndent()); // the field gives you the access of the previous value.
            field = value
            //println("Address was changed from $name: $field -> $value"); // the field gives you the access of the previous value.
            field = value
        }
        get() = field.plus("dilip") // field is the only way to access the getter and setter methods of Kotlin.

    var age : Int =0
}

fun main(args: Array<String>) {

    val user = User("dilip", "5.9")
    user.age = 32
    user.address = "Apple Valley"
    println("User is $user , ${user.age} , ${user.address}, ${user.height}" )
    user.address = "Eagan"
}