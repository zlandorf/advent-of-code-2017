package day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day3KtTest {

    @Test
    fun testDay3_example1() {
        assertThat(day3(1)).isEqualTo(0)
    }

    @Test
    fun testDay3_example2() {
        assertThat(day3(12)).isEqualTo(3)
    }

    @Test
    fun testDay3_example3() {
        assertThat(day3(23)).isEqualTo(2)
    }

    @Test
    fun testDay3_example4() {
        assertThat(day3(1024)).isEqualTo(31)
    }

    @Test
    fun testDay3Bis_example1() {
        assertThat(day3Bis(5)).isEqualTo(10)
    }

    @Test
    fun testDay3Bis_example2() {
        assertThat(day3Bis(26)).isEqualTo(54)
    }

}