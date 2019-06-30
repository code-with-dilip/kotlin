package com.learnkotlin.domain

import java.lang.IllegalArgumentException

data class User(var id: Int, val firstName: String, var lastName: String)



fun User.validateUser(){

    fun validateBeforeSave(value: String, fieldName : String){
        if(value.isEmpty())
            throw IllegalArgumentException("$fieldName is not present for the $id")
    }

    validateBeforeSave(firstName, "firstName")
    validateBeforeSave(lastName, "lastName")
}
