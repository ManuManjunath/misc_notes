package main

import (
	"fmt"
)

func main() {
	var x int
	var y int
	var oper string
	fnct := map[string]func(int, int) float64{
		"add":      addition,
		"subtract": subtraction,
		"multiply": multiplication,
		"divide":   division,
	}
	fmt.Println("What operation do you want to perform?")
	fmt.Println("Possible options - add, subtract, multiply, divide")
	fmt.Scan(&oper)
	fmt.Println("Enter 2 numbers")
	fmt.Scan(&x, &y)
	result := fnct[oper](x, y)
	fmt.Println(result)

}

func addition(a, b int) float64 {
	return float64(a + b)
}

func subtraction(a, b int) float64 {
	return float64(a - b)
}

func multiplication(a, b int) float64 {
	return float64(a * b)
}

func division(a, b int) float64 {
	if b == 0 {
		return 0.0
	}
	return float64(a / b)
}
