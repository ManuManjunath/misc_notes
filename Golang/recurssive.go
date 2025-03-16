package main

// This calls the function guessValue within itself until a certain condition is met

import (
	"fmt"
	"math/rand"
	"time"
)

// Define limit
var lower int = 1
var higher int = 100

func main() {
	// First store a random number.
	rand.Seed(time.Now().UnixNano())
	original := rand.Intn(higher-lower+1) + lower
	fmt.Printf("Original value is %v\n", original)
	fmt.Printf("Original limits are %v to %v\n", lower, higher)

	// Now try to guess the original number
	attempt := 1
	guessValue(lower, higher, attempt, original)
}

func guessValue(lower, higher, attempt, original int) {
	guessedValed := rand.Intn(higher-lower+1) + lower
	// fmt.Println(guessedValed)
	if guessedValed == original {
		fmt.Printf("Current guess: %v. You took %v attempts to guess.\n", guessedValed, attempt)
	} else if guessedValed > original {
		// If you have guessed higher, change your gusesing upper limit and try again
		fmt.Printf("You guessed higher: %v\n", guessedValed)
		newHigher := guessedValed - 1
		attempt += 1
		fmt.Printf("Try again. New limits are %v and %v\n", lower, newHigher)
		guessValue(lower, newHigher, attempt, original)
	} else {
		// If you have guessed lower, change your gusesing lower limit and try again
		fmt.Printf("You guessed lower: %v\n", guessedValed)
		newLower := guessedValed + 1
		attempt += 1
		fmt.Printf("Try again. New limits are %v and %v\n", newLower, higher)
		guessValue(newLower, higher, attempt, original)
	}
}

/*
Sample output:
Original value is 30
Original limits are 1 to 100
You guessed higher: 80
Try again. New limits are 1 and 79
You guessed higher: 59
Try again. New limits are 1 and 58
You guessed higher: 31
Try again. New limits are 1 and 30
You guessed lower: 21
Try again. New limits are 22 and 30
You guessed lower: 26
Try again. New limits are 27 and 30
You guessed lower: 28
Try again. New limits are 29 and 30
Current guess: 30. You took 7 attempts to guess.
*/
