// For loop
for (let i = 0; i < 5; i++) {
    console.log(i)
}
// 0, 1, 2, 3, 4

// While loop
let a = 1;
while (a <= 5) {
    console.log(a)
    a++
}
// 1, 2, 3, 4, 5

// Do while loop
let b = 1;
do {
    console.log(b)
    b++
} while (b > 5)
// b is NOT > 5. But it still executes once.

// Breaking loops
var str = "";
for (var i = 10; i >=0; i--) {
    str += "Number = " + i + "\n";
    // Break if divisible by 7
    if (i % 7 == 0) {
        break;
    }
}
console.log(str);