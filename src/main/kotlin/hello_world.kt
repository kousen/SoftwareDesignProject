import java.time.LocalDate
import java.time.Month

fun start(): String = "OK"

fun main() {
    assert(start() == "OK")

    val x = "Hello, world!"
    println("The string is ${x.length}")

    val p1 = Person("Aleem", LocalDate.of(2004, Month.FEBRUARY, 14))
    val p2 = Person("Aleem", LocalDate.of(2004, Month.FEBRUARY, 14))
    println(p1 == p2)

    val (n, a) = p1 // destructuring
    println("Name: $n, Age: $a")

    val p3 = p1.copy(name = "Somebody")
    println(p3)
}

data class Person(val name: String, val dob: LocalDate) {
    fun age(): Int {
        return LocalDate.now().year - dob.year
    }
}