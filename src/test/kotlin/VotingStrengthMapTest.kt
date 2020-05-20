import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.SimpleVotingStrengthMap
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.VotingStrengthWithComment
import org.junit.jupiter.api.DisplayName
import test_objects.*
import kotlin.test.Test
import kotlin.test.assertEquals
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
        val firstPerson = firstTestPlayer()
        val secondPerson = secondTestPlayer()

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

        val firstPerson = firstTestPlayer()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        val otherPerson = secondTestPlayer()

        assertNull(map.getOrNull(otherPerson))
    }

    @Test
    fun `getOrNull returns given value for person in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPlayer()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        assertEquals(override, map[firstPerson])
    }

    @Test
    fun `get returns default for person not in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPlayer()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        val otherPerson = secondTestPlayer()

        assertEquals(VotingStrengthWithComment(default), map[otherPerson])
    }

    @Test
    fun `get returns given value for person in map`() {
        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val firstPerson = firstTestPlayer()

        val map = SimpleVotingStrengthMap(default, mapOf(firstPerson to override))

        assertEquals(override, map[firstPerson])
    }

    @Test
    fun `returns provided value for special player`() {
        val specialPlayer = firstTestPlayer()

        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(default, mapOf(specialPlayer to override))

        assertEquals(map[specialPlayer], override)
    }

    @Test
    fun `returns default value for non-special player`() {
        val special = firstTestPlayer()
        val nonspecial = secondTestPlayer()

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
        val firstPlayer = firstTestPlayer()
        val secondPlayer = secondTestPlayer()

        val map = SimpleVotingStrengthMap(
            firstTestVotingStrength(),
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to secondTestVotingStrengthWithComment()
            )
        )

        assertEquals(map.specialPeople.toSet(), setOf(firstPlayer, secondPlayer))
    }
}
