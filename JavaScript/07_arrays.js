// Indexes start from 0. Can include different data types.
var arr1 = [];
arr1[0] = 1;
arr1[1] = "String";
arr1[2] = false;
arr1[3] = 0.5;
// Lets leave one item in between
arr1[5] = 10;
console.log(arr1);
// [ 1, 'String', false, 0.5, <1 empty item>, 10 ]

var arr2 = [2, 4, 6, 8, 10];
// Use push to add items
arr2.push('X');
// You can also push more than 1 value
arr2.push('Y', 'Z');
console.log(arr2)
// Use pop to remove the last item
arr2.pop();
console.log(arr2)
// To remove the 1st element from an array, use shift
arr2.shift();
console.log(arr2)
// To add elements to the beginning of the array, use Unshift
arr2.unshift("100", false);
console.log(arr2)
// use arr.length to see the number of items
console.log(arr2.length);

// To add/remove elements in between, use slice/splice
let arr3 = [1, 2, 3, 4, 5]
let newValues = arr3.slice(2, 4)
console.log(newValues)
// To find the index of elements
console.log(arr3.indexOf(1))
// If you search for the index of a non-existing element, you get -1
console.log(arr3.indexOf(10))

// For loop on Arrays
for (i = 0; i < arr2.length; i++) {
    console.log(arr2[i]);
  }

