package com.learnkotlin.classes

fun main(args: Array<String>){



    val person = Person("Dilip", 123,"Engineer")
    person.age=456
    //person.nameOccupation = "${person.name} - ${person.occupation}"
    println("${person.age}")
    println("${person.name}")
    println("${person.occupation}")
    println("${person.nameOccupation}")
    println( "Person : ${person}")

}