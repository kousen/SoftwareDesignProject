package edu.trincoll.jsonplaceholder

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.serialization.Serializable

@Serializable
data class UserPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

class JsonPlaceholderService {
    private val baseUrl = "https://jsonplaceholder.typicode.com"
    private val client = HttpClient(CIO)

    suspend fun getPost(id: Int): UserPost {
        val response = client.get("$baseUrl/posts/$id")
        return response.body<UserPost>()
    }

    fun getPosts(): List<UserPost> {
        return listOf(UserPost(1, 1000, "title", "body"))
    }


    fun addPost(post: UserPost): UserPost {
        return UserPost(1, 1000, "title", "body")
    }

    fun updatePost(post: UserPost): UserPost {
        return UserPost(1, 1000, "original title", "original body")
    }

    fun deletePost(id: Int): Boolean {
        return false
    }
}