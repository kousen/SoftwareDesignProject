package edu.trincoll.shapes

class Rectangle(val width: Double, val height: Double) : Shape(), Drawable {
    init {
        require(width > 0) { "Width must be positive" }
        require(height > 0) { "Height must be positive" }
    }

    override fun area() = width * height
    override fun perimeter() = 2 * (width + height)

    override fun draw() {
        println("Drawing a rectangle with width $width and height $height")
    }

    override fun getBoundingBox() = Pair(width, height)

    override fun toString() = "Rectangle(width=$width, height=$height)"
}