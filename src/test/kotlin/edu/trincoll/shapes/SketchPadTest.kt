package edu.trincoll.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.PI

class SketchPadTest {

    private val sketchPad = SketchPad().apply {
        addShape(Circle(5.0))
        addShape(Rectangle(4.0, 6.0))
        addShape(Triangle(3.0, 4.0, 5.0))
    }

    @Test
    fun `test paper size calculation`() {
        val (width, height) = sketchPad.calculateRequiredPaperSize()
        assertAll(
            { assertEquals(10.0, width, 0.001,
                "Width calculation is incorrect") },
            { assertEquals(10.0, height, 0.001,
                "Height calculation is incorrect") }
        )
    }

    @Test
    fun `test ink usage calculation`() {
        val circlePerimeter = 2 * PI * 5
        val rectanglePerimeter = 2 * (4 + 6)
        val trianglePerimeter = 3 + 4 + 5
        val expectedTotalInkUsage = circlePerimeter + rectanglePerimeter + trianglePerimeter
        assertEquals(expectedTotalInkUsage, sketchPad.getTotalInkUsed(),
            0.001, "Ink usage calculation is incorrect")
    }

    @Test
    fun `test shapes sorted by area`() {
        val sortedShapes = sketchPad.getShapesSortedByArea()
        assertAll(
            { assertTrue(sortedShapes[0] is Triangle, "First shape should be Triangle") },
            { assertTrue(sortedShapes[1] is Rectangle, "Second shape should be Rectangle") },
            { assertTrue(sortedShapes[2] is Circle, "Third shape should be Circle") }
        )
    }

    @Test
    fun `test drawing all shapes`() {
        assertDoesNotThrow { sketchPad.draw() }
    }

    @Test
    fun `test total area calculation`() {
        val circleArea = PI * 5 * 5
        val rectangleArea = 4 * 6
        val triangleArea = 6.0  // Area of a 3-4-5 right triangle
        val expectedTotalArea = circleArea + rectangleArea + triangleArea
        assertEquals(expectedTotalArea, sketchPad.totalArea(), 0.001,
            "Total area calculation is incorrect")
    }
}