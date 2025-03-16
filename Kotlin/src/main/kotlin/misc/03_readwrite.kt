package misc

import java.io.File
import java.io.PrintWriter

fun main() {
    val filename = "readwrite2.txt"
    var fileObject = File(filename)


    // Check if file exists
    if (fileObject.exists()) {
        println("$filename exists")
    } else {
        println("File does not exist.")
    }

    // Create a new file
    val isNewFileCreated: Boolean = fileObject.createNewFile()
    if (isNewFileCreated) {
        println("New file created successfully")
    } else {
        println("File already exists")
    }

    // Try creating a file that already exists
    val isFileCreated: Boolean = fileObject.createNewFile()
    if (isFileCreated) {
        println("New file created successfully")
    } else {
        println("You just created the file. It already exists")
    }

    // Write to the file
    // Any existing file will be overwritten
    fileObject.writeText("Adding line #1")
    // fileObject.writeBytes() is used to write an array of bytes
    // Append to the file
    fileObject.appendText("\nAdding line #2")
    // Another way to write is to use PrintWriter on the file instead of the file object
    val writer = PrintWriter(filename)
    writer.append("\nAdding line using PrintWriter")
    // You should also close the PrintWriter
    writer.close()
    // Another way to use PrintWriter using fileObject
    fileObject.printWriter().use {out ->
        out.println("Another way of adding text using printWriter")
        out.println("Adding a 2nd line")
    }

    // Read the file
    // readText() gets the entire content of the file as a string
    var content: String = fileObject.readText()
    println(content)
    // using forEachLine.
    fileObject.forEachLine {
        println(it)
    }
    // With line number
    var lineNum = 0
    fileObject.forEachLine {
        lineNum++
        println("#$lineNum: $it")
    }
    // Adding lines to an arrayList
    var arLst = arrayListOf<String>()
    fileObject.forEachLine {
        arLst.add(it)
    }
    println(arLst)




}