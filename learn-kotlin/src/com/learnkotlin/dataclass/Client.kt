package com.learnkotlin.dataclass

data class Client(val name: String, val id: Int)



class Client1(val name: String, val id: Int){

    override fun toString(): String {
        return "Client1(name='$name', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client1

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }

}


fun main(args : Array<String>) {

    val dataClient = Client("Dilip", 1);
    val dataClient1 = Client("Dilip", 1);
    println(dataClient==dataClient1)
    println(dataClient)

    val client2 = Client1("Dilip", 1);
    val client3 = Client1("Dilip", 1);
    println(client2==client3)
}
