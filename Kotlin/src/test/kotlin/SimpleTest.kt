import coroutines.someWork
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertEquals

class SimpleTest {

    @Test
    fun firstTest() {
        // someWork()
        assertEquals(2, 1+1)
    }

    @Test
    fun secondTest() = runBlocking {
        someWork()
        assertEquals(2, 1+1)
    }
}