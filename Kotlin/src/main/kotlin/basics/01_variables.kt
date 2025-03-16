package basics

fun main() {
    println("Hello, World.")

    // Comments

    /*
    Multi
    line
    comments
    */

    // vars & vals
    var name = "Manu"
    val name2 = "Cannot Change val"
    name = "Not Manu"
    /* You can't say -
    name2 = "something else"
    because "val"s are immutable
    */
    println("var can change its value - $name. But val cannot - $name2")

    // Binary and hexadecimal numbers
    println(0xC7E)
    println(0b10100000)
    println(0b11000001)

    // Swap 2 variables
    var a = 10
    var b = 20
    a = b.also { b = a }
    println("$a, $b")
}