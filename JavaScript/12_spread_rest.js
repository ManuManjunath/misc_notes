// rest operator - represents an unknown value as an array
//              - specifying parameter to a function whose value may change at runtime
// spread operator - Is used to expand an iterable (like array, object)

// spread on array (AKA list)
var array1 = [1, 2, 3]
var array2 = [...array1, 4, 5]
console.log(array2)
// Shows 1, 2, 3, 4, 5

// spread on object (AKA map or dictionary)
var object1 = {
    name: 'Manu',
    Age: 33
}
var object2 = {
    ...object1,
    Designation: "Sr Engineer"
}
console.log(object2)

// rest
function sum(...args) {
    console.log(args)
}
sum(4, 5)
// This will pass the arguments to ...args.
// Used when you don't know the number of parameters used for the function.
sum(1, 2, 3)