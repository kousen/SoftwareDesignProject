package edu.trincoll.hr.solutions

import kotlin.test.*

class SalariedTest {
    @Test
    fun `test salaried employee pay calculation`() {
        val employee = Salaried("Alice", 1, 52000.0)
        assertCloseTo(2000.0, employee.pay())
    }

    @Test
    fun `test salaried employee toString`() {
        val employee = Salaried("Bob", 2, 65000.0)
        assertEquals("Salaried(name=Bob, id=2, salary=65000.0)", employee.toString())
    }

    @Test
    fun `test salaried employee with very high salary`() {
        val employee = Salaried("Charlie", 3, 1000000.0)
        assertCloseTo(38461.54, employee.pay())
    }

    @Test
    fun `test salaried employee with very low salary`() {
        val employee = Salaried("David", 4, 20800.0)  // Minimum wage equivalent
        assertCloseTo(800.0, employee.pay())
    }
}
