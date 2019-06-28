package com.learnkotlin.chapter7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty(
        var propValue: Int,
        val changeSupport: PropertyChangeSupport
) {
    operator  fun getValue(p: Person3, prop : KProperty<*>): Int = propValue //KProperty to represent the property
    operator fun setValue(p: Person3, prop : KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}


class Person3(
        val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int by ObservableProperty(age, changeSupport)
    var salary : Int by ObservableProperty(salary, changeSupport)
}

fun main(args: Array<String>) {

    val p = Person3("dilip", 32,10000)
    p.addPropertyChangeListener(PropertyChangeListener { evt ->
        run {
            println("property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
        }
    })

    p.age = 33
    p.salary = 10001
}