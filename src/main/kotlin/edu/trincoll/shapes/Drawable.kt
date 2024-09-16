package edu.trincoll.shapes

interface Drawable {
    fun draw()
    fun getBoundingBox(): Pair<Double, Double>  // width, height
}
