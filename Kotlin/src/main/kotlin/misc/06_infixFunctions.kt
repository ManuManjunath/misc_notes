package misc

class SWEng() {
    var skill: String? = null

    fun showSkills(): String {
        return "$skill"
    }
}

// This is similar to an extension function but you'll be able to use the fun name as a keyword
infix fun SWEng.plus(sw: SWEng): SWEng {
    val newSWEng = SWEng()
    newSWEng.skill = this.skill + ", " + sw.skill
    return newSWEng
}

fun main() {
    val sw1 = SWEng()
    sw1.skill = "Kotlin"
    println(sw1.showSkills())

    val sw2 = SWEng()
    sw2.skill = "Java"
    println(sw2.showSkills())

    var sw3 = sw1 plus sw2 plus sw1
    // The "plus" above is the infix function
    println(sw3.showSkills())
}