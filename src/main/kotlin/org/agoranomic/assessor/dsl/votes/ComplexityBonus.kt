package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.SetOnce
import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription
import org.randomcat.util.requireDistinctBy

private fun GeneralVotingStrengthReceiver.personComplexityBonus(
    person: Person,
    clamp: VotingStrengthDifference,
    offices: List<ComplexityBonusReceiver.OfficeComplexity>,
) {
    offices.requireDistinctBy { it.office }

    val rawBonus = VotingStrengthDifference(offices.sumOf { it.complexity.toBigInteger() })

    val description =
        "Complexity bonus for offices ${offices.joinToString(", ") { it.office }}" +
                if (rawBonus > clamp) "; clamped to $clamp" else ""

    person add minOf(rawBonus, clamp) describedAs VotingStrengthModificationDescription(
        readable = description,
        kind = "office_complexity",
        parameters = mapOf(
            "offices" to offices.joinToString(",") { it.office },
            "total_complexity" to rawBonus.raw.toString(),
            "bonus_clamp" to clamp.toString(),
        ),
    )
}

interface ComplexityBonusReceiver {
    data class OfficeComplexity(
        val office: String,
        val complexity: Int,
    ) {
        init {
            require(complexity >= 0)
        }
    }

    operator fun String.invoke(complexity: Int) = OfficeComplexity(
        office = this,
        complexity = complexity,
    )

    infix fun OfficeComplexity.heldBy(person: Person?)

    fun maxBonus(max: Int)
}

fun GeneralVotingStrengthReceiver.complexityBonuses(block: DslInit<ComplexityBonusReceiver>) {
    val officesByHolder = mutableMapOf<Person, MutableList<ComplexityBonusReceiver.OfficeComplexity>>()
    val maxBonus = SetOnce.namedOf<Int>("complexity max bonus")

    block(object : ComplexityBonusReceiver {
        override fun ComplexityBonusReceiver.OfficeComplexity.heldBy(person: Person?) {
            if (person != null) {
                val list = officesByHolder.getOrPut(person) { mutableListOf() }
                require(list.none { it.office == this.office })

                list.add(this)
            }
        }

        override fun maxBonus(max: Int) {
            maxBonus.set(max)
        }
    })

    for ((person, offices) in officesByHolder) {
        personComplexityBonus(
            person = person,
            clamp = VotingStrengthDifference(maxBonus.get()),
            offices = offices,
        )
    }
}
