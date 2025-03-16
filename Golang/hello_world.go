package main

import (
	"fmt"
	"runtime"
)

func main() {
	fmt.Println("Hello, Go! I'm" ,runtime.GOOS)
}
