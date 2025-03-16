package basics

// Use varargs when you don't know the number of parameters you'll be sending to the function
fun main() {
    println(adding(1, 2, 3, 4, 5, 6))
    // The above numbers internally get passed as an array of integers

    greet("Person 1", "Person2", "Person 3")
    // The above names internally get passed as an array of strings
}

fun adding(vararg nums:Int): Int {
    var sum2 = 0
    for (i in nums) {
        sum2 += i
    }
    // return sum2
    // or -
    return nums.sum()
}

fun greet(vararg names: String) {
    for (name in names) {
        println("Hello $name")
    }
}