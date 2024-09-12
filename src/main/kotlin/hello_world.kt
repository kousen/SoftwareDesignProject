fun start(): String = "OK"

fun main() {
    assert(start() == "OK")

    val x = "Hello, world!"
    println("The string is ${x.length}")
}