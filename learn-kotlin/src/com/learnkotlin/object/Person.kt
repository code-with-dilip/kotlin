package com.learnkotlin.`object`

import com.learnkotlin.domain.Person


fun main(args: Array<String>) {

    val person = Person("Dilip")
    val person1 = Person("Aish")

    val personList = listOf<Person>(person,person1)
    println("Sort by name : ${personList.sortedWith(Person.NameComparator)}")

}