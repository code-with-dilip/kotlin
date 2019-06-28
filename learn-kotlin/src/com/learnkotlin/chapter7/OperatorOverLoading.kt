package com.learnkotlin.chapter7

import com.learnkotlin.accessors.User
import com.learnkotlin.chapter6.Person
import com.learnkotlin.collection.list
import com.learnkotlin.domain.Employee
import com.sun.javaws.exceptions.InvalidArgumentException
import com.sun.org.apache.xpath.internal.operations.Bool
import com.sun.tools.corba.se.idl.InvalidArgument
import java.lang.IndexOutOfBoundsException
import java.time.LocalDate

data class Point(val x: Int, val y: Int){

    operator fun plus(other: Point) : Point{
        return Point(x + other.x, y+other.y)
    }

    operator fun times(other: Point) : Point{
        return Point(x * other.x, y * other.y)
    }

    operator fun unaryMinus() : Point{
        return Point(-x,-y)
    }

    operator fun compareTo(point2: Point): Int {
        return compareValuesBy(this, point2, Point::x, Point::y )
    }

    operator fun Point.get(index: Int) : Int {
       return when(index){
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Please pass a valid argument")
        }
    }



}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    return when(index){
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}

operator fun Point.get(index: Int) : Int {
    return when(index){
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}

operator fun Point.get(index: Int, index1: Int) : Point {
    return when(setOf(index, index1)){
        setOf(0,1) -> Point(x, y)
        else -> throw IndexOutOfBoundsException("Please pass a valid argument")
    }
}

data class Rectangle(val upperLeft : Point, val lowerRight: Point)

operator fun Rectangle.contains(p : Point): Boolean{

return p.x in upperLeft.x until lowerRight.x &&
        p.y in upperLeft.y until  lowerRight.y
}

fun plusAssign(){

    var intList = mutableListOf(1,2)
    intList.plusAssign(2)
    println(intList)

}

fun collectionWithOperators(){

    var list = listOf(1,2,3)
    val list2 = list+ listOf(4,5)
    println(list2) // adds the 4.5 elements to the collection

    list = list- listOf(2);
    println(list)  // removes the element which has the value of 2
}

fun collectionWithObjectTypesAndOperators(){

    val user = Employee("Dilip", 32)
    val user2 = Employee("Aish", 28)
    val user3 = Employee("Scooby", 2)

    var employeeList = listOf(user, user2, user3)
    println("Before removing ${employeeList}")

    employeeList = employeeList-user
    println("After removing ${employeeList}")
}

fun comparingTwoPoints(point1: Point , point2: Point): Boolean{

    return point1<point2;
}

fun rangeToExample(){

    val now = LocalDate.now();
    val range = now .. now.plusDays(10)
    println(now.plusWeeks(1) in range) // returns a boolean

}

fun main(args: Array<String>) {
    val point = Point(1,2)
    val point2 = Point(1,2)
    val other = Point(5,6)
    println(point+other)
    println(point*other)

    var point1 = Point(1,2)
    point1 +=  Point(5,6)
    println(point1)
    plusAssign()
    collectionWithOperators()
    collectionWithObjectTypesAndOperators()
    println(-point)
    println("Are they equal ? ${point == point2}")
    println(point[1])
    println(point[0,1])
    val mutablePoint = MutablePoint(1,2)
    mutablePoint[0] = 5 // this calls the set method and assigns the value to it.
    println("mutablePoint : ${mutablePoint}")

    val rectangle = Rectangle(Point(10,10), Point(30,30))

    println("Is the point inside ? ${Point(20,20) in rectangle}")
    rangeToExample()


}
