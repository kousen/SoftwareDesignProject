package edu.trincoll.astro

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AstroTest {
    private val service = AstroService()

    @Test
    fun `check astro response`() {
        val response = service.getAstroResponse()
        assertTrue(response.number >= 0)
        assertEquals("success", response.message)
        assertEquals(response.number, response.people.size)
        println("There are ${response.number} astronauts in space right now.")
        response.people.forEach {
            println("${it.name} is on board the ${it.craft}.")
        }
    }
}