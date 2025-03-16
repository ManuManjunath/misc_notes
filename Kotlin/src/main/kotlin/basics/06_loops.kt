package basics

fun main() {
    // for loop
    var sum = 0
    for (i in 1..10) {
        sum += i
    }
    println(sum)
    // Iterating over a list
    val lst = listOf("One", "Two", "Three")
    for (i in lst) {
        println(i)
    }
    // Or
    lst.forEach{ it -> println(it)}
    // Loop with index
    for ((index, value) in lst.withIndex()) {
        println("$value is in position: $index")
    }

    // while loop
    var num = 10
    while (num >=0) {
        if (num % 2 == 0) {
            println(num)
        }
        num -= 1
    }

    // break and continue
    // break moves you to the end of the loop and skip all further iterations
    // Example: quit loop as soon as you encounter the character 'i'
    for (c in "kotlin") {
        if (c == 'i') {
            break
        }
        println(c)
    }

    // continue skips to the next iteration
    // Skip current iteration if character is a vowel
    val vowels = arrayListOf('a', 'e', 'i', 'o', 'u')
    for (c in "kotlin") {
        if (c in vowels) {
            continue
        }
        println(c)
    }
}