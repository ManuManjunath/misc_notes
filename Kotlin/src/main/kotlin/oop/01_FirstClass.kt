package oop

import java.util.*

class Person(val name: String, var age: Int = 30, var height: Double) {
    // Here 30 is the default age

    init {
        //this.name = name
        //this.age = age
        // No need to initialize the above variables since they're set in the class definition
        println("Object created")
    }

    fun greet(name: String) {
        println("Hello $name")
    }

    fun getYearOfBirth(): Int {
        val curYear = Calendar.getInstance().get(Calendar.YEAR)
        return curYear - age
    }

    // Another way of writing the same
    fun getYearOfBirth2() = Calendar.getInstance().get(Calendar.YEAR) - age

    fun print() = "$name is $age years old and $height cms tall."

    // private properties and methods cannot be accessed outside the class. See basics.main for details
    private val x = 10
    val y = x
}

fun main() {
    val person = Person("Manu", 33, 177.0)
    println(person.age)
    println(person.name)
    person.greet("Manu")
    println(person.getYearOfBirth())
    println(person.getYearOfBirth2())
    println(person.print())

    // Using named parameters and default value for age
    val person2 = Person(height = 160.0, name = "Someone")
    println(person2.age)

    // You cannot use the private property outside the class
    // println(person.x) // This won't work
    println(person.y) // This will


}