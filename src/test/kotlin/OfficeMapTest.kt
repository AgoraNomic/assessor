import org.agoranomic.assessor.dsl.ministries.OfficeState
import org.agoranomic.assessor.dsl.ministries.isHeld
import org.agoranomic.assessor.dsl.ministries.isVacant
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import test_objects.firstTestPlayer
import test_util.assertEqualsAndHashCode
import kotlin.test.*

class `OfficeState tests` {
    @Test
    fun `vacant returns Vacant`() {
        assertEquals(OfficeState.Vacant, OfficeState.vacant())
    }

    @Test
    fun `heldBy returns Held with correct holder`() {
        val holder = firstTestPlayer()
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
        val state = OfficeState.heldBy(firstTestPlayer())

        assertTrue(state.isHeld())
        assertFalse(state.isVacant())
    }
}

class `OfficeMap tests` {
    private enum class UnaryOffice { Value }

    @Test
    fun `officeMapOf returns held for non-null holder`() {
        val testPerson = firstTestPlayer()

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

        val testPerson = firstTestPlayer()
        val secondMap = officeMapOf(UnaryOffice.Value to testPerson)
        assertEqualsAndHashCode(secondMap, secondMap)
    }

    @Test
    fun `OfficeMap compares unequal to different map`() {
        val firstMap = officeMapOf(UnaryOffice.Value to null)

        val testPerson = firstTestPlayer()
        val secondMap = officeMapOf(UnaryOffice.Value to testPerson)

        assertNotEquals(firstMap, secondMap)
    }
}
