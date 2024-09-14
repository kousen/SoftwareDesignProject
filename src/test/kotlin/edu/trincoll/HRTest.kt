package edu.trincoll

import kotlin.test.*

class HRTest {

    private val salariedEmployee1 = Salaried("Alice", 1, 52000.0)
    private val salariedEmployee2 = Salaried("Bob", 2, 65000.0)
    private val hourlyEmployee1 = Hourly("Charlie", 3, 25.0, 80.0)
    private val hourlyEmployee2 = Hourly("David", 4, 30.0, 75.0)

    @Test
    fun `test hiring and paying employees`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(hourlyEmployee1)

        assertCloseTo(4000.0, hr.payEmployees())
    }

    @Test
    fun `test firing an employee`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(hourlyEmployee1)
            .fire(1)

        assertCloseTo(2000.0, hr.payEmployees())
    }

    @Test
    fun `test finding an employee`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(hourlyEmployee1)

        assertEquals(salariedEmployee1, hr.findEmployee(1))
        assertNull(hr.findEmployee(5))
    }

    @Test
    fun `test listing employees`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(hourlyEmployee1)

        assertEquals(listOf(salariedEmployee1, hourlyEmployee1), hr.listEmployees())
    }

    @Test
    fun `test counting employees`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(hourlyEmployee1)

        assertEquals(2, hr.countEmployees())
    }

    @Test
    fun `test total salary expense`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(salariedEmployee2)
            .hire(hourlyEmployee1)
            .hire(hourlyEmployee2)

        val expectedExpense =
            52000.0 + 65000.0 + (25.0 * 80.0 * 26) + (30.0 * 75.0 * 26)
        assertCloseTo(expectedExpense / 26.0, hr.totalSalaryExpense())
    }

    @Test
    fun `test average salary`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(salariedEmployee2)
            .hire(hourlyEmployee1)
            .hire(hourlyEmployee2)

        val expectedAverage = (52000.0/26 + 65000.0/26 + (25.0 * 80.0) + (30.0 * 75.0)) / 4
        assertCloseTo(expectedAverage, hr.averageSalary())
    }

    @Test
    fun `test employees by type`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(salariedEmployee2)
            .hire(hourlyEmployee1)
            .hire(hourlyEmployee2)

        val employeesByType = hr.employeesByType()
        assertEquals(2, employeesByType["Salaried"]?.size)
        assertEquals(2, employeesByType["Hourly"]?.size)
    }

    @Test
    fun `test highest paid employee`() {
        val hr = HR()
            .hire(salariedEmployee1)
            .hire(salariedEmployee2)
            .hire(hourlyEmployee1)
            .hire(hourlyEmployee2)

        assertEquals(salariedEmployee2, hr.highestPaidEmployee())
    }

    @Test
    fun `test empty HR`() {
        val hr = HR()

        assertEquals(0.0, hr.payEmployees())
        assertEquals(0, hr.countEmployees())
        assertNull(hr.highestPaidEmployee())
        assertEquals(0.0, hr.averageSalary())
        assertTrue(hr.listEmployees().isEmpty())
    }
}