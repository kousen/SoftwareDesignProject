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

class AstroService {
    fun getAstroResponse(): AstroResponse {
        val url = "http://api.open-notify.org/astros.json"
        val json = URL(url).readText()
        return Json.decodeFromString<AstroResponse>(json)
    }
}
