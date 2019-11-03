package org.agoranomic.assessor.lib

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import java.math.BigDecimal

@Serializer(forClass = BigDecimal::class)
object BigDecimalSerializer : KSerializer<BigDecimal> {
    override val descriptor: SerialDescriptor = StringDescriptor

    override fun serialize(encoder: Encoder, obj: BigDecimal) {
        encoder.encodeString(obj.toString())
    }

    override fun deserialize(decoder: Decoder): BigDecimal {
        return BigDecimal(decoder.decodeString())
    }
}

data class Player(val name: String) {
    @Serializer(forClass = Player::class)
    companion object : KSerializer<Player> {
        override val descriptor: SerialDescriptor =
            StringDescriptor

        override fun serialize(encoder: Encoder, obj: Player) {
            encoder.encodeString(obj.name)
        }

        override fun deserialize(decoder: Decoder): Player {
            return Player(name = decoder.decodeString())
        }
    }
}

typealias ProposalNumber = Int
typealias ProposalAI = BigDecimal
@Serializable
data class Proposal(val number: ProposalNumber, @Serializable(with = BigDecimalSerializer::class) val ai: ProposalAI, val title: String, val author: Player, val coauthors: List<Player>, val text: String)

fun Iterable<Proposal>.lookupOrFail(number: ProposalNumber): Proposal {
    return this.find { it.number == number } ?: throw IllegalStateException("No proposal with number " + number)
}

fun ProposalNumber.lookupIn(list: Iterable<Proposal>) = list.lookupOrFail(this)