package main
// Structs allow us to define our own custom data types - a collection of fields

import (
  "fmt"
)

func main() {
  // Create a struct with the "type" keyword
  type person struct {
    name string
    age int
    gender string
  }

  // To declare variables to the person type -
  // var Person1 person
  // or you can also say -
  // Person1 := new(person) // This also creates a pointer
  // The above steps initializes the person type with 0 values
  Person1 := person{
    name: "Manu Manjunath",
    age: 32,
    gender: "M",
  }
  fmt.Println(Person1)
  // To view specific attributes -
  fmt.Println(Person1.age)

  // To change a value -
  Person1.age = 33
  fmt.Println(Person1.age)
}
