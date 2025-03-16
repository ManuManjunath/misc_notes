package main

// Pointers - To get the memory address of a variable ("&"var)
// Function to change the value of a variable using its pointer.

import (
	"fmt"
	"reflect"
)

func main() {
	// To declare a variable as a pointer -
	var i *int
	fmt.Println(reflect.TypeOf(i), i)
	age := 32
	// Using another function to increment using pointers
	incAge(&age)
	fmt.Println("Incremented age is ", age)
	// You can view the memory address by using ""&var"
	fmt.Println("memory address for age = ", &age)
	// You can also do the below -
	name := "Manu"
	// To create a pointer variable for name -
	namePtr := &name
	fmt.Println("Memory address for name = ", namePtr)
	// To get the value of variable from the memory address, use "*"
	fmt.Println("Value of Name is ", *namePtr)

	// Validating byValue and byPointer -
	a := "This"
	b := "That"

	// Only a copy of the variables are sent tot he function
	byValue(a, b)
	fmt.Println(a, b)

	// By passing the pointer, the original variale is sent to the function

	byPointer(&a, &b)
	fmt.Println(a, b)
}

// To modify the original variables in its address using "*".
func incAge(x *int) {
	*x++
	// This returns 32 + 1 = 33
}

func byValue(a, b string) {
	a = "One"
	b = "Two"
}

func byPointer(a, b *string) {
	*a = "One"
	*b = "Two"
}
