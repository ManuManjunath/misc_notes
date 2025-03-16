package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(500)
        println("world")
    }
    print("Hello, ")

    someWork()
}

suspend fun someWork() {
    delay(1000)
}
