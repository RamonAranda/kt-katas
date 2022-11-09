package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ScaleTests : StringSpec({
    "it should transform units" {
        Scale.Units.translate(1) shouldBe "I"
        Scale.Units.translate(2) shouldBe "II"
        Scale.Units.translate(3) shouldBe "III"
        Scale.Units.translate(4) shouldBe "IV"
        Scale.Units.translate(5) shouldBe "V"
        Scale.Units.translate(6) shouldBe "VI"
        Scale.Units.translate(7) shouldBe "VII"
        Scale.Units.translate(8) shouldBe "VIII"
        Scale.Units.translate(9) shouldBe "IX"
    }
    "it should transform tens" {
        Scale.Tens.translate(1) shouldBe "X"
        Scale.Tens.translate(2) shouldBe "XX"
        Scale.Tens.translate(3) shouldBe "XXX"
        Scale.Tens.translate(4) shouldBe "XL"
        Scale.Tens.translate(5) shouldBe "L"
        Scale.Tens.translate(6) shouldBe "LX"
        Scale.Tens.translate(7) shouldBe "LXX"
        Scale.Tens.translate(8) shouldBe "LXXX"
        Scale.Tens.translate(9) shouldBe "XC"
    }
    "it should transform hundreds" {
        Scale.Hundreds.translate(1) shouldBe "C"
        Scale.Hundreds.translate(2) shouldBe "CC"
        Scale.Hundreds.translate(3) shouldBe "CCC"
        Scale.Hundreds.translate(4) shouldBe "CD"
        Scale.Hundreds.translate(5) shouldBe "D"
        Scale.Hundreds.translate(6) shouldBe "DC"
        Scale.Hundreds.translate(7) shouldBe "DCC"
        Scale.Hundreds.translate(8) shouldBe "DCCC"
        Scale.Hundreds.translate(9) shouldBe "CM"
    }
    "it should transform thousands" {
        Scale.Thousands.translate(1) shouldBe "M".repeat(1)
        Scale.Thousands.translate(2) shouldBe "M".repeat(2)
        Scale.Thousands.translate(3) shouldBe "M".repeat(3)
        Scale.Thousands.translate(4) shouldBe "M".repeat(4)
        Scale.Thousands.translate(5) shouldBe "M".repeat(5)
        Scale.Thousands.translate(6) shouldBe "M".repeat(6)
        Scale.Thousands.translate(7) shouldBe "M".repeat(7)
        Scale.Thousands.translate(8) shouldBe "M".repeat(8)
        Scale.Thousands.translate(9) shouldBe "M".repeat(9)
    }
})
