package com.learnkotlin.chapter5

import com.learnkotlin.domain.Employee
import com.learnkotlin.domain.Person
import com.learnkotlin.domain.Student
import com.learnkotlin.domain.User


val people = listOf(Person("Alice"), Person("Bob"))
val employees = listOf(Employee("scooby",2),Employee("dilip",32),Employee("aish",28))
val map = mapOf<Int, String>(0 to "Zero",1 to "One", 2 to "two")
val numberList = listOf<Int>(1,2,3,4)
val dilipActivities = listOf("running", "cricket")
val aishActivities = listOf("running", "hurdles")
val scoobyActivities = listOf("sleep", "running")
val students = listOf(Student("dilip",dilipActivities ),Student("aish",aishActivities ),Student("scooby",scoobyActivities ) )

fun hello() = println("hello")

fun filter(){
    println(numberList.filter { i -> i %2 ==0 })
}

val maxAge = employees.maxBy(Employee::age)?.age
fun map(){
    println(numberList.map { i -> i*2 })
    println(people.map { Person::name })
    println(employees.filter { it.age == maxAge})
}

fun playingWithMap(){
    println(map.mapValues { it.value.toUpperCase() })
}

fun groupBy(){

    println(employees.groupBy(Employee::age))
}

fun flatmap(){

    println(students.flatMap { it.activities.toList() })
    println("distinct activities are ${students.flatMap { it.activities}
            .distinct()
            .toList()
    }")
}


fun collectionWithoutSequence(){
    val namewithPList = employees.map(Employee::name) // creates an intermediate list
            .filter { it.contains("p") } // creates an intermediate list
    println("collectionWithoutSequence : $namewithPList")
}

fun collectionWithSequence(){
    val namewithPList = employees.asSequence()
            .map(Employee::name)
           .filter { it.contains("p") }
    println(namewithPList)
}

val generate = generateSequence(0) { it+1 }
val until100 = generate.takeWhile { it<=100 }


val employeeAboveAge2 = { e:Employee -> e.age>2}

fun main(args: Array<String>) {
    val users = listOf(User(1,"dilip","sundarraj"), User(2,"scooby","dilip"))
    println(users.maxBy { it.id })
    println(users.maxBy({ u: User -> u.id})) // approach 2 without syntax shortcuts
    println(users.maxBy {  u: User -> u.id })

    println(users.maxBy(User::id))

    run { println(42)} // not assigning a lambda a function to a variable

    println(people.joinToString(" ", transform = {p: Person -> p.name})) // names are seperated by a space.

    println(people.joinToString(" ")  {p -> p.name})

    println(people.joinToString(" ")  {it.name})

    run(::hello)
    run({ hello()})

    filter()
    map()
    playingWithMap()
    println(employees.all(employeeAboveAge2))
    println("Employees above age 2 : !${employees.find(employeeAboveAge2)}") // returns the first element that matches it.
    println(employees.any(employeeAboveAge2))
    println(employees.find(employeeAboveAge2))
    println(employees.count(employeeAboveAge2))
    println(groupBy())
    flatmap()
    collectionWithSequence()
    println("The sum is  ${until100.sum()}")
    collectionWithoutSequence()

}