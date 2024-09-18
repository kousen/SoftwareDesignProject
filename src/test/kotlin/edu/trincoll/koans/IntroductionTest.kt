package edu.trincoll.koans

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class IntroductionTest {

    // Hello, World!
    @Test
    fun testStart() {
        assertEquals("OK", start())
    }

    // Named arguments
    @Test
    fun joinOptions() {
        assertEquals("[yes, no, may be]", joinOptions(listOf("yes", "no", "may be")))
    }

    // Default arguments
    @Test
    fun testDefaultAndNamedParams() {
        assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }

    // Triple-quoted strings
    @Test
    fun getTripleQuotedString() {
        assertEquals(
            """question = "life, the universe, and everything"
answer = 42""", tripleQuotedString
        )
    }

    // String templates
    private fun testMatch(date: String) =
        assertTrue(date.matches(getPattern().toRegex()), "The pattern should match $date")

    @Suppress("SameParameterValue")
    private fun testMismatch(date: String) =
        assertFalse(date.matches(getPattern().toRegex()), "The pattern shouldn't match $date")

    @Test
    fun match() {
        testMatch("11 MAR 1952")
    }

    @Test
    fun match1() {
        testMatch("24 AUG 1957")
    }

    @Test
    fun doNotMatch() {
        testMismatch("24 RRR 1957")
    }

    // Nullable types
    private fun testSendMessageToClient(
        client: Client?,
        message: String?,
        expectedEmail: String? = null,
        shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                assertEquals(expectedMessage, message, "The message is not as expected:")
                assertEquals(expectedEmail, email, "The email is not as expected:")
            }
        })
        assertEquals(shouldBeInvoked, invoked,
            "The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked")
    }

    @Test
    fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
            "Hi Bob! We have an awesome proposition for you...",
            "bob@gmail.com",
            true)
    }

    @Test
    fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test
    fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }

    // Nothing type
    private fun testAge(age: Int) {
        val e: IllegalArgumentException? = try {
            checkAge(age)
            null
        } catch (e: IllegalArgumentException) {
            e
        }
        assertNotNull(e,
            "Expected IllegalArgumentException for 'checkAge($age)'")
    }

    @Test
    fun testNegative() = testAge(-10)

    @Test
    fun testLargeNumber() = testAge(200)

    // Lambdas
    @Test
    fun contains() {
        assertTrue(containsEven(listOf(1, 2, 3, 126, 555)),
            "The result should be true if the collection contains an even number")
    }

    @Test
    fun notContains() {
        assertFalse(containsEven(listOf(43, 33)),
            "The result should be false if the collection doesn't contain an even number")
    }
}