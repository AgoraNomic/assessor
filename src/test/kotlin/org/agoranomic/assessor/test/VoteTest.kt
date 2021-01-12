package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.voting_strength.*
import org.junit.jupiter.api.DisplayName
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("VotingStrength test")
class VotingStrengthTest {
    @Test
    fun `VotingStrength zero() works`() {
        assertEquals(VotingStrength.zero().raw, BigInteger.ZERO)
    }

    @Test
    fun `VotingStrength math works`() {
        assertEquals(VotingStrength(4) + VotingStrengthDifference(3), VotingStrength(7))
        assertEquals(VotingStrength(4) - VotingStrength(3), VotingStrengthDifference(1))
        assertEquals(VotingStrengthDifference(3) * 2, VotingStrengthDifference(6))
        assertEquals(2 * VotingStrengthDifference(4), VotingStrengthDifference(8))
    }

    @Test
    fun `VotingStrength comparsion works`() {
        val first = VotingStrength(3)

        assertTrue(first == first)
        assertFalse(first < first)
        assertTrue(first <= first)
        assertFalse(first > first)
        assertTrue(first >= first)

        val second = VotingStrength(4)

        assertFalse(first == second)
        assertTrue(first < second)
        assertTrue(first <= second)
        assertFalse(first > second)
        assertFalse(first >= second)
    }
}
