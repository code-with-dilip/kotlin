package com.learnkotlin.constructors

class User(val nickname: String)

class Employee constructor(_name: String) {

    val name : String
    init {
        name=_name
    }
}
 class Person (val _name: String = "default"){

    val name:String
        get() = field.plus("dilip")
    init {
        name ="ddd"
    }
     infix fun infixCall(str: String) = str+"-"



 }

class Person1(){
    var address: String = "unspecified"
        set(value: String) {
            //println("Address was changed from $name: $field -> $value"); // the field gives you the access of the previous value.
            field = value
        }
        get() = field.plus("dilip")

    val address1: String = "unspecified"
        get() = field.plus("dilip")


}

class Student {

     var age: Int
    var name: String

    constructor(_age: Int) : this (_age, "default"){
        age = _age
        name = ""
    }
    constructor(_age: Int, _name: String){
        age = _age
        name = _name
    }
}


fun main(args: Array<String>) {

    val user = User("Dilip")
    println("user ${user}")

    val employee = Employee("Dilip")
    println("Employee is ${employee}")

    val person = Person()
    println("person is ${person.name}")
    val infixResposne = person infixCall "ddd"
    println(infixResposne)

    val student = Student(12)
    println("student is ${student}")

}
