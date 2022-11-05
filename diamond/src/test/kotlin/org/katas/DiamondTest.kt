package org.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DiamondTest : StringSpec({

    "it should compute diamond for A letter" {
        val expected =
            """
A
""".trimIndent()

        Diamond('A').toString() shouldBe expected
    }

    "it should compute diamond for B letter" {
        val expected =
            """
 A
B B
 A
""".trimIndent()

        Diamond('B').toString() shouldBe expected
    }
    "it should compute diamond for C letter" {
        val expected =
            """
  A
 B B
C   C
 B B
  A
""".trimIndent()

        Diamond('C').toString() shouldBe expected
    }
    "it should compute diamond for D letter" {
        val expected =
            """
   A
  B B
 C   C
D     D
 C   C
  B B
   A
""".trimIndent()

        Diamond('D').toString() shouldBe expected
    }

})
