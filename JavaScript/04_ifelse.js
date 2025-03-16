let a = '10';

if (a % 2 === 0 ) {
    console.log("Even number")
} else if (a % 2 === 1) {
    console.log("Odd number")
} else {
    console.log("Unknown number")
}

/*
Falsey:
false, 0, emoty strings, null, undefined, NaN
Truthy:
Everything else
*/

// Another type of if-else - Ternary operator
let b = (a < 10) ? 'single digit' : 'double digit'
console.log(b)
/*
This is similar to:
if (a < 10) {
    let b = 'single digit'
} else {
    let b = 'doublt digit
}
*/

// Multiple conditions
// All conditions in if/else if need to be inside ()
let age = 50;
if (age < 50 && age % 2 == 0) {
    console.log("Even number under 50");
} else if (age < 50 && age % 2 != 0) {
    console.log("Odd number under 50");
} else if (age > 50) {
    console.log("Over 50 years old");
} else {
    console.log("50 years old");
}