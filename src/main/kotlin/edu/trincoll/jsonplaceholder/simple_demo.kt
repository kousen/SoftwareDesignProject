package edu.trincoll.jsonplaceholder

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class OllamaRequest(
    val model: String,
    val prompt: String,
    val stream: Boolean,
)

@Serializable
data class OllamaResponse(
    val model: String,
    val created_at: String,
    val response: String,
)

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }

    val request = OllamaRequest("llama3.2","Why is the sky blue?", false)
    println(request)
    val response = client.post("http://localhost:11434/api/generate") {
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
        setBody(request)
    }

    println(response.status)
    val body = response.body<OllamaResponse>()
    println("Model: " + body.model)
    println("Created At: " + body.created_at)
    println("Response: " + body.response)
}