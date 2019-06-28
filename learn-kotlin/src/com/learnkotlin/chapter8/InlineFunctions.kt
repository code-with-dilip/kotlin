package com.learnkotlin.chapter8

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock

inline fun synchronized(lock: Lock, action: () -> Unit): Unit {
    lock.lock()
    try {
        return action()
    }finally {
        lock.unlock()
    }
}

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age < 30 })
    println(people.filter { it.age > 30 }
            .map(Person::name))
}