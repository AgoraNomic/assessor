import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.DslValueMap
import org.junit.jupiter.api.Nested
import test_objects.firstTestPlayer
import kotlin.test.*

class `DslValue tests` {
    @Nested
    inner class `before set` {
        @Test
        fun `get fails`() {
            val dslValue = DslValue<String>()
            assertFails { dslValue.get() }
        }

        @Test
        fun `set does not fail`() {
            val dslValue = DslValue<String>()

            // Test fails if this throws
            dslValue.set("I'm a string")
        }

        @Test
        fun `getOrElse returns default`() {
            val dslValue = DslValue<String>()
            val default = "I'm a string"

            assertSame(default, dslValue.getOrElse(default))
        }

        @Test
        fun `getOrNull returns null`() {
            val dslValue = DslValue<String>()
            assertNull(dslValue.getOrNull())
        }
    }

    @Nested
    inner class `after set` {
        @Test
        fun `get returns value`() {
            val dslValue = DslValue<String>()
            val value = "I'm a string"

            dslValue.set(value)

            assertSame(value, dslValue.get())
        }

        @Test
        fun `set fails`() {
            val dslValue = DslValue<String>()
            val value = "I'm a string"

            dslValue.set(value)

            assertFails { dslValue.set(value) }
        }

        @Test
        fun `getOrElse returns value`() {
            val dslValue = DslValue<String>()
            val value = "First string"

            dslValue.set(value)

            assertSame(value, dslValue.getOrElse("I'm a default"))
        }

        @Test
        fun `getOrNull returns value`() {
            val dslValue = DslValue<String>()
            val value = "First string"

            dslValue.set(value)

            assertSame(value, dslValue.getOrNull())
        }
    }
}

class `DslValueMap tests` {
    private data class KeyType(val value: String)
    private data class ValueType(val value: String)

    private val testKey = KeyType("Key")
    private val testValue = ValueType("Value")

    private val defaultValue = ValueType("Default value")

    private fun emptyTestMap(): DslValueMap<KeyType, ValueType> {
        return DslValueMap()
    }

    private fun filledTestMap(): DslValueMap<KeyType, ValueType> {
        return emptyTestMap().also { it[testKey] = testValue }
    }

    @Nested
    inner class `before set` {
        @Test
        fun `set works`() {
            val map = emptyTestMap()

            // Should not fail
            map[testKey] = testValue
        }

        @Test
        fun `get fails`() {
            val map = emptyTestMap()

            assertFails { map[testKey] }
        }

        @Test
        fun `getOrElse returns default`() {
            val map = emptyTestMap()

            assertEquals(defaultValue, map.getOrElse(testKey, defaultValue))
        }

        @Test
        fun `containsKey returns false`() {
            val map = emptyTestMap()

            assertFalse(map.containsKey(testKey))
        }

        @Test
        fun `getOrNull returns null`() {
            val map = emptyTestMap()

            assertNull(map.getOrNull(testKey))
        }
    }

    @Nested
    inner class `after set` {
        @Test
        fun `set fails`() {
            val map = filledTestMap()

            assertFails { map[testKey] = testValue }
        }

        @Test
        fun `get returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map[testKey])
        }

        @Test
        fun `containsKey returns true`() {
            val map = filledTestMap()

            assertTrue(map.containsKey(testKey))
        }

        @Test
        fun `getOrElse returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map.getOrElse(testKey, defaultValue))
        }

        @Test
        fun `getOrNull returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map.getOrNull(testKey))
        }
    }

    @Test
    fun `compile with empty returns empty`() {
        assertEquals(mapOf<KeyType, ValueType>(), emptyTestMap().compile())
    }

    @Test
    fun `compile with values works`() {
        val firstKey = KeyType("First key")
        val firstValue = ValueType("First value")

        val secondKey = KeyType("Second key")
        val secondValue = ValueType("Second value")

        val map = emptyTestMap()
        map[firstKey] = firstValue
        map[secondKey] = secondValue

        assertEquals(
            mapOf(
                firstKey to firstValue,
                secondKey to secondValue
            ),
            map.compile()
        )
    }
}
