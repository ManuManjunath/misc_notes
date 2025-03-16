fun main() {
    // Higher order functions accepts a function as a parameter or returns a function
    higherOrder(2.0, 3.0, ::adding)
    // You call a higher order function by using ::
}

fun adding(a: Double, b: Double): Double {
    return a + b
}

fun higherOrder(a: Double, b: Double, fn: (Double, Double) -> Double) {
    // -> Shows the return type
    println(fn(a, b))
}