package edu.trincoll.jsonplaceholder

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable

@Serializable
data class BlogPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

class JsonplaceholderService {
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    suspend fun getPosts(): List<BlogPost> =
        HttpClient(CIO) {
            install(ContentNegotiation) { json() }
        }.use { client ->
            client.get("$baseUrl/posts") {
                accept(ContentType.Application.Json)
            }.body()
        }

    suspend fun getPost(index: Int): HttpResponse =
        HttpClient(CIO) {
            install(ContentNegotiation) { json() }
        }.use { client ->
            client.get("$baseUrl/posts/$index") {
                accept(ContentType.Application.Json)
            }
        }

    suspend fun insertPost(post: BlogPost): HttpResponse =
        HttpClient(CIO) {
            install(ContentNegotiation) { json() }
        }.use { client ->
            client.post("$baseUrl/posts") {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                setBody(post)
            }
        }

    // Implement the updatePost method
    suspend fun updatePost(post: BlogPost): BlogPost =
        HttpClient(CIO) {
            install(ContentNegotiation) { json() }
        }.use { client ->
            client.put("$baseUrl/posts/${post.id}") {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                setBody(post)
            }.body()
        }

    // Implement the deletePost method
    suspend fun deletePost(index: Int): HttpResponse =
        HttpClient(CIO).use { client ->
            client.delete("$baseUrl/posts/$index")
        }
}

