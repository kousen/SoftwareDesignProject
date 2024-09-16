package edu.trincoll.hr

abstract class Employee(
    val name: String,
    val id: Int
) : Comparable<Employee> {
    abstract fun pay(): Double

    override fun compareTo(other: Employee): Int {
        return compareValuesBy(
            this, other,
            Employee::pay,
            Employee::name,
            Employee::id
        )
    }

    override fun toString() = "Employee(name=$name, id=$id)"
}