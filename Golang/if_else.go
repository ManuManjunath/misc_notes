package main

import (
  "fmt"
)

func main() {
  a := 90
  b := 85

  if a > b {
    fmt.Println("a > b")
  } else if a < b {
    fmt.Println("b > a")
  } else {
    fmt.Println("a = b ")
  }
  fmt.Println(another(a, b))
}

// with simple initialization statements
// Here <b, a := 90, 85> is applicable only inside the if/else block
func another(x, y int) string {
  // Here we see that the parameters are ignored as a & b have different values within the IF-ELSE block
  if b, a := 90, 85; a > b {
    return "a > b"
  } else if a < b {
      return "b > a"
  } else {
        return "a = b"
  }
}
// IF runs from top to bottom.
// Exits a block once a condition is matched.
