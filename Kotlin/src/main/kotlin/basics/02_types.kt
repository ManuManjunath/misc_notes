package basics

fun main() {
    /*
    Integer types -
    Byte --> 8 bits (-128 to + 127)
    Short --> 16 bits (-32768 to 32767)
    Int --> 32 bits (-2,147,483,648 (-2^31) to 2,147,483,647 (2^31 - 1))
    Long --> 64 bits (-9,223,372,036,854,775,808 (-2^63) to 9,223,372,036,854,775,807 (2^63 - 1))
    */
    val myByte: Byte = 13
    val myShort: Short = 125
    val myInt: Int = 123123123
    val myLong: Long = 12_039_812_309_487_120_3
    println("$myByte, $myShort, $myInt, $myLong")
    // Without explicit mentioning of type
    val myAge = 33
    println(myAge)

    // Float types - Float =  32 bit, Double = 64 bit
    var myFloat = 3.14F
    var myDouble = 3.14159265358979323
    /*
    Or to explicitly declare variable type:
    var myFloat: Float = 3.14F
    var myDouble: Double = 3.14159265358979323
    */
    println("$myFloat is of type: " + myFloat::class.java.typeName + " and $myDouble is of type " + myDouble::class.java.typeName)
    // Converting floats & doubles
    myDouble = myFloat.toDouble()
    println(myDouble)

    // Booleans
    var isSunny = true
    isSunny = false
    println("data type of isSunny is " + isSunny::class.java.typeName)

    // String and char
    // Chars are of 1 character length
    val letterChar: Char = 'A'
    val digitChar: Char = '1'
    // Use single quotes for char
    println("$letterChar is of type " + letterChar::class.java.typeName + ", $digitChar is of type " + digitChar::class.java.typeName)

    // Strings are longer
    val myStr: String = "Hello World!"
    // or just - myStr = "Hello World!"
    // To pull a specific character from a string
    var firstChar = myStr[0]
    println("First character in " + myStr + " is " + firstChar + " and the last character is " + myStr[myStr.length - 1])

    // To concat strings
    val concat1 = "Manu "
    val concat2 = "Manjunath"
    println(concat1 + concat2)

    /*
    Number conversions
    toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char
    */

}