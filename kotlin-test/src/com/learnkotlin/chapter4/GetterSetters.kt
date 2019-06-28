package com.learnkotlin.chapter4


class Person(_name : String){

    var name: String = _name
        get() {
           return  field.plus("dilip")
        }
    set(_value : String){

        field =name+_value
    }

}

class User3(_name : String){

    val name : String = _name
    get(){
        return field.plus("dilip")
    }
}


fun main() {

    val person = Person("Dilip")
    println(person.name)
    person.name = "Aish"
    println(person.name)
}