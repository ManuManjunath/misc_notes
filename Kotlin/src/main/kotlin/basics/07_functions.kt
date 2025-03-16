package basics

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val a = 10
    val b = 5
    val sum = add(a, b)
    println(sum)
    // Using another function with the same name, but different return type
    println(add(5.0, 2.0))
    // Assigning function to a variable
    var x: (a: Double, b: Double) -> Double = ::add
    // Now, use the variable x instead of the function add
    println(x(5.0, 2.0))

    println("Today is " + getDate())
    val lst = arrayListOf(1, 2, 3, 4, 5)
    val revLst = reverseIt(lst)
    println(revLst)
    // You can also define optional default parameter values.
    println(defParm())
    println(defParm(2))
    // using a single expression function
    println(theAnswer())
}

// With arguments and return
fun add(a: Int, b: Int): Int {
    // : Int in the end is the type of the return value
    return a + b
}

// function overloading - same function name with different params
fun add(a: Double, b: Double): Double {
    return a + b
}

// Without argument but has a return
fun getDate(): Date {
    return Date()
}

fun reverseIt(lst: ArrayList<Int>): ArrayList<Int> {
    var result = arrayListOf<Int>()
    for (i in lst) {
        result.add(0, i)
    }
    return result
}

fun defParm(num: Int = 1): Int {
    return num
}

// Single expression functions
fun theAnswer() = 42

