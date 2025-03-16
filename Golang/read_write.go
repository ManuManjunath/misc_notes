package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func main() {
	// Write to a new file
	file, err := os.Create("read_write.txt")
	if err != nil {
		fmt.Printf("Error: %v \n", err.Error())
	} else {
		text, err := file.WriteString("Writing line #1")
		if err != nil {
			fmt.Printf("Error: %v \n", err.Error())
		} else {
			fmt.Printf("%v bytes written successfully \n", text)
		}
		file.Close()
	}

	// Append lines to file
	file, err = os.OpenFile("read_write.txt", os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0777)
	if err != nil {
		fmt.Println("Error: %v", err.Error())
	} else {
		text2, err := file.WriteString("\nAppending line #2")
		if err != nil {
			fmt.Println("Error: %v", err.Error())
		} else {
			fmt.Printf("%v bytes written successfully \n", text2)
		}
		file.Close()
	}

	// Read from file
	read, err := ioutil.ReadFile("read_write.txt")
	if err != nil {
		fmt.Printf("Error : %v \n", err.Error())
	} else {
		fmt.Println("Reading file contents - ")
		fmt.Println(string(read))
	}
}
