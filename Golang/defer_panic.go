package main

import (
	"fmt"
)

func main() {
	funcNormal()
	funcDefer()
	funcDefer2()
	funcPanic()

}

func funcNormal() {
	fmt.Println("How it would usually work")
	fmt.Println("Line 1")
	fmt.Println("Line 2")
	fmt.Println("Line 3")
	fmt.Println("Line 4")
}

func funcDefer() {
	// Defer statements will run after the function is completed.
	// Usually used to close files
	// multiple defer statements will run bottom up
	fmt.Println("Working with defer")
	fmt.Println("Line 1")
	defer fmt.Println("Line 2")
	defer fmt.Println("Line 3")
	fmt.Println("Line 4")
}

func funcDefer2() {
	// De fer takes argements at the time when the defer statement was called.
	// The below code will print "This" and not "That"
	// This is because a was "This" when the Print statement was defered
	a := "This"
	defer fmt.Println(a)
	a = "That"
}

func funcPanic() {
	fmt.Println("Working with panic")
	defer fmt.Println("Line 1")
	fmt.Println("Line 2")
	// Pending defer statements are executed before panic
	panic("Nothing else should run")
	// This defer is after the panic. So won't run.
	defer fmt.Println("Line 3")
	fmt.Println("Line 4")
}
