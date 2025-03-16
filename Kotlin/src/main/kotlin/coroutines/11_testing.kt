package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    withoutAsync2()
    // This will take about 200 + 100 ms to complete

    // For it to call both functions together, instead of running them both in their own "lauch", try this
    withAsync2()
    // Since this calls both functions together, it runs in just over 200 ms
}

suspend fun doubltThis1(): Pair<Int, Boolean> {
    delay(2000)
    println("Working on work #1")
    return Pair(2, true)
}

suspend fun doubleThis2(): Pair<Int, Boolean> {
    delay(3000)
    println("Working on work #2")
    return Pair(2, true)
}

fun withoutAsync2() = runBlocking {
    val timeTaken = measureTimeMillis {
        val (a, b) = doubltThis1()
        val (c, d) = doubleThis2()
        println("Result is ${a + c}. Booleans: $b & $d")
    }
    println("Time taken to run without async is $timeTaken")
}



fun withAsync2() = runBlocking {
    val timeTaken = measureTimeMillis {
        val deferredPair1 = async { doubltThis1() }
        val deferredPair2 = async { doubleThis2() }
        val (a, b) = deferredPair1.await()
        val(c, d) = deferredPair2.await()
        println("Result is ${a + c}. Booleans: $b & $d")
    }
    println("Time taken to run without async is $timeTaken")
}
