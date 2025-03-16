let a = 10;
console.log(typeof(a))

let b = 10.99;
console.log(typeof(b))
// integers, decimals - they're all of type number

console.log(a + b)
/* 
10 + 10.99 DOESN'T show 20.99, but 20.990000000000002
To show it as 20.99 (which it is), do the following - 
*/
console.log(+(a+b).toFixed(2))

a += 1
// same as a = a + 1

let c = "10.99"
console.log(typeof(c))

let d = "hello "
let e = 'world'
console.log(d + e)
let f = `This quote can be used to embed variables - ${d}
add new lines to the same string variable`
console.log(f)

// Length of a string
console.log(f.length)

// string + number
let g = "abcd"
let h = 10
console.log(g + h)
// This shows abcd10

let i = 123
console.log(typeof i.toString())

j = "123.45"
console.log(typeof Number.parseFloat(j))

// Booleans
let k = true
// To print the opposite boolean
console.log(!k)
l = 1
