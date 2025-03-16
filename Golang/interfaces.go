package main

import (
	"fmt"
	"math"
)

// Interfaces are named collection of method signatures

// Define an interface, geometry with 2 methods - area and perimeter
type geometry interface {
	area() float64
	perim() float64
}

// Now we define the required shapes as structs
type rect struct {
	width, height float64
}
type circle struct {
	radius float64
}

// Now implement methods for the interface
func (r rect) area() float64 {
	return r.width * r.height
}
func (r rect) perim() float64 {
	return 2*r.width + 2*r.height
}
func (c circle) area() float64 {
	return math.Pi * c.radius * c.radius
}
func (c circle) perim() float64 {
	return 2 * math.Pi * c.radius
}

func calculate(g geometry) {
	fmt.Println("The shape is", g)
	fmt.Println("Area = ", g.area())
	fmt.Println("Perimeter = ", g.perim())
}

func main() {

	r := rect{width: 5, height: 10}
	c := circle{radius: 5}

	calculate(r)
	calculate(c)

	// You can also assign multiple types to an interface -
	var a interface{}
	fmt.Println(a)
	a = 10
	fmt.Printf("Type = %T and Value = %v\n", a, a)
	a = 3.14
	fmt.Printf("Type = %T and Value = %v\n", a, a)
	a = 7 + 7i
	fmt.Printf("Type = %T and Value = %v\n", a, a)
	var b int
	a = &b
	fmt.Printf("Type = %T and Value = %v\n", a, a)
	// This woulnd't have worked if a was in int/float/string, etc
}
