package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.CappedVotingStrengthMap
import org.agoranomic.assessor.lib.SimpleVotingStrengthMap
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.VotingStrengthWithComment
import org.junit.jupiter.api.DisplayName
import org.agoranomic.assessor.test.test_objects.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

@DisplayName("CappedVotingStrengthMap test")
class CappedVotingStrengthMapTest {
    @Test
    fun `constructor throws if min less than max`() {
        val baseMap = SimpleVotingStrengthMap(defaultStrength = firstTestVotingStrength(), strengthMap = emptyMap())

        val badMin = VotingStrength(42)
        val badMax = VotingStrength(8)

        assertFailsWith<IllegalArgumentException> {
            CappedVotingStrengthMap(
                base = baseMap,
                min = badMin,
                max = badMax
            )
        }
    }

    @Test
    fun `constructor throws if base map has invalid default`() {
        val min = VotingStrength(3)
        val max = VotingStrength(5)

        // An invalid strength is one that is not between min and max
        for (invalidStrength in listOf(VotingStrength(0), VotingStrength(12))) {
            val baseMap = SimpleVotingStrengthMap(defaultStrength = invalidStrength, strengthMap = emptyMap())

            assertFailsWith<IllegalArgumentException> {
                CappedVotingStrengthMap(
                    base = baseMap,
                    min = min,
                    max = max
                )
            }
        }
    }

    @Test
    fun `defaultStrength is same as base`() {
        val min = VotingStrength(8)
        val max = VotingStrength(42)
        val baseDefault = VotingStrength(20) // In between min and max

        val baseMap = SimpleVotingStrengthMap(defaultStrength = baseDefault, strengthMap = emptyMap())

        val cappedMap = CappedVotingStrengthMap(
            base = baseMap,
            min = min,
            max = max
        )

        assertEquals(baseDefault, cappedMap.defaultStrength)
    }

    @Test
    fun `specialPeople is same as base`() {
        val min = VotingStrength(8)
        val max = VotingStrength(42)
        val baseDefault = VotingStrength(20) // In between min and max

        val baseMap = SimpleVotingStrengthMap(
            defaultStrength = baseDefault,
            strengthMap = mapOf(
                firstTestPlayer() to firstTestVotingStrengthWithComment(),
                secondTestPlayer() to secondTestVotingStrengthWithComment()
            )
        )

        val cappedMap = CappedVotingStrengthMap(
            base = baseMap,
            min = min,
            max = max
        )

        assertEquals(baseMap.specialPeople, cappedMap.specialPeople)
    }

    @Test
    fun `getOrNull behaves correctly`() {
        for (useMin in listOf(false, true)) {
            for (useMax in listOf(false, true)) {
                val min = VotingStrength(8)
                val max = VotingStrength(42)

                val baseDefault = VotingStrength(20) // In between min and max

                val belowMinStrength = VotingStrength(0)
                val belowMinPlayer = testPlayer(0)
                val belowMinExpected = if (useMin) min else belowMinStrength

                val normalStrength = VotingStrength(25)
                val normalPlayer = testPlayer(1)

                val aboveMaxStrength = VotingStrength(99)
                val aboveMaxPlayer = testPlayer(2)
                val aboveMaxExpected = if (useMax) max else aboveMaxStrength

                val notInBasePlayer = testPlayer(3)

                val baseMap = SimpleVotingStrengthMap(
                    defaultStrength = baseDefault,
                    strengthMap = mapOf(
                        belowMinPlayer to VotingStrengthWithComment(belowMinStrength),
                        normalPlayer to VotingStrengthWithComment(normalStrength),
                        aboveMaxPlayer to VotingStrengthWithComment(aboveMaxStrength)
                    )
                )

                val cappedMap = CappedVotingStrengthMap(
                    base = baseMap,
                    min = if (useMin) min else null,
                    max = if (useMax) max else null
                )

                // Second test player is not in base map, so result should be null
                assertNull(cappedMap.getOrNull(notInBasePlayer))
                assertEquals(baseMap.getOrNull(normalPlayer), cappedMap.getOrNull(normalPlayer))

                assertEquals(belowMinExpected, cappedMap.getOrNull(belowMinPlayer)!!.value)
                assertEquals(aboveMaxExpected, cappedMap.getOrNull(aboveMaxPlayer)!!.value)
            }
        }
    }
}
