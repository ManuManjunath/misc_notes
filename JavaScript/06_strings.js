// Strings - Can use single or double quotes
var str1 = "I'm using single quotes inside string";
var str2 = 'This way "ALSO" possible!';
var str3 = "Escaping double quotes is \"EASY\"";
var str4 = "Multiple \n lines"
console.log(str1);
console.log(str2);
console.log(str3);
console.log(str4);
// Concat using +
var str5 = "ABCDEFGH";
console.log(str5.charAt(2)); // C
console.log(str5.indexOf('E')); // 4
// Splitting each word of a string to an Array item
var str6 = "Trying to split each word";
console.log(str6.split(" "));
// [ 'Trying', 'to', 'split', 'each', 'word' ]
// Slicing
var str7 = str6.slice(4, 10); // substring from index 4 to 10(-1)
console.log(str7);


let a = "hello "
let b = 'world'
console.log(a + b)
let c = `This quote can be used to embed variables - ${a}
add new lines to the same string variable`
console.log(c)