package com.learnkotlin.chapter7

import java.time.LocalDate


fun iterateChars(){
    for (c in "abc")
        println(c)
}

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> {

    return object : Iterator<LocalDate>{
        var current = start

        override fun hasNext() = current<=endInclusive

        override fun next(): LocalDate = current.apply { current = plusDays(1) }

    }
}

fun iterateOverRangeOfDates(){

    var startDate = LocalDate.of(2019,4,1)
    var endDate = LocalDate.of(2019,4,14)
    val interval  = startDate..endDate

    for (date in interval){
        println(date)
    }
}


fun main(args: Array<String>) {

    iterateChars()
    iterateOverRangeOfDates()

}
