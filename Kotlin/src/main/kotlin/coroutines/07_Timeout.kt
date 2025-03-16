package coroutines

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

fun main() = runBlocking {
    val job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()
            print(".")
            Thread.sleep(1)
            // This job is expected to take (1000 * 1)ms but times out after 100ms
        }
    }
    if (job == null) {
        println("Timed out")
    }
}