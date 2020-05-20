import org.agoranomic.assessor.lib.ProposalDataMismatchException
import org.agoranomic.assessor.lib.checkMismatch
import org.junit.jupiter.api.DisplayName
import test_objects.firstTestProposal
import test_objects.secondTestProposal
import test_util.assertSucceeds
import test_util.copyWithNumber
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

@DisplayName("checkMismatch test")
class CheckMismatchTest {
    @Test
    fun `checkMismatch does not throw for equivalent proposals`() {
        val firstProposal = firstTestProposal()
        val firstProposalCopy = firstProposal.copy()

        assertSucceeds {
            checkMismatch(original = firstProposal, next = firstProposalCopy)
        }
    }

    @Test
    fun `checkMismatch throws IllegalArgumentException if numbers are different`() {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()

        check(firstProposal.number != secondProposal.number)

        assertFailsWith<IllegalArgumentException> {
            checkMismatch(original = firstProposal, next = secondProposal)
        }

        assertFailsWith<IllegalArgumentException> {
            checkMismatch(original = secondProposal, next = firstProposal)
        }
    }

    @Test
    fun `checkMismatch throws IllegalArgumentException if numbers are same and data is different`() {
        val originalProposal = firstTestProposal()
        val nextProposal = secondTestProposal().copyWithNumber(originalProposal.number)

        check(originalProposal.number == nextProposal.number)
        check(originalProposal != nextProposal)

        val exception = assertFailsWith<ProposalDataMismatchException> {
            checkMismatch(original = originalProposal, next = nextProposal)
        }

        assertSame(originalProposal, exception.original)
        assertSame(nextProposal, exception.next)
    }
}
