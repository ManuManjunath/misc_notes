package main

import (
	"fmt"
)

func main() {
	var x, y int
	strng := "MyString"
	intgr := 12
	flt := 3.14159265000111000111
	// Println implicitly adds "\n"
	fmt.Println("Println String", strng)
	// Explicitly mention "\n" when using Print
	fmt.Print("Print String ", strng, "\n")
	// Printf - (also needs an explicit "\n")
	// %v - value in default format
	fmt.Printf("Printf Integer %v \n", intgr)
	// %T - Type of value
	fmt.Printf("%v is a %T, %v is a %T and %v is a %T \n", intgr, intgr, flt, flt, strng, strng)
	// %t - booleans true or false
	fmt.Printf("Booleans - %t, %t \n", true, false)
	// %b and %x - binary and hexadecimal numbers
	fmt.Println("Enter 2 integers")
	fmt.Scanf("%d %d", &x, &y)
	fmt.Printf("%v is %b in binary and %v is %x in hexadecimal \n", x, x, y, y)
	// %% - escape for % --> Just prints "%"
	fmt.Printf("%% \n")
	// %g - Full float as is
	fmt.Printf("Printf full float %g \n", flt)
	// %0.25 for float with 2 decimal places
	fmt.Printf("Printf 2 decimals for floats %0.2f \n", flt)
	// %s - string or slice as is
	fmt.Printf("Printf %s of Type %T \n", strng, strng)
	// %q - double quoted string
	fmt.Printf("%q \n", strng)

}
