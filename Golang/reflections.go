package main

import (
	"fmt"
	"reflect"
)

type (
	Person struct {
		Name     string
		Age      int
		Location string
	}
)

func main() {
	var a interface{}
	fmt.Println("Type = ", reflect.ValueOf(a), "and Value = ", reflect.TypeOf(a))
	a = 3.14
	fmt.Println("Type = ", reflect.ValueOf(a), "and Value = ", reflect.TypeOf(a))
	a = 10
	fmt.Println("Type = ", reflect.ValueOf(a), "and Value = ", reflect.TypeOf(a))
	a = 7 + 7i
	fmt.Println("Type = ", reflect.ValueOf(a), "and Value = ", reflect.TypeOf(a))
	var b int
	a = &b
	fmt.Println("Type = ", reflect.ValueOf(a), "and Value = ", reflect.TypeOf(a))

	// kind - category of a type
	i := 10.4
	x := reflect.TypeOf(i)
	if x.Kind() != reflect.Int {
		fmt.Printf("Error: Expecting an Int, but received %v\n", x.Kind())
	} else {
		fmt.Println(i)
	}

	// Tesing with structs
	getStructInfo(3.14)
	getStructInfo(Person{})
}

func getStructInfo(x interface{}) {
	t := reflect.TypeOf(x)
	fmt.Printf("Kind of %v is %v\n", x, t.Kind())
	if t.Kind() != reflect.Struct {
		fmt.Printf("Error: Not a struct\n")
		return
	}

	// NumField returns the number of fields for a struct
	n := t.NumField()
	fmt.Printf("Struct of type %v has %v fields.\n", t, n)
	for i := 0; i < n; i++ {
		tt := t.Field(i)
		fmt.Printf("Field %v: name: %v, type %v\n", i, tt.Name, tt.Type)
	}
}
