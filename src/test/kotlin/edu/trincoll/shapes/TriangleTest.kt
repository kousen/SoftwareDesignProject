package edu.trincoll.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.sqrt

class TriangleTest {

    @Test
    fun `test right triangle area calculation`() {
        val triangle = Triangle(3.0, 4.0, 5.0)
        assertEquals(6.0, triangle.area(), 0.001, "Right triangle area calculation is incorrect")
    }

    @Test
    fun `test right triangle perimeter calculation`() {
        val triangle = Triangle(3.0, 4.0, 5.0)
        assertEquals(12.0, triangle.perimeter(), 0.001, "Right triangle perimeter calculation is incorrect")
    }

    @Test
    fun `test isosceles triangle calculations`() {
        val triangle = Triangle(5.0, 5.0, 6.0)
        assertAll(
            { assertEquals(16.0, triangle.perimeter(), 0.001, "Isosceles triangle perimeter calculation is incorrect") },
            { assertEquals(12.0, triangle.area(), 0.001, "Isosceles triangle area calculation is incorrect") }
        )
    }

    @Test
    fun `test equilateral triangle calculations`() {
        val side = 5.0
        val triangle = Triangle(side, side, side)
        val expectedPerimeter = 3 * side
        val expectedArea = (sqrt(3.0) / 4) * side * side
        assertAll(
            { assertEquals(expectedPerimeter, triangle.perimeter(), 0.001, "Equilateral triangle perimeter calculation is incorrect") },
            { assertEquals(expectedArea, triangle.area(), 0.001, "Equilateral triangle area calculation is incorrect") }
        )
    }

    @Test
    fun `test invalid triangle creation`() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(1.0, 1.0, 3.0)
        }
    }

    @Test
    fun `test triangle toString`() {
        val triangle = Triangle(3.0, 4.0, 5.0)
        assertEquals("Triangle(a=3.0, b=4.0, c=5.0)", triangle.toString(), "toString output is incorrect")
    }
}