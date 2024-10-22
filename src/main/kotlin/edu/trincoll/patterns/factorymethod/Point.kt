package edu.trincoll.patterns.factorymethod

import kotlin.math.cos
import kotlin.math.sin

data class Point(
    val x: Double,
    val y: Double
)

fun rectangularPoint(x: Double, y: Double): Point {
    return Point(x, y)
}

fun polarPoint(r: Double, theta: Double) : Point {
    val x = r * cos(theta)
    val y = r * sin(theta)
    return Point(x,y)
}

fun main() {
    val pointFromFM = rectangularPoint(3.0, 4.0)
    println(pointFromFM)
    val polarPoint = polarPoint(1.0, Math.PI / 2)
    println(polarPoint)
}