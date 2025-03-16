package main
// To declare variables -

import (
	"fmt"
	"reflect" //Use this to check the Variable type
)

// To declare variables at package level - (outside functions)
var (
	name, location string
	age            int
	x = 100 // Just to show how to specift a value
)

// If you don't specify value for the var, it uses a defaiult "zero value"
// Every type has a zero value.

// Go can also infer types -
// var (name, location, age = "Manu", "Bangalore", 32)

func main() {
	fmt.Println("Name is ", name, "and is of type ", reflect.TypeOf(name))
	fmt.Println("Location is ", location, "and is of type", reflect.TypeOf(location))
	fmt.Println("Age is ", age, "and is of type ", reflect.TypeOf(age))

	a := 3.5
	b := 6
	// ":=" doesn't work outside of functions
	// To add an int and a float
	c := a + float64(b)
	fmt.Println("c = ", c, " and of type", reflect.TypeOf(c))
}
