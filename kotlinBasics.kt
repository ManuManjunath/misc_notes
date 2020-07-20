package KOTLIN_LEARNING

fun main() {
    // Vals and Vars

    var myName = "Manu"
    val name2 = "Cannot change"
    myName = "Not Manu"
    // You can't say - <name2 = "something else"> because "val"s are immutable
    println("Hello " + myName)
    println("Values are like constants - " + name2)

    // TODO: Add notes using "TODO". It still works as a comment but its easy to bookmark these lines

    /*
    Multi line comment -
    Like in SQL or Go lang
     */

    // Integer types - Byte = 8 bit, Short = 16 bit, Int = 32 bit, Long = 64 bi t
    val myByte: Byte = 13
    val myShort: Short = 125
    val myInt: Int = 123123123
    val myLong: Long = 12_039_812_309_487_120_3
    // Without explicit mentioning of type
    val myAge = 32
    println(myAge)

    // Float types - Float =  32 bit, Double = 64 bit
    var myFloat: Float = 3.14F
    var myDouble: Double = 3.14159265358979323

    // Booleans
    var isSunny = true
    isSunny = false

    // String and char
    // Chars are of 1 character length
    val letterChar = 'A'
    val digitChar = '1'
    // Strings are longer
    val myStr = "Hello World!"
    // To pull a specific character from a string
    var firstChar = myStr[0]
    println("First character in " + myStr + " is " + firstChar + " and the last character is " + myStr[myStr.length - 1])

    // Arithmetic operators (+ - * / %)
    var ans = 5 + 3
    ans /= 2 // Same as ans = ans / 2
    ans %= 3 // Same as ans = ans % 3
    println(ans)
    // Int divide by Int will always return an Int. The below will return 1 and not 1.666
    println(5 / 3)
    // Use toDouble to get the decimals
    println(5.toDouble() / 3.toDouble())
    // Also check out toInt, toChar etc

    // Comparison operators (== != > < >= <=)
    val a = 5
    val b = 5.0
    val check = 1 > b
    println("Is 5 > 5.0? $check")
    // You can use $var instead of concatenating - Like f-strings in Python
    // Cannot use == or != to compare int with float
    println("Is 2 less than 3? ${2 < 3}")
    // This way, you can directly perform calculations in the print statement
    
}
