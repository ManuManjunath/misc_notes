package coroutines

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) {
            delay(10)
            print(".")
            // Expecting it to print 1000 dots
        }
    }
    // Instead of letting it run, we'll try to cancel it after 250ms
    // That is enough time for it to print about 25 dots
    delay(250)
    // job.cancel()
    // job.join()
    job.cancelAndJoin()
    println("Done")
}