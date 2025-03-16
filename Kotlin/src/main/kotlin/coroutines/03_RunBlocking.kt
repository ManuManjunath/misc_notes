package coroutines

import kotlinx.coroutines.*
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main() = runBlocking {
    launch {
        delay(500)
        println("coroutines")
    }
    print("Hello, ")
    //Thread.sleep(1000)
    // runBlocking will exit after it has completed the coroutine
}