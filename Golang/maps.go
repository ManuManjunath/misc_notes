package main

// similar to dictionaries in Python - unordered list of keys and values
import (
  "fmt"
)
func main() {
  mp1 := make(map[string]int)
  mp1["triangle"] = 3
  mp1["rectangle"] = 4
  mp1["pentagon"] = 5
  mp1["hexagon"] = 6
  mp1["heptagon"] = 7

  fmt.Println(mp1)
  // To view the value for a spoecific key -
  fmt.Println(mp1["triangle"])

  // Another way to create a map -
  mp2 := map[string]int {
    "octagon": 8,
    "nonagon": 9,
    "decagon": 10,
    // Add the comma even after the last element
  }
  // To add -
  mp2["line"] = 1
  // To update -
  mp2["line"] = 1000
  // To delete -
  delete(mp2, "line")
  fmt.Println(mp2)

  // To specify an optional size of a map - can imporve performance
  // make(map[keyType]valueType, size)
}
