package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        // delay(500)
        println("coroutines")
    }
    print("Hello, ")
    job.join()
    // Use join on the job rather than adding delay(xxx)
}
