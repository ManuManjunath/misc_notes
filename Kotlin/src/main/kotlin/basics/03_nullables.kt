package basics

fun main() {
    // Nullables
    var name :String = "Manu"
    // name = null --> Compilation error. Null cannot be a value of non-null type string
    var nullableName : String? = "Manu"
    nullableName = null
    println(nullableName)
    // To use nullable variables, use "?" -
    var len = nullableName?.length
    println(len)
    // Elvis Operator
    // To assign a nullable value to a non nullable variable -
    nullableName = null
    name = nullableName ?: "Guest"
    // This means, if the nullable value is null, it'll use the default "Guest".
    // If not, it'll use the value from the nullable variable.
    println(name)

    // Use ? for a safe call
    println(nullableName?.length)
    // This will show the length if its not null and will return null of the string is null

    // If you're sure the variable cannot be null and want a null pointer exception if its null, use !!
    var test: String?
    test = null
    // This will give you NullPointerException
    // println(test!!.length)

}