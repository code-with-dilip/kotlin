package com.learnkotlin.classes

class Client(val name: String, val postalCode: Int){
    override fun toString(): String = "Client (name : ${name} - Postal Code : ${postalCode})"
    override fun equals(client2: Any?): Boolean {
        if(client2!=null && client2 is Client) //is check in Kotlin is the analogue of instanceof in Java
            return client2.name == name && client2.postalCode==postalCode
        else if (client2 !is Client) // takes care of handling null check too
           return false
        else
            return false
    }
    override fun hashCode(): Int { // overriden hash code method to make it work for complext comparisions.
        return name.hashCode() *31 + postalCode
    }
}

fun hashCodeComparisonUsingHashset(client1 : Client, client2:Client) : Boolean {
    val hashSet = hashSetOf<Client>(client1)
    return hashSet.contains(client2);
}

fun main(args: Array<String>) {

    var client = Client("dilip", 55124)
    var client1 = Client("dilip", 55124)
    println("Client is : ${client} and their hashcode is ${client.hashCode()}")
    println("Client1 is : ${client1} and their hashcode is ${client1.hashCode()}")
    println("Are these clients equal : ${client == client1}")
    println("hashCodeComparisonUsingHashset : ${hashCodeComparisonUsingHashset(client,client1)}")


}