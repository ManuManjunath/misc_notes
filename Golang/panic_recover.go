package main

import (
	"fmt"
	"log"
)

func main() {
	fmt.Println("start")
	panicRecover()
	fmt.Println("end")
}

func panicRecover() {
	fmt.Println("about to panic")
	// Using an anonymous function to recover the panic
	// Before the function ends, this defer statement recovers and logs the error
	defer func() {
		// recovers are only useful inside defer because they're executed after panic
		if err := recover(); err != nil {
			// Logging the error instead of failing the program
			log.Println("Error: ", err)
			// If you want the function to end and also not run the rest of the commands even from ther main function -
			// panic(err)
		}

	}()
	panic("panic - something bad happened")
	// The below line won't run because the function has panicked.
	fmt.Println("Done with panic")
	// Now goes back to run the rest of the commands from the main function - Println("end") - unless panic(err) is added to the defer func
}
