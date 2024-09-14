package edu.trincoll

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HourlyTest {
    @Test
    fun `test hourly employee pay calculation`() {
        val employee = Hourly("Eve", 5, 20.0, 80.0)
        assertCloseTo(1600.0, employee.pay())
    }

    @Test
    fun `test hourly employee toString`() {
        val employee = Hourly("Frank", 6, 25.0, 75.0)
        assertEquals("Hourly(name=Frank, id=6, rate=25.0, hours=75.0)", employee.toString())
    }

    @Test
    fun `test hourly employee with overtime`() {
        val employee = Hourly("Grace", 7, 20.0, 100.0)  // Assuming no overtime pay for simplicity
        assertCloseTo(2000.0, employee.pay())
    }

    @Test
    fun `test hourly employee with very low hours`() {
        val employee = Hourly("Henry", 8, 15.0, 10.0)
        assertCloseTo(150.0, employee.pay())
    }

    @Test
    fun `test hourly employee with default hours`() {
        val employee = Hourly("Ivy", 9, 18.0)  // Using default 80.0 hours
        assertCloseTo(1440.0, employee.pay())
    }
}
