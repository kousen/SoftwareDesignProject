package edu.trincoll.jsonplaceholder

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class JsonplaceholderServiceTest {
    private val service = JsonplaceholderService()

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

    //@Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest(name = "post {0}")
    @MethodSource("blogPostIndices")
    fun `each blog post`(index: Int) {
        runBlocking {
            val post = service.getPost(index)
            assertAll(
                { assertTrue(post.userId > 0) },
                { assertEquals(index, post.id) },
                { assertTrue(post.title.isNotBlank()) },
                { assertTrue(post.body.isNotBlank()) },
            )
        }
    }

    @Test
    fun `insert blog post`() {
        runBlocking {
            val post = BlogPost(1, 101, "Test Post", "This is a test post.")
            val response = service.insertPost(post)
            assertEquals(post, response)
        }
    }
}