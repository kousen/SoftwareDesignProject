class Demo {
    fun whenDemo() {
        for (i in 1..10) {
            val answer =
                when (i % 3) {
                    0 -> "$i is divisible by 3"
                    1 -> "$i % 3 = 1"
                    2 -> "$i % 3 = 2"
                    else -> "Houston, we have a problem..."
                }
            println(answer)
        }
    }

    fun foldDemo() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val sum = numbers.fold(0) { acc, i ->
            println("acc: $acc, i: $i")
            acc + i
        }
        println(sum)

        "PWND".fold("") { acc, c ->
            println("acc: $acc, c: $c")
            "$acc$acc$c"
        }
    }
}

val isEvenLambda = { i: Int -> i % 2 == 0 }

fun main() {
    val demo = Demo()
    demo.foldDemo()
}
