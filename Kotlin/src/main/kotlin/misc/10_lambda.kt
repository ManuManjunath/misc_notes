fun main() {
    // lambda functions have no name and defined inside {  }
    // { variable: Type -> body }

    val isEven = {a: Int -> a % 2 == 0}
    println(isEven(10))
}