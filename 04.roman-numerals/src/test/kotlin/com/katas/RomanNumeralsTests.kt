package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RomanNumeralsTests : StringSpec({
    "it should transform basic numerals" {
        romanNumerals(1) shouldBe "I"
        romanNumerals(5) shouldBe "V"
        romanNumerals(10) shouldBe "X"
        romanNumerals(50) shouldBe "L"
        romanNumerals(100) shouldBe "C"
        romanNumerals(500) shouldBe "D"
        romanNumerals(1000) shouldBe "M"
    }
    "acceptance" {
        romanNumerals(48) shouldBe "XLVIII"
        romanNumerals(49) shouldBe "XLIX"
        romanNumerals(50) shouldBe "L"
        romanNumerals(51) shouldBe "LI"
        romanNumerals(98) shouldBe "XCVIII"
        romanNumerals(99) shouldBe "XCIX"
        romanNumerals(494) shouldBe "CDXCIV"
        romanNumerals(499) shouldBe "CDXCIX"
        romanNumerals(582) shouldBe "DLXXXII"
        romanNumerals(592) shouldBe "DXCII"
        romanNumerals(999) shouldBe "CMXCIX"
    }
})
