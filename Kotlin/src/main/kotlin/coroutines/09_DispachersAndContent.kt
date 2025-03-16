package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

val scope = CoroutineScope(Job())

// To create a new dispatcher:
val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher() // Returns a coroutine dispatcher
val executor = Executors.newFixedThreadPool(5)

fun main() = runBlocking {
    // Different dispatchers: Default, Main, IO, Other
    val jobs = arrayListOf<Job>()

    jobs += launch { // Default context
        println("Default: In thread ${Thread.currentThread().name}")
        // Default: In thread main
        // The default context is using the Main thread - Same thread as the Main function.
    }
    jobs += launch(Dispatchers.Default) { // Default context
        // println("defaultDispatcher: In thread ${Thread.currentThread().name}")
        showDetails("defaultDispatcher")
        // defaultDispatcher: In thread DefaultDispatcher-worker-1
    }
    jobs += launch(Dispatchers.IO) { //IO context
        // println("IO Dispatcher: In thread ${Thread.currentThread().name}")
        showDetails("IO dispatcher")
        // IO Dispatcher: In thread DefaultDispatcher-worker-2
        // Also uses the DefaultDispatcher
    }
    jobs += launch(Dispatchers.Unconfined) { // not-confined. Will work with th main thread
        // println("Unconfined: In thread ${Thread.currentThread().name}")
        showDetails("Unconfined")
        // Unconfined: In thread main
    }
    jobs += launch(newSingleThreadContext("OwnThread")) { // It will launch all the coroutines on its own thread and they'll run one after the other
        // println("newSTC: In thread ${Thread.currentThread().name}")
        showDetails("new STC")
    }
    jobs += launch(dispatcher) { // Will get dispatched to ForkJoinPool.commonPool (Or equivalent)
        // println("Cached thread pool: In thread ${Thread.currentThread().name}")
        showDetails("Cached thread pool")
    }
    jobs += launch(executor.asCoroutineDispatcher()) { // Will get dispatched to ForkJoinPool.commonPool (Or equivalent)
        // println("Fixed thread pool: In thread: ${Thread.currentThread().name}") // Fixed thread pool of size 5
        showDetails("Fixed thread pool")
    }

    jobs.forEach { it.join() }

    // If you don't shut down the services, the main thread will never end
    executor.shutdown()
    dispatcher.close()

    // Code running in the Default dispatcher runs last
}

suspend fun showDetails(dispatcherName: String) {
    // This will show what threads are being used
    // println("Dispatcher: $dispatcherName & Thread: ${Thread.currentThread().name}")

    // You can override the dispatcher using withContext
    withContext(Dispatchers.IO) {
        println("Dispatcher: $dispatcherName & Thread: ${Thread.currentThread().name}")
    }
    // This will show that all of them are running on the DefaultDispatcher-worker thread (using IO dispatcher)

}
