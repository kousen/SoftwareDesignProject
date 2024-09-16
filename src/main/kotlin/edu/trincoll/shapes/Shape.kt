package edu.trincoll.shapes

abstract class Shape : Comparable<Shape> {
    abstract fun area(): Double
    abstract fun perimeter(): Double

    override fun compareTo(other: Shape) =
        this.area().compareTo(other.area())
}
