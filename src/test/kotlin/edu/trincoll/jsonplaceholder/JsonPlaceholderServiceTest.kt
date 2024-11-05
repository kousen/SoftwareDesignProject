package edu.trincoll.jsonplaceholder

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JsonPlaceholderServiceTest {
    private val service = JsonPlaceholderService()

    @Test
    fun `check getPost`() {
        runBlocking {
            val post = service.getPost(1)
            println(post)
            assertEquals(1, post.id)
        }
    }

    @Test
    fun `check getPosts`() {
        val posts = service.getPosts()
        println(posts)
        assertEquals(100, posts.size)
    }

    @Test
    fun `check addPost`() {
        val post = UserPost(1, 1, "title", "body")
        val newPost = service.addPost(post)
        println(newPost)
        assertEquals(101, newPost.id)
    }

    @Test
    fun `check updatePost`() {
        val post = UserPost(1, 1, "title", "body")
        val updatedPost = service.updatePost(post)
        println(updatedPost)
        assertEquals("title", updatedPost.title)
        assertEquals("body", updatedPost.body)
    }

    @Test
    fun `check deletePost`() {
        val result = service.deletePost(1)
        println(result)
        assertEquals(99, service.getPosts().size)
    }

}