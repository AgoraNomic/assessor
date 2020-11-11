package org.agoranomic.assessor.test.dsl.proposal

import org.agoranomic.assessor.dsl.receivers.ProposalClassAndChamberV1Receiver
import org.agoranomic.assessor.dsl.receivers.ProposalCommonReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.ProposalClassAndChamberV1
import org.agoranomic.assessor.lib.proposal.ProposalClassAndChamberV1Data
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

interface ProposalClassAndChamberV1CompilerTest<R> :
    ProposalCompilerTestBase<R> where R : ProposalCommonReceiver, R : ProposalClassAndChamberV1Receiver {

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
                    to ProposalClassAndChamberV1.Classless,
            { it: R -> it.democratic() }
                    to ProposalClassAndChamberV1.DemocraticClass,
            { it: R -> it.chamber(MinistryV1.Participation) }
                    to ProposalClassAndChamberV1.OrdinaryClass(MinistryV1.Participation),
            { it: R -> it.chamber(MinistryV1.Economy) }
                    to ProposalClassAndChamberV1.OrdinaryClass(MinistryV1.Economy)
        )

        for ((init, expectedClassAndChamber) in initToExpected) {
            val proposal = compile {
                setupExceptClassAndChamber()

                init(this)
            }

            val versionedData = proposal.versionedData

            assertTrue(versionedData is ProposalClassAndChamberV1Data)
            assertEquals(expectedClassAndChamber, versionedData.classAndChamber)
        }
    }
}
