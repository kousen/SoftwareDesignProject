package edu.trincoll.hr.solutions

import kotlin.math.abs
import kotlin.test.assertTrue

fun assertCloseTo(expected: Double, actual: Double, precision: Double = 0.01) {
    assertTrue(
        abs(expected - actual) <= precision,
        "Expected $expected to be close to $actual within precision $precision, but was not."
    )
}