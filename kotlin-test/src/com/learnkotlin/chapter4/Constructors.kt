package com.learnkotlin.chapter4


class User(val name: String){

}

class User1(_name : String){

    val name : String = _name

}

class User2{
    var name : String
    var length : Int

    constructor(_name: String): this(_name, _name.length){
        name = _name
    }

    constructor(_name: String, _length: Int){
        name = _name
        length = _length
    }

}

interface Employee {

    val id : Int
}

class EmployeeImpl(override val id : Int) : Employee {

}


fun main() {

    val user = Person("Dilip")
    println(user.name)

    val user1 = User1("Dilip")
    println(user1.name)

    val user2 = User2("Dilip")
    println(user2.name)

    val employeeImpl = EmployeeImpl(123)
    println(employeeImpl.id)
}