package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        // runWithGlobalScope()
        // println("runWithGlobalScope returned")
        /*
        Order of output is not consistent
        Function returns without finishing complete work
            Launch 1
            runWithGlobalScope finished
            runWithGlobalScope returned
            Launch 2
        */
        runWithLocalScope()
        println("runWithLocalScope returned")
        /*
        Output order is always consistent. Function returns after completing all sub coroutines
            Launch 1
            Launch 2
            runWithLocalScopeFinished
            runWithLocalScope returned
        */

        /*
        To create your own scope, use:
        lateint var scopeName: CoroutineScope
        scopeName = MainScope()
        scopeName.launch {
            // add code here
        }
        When you want to close the scope, use:
        scopeName.cancel()
        */
    }
}

suspend fun runWithGlobalScope() {
    GlobalScope.launch {
        println("Launch 1")
        delay(1000)
    }
    GlobalScope.launch {
        println("Launch 2")
        delay(2000)
    }
    println("runWithGlobalScope finished")
}

suspend fun runWithLocalScope() {
    coroutineScope {
        launch {
            println("Launch 1")
            delay(1000)
        }
        launch {
            println("Launch 2")
            delay(2000)
        }
    }
    println("runWithLocalScopeFinished")
}
