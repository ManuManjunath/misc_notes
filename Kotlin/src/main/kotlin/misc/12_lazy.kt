package misc

import kotlin.system.measureTimeMillis

class Person {
    // val children = loadChildren()
    val children by lazy { loadChildren() }

    companion object {
        fun loadChildren(): List<String> {
            println("Loading children")
            Thread.sleep(3000)
            return listOf("Child1", "Child2")
        }
    }
}

fun main() {
    println("Creating person")
    val timeTaken = measureTimeMillis {
        val person1 = Person()
        // If you don't use the children variable, the time it takes is ~ 5ms - It just created the object.
        // It will take 3 seconds only IF you use the function - lazy running
        person1.children.forEach { println(it) }

    }
    println("Person created in ${timeTaken} ms")
}