import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalAI
import org.agoranomic.assessor.lib.ProposalNumber
import org.junit.jupiter.api.Nested
import test_objects.*
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.Test

abstract class ProposalDslTestBase<ProposalReceiver : ProposalCommonReceiver> {
    protected fun ProposalReceiver.onlyCommonSetup(
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

    protected abstract fun ProposalReceiver.extendSetupForCommonTests()

    private fun ProposalReceiver.setupForCommonTests(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyAI: Boolean = true
    ) {
        onlyCommonSetup(
            specifyTitle = specifyTitle,
            specifyText = specifyText,
            specifyAuthor = specifyAuthor,
            specifyCoauthors = specifyCoauthors,
            specifyAI = specifyAI
        )

        extendSetupForCommonTests()
    }

    protected abstract fun compile(
        number: ProposalNumber = firstTestProposalNumber(),
        init: DslInit<ProposalReceiver>
    ): Proposal

    @Nested
    inner class `title tests` {
        private fun ProposalReceiver.setupForTitle() = setupForCommonTests(specifyTitle = false)

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
        private fun ProposalReceiver.setupForText() = setupForCommonTests(specifyText = false)

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
        private fun ProposalReceiver.setupForAuthor() = setupForCommonTests(specifyAuthor = false)

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
        private fun ProposalReceiver.setupForCoauthors() = setupForCommonTests(specifyCoauthors = false)

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
        private fun ProposalReceiver.setupForAI() = setupForCommonTests(specifyAI = false)

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

        @Test
        fun `double to AI conversion works`() {
            for (integerPart in (0..3).map { it.toString() }) {
                for (decimalPart in (0..9).map { it.toString() }) {
                    val aiString = "$integerPart.$decimalPart"

                    // toDouble returns the nearest double value to the String value (I think?), which is the same as
                    // what it would be represented as in a source code literal.
                    val aiDouble = aiString.toDouble()

                    val expectedAI = ProposalAI(aiString.toBigDecimal())

                    val proposal = compile {
                        setupForAI()
                        ai(aiDouble)
                    }

                    assertEquals(expectedAI, proposal.ai)
                }
            }
        }
    }
}

class ProposalDslV0Test : ProposalDslTestBase<ProposalReceiverV0>() {
    override fun ProposalReceiverV0.extendSetupForCommonTests() {
        // Nothing else to do, since V0 dsl is the same as the common
    }

    override fun compile(number: ProposalNumber, init: ProposalReceiverV0Init): Proposal {
        return buildProposalV0(number, init)
    }
}
