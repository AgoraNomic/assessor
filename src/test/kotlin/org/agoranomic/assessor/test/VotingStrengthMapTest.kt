package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.SimpleVotingStrengthMap
import org.agoranomic.assessor.lib.VotingStrengthWithComment
import org.junit.jupiter.api.DisplayName
import org.agoranomic.assessor.test.test_objects.*
import org.agoranomic.assessor.test.test_util.assertEqualsAndHashCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull

@DisplayName("SimpleVotingStrengthMap test")
class SimpleVotingStrengthMapTest {
    @Test
    fun `defaultStrength is what is passed in constructor`() {
        val default = firstTestVotingStrength()
        val map = SimpleVotingStrengthMap(default, emptyMap())

        assertEquals(default, map.defaultStrength)
    }

    @Test
    fun `specialPeople is the same as keys of map`() {
        val firstPerson = firstTestPerson()
        val secondPerson = secondTestPerson()

        val defaultStrength = firstTestVotingStrength()
        val overrideStrength = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(firstPerson to overrideStrength, secondPerson to overrideStrength)
        )

        assertEquals(setOf(firstPerson, secondPerson), map.specialPeople)
    }

    @Test
    fun `getOrNull returns null for person not in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPerson()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        val otherPerson = secondTestPerson()

        assertNull(map.getOrNull(otherPerson))
    }

    @Test
    fun `getOrNull returns given value for person in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPerson()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        assertEquals(override, map[firstPerson])
    }

    @Test
    fun `get returns default for person not in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPerson()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        val otherPerson = secondTestPerson()

        assertEquals(VotingStrengthWithComment(default), map[otherPerson])
    }

    @Test
    fun `get returns given value for person in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPerson()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        assertEquals(override, map[firstPerson])
    }

    @Test
    fun `returns provided value for special player`() {
        val specialPlayer = firstTestPerson()

        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(default, mapOf(specialPlayer to override))

        assertEquals(map[specialPlayer], override)
    }

    @Test
    fun `returns default value for non-special player`() {
        val special = firstTestPerson()
        val nonspecial = secondTestPerson()

        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(default, mapOf(special to override))

        assertEquals(map[nonspecial], VotingStrengthWithComment(default, comment = null))
    }

    @Test
    fun `specialPlayers empty for empty map`() {
        val emptyMap = SimpleVotingStrengthMap(firstTestVotingStrength(), emptyMap())
        assertEquals(emptyMap.specialPeople, emptySet<Person>())
    }

    @Test
    fun `specialPlayers correct for non-empty map`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()

        val map = SimpleVotingStrengthMap(
            firstTestVotingStrength(),
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to secondTestVotingStrengthWithComment()
            )
        )

        assertEquals(map.specialPeople.toSet(), setOf(firstPlayer, secondPlayer))
    }

    @Test
    fun `equality reflexiveness`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()
        val defaultStrength = firstTestVotingStrength()

        val map = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to secondTestVotingStrengthWithComment()
            )
        )

        assertEqualsAndHashCode(map, map)
    }

    @Test
    fun `normal equality`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()
        val defaultStrength = firstTestVotingStrength()

        fun createMap() = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to secondTestVotingStrengthWithComment()
            )
        )

        assertEqualsAndHashCode(createMap(), createMap())
    }

    @Test
    fun `equality and hash code with different special players`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()
        val defaultStrength = firstTestVotingStrength()

        val firstMap = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to VotingStrengthWithComment(defaultStrength, null)
            )
        )

        val secondMap = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment()
            )
        )

        // By contract, these maps are different because their special players are different
        assertNotEquals(firstMap, secondMap)
        assertNotEquals(secondMap, firstMap)
    }

    @Test
    fun `equality and hash code with different default strength`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()

        val firstDefaultStrength = firstTestVotingStrength()
        val secondDefaultStrength = secondTestVotingStrength()

        check(firstDefaultStrength != secondDefaultStrength)

        val baseMap = mapOf(
            firstPlayer to firstTestVotingStrengthWithComment(),
            secondPlayer to secondTestVotingStrengthWithComment()
        )

        val firstMap = SimpleVotingStrengthMap(
            firstDefaultStrength,
            baseMap
        )

        val secondMap = SimpleVotingStrengthMap(
            secondDefaultStrength,
            baseMap
        )

        assertNotEquals(firstMap, secondMap)
        assertNotEquals(secondMap, firstMap)
    }

    @Test
    fun `equality and hash code with different strength values`() {
        val firstPlayer = firstTestPerson()
        val secondPlayer = secondTestPerson()

        val defaultStrength = firstTestVotingStrength()
        val firstStrength = firstTestVotingStrengthWithComment()
        val secondStrength = secondTestVotingStrengthWithComment()

        check(firstStrength != secondStrength)

        val firstMap = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(firstPlayer to firstStrength, secondPlayer to secondStrength)
        )

        val secondMap = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(firstPlayer to secondStrength, secondPlayer to firstStrength) // Order intentionally flipped
        )

        assertNotEquals(firstMap, secondMap)
        assertNotEquals(secondMap, firstMap)
    }
}
