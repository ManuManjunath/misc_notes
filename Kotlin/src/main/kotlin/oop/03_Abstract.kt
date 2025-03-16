package oop

import java.util.*

abstract class Human2(open val name: String, open var age: Int) {
    // You can create objects out of the parent open class.
    // If you don't want to, declare them as abstract class.
    // Additionally, any parent class method you want to use, should also be declared as an abstract method

    init {
        println("Object initialized")
    }

    // You can define 3 types of methods - open, abstract or neither

    fun getYearOfBirth() = Calendar.getInstance().get(Calendar.YEAR) - age
    // Since the above method is neither open not abstract, you cannot implement this in the child classes

    // Suppose the implementation of a particular method is different for different child classes, declare them as abstract
    // These need to have a mandatory override in the child classes
    abstract fun speak(): String
    // Abstract methods and class are also implicitly open.

    // If you want optional implementation of the abstract class methods in child classes, declare them as open methods.
    open fun something() {
        println("Just for testing open methods in an abstract class")
    }
    // This is implemented in Student2 but not in Employee2

}

// Now lets use the above parent (abstract class) similar to the open class
class Student2(override val name: String, override var age: Int, val school: String): Human2(name, age) {

    fun studentDetails(): String {
        return "$name is $age years old and is studying in $school"
    }

    // To use the abstract method from the parent class, use override
    override fun speak(): String {
        // overridden methods are also implicitly open
        // Meaning, they can be further overridden in grand-child classes
        // If you don't want to allow further overriding, specify it as final -
        // override final fun speak()
        return "Hi! I'm a student"
    }
    // Note that it will error without implementing the abstract method from the parent class.

    override fun something() {
        // Here you can either show the same return statement from the parent class by using super.method()
        // super.something()
        // Or override the return statement
        // println("Overriding the parent return statement")

        // If you want to extend the method from the parent class - meaning show parent's result and also show something else, do this
        super.something()
        println("Adding to super")
    }
}

class Employee2(override val name: String, override var age: Int, val company: String): Human2(name, age) {
    fun employeeDetails(): String {
        return "$name is $age years old and is working in $company"
    }

    // All parent abstract methods have to be overridden and implemented in the child classes
    override fun speak(): String {
        return "Hi! I'm an employee"
    }

    // Note that we do NOT have an implementation of the optional open method - something here
}

fun main() {
    var student2 = Student2(name = "Stu2", age = 20, school = "Some school")
    println(student2.studentDetails())
    // You can use abstract methods from parent's class
    println(student2.speak())
    // You can also use the methods which are not declared as abstract in the parent class
    println(student2.getYearOfBirth())
    println(student2.something())

    var employee2 = Employee2(name = "Empl2", age = 35, company = "Some company")
    println(employee2.employeeDetails())

    // However, you cannot use the parent class as an object anymore like belowx
    // person2 = Human2(name = "ABCD", age = "100")

}
