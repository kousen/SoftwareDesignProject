package edu.trincoll.hr

import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.math.abs

fun assertCloseTo(expected: Double, actual: Double, precision: Double = 0.01) {
    assertTrue(
        abs(expected - actual) <= precision,
        "Expected $expected to be close to $actual within precision $precision, but was not."
    )
}