package day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day2KtTest {

    @Test
    fun testDay2() {
        assertThat(day2(listOf(
            "5 1 9 5",
            "7 5 3",
            "2 4 6 8"
        ))).isEqualTo(18)
    }

    @Test
    fun testDay2Bis() {
        assertThat(day2Bis(listOf(
            "5 9 2 8",
            "9 4 7 3",
            "3 8 6 5"
        ))).isEqualTo(9)
    }

}