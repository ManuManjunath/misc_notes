let person = {
    firstName: 'Manu',
    lastName: 'Manjunath',
    age: 33
};
// To extract specific values
console.log(person.firstName)
// Or
console.log(person['firstName'])

// Another way to destructure - 
const {firstName, lastName} = person
console.log(firstName)
console.log(lastName)

// To modify a value
person.age = 34
console.log(person)

// To add new values
person['email'] = 'manu.manjunath@target.com'
console.log(person)

// To remove a key
delete person.age
console.log(person)

// Methods in object
let dog = {
    name: 'Shabby',
    age: 3,
    gender: 'female',
    colour: 'white',
    tail: function() {
        return this.name + " has a tail";
    },
    bites: function(a) {
        if (a) {
            return "Yes"
        } else {
            return "No"
        }
    }
};
console.log(dog.tail())
console.log(dog.bites(false))

// Passing an object to a function