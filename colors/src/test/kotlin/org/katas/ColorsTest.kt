package org.katas

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ColorsTest : ShouldSpec({
    should("return red as nearest color") {
        Color("#FF0000").nearestColor() shouldBe BasePaletteColor.RED
        Color("#FFFEFE").nearestColor() shouldBe BasePaletteColor.RED
        Color("#FF1212").nearestColor() shouldBe BasePaletteColor.RED
        Color("#FFFE00").nearestColor() shouldBe BasePaletteColor.RED
        Color("#FF00FE").nearestColor() shouldBe BasePaletteColor.RED
        Color("#020101").nearestColor() shouldBe BasePaletteColor.RED
    }
    should("return green as nearest color") {
        Color("#00FF00").nearestColor() shouldBe BasePaletteColor.GREEN
        Color("#FEFFFE").nearestColor() shouldBe BasePaletteColor.GREEN
        Color("#21FF12").nearestColor() shouldBe BasePaletteColor.GREEN
        Color("#FEFF00").nearestColor() shouldBe BasePaletteColor.GREEN
        Color("#00FFFE").nearestColor() shouldBe BasePaletteColor.GREEN
        Color("#010201").nearestColor() shouldBe BasePaletteColor.GREEN
    }
    should("return blue as nearest color") {
        Color("#0000FF").nearestColor() shouldBe BasePaletteColor.BLUE
        Color("#FEFEFF").nearestColor() shouldBe BasePaletteColor.BLUE
        Color("#2112FF").nearestColor() shouldBe BasePaletteColor.BLUE
        Color("#FE00FF").nearestColor() shouldBe BasePaletteColor.BLUE
        Color("#00FEFF").nearestColor() shouldBe BasePaletteColor.BLUE
        Color("#010102").nearestColor() shouldBe BasePaletteColor.BLUE
    }
    should("return red as farthest color") {
        Color("#000101").farthestColor() shouldBe BasePaletteColor.RED
        Color("#00F0F1").farthestColor() shouldBe BasePaletteColor.RED
        Color("#FEFFFF").farthestColor() shouldBe BasePaletteColor.RED
    }
    should("return green as farthest color") {
        Color("#010001").farthestColor() shouldBe BasePaletteColor.GREEN
        Color("#F000F1").farthestColor() shouldBe BasePaletteColor.GREEN
        Color("#FFFEFF").farthestColor() shouldBe BasePaletteColor.GREEN
    }
    should("return blue as farthest color") {
        Color("#010100").farthestColor() shouldBe BasePaletteColor.BLUE
        Color("#F0F100").farthestColor() shouldBe BasePaletteColor.BLUE
        Color("#FFFFFE").farthestColor() shouldBe BasePaletteColor.BLUE
    }
})
