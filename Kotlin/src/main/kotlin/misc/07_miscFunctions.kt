package misc

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    // map
    var square = numbers.map{ it * it}
    println(square)
    // Returns another list after applying the function

    // filter
    var evens = numbers.filter{ it%2 == 0}
    println(evens)
    // Returns a list after applying the filter

    // reduce
    // fold
}