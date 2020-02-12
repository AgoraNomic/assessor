import org.agoranomic.assessor.dsl.DslValue
import org.junit.jupiter.api.Nested
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
