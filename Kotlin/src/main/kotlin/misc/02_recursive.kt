package misc

fun main() {
    val origLower = 1
    val origUpper = 100
    var origNum: Int
    origNum = (origLower..origUpper).shuffled().last() // This includes lower and upper in range
    println("Original number is $origNum. Lets see how many attempts it takes to guess it right")
    var attempt =  0
    guess(origLower, origUpper, attempt, origNum)
}

fun guess(lower: Int, upper: Int, attempt: Int, orig: Int) {
    val guessedValue = (lower..upper).shuffled().last()
    var low = lower
    var up = upper
    var att = attempt
    att += 1
    if (guessedValue == orig) {
        println("You guessed it right - $guessedValue! You took $att attempts.")
    } else if (guessedValue > orig) {
        val newUp = guessedValue - 1
        println("You guessed $guessedValue, which is higher. Try again with new limits: $low to $newUp")
        guess(low, newUp, att, orig)
    } else {
        val newLow = guessedValue + 1
        println("You guessed $guessedValue, which is lower. Try again with new limits: $newLow to $up")
        guess(newLow, up, att, orig)
    }
}