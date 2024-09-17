package edu.trincoll.shapes

import kotlin.math.sqrt

class Triangle(val a: Double, val b: Double, val c: Double) : Shape(), Drawable {
    init {
        require(a > 0 && b > 0 && c > 0) { "All sides must be positive" }
        require(a + b > c && b + c > a && c + a > b)
            { "The sum of any two sides must be greater than the third side" }
    }

    override fun area(): Double {
        val s = (a + b + c) / 2
        return sqrt(s * (s - a) * (s - b) * (s - c))
    }

    override fun perimeter() = a + b + c

    override fun draw() {
        println("Drawing a triangle with sides $a, $b, and $c")
    }

    override fun getBoundingBox(): Pair<Double, Double> {
        // This is an approximation. Accurate bounding box would require more
        // information about the triangle's orientation.
        val s = (a + b + c) / 2
        val area = sqrt(s * (s - a) * (s - b) * (s - c))
        val height = 2 * area / a
        return Pair(a, height)
    }

    override fun toString() = "Triangle(a=$a, b=$b, c=$c)"
}
