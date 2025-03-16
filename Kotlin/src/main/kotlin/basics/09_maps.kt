package basics

fun main() {
    // Use mapOf(Pair(key, value)) format
    // You can mix different data types
    val map1 = mapOf(Pair("Manu Manjunath", 33), Pair("John Doe", 45), Pair("Jane Doe", "Forty"), Pair(10, true))
    // You can also use mapOf(<key> to <value>) format
    val map2 = mapOf("Manu Manjunath" to 33, "John Doe" to 45, "Jane Doe" to "Forty", 10 to true)

    // Compare 2 maps -
    println(map1 == map2)
    // Get a list of all keys and values
    println(map2.keys)
    println(map2.values)
    // Get a list of key-value mapping
    println(map2.entries)

    // Get specific values
    println(map1["Manu Manjunath"])

    // Create a mutable map if you want to update values
    var map3 = mutableMapOf(Pair("Manu Manjunath", 33), Pair("John Doe", 45), Pair("Jane Doe", 40))
    map3["John Doe"] = 46
    // Delete specific key-value pairs
    map3.remove("Jane Doe")
    println(map3)
    // To add a new entry
    map3["New User"] = 314
    // or map3.put("New User", 314)
    // Add if key does not exist
    map3.putIfAbsent("Jane Doe", 315)
    println(map3)
    // Check if key exists
    println(map3.contains("Manu Manjunath"))
    // Check if value exists
    println(map3.containsValue(315))
    // Get a default value if key does not exist
    println(map3.get("Manu Manjunath"))
    println(map3.getOrDefault("Manjunath Manu", -1))

    // Looping through a map
    map3.entries.forEach {
        println("${it.key} is mapped to ${it.value}")
    }
}