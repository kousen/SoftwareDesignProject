package edu.trincoll

import org.junit.jupiter.api.Test
import kotlin.math.roundToInt
import kotlin.test.assertEquals

class HourlyTest {
    @Test
    fun `test hourly employee pay calculation`() {
        val employee = HourlyEmployee("Eve", 5, 20.0, 80.0)
        assertEquals(1600.0, employee.pay().roundToTwoDecimals())
    }

    @Test
    fun `test hourly employee toString`() {
        val employee = HourlyEmployee("Frank", 6, 25.0, 75.0)
        assertEquals("HourlyEmployee(name=Frank, id=6, rate=25.0, hours=75.0)", employee.toString())
    }

    @Test
    fun `test hourly employee with overtime`() {
        val employee = HourlyEmployee("Grace", 7, 20.0, 100.0)  // Assuming no overtime pay for simplicity
        assertEquals(2000.0, employee.pay().roundToTwoDecimals())
    }

    @Test
    fun `test hourly employee with very low hours`() {
        val employee = HourlyEmployee("Henry", 8, 15.0, 10.0)
        assertEquals(150.0, employee.pay().roundToTwoDecimals())
    }

    @Test
    fun `test hourly employee with default hours`() {
        val employee = HourlyEmployee("Ivy", 9, 18.0)  // Using default 80.0 hours
        assertEquals(1440.0, employee.pay().roundToTwoDecimals())
    }
}

// Helper function to round to two decimal places
private fun Double.roundToTwoDecimals(): Double {
    return (this * 100).roundToInt() / 100.0
}
