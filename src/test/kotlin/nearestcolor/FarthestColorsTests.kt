package nearestcolor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FarthestColorsTests {

    @Test fun `an exact match is found immediately`() {
        assertEquals(listOf(Color.Red), farthestColors("00FFFF"))
        assertEquals(listOf(Color.Green), farthestColors("FF00FF"))
        assertEquals(listOf(Color.Blue), farthestColors("FFFF00"))
    }

    @Test fun `multiple colors can be an exact match`() {
        assertEquals(listOf(Color.Red, Color.Green), farthestColors("0000FF"))
        assertEquals(listOf(Color.Red, Color.Blue), farthestColors("00FF00"))
        assertEquals(listOf(Color.Green, Color.Blue), farthestColors("FF0000"))
        assertEquals(listOf(Color.Red, Color.Green, Color.Blue), farthestColors("000000"))
        assertEquals(listOf(Color.Red, Color.Green, Color.Blue), farthestColors("FFFFFF"))
    }

    @Test fun `nearest color is chosen`() {
        assertEquals(listOf(Color.Red), farthestColors("EEFFFF"))
        assertEquals(listOf(Color.Red), farthestColors("DDEEEE"))
        assertEquals(listOf(Color.Blue), farthestColors("221100"))
    }
}
