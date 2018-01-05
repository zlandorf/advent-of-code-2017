package day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day8KtTest {

    @Test
    fun testDay8() {
        val instructions = listOf(
            "b inc 5 if a > 1",
            "a inc 1 if b < 5",
            "c dec -10 if a >= 1",
            "c inc -20 if c == 10"
        )

        assertThat(day8(instructions).first).isEqualTo(1)
    }

    @Test
    fun testDay8Bis() {
        val instructions = listOf(
            "b inc 5 if a > 1",
            "a inc 1 if b < 5",
            "c dec -10 if a >= 1",
            "c inc -20 if c == 10"
        )

        assertThat(day8(instructions).second).isEqualTo(10)
    }

}