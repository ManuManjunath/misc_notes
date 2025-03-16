package main

import (
  "fmt"
  "time"
)

func main() {
  // To test the simple switch
  fmt.Println(simpleswitch())
  // To test fallthrough - fallthroughs are not recommended
  fmt.Println(flthru())
}

func simpleswitch() string {
  // the type in <switch> and <case> have to match
  switch time.Now().Weekday() {
  case time.Saturday:
    return "Its a Saturday"
  case time.Sunday:
    return "Its a Sunday"
  default:
    return "Its a weekday"
  }
}
// Switch exits the block after finding a match by default.
// If you want to run the case after the 1st matching case, use fallthrough

func flthru() string{
  a := 88
  switch {
  case a > 50:
    fmt.Println("a is in the top 50%")
    fallthrough
  case a > 75:
    fmt.Println("a is in the top 75%")
    // fallthrough
  case a > 90:
    fmt.Println("a is in the top 90%")
  default:
    fmt.Println("a has some unknown score")
  }
  return "fallthrough WIP"
}
