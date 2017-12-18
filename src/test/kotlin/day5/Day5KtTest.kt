package day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day5KtTest {
    @Test
    fun testDay5_example1() {
        assertThat(day5(listOf(
            "0", "3", "0", "1", "-3"
        ))).isEqualTo(5)
    }

    @Test
    fun testDay5Bis_example1() {
        assertThat(day5Bis(listOf(
            "0", "3", "0", "1", "-3"
        ))).isEqualTo(10)
    }

}