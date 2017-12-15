package day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class Day1KtTest {

    @Test
    fun testDay1_example1() {
        assertThat(day1("1122")).isEqualTo(3)
    }

    @Test
    fun testDay1_example2() {
        assertThat(day1("1111")).isEqualTo(4)
    }

    @Test
    fun testDay1_example3() {
        assertThat(day1("1234")).isEqualTo(0)
    }

    @Test
    fun testDay1_example4() {
        assertThat(day1("91212129")).isEqualTo(9)
    }

    @Test
    fun testDay1Bis_example1() {
        assertThat(day1Bis("1212")).isEqualTo(6)
    }

    @Test
    fun testDay1Bis_example2() {
        assertThat(day1Bis("1221")).isEqualTo(0)
    }

    @Test
    fun testDay1Bis_example3() {
        assertThat(day1Bis("123425")).isEqualTo(4)
    }

    @Test
    fun testDay1Bis_example4() {
        assertThat(day1Bis("123123")).isEqualTo(12)
    }

    @Test
    fun testDay1Bis_example5() {
        assertThat(day1Bis("12131415")).isEqualTo(4)
    }

}