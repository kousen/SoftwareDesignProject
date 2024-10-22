package edu.trincoll.hr.solutions

abstract class Employee(
    val name: String,
    val id: Int
) : Comparable<Employee> {
    abstract fun pay(): Double

    override fun compareTo(other: Employee): Int {
        return compareValuesBy(
            this, other,
            { it.pay() },
            { it.name },
            { it.id }
        )
    }

    override fun toString() = "Employee(name=$name, id=$id)"
}