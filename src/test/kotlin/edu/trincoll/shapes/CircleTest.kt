package edu.trincoll.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.PI

class CircleTest {
    @Test
    fun `test circle radius`() {
        val circle = Circle(5.0)
        assertEquals(5.0, circle.radius, 0.001, "Circle radius is incorrect")
    }

    @Test
    fun `test circle area calculation`() {
        val circle = Circle(5.0)
        assertEquals(PI * 25, circle.area(), 0.001, "Circle area calculation is incorrect")
    }

    @Test
    fun `test circle perimeter calculation`() {
        val circle = Circle(5.0)
        assertEquals(2 * PI * 5, circle.perimeter(), 0.001, "Circle perimeter calculation is incorrect")
    }

    @Test
    fun `test circle bounding box`() {
        val circle = Circle(5.0)
        val (width, height) = circle.getBoundingBox()
        assertAll(
            { assertEquals(10.0, width, 0.001, "Bounding box width is incorrect") },
            { assertEquals(10.0, height, 0.001, "Bounding box height is incorrect") }
        )
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, -1.0, -5.0])
    fun `test circle creation with invalid radius`(radius: Double) {
        assertThrows(IllegalArgumentException::class.java) {
            Circle(radius)
        }
    }

    @Test
    fun `test circle toString`() {
        val circle = Circle(5.0)
        assertEquals("Circle(radius=5.0)", circle.toString(), "toString output is incorrect")
    }
}