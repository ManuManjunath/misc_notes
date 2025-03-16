package misc

import java.io.File

fun main() {
    val filename = "ips.txt"
    val fileObject = File(filename)
    var ipCount: MutableMap<String, Int> = mutableMapOf()
    if (!fileObject.exists()) {
        println("File does not exist")
    } else {
        fileObject.forEachLine {
            val oldVal = ipCount.getOrDefault(it, 0)
            ipCount[it] = oldVal + 1
        }
        var maxIp:String = ipCount.keys.first()
        var maxVal = 0
        for ((key, value) in ipCount.entries) {
            if (value > maxVal) {
                maxVal = value
                maxIp = key
            }
        }
        println("$maxIp is the most frequent IP address with $maxVal occurrences")

        // You can also do this -
        var (maxIp2, maxVal2) = ipCount.entries.maxByOrNull { it.value }!!
        println("$maxIp2 is the most frequent IP address with $maxVal2 occurrences")
    }
}