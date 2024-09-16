package edu.trincoll.hr

import kotlin.test.Test
import kotlin.test.assertEquals

class EmployeeSortingTest {

    @Test
    fun `test sorting employees with different pay`() {
        val employees = listOf(
            Salaried("Alice", 1, 60000.0),
            Hourly("Bob", 2, 25.0, 80.0),
            Salaried("Charlie", 3, 52000.0)
        )

        val sortedEmployees = employees.sorted()

        assertEquals(listOf("Bob", "Charlie", "Alice"),
            sortedEmployees.map { it.name })
    }

    @Test
    fun `test sorting employees with same pay but different names`() {
        val employees = listOf(
            Salaried("Charlie", 1, 52000.0),
            Salaried("Alice", 2, 52000.0),
            Salaried("Bob", 3, 52000.0)
        )

        val sortedEmployees = employees.sorted()

        assertEquals(listOf("Alice", "Bob", "Charlie"),
            sortedEmployees.map { it.name })
    }

    @Test
    fun `test sorting employees with same pay and name but different IDs`() {
        val employees = listOf(
            Salaried("Alice", 3, 52000.0),
            Salaried("Alice", 1, 52000.0),
            Salaried("Alice", 2, 52000.0)
        )

        val sortedEmployees = employees.sorted()

        assertEquals(listOf(1, 2, 3), sortedEmployees.map { it.id })
    }

    @Test
    fun `test sorting mixed employee types`() {
        val employees = listOf(
            Salaried("Alice", 1, 52000.0),    // 2000 per pay period
            Hourly("Bob", 2, 25.0, 80.0),  // 2000 per pay period
            Salaried("Charlie", 3, 60000.0),  // 2307.69 per pay period
            Hourly("David", 4, 30.0, 70.0)  // 2100 per pay period
        )

        val sortedEmployees = employees.sorted()

        assertEquals(listOf("Alice", "Bob", "David", "Charlie"),
            sortedEmployees.map { it.name })
    }
}