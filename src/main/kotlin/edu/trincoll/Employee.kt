package edu.trincoll

abstract class Employee(
    val name: String,
    val id: Int
) {
    abstract fun pay(): Double

    override fun toString() = "Employee(name=$name, id=$id)"
}