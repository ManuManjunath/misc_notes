// and or not
/*
And --> %%
OR --> ||
NOT --> !=
*/

let a = 1
let b = "1"

// With ==
if (a == b) {
    console.log(true)
} else {
    console.log(false)
}
// This shows true because it converts types

// With ===
if (a === b) {
    console.log(true)
} else {
    console.log(false)
}
// This shows false.

let c = true
let d  = 1
console.log(c == d)
// This is true because 1 is true
console.log(c === d)
// This is false because it is a different kind of true

/*
Similarly, use:
!= for non strict not equals sign
!== for strict not equals sign
*/

var divBy2 = true;
var divBy3 = true;
console.log(divBy2 && divBy3);
// This will return true only if both the statements are true.