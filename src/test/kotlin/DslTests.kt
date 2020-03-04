import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import test_objects.firstTestProposalNumber
import org.junit.jupiter.api.Nested
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.Test

class `Proposal DSL V0 tests` {
    companion object {
        private fun ProposalReceiverV0.commonSetup(
            specifyTitle: Boolean = true,
            specifyText: Boolean = true,
            specifyAuthor: Boolean = true,
            specifyCoauthors: Boolean = true,
            specifyAI: Boolean = true
        ) {
            if (specifyTitle) title("Some title")
            if (specifyText) text("Some text")
            if (specifyAuthor) author(Person("Some author"))
            if (specifyCoauthors) coauthors(Person("First coauthor"), Person("second coauthor"))
            if (specifyAI) ai(1)
        }

        private fun compile(
            number: ProposalNumber = firstTestProposalNumber(),
            init: ProposalReceiverV0Init
        ): Proposal = buildProposalV0(number, init)
    }


    @Nested
    inner class `title tests` {
        private fun ProposalReceiverV0.setupForTitle() = commonSetup(specifyTitle = false)

        @Test
        fun `fails when title not specified`() {
            assertFails {
                compile {
                    setupForTitle()
                    // Don't set title
                }
            }
        }

        @Test
        fun `fails when title specified twice`() {
            val titleToSet = "A title"

            assertFails {
                compile {
                    setupForTitle()
                    title(titleToSet)
                    title(titleToSet)
                }
            }
        }

        @Test
        fun `returns correct title`() {
            val expectedTitle = "I'm a title!"

            val proposal = compile {
                setupForTitle()
                title(expectedTitle)
            }

            assertEquals(expectedTitle, proposal.title)
        }
    }

    @Nested
    inner class `text tests` {
        private fun ProposalReceiverV0.setupForText() = commonSetup(specifyText = false)

        @Test
        fun `fails when text not specified`() {
            assertFails {
                compile {
                    setupForText()
                    // Don't set text
                }
            }
        }

        @Test
        fun `fails when text specified twice`() {
            val textToSet = "Some text"

            assertFails {
                compile {
                    setupForText()
                    text(textToSet)
                    text(textToSet)
                }
            }
        }

        @Test
        fun `returns correct text`() {
            val expectedText = "I'm a proposal text!"

            val proposal = compile {
                setupForText()
                text(expectedText)
            }

            assertEquals(expectedText, proposal.text)
        }
    }
}
