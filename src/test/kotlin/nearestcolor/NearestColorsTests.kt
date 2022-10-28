package nearestcolor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NearestColorsTests {

    @Test fun `an exact match is found immediately`() {
        assertEquals(listOf(Color.Red), nearestColors("FF0000"))
        assertEquals(listOf(Color.Green), nearestColors("00FF00"))
        assertEquals(listOf(Color.Blue), nearestColors("0000FF"))
    }

    @Test fun `multiple colors can be an exact match`() {
        assertEquals(listOf(Color.Red, Color.Green), nearestColors("FFFF00"))
        assertEquals(listOf(Color.Red, Color.Blue), nearestColors("FF00FF"))
        assertEquals(listOf(Color.Green, Color.Blue), nearestColors("00FFFF"))
        assertEquals(listOf(Color.Red, Color.Green, Color.Blue), nearestColors("FFFFFF"))
        assertEquals(listOf(Color.Red, Color.Green, Color.Blue), nearestColors("000000"))
    }

    @Test fun `nearest color is chosen`() {
        assertEquals(listOf(Color.Red), nearestColors("FFEEEE"))
        assertEquals(listOf(Color.Red), nearestColors("EEDDDD"))
        assertEquals(listOf(Color.Blue), nearestColors("001122"))
    }
}
