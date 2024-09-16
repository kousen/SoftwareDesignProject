package edu.trincoll.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RectangleTest {

    @Test
    fun `test rectangle area calculation`() {
        val rectangle = Rectangle(4.0, 5.0)
        assertEquals(20.0, rectangle.area(), 0.001, "Rectangle area calculation is incorrect")
    }

    @Test
    fun `test rectangle perimeter calculation`() {
        val rectangle = Rectangle(4.0, 5.0)
        assertEquals(18.0, rectangle.perimeter(), 0.001, "Rectangle perimeter calculation is incorrect")
    }

    @Test
    fun `test rectangle bounding box`() {
        val rectangle = Rectangle(4.0, 5.0)
        val (width, height) = rectangle.getBoundingBox()
        assertAll(
            { assertEquals(4.0, width, 0.001, "Bounding box width is incorrect") },
            { assertEquals(5.0, height, 0.001, "Bounding box height is incorrect") }
        )
    }

    @ParameterizedTest
    @CsvSource("0.0,5.0", "4.0,0.0", "-1.0,5.0", "4.0,-1.0")
    fun `test rectangle creation with invalid dimensions`(width: Double, height: Double) {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(width, height)
        }
    }

    @Test
    fun `test rectangle toString`() {
        val rectangle = Rectangle(4.0, 5.0)
        assertEquals("Rectangle(width=4.0, height=5.0)", rectangle.toString(), "toString output is incorrect")
    }

    @Test
    fun `test square creation`() {
        val square = Rectangle(5.0, 5.0)
        assertAll(
            { assertEquals(25.0, square.area(), 0.001, "Square area calculation is incorrect") },
            { assertEquals(20.0, square.perimeter(), 0.001, "Square perimeter calculation is incorrect") }
        )
    }
}