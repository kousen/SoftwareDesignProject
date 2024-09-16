package edu.trincoll.hr

class Salaried(
    name: String,
    id: Int,
    val salary: Double
) : Employee(name, id) {

    override fun pay() = salary / 26.0  // paid every two weeks

    override fun toString() = "Salaried(name=$name, id=$id, salary=$salary)"
}