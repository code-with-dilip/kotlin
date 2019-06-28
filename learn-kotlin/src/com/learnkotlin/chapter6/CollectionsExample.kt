package com.learnkotlin.chapter6



fun nullableCollections(intList : List<Int?>){
    for (i in intList)
        println(i.toString().toIntOrNull())

}

fun getNonNull(intList : List<Int?>) : List<Int>{
        return intList.filterNotNull()
}

fun playwithList(source: Collection<Int>,
                 target: MutableCollection<Int>){

    target.add(4)
}

fun main(args: Array<String>) {

    val numList = listOf(1,null,3)
    println(nullableCollections(numList))
    println(getNonNull(numList))

    val source: Collection<Int> = listOf(1,2,3)
    val target: MutableCollection<Int> = mutableListOf(1,2,3)
    playwithList(source,target)
    println(target)

}