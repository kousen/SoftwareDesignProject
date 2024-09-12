class Demo {
    fun whenDemo() {
        for (i in 1..10) {
            var answer =
                when (i % 3) {
                    0 -> "$i is divisible by 3"
                    1 -> "$i % 3 = 1"
                    2 -> "$i % 3 = 2"
                    else -> "Houston, we have a problem..."
                }
            println(answer)
        }
    }


}

fun main() {
    val demo = Demo()
    demo.whenDemo()
}
