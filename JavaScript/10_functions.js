// Normal function
function addThem(a, b) {
    return a + b
}
console.log(addThem(2, 3))

// If you pass more number of paraneters than required, the extra paramneters are ignored.
console.log(addThem(2, 3, 4, 5, 6))
// This will just add 2 & 3

// Arrow function (function expression)
let x = (a, b) => {
    return a + b
}
console.log(x(2, 2))
/*
Function name is optional.
If it has just 1 statement, you can also remove "{}" and "return" keyword
So it can be re-written as 
*/
let y = (a, b) => (a + b)
console.log(y(3, 3))

// Another example to convert normal function to arrow function
function isPositive(n) {
    return n >=0
}
console.log(isPositive(3))

// Lets convert the above to an arrow function
let isPos = (n) => (n>=0)
console.log(isPos(3))
// If there is just 1 parameter for the function, you need not pass it in ()
// So it can be re-written as
let isPostv = n => n>=0


// Nested function
function hypotenuse(a, b) {
    function sideSquare(x) {
        return x * x;
    }
    return Math.sqrt(sideSquare(a) + sideSquare(b));
}
console.log("hypotenuse = " + hypotenuse(3, 4));


// Recursive function - a functions gets called in itself
var min = 1;
var max = 100;
var attempt = 1;
console.log("Original limits are " + min + " to " + max)
var rnd = Math.floor(Math.random() * (max - min + 1)) + min;
// This returns a random number between 0 and 100
console.log("Random number to guess is " + rnd);
// Now write a recursive function to guess the above value
function guessValue(min, max, attempt) {
    var guess = Math.floor(Math.random() * (max - min + 1)) + min;
    if (guess === rnd) {
        console.log("You have guessed it right - " + guess + "! You took " + attempt + " attempt(s) to get it right");
    }
    else if (guess < rnd) {
        console.log("You have guessed lower - " + guess);
        attempt ++;
        newMin = guess + 1;
        console.log("New guessing limits are - " + newMin + " to " + max);
        guessValue(newMin, max, attempt);
    }
    else if (guess > rnd) {
        console.log("You have guessed higher - " + guess);
        attempt ++;
        newMax = guess - 1;
        console.log("New guessing limits are - " + min + " to " + newMax);
        guessValue(min, newMax, attempt);
    }
}
// Lets see how many attempts it takes to guess
guessValue(min, max, attempt);
