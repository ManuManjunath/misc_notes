package basics

import java.lang.NumberFormatException

fun main() {
    val res = try {
        10 / 0
    } catch (e:ArithmeticException) {
        0
    }
    println(res)

    val num = "4abc"
    val res2: Int? = try {
        Integer.parseInt(num)
    } catch (e:NumberFormatException) {
        null
    }
    println(res2)

    // Generic exception. Use this when you don't know what error you might get.
    try {
        println(10/num.toInt())
    } catch(e: NumberFormatException) {
        println("Example for multiple catch blocks")
    } catch(e: Exception) {
        println("Generic exception catching - $e")
    } finally {
        // Same as python
    }

}