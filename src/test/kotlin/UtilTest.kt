import org.agoranomic.assessor.lib.getOrFail
import org.agoranomic.assessor.lib.times
import org.agoranomic.assessor.lib.compareTo
import java.math.BigDecimal
import kotlin.test.*

class `getOrFail tests` {
    @Test
    fun `returns correct non-null value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertEquals(map.getOrFail(1), "hi")
    }

    @Test
    fun `returns correct null value`() {
        val map = mapOf(1 to "hi", 2 to null)
        assertEquals(map.getOrFail(2), null)
    }

    @Test
    fun `throws on missing value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertFails { map.getOrFail(3) }
    }
}

class `BigDecimal util tests` {
    @Test
    fun `multiplication works`() {
        val bd = BigDecimal.valueOf(5)!!
        val i = 2

        assertEquals(bd * i, BigDecimal.TEN)
        assertEquals(i * bd, BigDecimal.TEN)
    }

    @Test
    fun `comparison works`() {
        val i = 1
        val bd = BigDecimal.valueOf(5)!!

        assertTrue(i < bd)
        assertTrue(i <= bd)
        assertFalse(i > bd)
        assertFalse(i >= bd)

        assertFalse(bd < i)
        assertFalse(bd <= i)
        assertTrue(bd > i)
        assertTrue(bd >= i)
    }
}
