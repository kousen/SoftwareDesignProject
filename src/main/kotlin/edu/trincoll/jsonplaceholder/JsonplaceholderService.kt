package edu.trincoll.jsonplaceholder

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class BlogPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

class JsonplaceholderService {
    private val baseUrl = "https://jsonplaceholder.typicode.com"
    private val client = HttpClient(CIO)

    suspend fun getBlogPosts(): List<BlogPost> {
        val httpResponse = client.get("$baseUrl/posts")
        val posts = Json.decodeFromString<List<BlogPost>>(httpResponse.body())
        client.close()
        return posts
    }

    suspend fun getBlogPost(index: Int): BlogPost {
        val httpResponse = client.get("$baseUrl/posts/$index")
        val post = Json.decodeFromString<BlogPost>(httpResponse.body())
        client.close()
        return post
    }
}

