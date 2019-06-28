package com.learnkotlin.chapter7

class Person(val name: String) {
    private var _emails: List<String>? = null
    val emails : List<String>
        get(){
            if (_emails == null) {
                println("sets the emails")
                _emails = arrayListOf("dilip", "aish")
            }
            return _emails!!
        }
}

class Person1(val name: String) {
    val emails : List<String> by lazy { namesList() }
}

fun namesList(): ArrayList<String> {
    println("inside namesList")
    return arrayListOf("dilip", "aish")
}

fun main(args: Array<String>) {
    val p = Person("Dilip")
    p.emails
    p.emails
    val p1 = Person1("Dilip")
    p1.emails
    p1.emails
}