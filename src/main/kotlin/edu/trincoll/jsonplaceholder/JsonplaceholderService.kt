package edu.trincoll.jsonplaceholder

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
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

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getPosts() =
        client.get("$baseUrl/posts") {
            accept(ContentType.Application.Json)
        }.body<List<BlogPost>>()

    suspend fun getPost(index: Int) =
        client.get("$baseUrl/posts/$index") {
            accept(ContentType.Application.Json)
        }.body<BlogPost>()

    suspend fun insertPost(post: BlogPost) =
        client.post("$baseUrl/posts") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            setBody(post)
        }.body<BlogPost>()
}

