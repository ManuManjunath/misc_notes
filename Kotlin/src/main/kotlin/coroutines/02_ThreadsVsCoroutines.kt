package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

const val num_tasks = 5000
const val loops = 300
const val wait_ms = 10L

fun main() {
    usingThreads()
    usingCoroutines()

    scalingThreads() // ~30 seconds
    scalingCoroutines() // ~7 seconds
}

fun usingThreads() {
    thread {
        Thread.sleep(500)
        println("threads")
    }
    print("Hello, ")
    Thread.sleep(1000)
}

fun usingCoroutines() {
    GlobalScope.launch {
        delay(500)
        // Delay suspends the coroutine and doesn't block the thread
        println("coroutines")
    }
    print("Hello, ")
    Thread.sleep(1000)
}

fun scalingCoroutines() = runBlocking {
    println("Starting coroutine at ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    val result = AtomicInteger()
    val jobs = mutableListOf<Job>()
    for (task in 1..num_tasks) {
        jobs.add(launch(Dispatchers.IO) {
            for (loop in 1..loops) {
                delay(wait_ms)
            }
        })
    }
    jobs.forEach { it.join() }
    // println(result.get())
    println("Ended coroutine at ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
}

fun scalingThreads() {
    println("Starting thread at ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    val result = AtomicInteger()
    val threads = mutableListOf<Thread>()
    for (task in 1..num_tasks) {
        threads.add(thread {
            for (loop in 1..loops) {
                Thread.sleep(wait_ms)
            }
            result.getAndIncrement()
        })
    }
    threads.forEach { it.join() }
    // println(result.get())
    println("Ended thread at ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
}
