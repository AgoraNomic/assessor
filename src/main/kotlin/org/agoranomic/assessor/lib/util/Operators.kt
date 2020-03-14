package org.agoranomic.assessor.lib.util

import java.math.BigDecimal
import java.math.BigInteger

operator fun BigDecimal.plus(other: Int) = this.plus(other.toBigDecimal())
operator fun Int.plus(other: BigDecimal) = (this.toBigDecimal()).plus(other)

operator fun BigDecimal.minus(other: Int) = this.minus(other.toBigDecimal())
operator fun Int.minus(other: BigDecimal) = (this.toBigDecimal()).minus(other)

operator fun BigDecimal.times(other: Int) = this.times(other.toBigDecimal())
operator fun Int.times(other: BigDecimal) = (this.toBigDecimal()).times(other)

operator fun BigDecimal.compareTo(other: Int) = this.compareTo(other.toBigDecimal())
operator fun Int.compareTo(other: BigDecimal) = (this.toBigDecimal()).compareTo(other)

operator fun BigInteger.plus(other: Int) = this.plus(other.toBigInteger())
operator fun Int.plus(other: BigInteger) = (this.toBigInteger()).plus(other)

operator fun BigInteger.minus(other: Int) = this.minus(other.toBigInteger())
operator fun Int.minus(other: BigInteger) = (this.toBigInteger()).minus(other)

operator fun BigInteger.times(other: Int) = this.times(other.toBigInteger())
operator fun Int.times(other: BigInteger) = (this.toBigInteger()).times(other)

operator fun BigInteger.div(other: Int) = this.div(other.toBigInteger())
operator fun Int.div(other: BigInteger) = (this.toBigInteger()).div(other)

operator fun BigInteger.rem(other: Int) = this.rem(other.toBigInteger())
operator fun Int.rem(other: BigInteger) = (this.toBigInteger()).rem(other)

operator fun BigInteger.compareTo(other: Int) = this.compareTo(other.toBigInteger())
operator fun Int.compareTo(other: BigInteger) = (this.toBigInteger()).compareTo(other)

operator fun BigInteger.plus(other: BigDecimal) = this.toBigDecimal().plus(other)
operator fun BigDecimal.plus(other: BigInteger) = this.plus(other.toBigDecimal())

operator fun BigInteger.minus(other: BigDecimal) = this.toBigDecimal().minus(other)
operator fun BigDecimal.minus(other: BigInteger) = this.minus(other.toBigDecimal())

operator fun BigInteger.times(other: BigDecimal) = this.toBigDecimal().times(other)
operator fun BigDecimal.times(other: BigInteger) = this.times(other.toBigDecimal())

operator fun BigInteger.compareTo(other: BigDecimal) = this.toBigDecimal().compareTo(other)
operator fun BigDecimal.compareTo(other: BigInteger) = this.compareTo(other.toBigDecimal())
