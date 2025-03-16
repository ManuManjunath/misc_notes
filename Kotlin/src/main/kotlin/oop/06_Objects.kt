package oop

// Class vs Object

object Cache{
    val name = "Object cache"

    fun retrieve(): Int {
        return 1
    }
}

class Cache2{
    val name: String = "Class cache"

    fun retrieve(): Int {
        return 0
    }
}

// You can also declare a companion object inside a class, which will work as a private method
// Whilst it can have a name, it does not need to have one, in which case it automatically has the name Companion:
class SomePerson(val firstName: String, val lastName: String) {
    companion object{
        val printSomething: String = "Something"
        fun getFullName(firstName: String, lastName: String): String {
            return "$firstName $lastName"
        }
    }
}

fun main() {
    // You can create multiple objects from a class using its constructor. Like -
    val something = Cache2()
    val something2 = Cache2()
    println(something.retrieve() == something2.retrieve())

    // But Objects (or Singleton Class) can have just one instance of it
    // You cannot instantiate an object. Like -
    // val something3 = Cache()
    // val something4 = Cache()
    // However, you can use it like this -
    println(Cache.retrieve())

    // Objects can also inherit from super classes, like -
    // object ObjName: SuperClass { ... }

    // You can use the companion object without initialising it with a constructor
    println(SomePerson.getFullName("Manu", "Manjunath"))
    println(SomePerson.printSomething)
    // To do the same from a class, you first have to initialise it with a constructor
    val c = Cache2()
    println(c.name)
}
