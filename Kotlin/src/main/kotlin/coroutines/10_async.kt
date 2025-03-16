package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    withoutAsync()
    // This will take about 200 + 100 ms to complete

    // For it to call both functions together, instead of running them both in their own "lauch", try this
    withAsync()
    // Since this calls both functions together, it runs in just over 200 ms
}

suspend fun doWork1(): Int {
    delay(200)
    println("Working on work #1")
    return 2
}

suspend fun doWork2(): Int {
    delay(100)
    println("Working on work #2")
    return 3
}

fun withoutAsync() = runBlocking {
    val timeTaken = measureTimeMillis {
        val res1 = doWork1()
        val res2 = doWork2()
        println("Result is ${res1 + res2}")
    }
    println("Time taken to run without async is $timeTaken")
}



fun withAsync() = runBlocking {
    val timeTaken = measureTimeMillis {
        val res1 = async { doWork1() }
        val res2 = async { doWork2() }
        println("Result is ${res1.await() + res2.await()}")
    }
    println("Time taken to run without async is $timeTaken")
}
