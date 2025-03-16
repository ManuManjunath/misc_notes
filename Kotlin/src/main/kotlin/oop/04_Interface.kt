package oop

// An interface defines a set of methods which each of its implementing classes have to offer
// Its like an abstract class where every method is abstract
interface Drivable {
    // All methods and properties defined in an interface are implicitly abstract
    fun drive(): String

    fun commonName()
}

interface MaxSpeed {
    fun getMaxSpeed(): Int

    // You can also have properties in Interfaces, which the child classes have to implement.
    val makeYear: Int
    // But their value cannot be initialised like this -
    // val makeYear: Int = 2010

    fun commonName() {
        println("Method from MaxSpeed interface")
    }
}

class Car(val colour: String): Drivable {
    // Use <: parent class name> at the end of class, similar to using open and abstract classes.
    // <: Drivable> in this example

    // Now you have to use the method defined in the parent Interface
    override fun drive(): String {
        return "Driving a $colour car"
    }

    override fun commonName() {
        println("From Drivable interface")
    }
}

// You an also use multiple parent Interfaces (which is not possible with open/abstract classes)
class Bike(val colour: String): Drivable, MaxSpeed {
    override fun drive(): String {
        return "Riding a $colour bike"
    }

    override fun getMaxSpeed(): Int {
        return 100
    }

    // Also implement the mandatory property from the parent interface
    override val makeYear = 2010

    override fun commonName() {
        super<MaxSpeed>.commonName()
        println("testing")
    }
}

fun main() {
    val car = Car("red")
    println(car.drive())

    val bike = Bike("blue")
    println(bike.drive())
    println("Max speed of bike is " + bike.getMaxSpeed() + ". It was built in " + bike.makeYear)

    println(bike.commonName())

    // You can also define properties using the parent Interface.
    val vehicle: Drivable = Bike("black")
    // Now, you can only use methods from the Drivable interface, although Bike has methods fromMaxSpeed interface too.
    println(vehicle.drive())
    // But you cannot use vehicle.getMaxSpeed() or vehicle.makeYear since they are defined in another interface

    val vehicle2: MaxSpeed = Bike("white")
    println("This vehicle was made in " + vehicle2.makeYear + " and its max speed is " + vehicle2.getMaxSpeed())
    // But you cannot use vehicle2.drive() since that is defined in another interface

}