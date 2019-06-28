package com.learnkotlin.`object`

import com.learnkotlin.domain.User


object Payroll {
    val allEmployees = arrayListOf<User>()

    fun addUser(user: User) = allEmployees.add(user)

    fun printAllEmployees() {
        for (person in allEmployees) {
            println("${person}")
        }
    }
}

fun main(args: Array<String>) {

    Payroll.addUser(User(1, "Dilip", "Sundarraj"))
    Payroll.addUser(User(1, "Aish", "Gurudev"))
    Payroll.printAllEmployees()

}