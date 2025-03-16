package main

import (
  "fmt"
)

func main() {
  // Arrays can have elements only of the same type and are of fixed length.
  // Index starts from 0
  var arr1 [5]int
  // Default value is 0
  arr1[2] = 10
  fmt.Println("Array1 is", arr1)


  // Slices are built on top of arrays and are pointers to the elements in the underlying array.
  // They have to be consecutive elements from the underlying array.
  // You can add/remove elements from a Slice.
  // Changing the value of a slice element updates it in the underlying array.
  slc1 := make([]string, 5, 10)
  // Parameters - type, length, capacity
  // Slices never store data.
  fmt.Println("Slice 1 is a slice of length ", len(slc1), "and capacity ", cap(slc1))
  fmt.Println("But its empty - ", slc1)

  // Another way to create a slice -
  slc2 := []string{"One", "Two", "Three", "Four", "Five"}
  fmt.Println("Slice 2 is ", slc2)
  fmt.Println("Slice 2 is a slice of length ", len(slc2), "and capacity ", cap(slc2))

  // Now add an item
  slc2 = append(slc2, "Six")
  fmt.Println("Added a new element", slc2)
  fmt.Println("Now the length and capacity of Slice 2 changed to ", len(slc2), cap(slc2))

  // Edit a value
  slc2[5] = "Seven"
  fmt.Println("6th element of Slice 2 modified. ", slc2)

  // Slice of slice
  slc3 := slc2[2:5]
  // This uses elements from position 2 until 4 (5-1)
  // if slc3 := slc2[:5] --> This implies the 1st value as index 0
  // if slc3 := slc2[2:] --> This implies the last value as the last index
  fmt.Println("Sliced slice is", slc3)

  // Add a slice to a slice
  slc4 := []string{"Thirty", "ThirtyOne", "ThirtyTwo"}
  slc2 = append(slc2, slc4...)
  fmt.Println("Slice 2 after adding another slice", slc2)

  // Remove something - say "Four"
  // to remove index i --> slice = append(slice[:i], slice[i+1:]...)
  slc2 = append(slc2[:3], slc2[4:]...)
  fmt.Println("After removing the 4th element -", slc2)

  // Multi dimensional slice
  // WIP
}
