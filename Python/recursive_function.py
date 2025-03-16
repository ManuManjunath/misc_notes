"""
Sample code for recursive function.
This calls the function "guessValue" within itself until a condition is met.
"""
import random

# Define limits
lower = 1
higher = 100


# First store a random number
original = random.randint(lower, higher)
print(f"Original value is: {original}")
print(f"Original limits are {lower} to {higher}")

# Now try to guess the original random number
def guessValue(lower, higher, attempt):
    guessedValue = random.randint(lower, higher)
    if guessedValue == original:
        print(f"Correct guess: {guessedValue}. You took {attempt} attempt(s)")
    elif guessedValue > original:
        # If you have guessed higher, change your guessing upper limit
        print(f"You guessed higher: {guessedValue}")
        newHigher = guessedValue -1
        attempt = attempt + 1
        print(f"New limits are {lower} to {newHigher}")
        guessValue(lower, newHigher, attempt)
    else:
        # If you have guessed lower, change your guessing lower limit
        print(f"You guessed lower: {guessedValue}")
        newLower = guessedValue + 1
        attempt = attempt + 1
        print(f"New limits are {newLower} to {higher}")
        guessValue(newLower, higher, attempt)

# Lets see how many attempts we take to guess
attempt = 1
guessValue(lower, higher, attempt)


"""
Sample output - 
Original value is: 79
Original limits are 1 to 100
You guessed lower: 75
New limits are 76 to 100
You guessed higher: 91
New limits are 76 to 90
You guessed higher: 80
New limits are 76 to 79
Correct guess: 79. You took 4 attempt(s)
"""
