package edu.trincoll.shapes

class SketchPad {
    private val shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun draw() {
        println("Drawing all shapes on the SketchPad:")
        shapes.forEach { (it as Drawable).draw() }  // cast to Drawable
    }

    fun calculateRequiredPaperSize(): Pair<Double, Double> {
        val maxWidth = shapes.maxOfOrNull { (it as Drawable).getBoundingBox().first } ?: 0.0
        val maxHeight = shapes.maxOfOrNull { (it as Drawable).getBoundingBox().second } ?: 0.0
        return Pair(maxWidth, maxHeight)
    }

    fun getTotalInkUsed() = shapes.sumOf { it.perimeter() }

    fun getShapesSortedByArea() = shapes.sorted()

    // New method to calculate total area
    fun totalArea() = shapes.sumOf { it.area() }
}
