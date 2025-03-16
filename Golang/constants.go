package main
// Constants are like variables but cannot change values.
// No shorthand method to declare and initialize (:=)

import (
  "fmt"
  "os"
)

func main() {
  const yearOfBirth = 1988
  // Will fail if you un-comment the below line
  // yearOfBirth = yearOfBirth + 1
  fmt.Println(yearOfBirth)
}
