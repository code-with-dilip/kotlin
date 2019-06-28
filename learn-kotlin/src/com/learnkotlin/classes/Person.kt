package com.learnkotlin.classes

class Person (
    val name: String,
    var age: Int =0,
    var occupation: String
){
    val nameOccupation: String
    get() {
        return "$name - $occupation"
    }
}
