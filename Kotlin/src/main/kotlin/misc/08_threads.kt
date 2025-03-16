package misc

import kotlin.concurrent.thread

fun main() { // executes in main thread

    println("Starting main program running in thread: ${Thread.currentThread().name}")

    // Create a background worker thread
   thread {
       println("Starting background thread: ${Thread.currentThread().name}")
       Thread.sleep(2000)
       println("Ending background thread: ${Thread.currentThread().name}")
   }

    // Creating another thread
    thread {
        println("Starting another background thread: ${Thread.currentThread().name}")
        Thread.sleep(500)
        println("Ending another background thread: ${Thread.currentThread().name}")
    }

    println("Ending main program running in thread: ${Thread.currentThread().name}")

}

/*
Output -
---------
Starting main program running in thread: main
Starting background thread: Thread-0
Ending main program running in thread: main
Starting another background thread: Thread-1
Ending another background thread: Thread-1
Ending background thread: Thread-0

Process finished with exit code 0
*/