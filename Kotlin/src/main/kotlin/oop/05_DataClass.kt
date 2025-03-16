package oop

// Data Classes are used to hold data and don't do much else
// You can implement the same in a normal class and also a data class

class Book (val title: String, val author: String, val year: Int, var price: Double) {

}

data class DataBook(val title: String, val author: String, val year: Int, var price: Double) {
    // data classes cannot be abstract or open
}

fun main() {
    // Lets create objects from both classes and see the difference
    val book = Book("Book1", "John Doe", 1999, 19.99)
    val dataBook = DataBook("Book1", "John Doe", 1999, 19.99)

    println(book)
    // This will just print the memory address from the package/class - oop.Book@3b6eb2ec
    println(dataBook)
    // This will print the property values - DataBook(title=Book1, author=John Doe, year=1999, price=19.99)

    // data classes also make it easier to compare
    val dataBook2 = DataBook("Book1", "John Doe", 1999, 19.99)
    println(dataBook.equals(dataBook2))
    // This won't work with regular classes since the object only shows the memory address.

    // You can also copy a data class object and change specific properties
    val dataBook3 = dataBook.copy(price = 20.99)
    println(dataBook3)

    // You can also decompose an object's properties into separate variables easily
    val (title, author, year, price) = dataBook
    println("The book \"$title\" authored by $author was published in $year and costs $$price")

    // To create a set object with multiple data set objects
    val set = hashSetOf(dataBook, dataBook2, dataBook3)
    // Here, although dataBook and dataBook2 are the same, the set will only contain one copy of it since it doesn't allow duplicates
    println(set)
}