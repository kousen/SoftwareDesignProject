package edu.trincoll.hr

// The HR class should have:
//   - a list of employees
//   - a hire method that takes an employee and returns a new HR object with that employee added
//   - a fire method that takes an id and returns a new HR object with the employee with that id removed
//   - a payEmployees method that returns the total pay of all employees
class HR(private val employees: List<Employee> = emptyList()) {
    fun hire(employee: Employee): HR =
        HR(employees + employee)

    fun fire(id: Int): HR =
        HR(employees.filter { it.id != id })

    fun payEmployees(): Double {
        employees.forEach { it.pay() }
        return employees.sumOf { it.pay() }
    }
}