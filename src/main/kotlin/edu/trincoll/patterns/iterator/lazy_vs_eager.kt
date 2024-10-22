package edu.trincoll.patterns.iterator

fun externalIterator() {
    val list = listOf(1, 2, 3, 4, 5)
    val iterator = list.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
}

fun externalIteratorForInLoop() {
    val list = listOf(1, 2, 3, 4, 5)
    for (i in list) {
        println(i)
    }
}

fun internalIterator() {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach { println(it) }
}

fun eager() {
    val list = listOf(1, 2, 3, 4, 5)
    list.map { it * 2 }
        .filter { it > 5 }
        .forEach { println(it) }

    println("eager")

    val list2 = listOf(1, 2, 3, 4, 5)
    var factor = 2
    val result = list2.map { it * factor }
    factor = 0
    result.forEach(::println)
}

fun lazy() {
    val list = listOf(1, 2, 3, 4, 5)
    list.asSequence()
        .map { it * 2 }
        .filter { it > 5 }
        .forEach { println(it) }

    println("lazy")

    val list2 = listOf(1, 2, 3, 4, 5).asSequence()
    var factor = 2
    val result = list2.map { it * factor }
    factor = 0
    result.forEach(::println)
}

fun main() {
    externalIterator()
    externalIteratorForInLoop()
    internalIterator()
    eager()
    lazy()
}
