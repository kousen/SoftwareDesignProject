package edu.trincoll.hr

class Hourly (
    name: String,
    id: Int,
    val rate: Double,
    val hours: Double = 80.0  // paid every two weeks
) : Employee(name, id) {

    override fun pay() = rate * hours

    override fun toString() =
        "Hourly(name=$name, id=$id, rate=$rate, hours=$hours)"
}