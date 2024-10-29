package edu.trincoll.astro

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.URL

@Serializable
data class Assignment(val name: String, val craft: String)

@Serializable
data class AstroResponse(
    val message: String,
    val number: Int,
    val people: List<Assignment>
)

fun main() {
    val url = "http://api.open-notify.org/astros.json"
    val json = URL(url).readText()
    // println(URL("https://trincoll.edu").readText())
    val response = Json.decodeFromString<AstroResponse>(json)
    println("There are ${response.number} astronauts in space right now.")
    response.people.forEach {
        println("${it.name} is on board the ${it.craft}.")
    }
}
