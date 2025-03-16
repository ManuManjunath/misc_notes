package basics

fun main() {
    // if else with multiple conditions
    // AND - &&
    // OR - ||
    // NOT - !=
    var someval = 21
    if (someval % 2 == 0 && someval % 3 == 0) {
        println("Divisible by 6")
    } else if (someval % 2 == 0 || someval < 0) {
        println("Even number or negative number")
    } else {
        println("Number is $someval")
    }

    // when
    val example = 8
    when (example) {
        1 -> {
            println("Value is 1")
            println("That is low")
        }
        2 -> println("It is 2")
        3 -> println("3 is pretty high")
        // Other options for left hand side
        2 * 3 -> println("Value is 6")
        "Hi there".length -> println("Value is length of string - Hi there --> 8")
        // Check for range
        in 5..10 -> println("Value is between 5 & 10")
        // Not in
        !in 11..20 -> println("Value is not between 11 and 20")
        else -> {
            println("Else is the default place it will come to if none of the above conditions meet")
            println("Value is $example")
        }
    }
}