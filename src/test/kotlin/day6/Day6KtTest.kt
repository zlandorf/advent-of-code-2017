package day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day6KtTest {

    @Test
    fun testDay6() {
        assertThat(day6("0 2 7 0")).isEqualTo(5)
    }

    @Test
    fun testDay6Bis() {
        assertThat(day6Bis("0 2 7 0")).isEqualTo(4)
    }

}