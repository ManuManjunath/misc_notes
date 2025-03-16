fun main() {
    // Inline function copies the parameters & higher order functions to the call site
    inline { println("Calling inline function")}

}

inline fun inline(fn: () -> Unit) {
    fn()
    println("Inside inline function")

}