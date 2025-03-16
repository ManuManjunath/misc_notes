package oop

import java.util.*

open class Human(open val name: String, open var age: Int) {
    // use open keyword to open the class for inheritance so it can be used by other classes.
    // open the class and all the properties

    init {
        println("Object initialized")
    }

    fun getYearOfBirth() = Calendar.getInstance().get(Calendar.YEAR) - age

    fun greet(name: String): String {
        return "Hello $name"
    }
}

// Now use Human class for student
class Student(override val name: String, override var age: Int, val school: String): Human(name, age) {
    // Note that you can have additional properties in the child class

    fun studentDetails(): String {
        return "$name is $age years old and is studying in $school"
    }

}

class Employee(override val name: String, override var age: Int, val company: String): Human(name, age) {
    fun employeeDetails(): String {
        return "$name is $age years old and is working in $company"
    }
}

fun main() {
    var student1 = Student(name = "Stu1", age = 20, school = "Some school")
    println(student1.studentDetails())
    // You can also use methods used in the parent class
    println(student1.greet("friends"))

    var employee1 = Employee("Empl", 33, "Some company")
    println(employee1.employeeDetails())
    // You can also use methods used in the parent class
    println(employee1.greet("colleagues"))

    val person = Human("Abc", 25)
    println(person.getYearOfBirth())
}