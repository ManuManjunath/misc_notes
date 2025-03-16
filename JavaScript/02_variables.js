/*
var - function scope
let - block scope
const - block scope. No reassignments
*/
var a = 1;
let b = 2;
const c = 3;

// const c = 4
// This will fail

// String
let d = 'A string variable'

// Undefined variable
let g;
console.log(g)
// This returns "undefined"

// let vs var
function varCheck() {
    for (var i=0; i<5; i++) {
        console.log(i)
    }
    // This will show 0, 1, 2, 3, 4
    console.log(i)
    // This will show 5
}

function letCheck() {
    for (let i=0; i<5; i++) {
        console.log(i)
    }
    // This will show 0, 1, 2, 3, 4
    // console.log(i)
    // Errors here - that i is not defined.
    // i was defined inside the for block. So can't be accessed outside.
}

console.log(varCheck())
console.log(letCheck())