package org.agoranomic.assessor.test.dsl.proposal

import org.agoranomic.assessor.dsl.receivers.ProposalClassAndChamberReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalCommonReceiver
import org.agoranomic.assessor.lib.proposal.ProposalChamber
import org.agoranomic.assessor.lib.proposal.ProposalClassAndChamber
import org.agoranomic.assessor.lib.proposal.ProposalClassAndChamberData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

interface ProposalClassAndChamberCompilerTest<R> :
    ProposalCompilerTestBase<R> where R : ProposalCommonReceiver, R : ProposalClassAndChamberReceiver {

    fun R.setupOnlyClassAndChamber() {
        democratic()
    }

    fun R.setupExceptClassAndChamber()

    @Test
    fun `fails if no class or chamber specified`() {
        assertFails {
            compile {
                setupExceptClassAndChamber()

                // Don't set class and chamber
            }
        }
    }

    @Test
    fun `fails if class and chamber specified twice`() {
        assertFails {
            compile {
                setupExceptClassAndChamber()

                classless()
                classless()
            }
        }
    }

    @Test
    fun `returns expected versioned data`() {
        val initToExpected = mapOf(
            { it: R -> it.classless() }
                    to ProposalClassAndChamber.Classless,
            { it: R -> it.democratic() }
                    to ProposalClassAndChamber.DemocraticClass,
            { it: R -> it.chamber(ProposalChamber.Participation) }
                    to ProposalClassAndChamber.OrdinaryClass(ProposalChamber.Participation),
            { it: R -> it.chamber(ProposalChamber.Economy) }
                    to ProposalClassAndChamber.OrdinaryClass(ProposalChamber.Economy)
        )

        for ((init, expectedClassAndChamber) in initToExpected) {
            val proposal = compile {
                setupExceptClassAndChamber()

                init(this)
            }

            val versionedData = proposal.versionedData

            assertTrue(versionedData is ProposalClassAndChamberData)
            assertEquals(expectedClassAndChamber, versionedData.classAndChamber)
        }
    }
}
