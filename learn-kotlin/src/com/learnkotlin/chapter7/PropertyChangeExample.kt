package com.learnkotlin.chapter7

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person2(val name: String, age: Int) : PropertyChangeAware() {

    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)

        }
}

fun main(args: Array<String>) {

    val p = Person2("dilip", 32)
    p.addPropertyChangeListener(PropertyChangeListener { evt ->
        run {
            println("property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
        }
    })
    p.age = 33
}