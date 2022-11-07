package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RomanNumerals : StringSpec({
    "it should transform basic numerals" {
        romanNumerals(1) shouldBe "I"
        romanNumerals(5) shouldBe "V"
        romanNumerals(10) shouldBe "X"
        romanNumerals(50) shouldBe "L"
        romanNumerals(100) shouldBe "C"
        romanNumerals(500) shouldBe "D"
        romanNumerals(1000) shouldBe "M"
    }
})
