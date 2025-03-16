package oop

// Use enums when you have a set list of values
enum class Direction {
    NORTH, SOUTH, EAST, WEST
    // Any object using this class can only have the above 4 values.
    // This way, you get type safety and also case match
}

enum class Colour(val rgb: Int) {
    // WIP - enum classes with methods and parms
    RED(0xFF0000), BLUE(0x00FF00), GREEN(0x0000FF);

    // If you want to have methods in the enum class, end the last entry with a semicolon
    fun hasRed(): Boolean {
        return false
    }
}

fun main() {
    // Auto completion also allows you have only the 4 options available in the enum
    val step1: Direction = Direction.EAST
    val step2: Direction = Direction.WEST
    val step3: Direction = Direction.NORTH
    val step4: Direction = Direction.SOUTH
    // You cannot input any value other than the above
    // val step5 = Direction.NORTHWEST

    println("First go $step1. Then go $step2. Then go $step3. Then go $step4")
}