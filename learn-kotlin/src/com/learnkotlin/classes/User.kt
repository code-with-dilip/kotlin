package com.learnkotlin.classes

data class User(val name: String, val age: Int)

fun hashCodeComparisonUsingHashset(user1 : User, user2 :User) : Boolean {
    val hashSet = hashSetOf<User>(user1)
    return hashSet.contains(user2);
}

fun main(args: Array<String>) {

    val user1 = User("dilip", 32)
    val user2 = User("dilip", 32)
    val result = user1 == user2

    println("Comparing two objects using Hashset : ${hashCodeComparisonUsingHashset(user1,user2)}")
    println("Comparing two objects using the == :  $result ")
        val user3  = user1.copy(age = 40);
        println("The new object is $user3")

}