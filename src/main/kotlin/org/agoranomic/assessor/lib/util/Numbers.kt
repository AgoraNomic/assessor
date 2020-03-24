package org.agoranomic.assessor.lib.util

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

/**
 * Returns the smallest number greater than or equal to [x].
 */
fun ceil(x: BigDecimal): BigInteger {
    return x.setScale(0, RoundingMode.CEILING).toBigIntegerExact()
}
