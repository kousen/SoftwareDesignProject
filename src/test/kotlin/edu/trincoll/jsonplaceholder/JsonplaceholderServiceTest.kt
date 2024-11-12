package edu.trincoll.jsonplaceholder

import io.ktor.client.call.body
import io.ktor.http.isSuccess
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class JsonplaceholderServiceTest {
    private val service = JsonPlaceholderService()

    @Test
    fun `all posts`() {
        runBlocking {
            val posts = service.getPosts()
            assertEquals(100, posts.size)
        }
    }

    companion object {
        @JvmStatic
        fun blogPostIndices() = (1..100).toList()
    }

    @ParameterizedTest(name = "post {0}")
    @MethodSource("blogPostIndices")
    fun `each blog post`(index: Int) {
        runBlocking {
            val response = service.getPost(index)
            assertTrue(response.status.isSuccess())
            val post = response.body<BlogPost>()
            assertAll(
                // { assertTrue(post.userId > 0) },
                { assertEquals(index, post.id) },
                { assertTrue(post.title.isNotBlank()) },
                { assertTrue(post.body.isNotBlank()) },
            )
        }
    }

    @Test
    fun `insert blog post`() {
        runBlocking {
            val post = BlogPost( 101, "Test Post", "This is a test post.")
            val response = service.insertPost(post)
            assertEquals(201, response.status.value)
            assertEquals(post, response.body())
        }
    }

    @Test
    fun `update blog post`() {
        runBlocking {
            val post = BlogPost(1, "Test Post", "This is a test post.")
            val response = service.updatePost(post)
            assertEquals(post, response)
        }
    }

    @Test
    fun `delete blog post`() {
        runBlocking {
            val response = service.deletePost(1)
            assertEquals(200, response.status.value)
        }
    }

}