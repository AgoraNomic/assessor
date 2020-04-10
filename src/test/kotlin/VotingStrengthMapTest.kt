import org.agoranomic.assessor.lib.SimpleVotingStrengthMap
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.VotingStrengthWithComment
import test_objects.firstTestPlayer
import test_objects.firstTestVotingStrength
import test_objects.firstTestVotingStrengthWithComment
import test_objects.secondTestPlayer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class `SimpleVotingStrengthMap test` {
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
}
