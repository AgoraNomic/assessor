import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.junit.jupiter.api.Nested
import test_objects.*
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
            if (specifyTitle) title(firstTestProposalTitle())
            if (specifyText) text(firstTestProposalText())
            if (specifyAuthor) author(firstTestProposalAuthor())
            if (specifyCoauthors) coauthors(firstTestProposalCoauthors())
            if (specifyAI) ai(firstTestProposalAI())
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
            val titleToSet = firstTestProposalTitle()

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
            val expectedTitle = firstTestProposalTitle()

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
            val textToSet = firstTestProposalText()

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
            val expectedText = firstTestProposalText()

            val proposal = compile {
                setupForText()
                text(expectedText)
            }

            assertEquals(expectedText, proposal.text)
        }
    }

    @Nested
    inner class `author tests` {
        private fun ProposalReceiverV0.setupForAuthor() = commonSetup(specifyAuthor = false)

        @Test
        fun `fails when author not specified`() {
            assertFails {
                compile {
                    setupForAuthor()
                    // Don't set author
                }
            }
        }

        @Test
        fun `fails when author specified twice`() {
            val authorToSet = firstTestProposalAuthor()

            assertFails {
                compile {
                    setupForAuthor()
                    author(authorToSet)
                    author(authorToSet)
                }
            }
        }

        @Test
        fun `returns expected author`() {
            val expectedAuthor = firstTestProposalAuthor()

            val proposal = compile {
                setupForAuthor()
                author(expectedAuthor)
            }

            assertEquals(expectedAuthor, proposal.author)
        }
    }

    @Nested
    inner class `coauthors tests` {
        private fun ProposalReceiverV0.setupForCoauthors() = commonSetup(specifyCoauthors = false)

        @Test
        fun `has empty coauthors when none specified`() {
            val proposal = compile {
                setupForCoauthors()
            }

            assertEquals(Persons.empty(), proposal.coauthors)
        }

        @Test
        fun `fails when coauthors specified twice`() {
            val coauthorsToSet = firstTestProposalCoauthors()

            assertFails {
                compile {
                    setupForCoauthors()
                    coauthors(coauthorsToSet)
                    coauthors(coauthorsToSet)
                }
            }
        }

        @Test
        fun `returns expected coauthors when using Persons argument`() {
            val coauthorsToSet = firstTestProposalCoauthors()

            val proposal = compile {
                setupForCoauthors()
                coauthors(coauthorsToSet)
            }

            assertEquals(coauthorsToSet, proposal.coauthors)
        }

        @Test
        fun `returns expected coauthors when using varargs`() {
            val coauthorsToSet = firstTestProposalCoauthors().toTypedArray()

            val proposal = compile {
                setupForCoauthors()
                coauthors(*coauthorsToSet)
            }

            assertEquals(Persons.checkingDistinct(coauthorsToSet.toList()), proposal.coauthors)
        }
    }

    @Nested
    inner class `AI tests` {
        private fun ProposalReceiverV0.setupForAI() = commonSetup(specifyAI = false)

        @Test
        fun `fails when AI not specified`() {
            assertFails {
                compile {
                    setupForAI()
                    // Don't set AI
                }
            }
        }

        @Test
        fun `fails when AI specified twice`() {
            val aiToSet = firstTestProposalAI()

            assertFails {
                compile {
                    setupForAI()
                    ai(aiToSet)
                    ai(aiToSet)
                }
            }
        }

        @Test
        fun `returns expected AI`() {
            val expectedAI = firstTestProposalAI()

            val proposal = compile {
                setupForAI()
                ai(expectedAI)
            }

            assertEquals(expectedAI, proposal.ai)
        }
    }
}
