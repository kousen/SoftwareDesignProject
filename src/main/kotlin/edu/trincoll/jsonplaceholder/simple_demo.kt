package edu.trincoll.jsonplaceholder

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get

suspend fun main() {
    val baseUrl = "https://jsonplaceholder.typicode.com"
    // URL("$baseUrl/posts").readText().also { println(it) }

    val client = HttpClient(CIO)
    val httpResponse = client.get("$baseUrl/posts")
    println(httpResponse.status)
    client.close()
}