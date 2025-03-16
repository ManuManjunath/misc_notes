package oop

class School (var nm: String ) {
    var name: String = nm
    var city: String = ""

    constructor(name: String, city: String): this(name) {
        // Pass the Class' main paramater in this
        this.city = city
    }

    fun learn() {
        println("You can learn in $name if you live in $city")
    }
}

fun main() {
    var sch1 = School("Some School", "Bangalore")
    sch1.learn()
}