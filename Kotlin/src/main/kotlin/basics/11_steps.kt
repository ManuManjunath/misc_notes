package basics

fun main() {
    for (x in 1..10 step 2) {
        // Considers every 2nd element
        println(x)
    }

    for (x in 20 downTo 1 step 5) {
        // Considers every 5th element
        println(x)
    }
}