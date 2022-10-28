package nearestcolor

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NearestColorsTests {

    @Test fun `an exact match is found immediately`() {
        assertEquals(listOf(Color.Red), nearestColors("FF0000"))
    }
}
