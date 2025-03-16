package basics

import java.util.*
import java.util.Arrays.fill

fun main() {
    // Use an array if you know the number of elements and its not going to change.
    val days = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    // Arrays can also store different data types
    val mixed = arrayOf("Name", 1, false, 3.14F)
    // If you want to specify the data type in an array, you can use the below
    val intArr = intArrayOf(1, 2, 3, 4)
    val fltArr = floatArrayOf(3.14F, 5.5F, 8.0F)
    // You can concatenate 2 arrays of same type
    val months = arrayOf("Jan", "Feb", "Mar")
    val daysMonths = days + months
    val intArr2 = intArrayOf(5, 6, 7, 8)
    // Not so easy to print an array with its elements
    println(months.contentToString())
    // Another option is to iport java.utils.Arrays
    println(Arrays.toString(daysMonths))
    // Concatenate arrays of integers
    println((intArr + intArr2).contentToString())
    // To see the size (length) of an array
    println(daysMonths.size)
    // To check if an array is empty
    println(daysMonths.isEmpty())
    // To check if an array contains a specific element
    println(daysMonths.contains("Feb"))
    // To print specific elements
    println(mixed[1])
    println(fltArr[2])
    println(months.last())
    // To get the index of an element
    println(intArr.indexOf(4))
    // To create an array filled with the same value
    val newArr = IntArray(5).apply {fill(10)}
    println(newArr.contentToString())

    // Use lists if you want to basics.add / delete elements from the collection
    val nums = listOf(1, 2, 3, 4)
    // This creates an immutable list?
    // Its easier to print list
    println(nums)
    // Using index
    for ((i, v)in nums.withIndex()) {
        println("$v is in $i position")
    }

    // Use arrayList
    val arlst = arrayListOf(1, 2, 3, 4)
    // This internally stores the elements in an array and resizes is necessary
    // To basics.add an element
    arlst.add(5)
    // To basics.add an element at a specific index
    arlst.add(2, 50)
    // To reassign an element by index
    arlst[0] = 0
    // To delete an element by value
    arlst.remove(3)
    // To delete an element by index
    arlst.removeAt(0)
    val arlst2 = arrayListOf(100, 200, 300, false, "testing")
    // Use + to concatenate
    // Unlike arrays, you can concatenate lists with different data type
    println(arlst + arlst2)

    // Sublists
    val lst = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
    val sublst = lst.subList(2, 5)
    // This will create a sublist from 2nd position till the 5th position.
    // 5th is excluded
    println(sublst)

    // Sets - Unordered list without duplicates
    var set1 = mutableSetOf("A", "B", "C")
    if (set1.add("C")) {
        println("Added C to the set")
    } else {
        println("Unable to basics.add C because its already present")
    }



}