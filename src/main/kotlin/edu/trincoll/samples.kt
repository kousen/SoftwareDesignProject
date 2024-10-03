package edu.trincoll

fun main() {
    val pair = Pair(1, "abc")
    val (first, second) = pair // destructuring
    println("First element of the pair: $first")
    println("Second element of the pair: $second")
    println(pair)

    // extension function "to"
    val other = 2.to("def")
    // infix function
    val yetAnother = 3 to "ghi"
    println(other)
    println(yetAnother)
    assert(other.toString() == "(2, def)")

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    for ((key, value) in map) {
        println("Key: $key, Value: $value")
    }
}