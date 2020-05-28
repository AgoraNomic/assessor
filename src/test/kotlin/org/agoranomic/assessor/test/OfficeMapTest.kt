package org.agoranomic.assessor.test

import org.agoranomic.assessor.dsl.ministries.*
import org.junit.jupiter.api.DisplayName
import org.agoranomic.assessor.test.test_objects.firstTestPerson
import org.agoranomic.assessor.test.test_util.assertEqualsAndHashCode
import kotlin.test.*

@DisplayName("OfficeState test")
class OfficeStateTest {
    @Test
    fun `vacant returns Vacant`() {
        assertEquals(OfficeState.Vacant, OfficeState.vacant())
    }

    @Test
    fun `heldBy returns Held with correct holder`() {
        val holder = firstTestPerson()
        assertEquals(OfficeState.Held(holder), OfficeState.heldBy(holder))
    }

    @Test
    fun `Vacant OfficeState is vacant and not held`() {
        val state = OfficeState.vacant()

        assertTrue(state.isVacant())
        assertFalse(state.isHeld())
    }

    @Test
    fun `Held OfficeState is held and not vacant`() {
        val state = OfficeState.heldBy(firstTestPerson())

        assertTrue(state.isHeld())
        assertFalse(state.isVacant())
    }
}

@DisplayName("OfficeMap test")
class OfficeMapTest {
    private enum class UnaryOffice { Value }

    @Test
    fun `toOfficeMap returns OfficeMap containing given entries`() {
        val testPerson = firstTestPerson()
        val testState = OfficeState.heldBy(testPerson)

        val map = listOf(UnaryOffice.Value to testState).toOfficeMap()
        assertEquals(testState, map[UnaryOffice.Value])
    }

    @Test
    fun `toOfficeMap throws when non-exhaustive`() {
        assertFailsWith<IllegalArgumentException> {
            listOf<Pair<UnaryOffice, OfficeState>>().toOfficeMap()
        }
    }

    @Test
    fun `toOfficeMap throws when keys repeated`() {
        assertFailsWith<IllegalArgumentException> {
            listOf(
                UnaryOffice.Value to OfficeState.heldBy(firstTestPerson()),
                UnaryOffice.Value to OfficeState.vacant()
            ).toOfficeMap()
        }
    }

    @Test
    fun `toOfficeMap return compares equal to officeMapOf return`() {
        val testPerson = firstTestPerson()

        assertEqualsAndHashCode(
            officeMapOf(UnaryOffice.Value to testPerson),
            listOf(UnaryOffice.Value to OfficeState.heldBy(testPerson)).toOfficeMap()
        )
    }

    @Test
    fun `officeMapOf returns held for non-null holder`() {
        val testPerson = firstTestPerson()

        val map = officeMapOf(UnaryOffice.Value to testPerson)
        assertEquals(OfficeState.heldBy(testPerson), map[UnaryOffice.Value])
    }

    @Test
    fun `officeMapOf returns vacant for null holder`() {
        val map = officeMapOf(UnaryOffice.Value to null)
        assertEquals(OfficeState.vacant(), map[UnaryOffice.Value])
    }

    @Test
    fun `officeMapOf throws when non-exhaustive`() {
        assertFailsWith<IllegalArgumentException> {
            officeMapOf<UnaryOffice>()
        }
    }

    @Test
    fun `officeMapOf throws when keys repeated`() {
        assertFailsWith<IllegalArgumentException> {
            officeMapOf(UnaryOffice.Value to null, UnaryOffice.Value to null)
        }
    }

    @Test
    fun `OfficeMap compares equal to self`() {
        val firstMap = officeMapOf(UnaryOffice.Value to null)
        assertEqualsAndHashCode(firstMap, firstMap)

        val testPerson = firstTestPerson()
        val secondMap = officeMapOf(UnaryOffice.Value to testPerson)
        assertEqualsAndHashCode(secondMap, secondMap)
    }

    @Test
    fun `OfficeMap compares unequal to different map`() {
        val firstMap = officeMapOf(UnaryOffice.Value to null)

        val testPerson = firstTestPerson()
        val secondMap = officeMapOf(UnaryOffice.Value to testPerson)

        assertNotEquals(firstMap, secondMap)
    }
}
