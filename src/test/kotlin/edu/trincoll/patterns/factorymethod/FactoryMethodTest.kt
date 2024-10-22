package edu.trincoll.patterns.factorymethod

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class FactoryMethodTest {

    @Test
    fun `create rectangular point`() {
        val pointFromFM = rectangularPoint(3.0, 4.0)
        println(pointFromFM)
        assertAll(
            { assertEquals(3.0, pointFromFM.x, 0.0001) },
            { assertEquals(4.0, pointFromFM.y, 0.0001) }
        )
    }

    @Test
    fun `create polar point`() {
        val polarPoint = polarPoint(1.0, Math.PI / 2)
        println(polarPoint)
        assertAll(
            { assertEquals(0.0, polarPoint.x, 0.0001) },
            { assertEquals(1.0, polarPoint.y, 0.0001) }
        )
    }
}