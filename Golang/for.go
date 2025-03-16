package main

import (
  "fmt"
  "time"
)

func main() {
  timer := 10
  fmt.Println("\nTesting a simple for loop")
  fmt.Println(basic_for(timer))

  fmt.Println("\nFor loop working like while")
  for_like_while()

  fmt.Println("\nTesting for loop on a slice")
  for_slice()

  fmt.Println("\nIterating over a map")
  for_map()

  fmt.Println("\nTesting break statement")
  fmt.Println(break_test(timer))

  // for testing continue
  // WIP - fmt.Println(continue_test())

  fmt.Println("\nTesting a for loop inside another for loop")
  for_in_for()
}

func basic_for(timer int) string {
  // counts down from 10 to 0 after each second
  for i := timer; i >= 0; i-- {
    // The "i--" runs at the end of each iteration
    fmt.Println(i)
    time.Sleep(1 * time.Second)
  }
  return "done"
}

func for_like_while() {
  // To make it work like a while loop -
  i := 0
  for i <= 5 {
    fmt.Println(i)
    i++
  }
  return
}

func for_slice() {
  // Iterating over a slice -
  slc1 := []string{"Apple", "Orange", "Banana", "Strawberry"}
  for index, value := range slc1 {
    fmt.Println("index:", index, "value:", value)
  }
  return
}

func for_map() {
  // Iterating over a map -
  mp1 := map[string]int {"A": 1, "B": 2, "C": 3, "D": 4, "E": 5}

  for key, value := range mp1 {
    fmt.Println("Key is", key, "value is", value)
  }
}

func break_test(timer int) string {
  // Similar to basic_for but breaks after 5
  for i := timer ; i >= 0 ; i -- {
    if i < 5 {
      break
    }
    fmt.Println(i)
    time.Sleep(1 * time.Second)
  }
  return "break at 5"
}
/*
func continue_test() {

}
*/
func for_in_for() {
  even := []int{2, 4, 6, 8, 10}
  prime := []int{2, 3, 5, 7, 11}

  for _, e := range even {
    for _, p := range prime {
      if e == p {
        fmt.Println(e, "is both even and prime")
      }
    }
  }
}
