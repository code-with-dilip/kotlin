package com.learnkotlin.chapter6

import com.learnkotlin.cast.Expr
import com.learnkotlin.cast.Num
import com.learnkotlin.domain.User
import java.lang.Exception

fun strLen(s: String?) = if(s!=null) s.length else 0

fun strLen1(s: String?) {
    var length=0
    if(s!=null){
        length=s.length
    }else
        length =0
    //return length;
}

class Car(val name : String, val user: User?)

fun carUser(car: Car) =  car?.user

fun strLenSafe(s: String?): Int = s?.length ?: 0


fun strLenusingSafeCall(s: String?) = s?.length

fun castAs(expr: Expr?) : Num? {

    return expr as? Num
}

fun ignoreNull(s: String?){

    val sNotNull : String =s!!
    println(sNotNull.length)
}

fun letExample(str: String?) : Int?{
    str?.let { return it.length}
    return null
}

val isNull = { s : String -> s.isNullOrBlank()}

fun printHashCode(t: Any?){

    println(t?.hashCode())
}

fun getPersonName(person: Person){

    println(person.name.toUpperCase())

}
fun main(args: Array<String>) {
    strLen(null) // compiler will complain on this one.
    strLen1(null)
    println(strLenusingSafeCall("dilip"))
    println(strLenusingSafeCall(null))
    val car = Car("camry", null)
    println("user of the car is ${carUser(car)}")
    println("${strLenSafe("dilip")}")
    val num = Num(1)
    println("Valid Cast as ${castAs(num)}")
    println("Null Cast as ${castAs(null)}")

    letExample("dilip")
    letExample(null)
    //println(ignoreNull(null))
    println("Is it null ${isNull("")}")

    val person = Person(null);
    getPersonName(person)
}