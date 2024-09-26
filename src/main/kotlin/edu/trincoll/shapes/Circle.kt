package edu.trincoll.shapes

import kotlin.math.PI
import kotlin.require

class Circle(val radius: Double) : Shape(), Drawable {

    init {
        require(radius > 0) { "Radius must be positive" }
    }

    override fun area() = PI * radius * radius
    override fun perimeter() = 2 * PI * radius

    override fun draw() = println("Drawing a circle with radius $radius")

    override fun getBoundingBox() = Pair(2 * radius, 2 * radius)

    override fun toString() = "Circle(radius=$radius)"
}