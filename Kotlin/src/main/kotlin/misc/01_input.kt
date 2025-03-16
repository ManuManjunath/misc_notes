package misc

import java.lang.NumberFormatException
import java.util.*

fun main() {
    val number: Int = Random().nextInt(100) + 1
    var input: String? // Inputs are always of type string
    var guess = -1

    while (guess != number) {
        println("Guess a number between 1 and 100")
        input = readLine()

        if (input != null) {
            try {
                guess = input.toInt()
                when {
                    guess > number -> println("You guessed higher")
                    guess < number -> println("You guessed lower")
                    else -> println("You got it")
                }
            } catch (e:NumberFormatException) {
                println("Enter a number")
            }
        }
    }
}