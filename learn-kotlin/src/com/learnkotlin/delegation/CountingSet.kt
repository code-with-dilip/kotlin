package com.learnkotlin.delegation

class CountingSet(val innerSet: MutableCollection<String> = HashSet<String>()) : MutableCollection<String> by innerSet { // this by keyword takes care of forwarding the

    var objectsAdded =0

    override fun add(element: String): Boolean {
        objectsAdded++
        return innerSet.add(element);
    }

    override fun addAll(elements: Collection<String>): Boolean {
        objectsAdded++
        return innerSet.addAll(elements)

    }
}

fun main(args: Array<String>) {

    val countingSet = CountingSet()
    countingSet.add("Dilip")
    println("objectsAdded ${countingSet.objectsAdded} and the size is ${countingSet.size}")

}