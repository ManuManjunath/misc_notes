package misc

// Consider the below class with just one method
class Circle (val radius: Double) {
    fun area(): Double {
        return Math.PI * radius * radius
    }
}

// You can extend the above class and add more methods using ClassName.NewFunction
fun Circle.perimeter(): Double {
    return 2 * Math.PI * radius
}

fun String.toTitleCase(): String {
    return this.toLowerCase().split(" ").joinToString(" ") {
        it.capitalize()
    }
}

fun main() {
    val c1 = Circle(5.0)
    println(c1.area())

    // Now try to use the extended function
    println(c1.perimeter())

    // Another example using Strings
    println("some string with all lower case".toTitleCase())
    println("ANOTHER STRING WITH ALL UPPER CASE".toTitleCase())
}