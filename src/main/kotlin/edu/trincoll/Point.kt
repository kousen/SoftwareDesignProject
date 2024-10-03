package edu.trincoll

class Point(
    val x: Double,
    val y: Double
) {

    fun rectangularPoint(x: Double, y: Double): Point {
        return Point(x, y)
    }
}

fun main() {
    val point = Point(3.0, 4.0)
    println(point.rectangularPoint(3.0, 4.0))
}