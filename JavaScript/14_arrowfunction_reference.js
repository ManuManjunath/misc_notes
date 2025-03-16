class Employee{
    // Initialize name
    constructor(name) {
        this.name = name
    }

    // Inside a class, you can omit the keywork "function" before creating a method.
    printNameArrow() {
        // setTimeout is used to add delay
        // It takes 2 parameters - a function and milliseconds for delay
        setTimeout(() =>{
            console.log('Arrow method', this.name)
        }, 1000)
    }

    printNameNormal() {
        setTimeout(function(){
            console.log("Normal method", this.name)
        }, 1000)
    }
}

// Initialize the object
let employee = new Employee("Manu")
employee.printNameArrow()
// This returns Manu
// Because arrow function is able to bind itself to the current object
employee.printNameNormal()
//This returns undefined