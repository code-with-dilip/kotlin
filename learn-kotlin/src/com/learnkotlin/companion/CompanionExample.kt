package com.learnkotlin.companion

import com.learnkotlin.domain.User

class CompanionExample{
    companion object {
        fun bar(){
            println("inside bar")
        }
    }
}

class Car private constructor(val model : String){

    companion object  {
        fun newCar( cmodel: String) : Car{
            return Car(cmodel)
        }
    }


}

class Employee {

    companion object Payroll {
        val allEmployees = arrayListOf<User>()

        fun addUser(user: User) = allEmployees.add(user)
    }
}

fun Employee.Payroll.size(users : ArrayList<User> ) = users.size


fun main(args: Array<String>) {

    CompanionExample.bar()
    val car = Car.newCar("camry")
    Employee.Payroll.addUser(User(1, "a","b"))
    Employee.addUser(User(1, "a","b"))
    println("Extension Function size ${Employee.size(Employee.allEmployees)}")

}