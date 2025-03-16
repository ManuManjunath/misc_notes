package oop

// You can also declare a companion object inside a class, which will work as a private method
// Whilst it can have a name, it does not need to have one, in which case it automatically has the name Companion:
class A {
    // You can use something like this so its easier to create class objects
    companion object {
        fun create(): A = A()
    }

    fun show(): String {
        return "In show method"
    }

}

fun main() {
    // You can use the companion object without initialising it with a constructor
    var obj = A.create()
    println(obj.show())
}
