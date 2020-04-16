import org.agoranomic.assessor.dsl.ministries.OfficeState
import org.agoranomic.assessor.dsl.ministries.isHeld
import org.agoranomic.assessor.dsl.ministries.isVacant
import test_objects.firstTestPlayer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

}
