package edu.trincoll.koans

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClassesTest {
    // Data classes
    @Test
    fun testListOfPeople() {
        assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]",
            getPeople().toString(),
            "The class Person is implemented incorrectly\n")
    }

    @Test
    fun testComparePeople() {
        assertTrue(comparePeople(),
            "'comparePeople' function should return true")
    }

    // Smart casts
    @Test
    fun testNum() {
        assertEquals(2, evalSmartCasts(Num(2)),
            "'eval' on Num(2) works incorrectly\n")
    }

    @Test
    fun testSum() {
        assertEquals(3, evalSmartCasts(Sum(Num(2), Num(1))),
            "'eval' on Sum(Num(2), Num(1)) works incorrectly\n")
    }

    @Test
    fun testRecursion() {
        assertEquals(6, evalSmartCasts(Sum(Sum(Num(1), Num(2)), Num(3))),
            "'eval' on Sum(Sum(Num(1), Num(2)), Num(3)) works incorrectly\n", )
    }

    // Sealed classes
    @Test
    fun testNumSealed() {
        assertEquals(2, eval(Num(2)),
            "'eval' on Num(2) works incorrectly\n")
    }

    @Test
    fun testSumSealed() {
        assertEquals(3, eval(Sum(Num(2), Num(1))),
            "'eval' on Sum(Num(2), Num(1)) works incorrectly\n")
    }

    @Test
    fun testRecursionSealed() {
        assertEquals(6, eval(Sum(Sum(Num(1), Num(2)), Num(3))),
            "'eval' on Sum(Sum(Num(1), Num(2)), Num(3)) works incorrectly\n", )
    }

    @Test
    fun testRandom() {
        val string = useDifferentRandomClasses()
        assertTrue(
            setOf('0', '1').any { it in string },
            "The string should contain random numbers 0 or 1\n$string")
    }

    // Extension functions
    @Test
    fun testIntExtension() {
        assertEquals(RationalNumber(4, 1), 4.r(),
            "Rational number creation error: ")
    }

    @Test
    fun testPairExtension() {
        assertEquals(RationalNumber(2, 3), Pair(2, 3).r(),
            "Rational number creation error: ")
    }
}