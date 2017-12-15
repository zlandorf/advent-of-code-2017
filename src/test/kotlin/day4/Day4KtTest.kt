package day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day4KtTest {

    @Test
    fun testFilter_example1() {
        assertThat(isValid("aa bb cc dd aaa")).isEqualTo(true)
    }

    @Test
    fun testFilter_example2() {
        assertThat(isValid("aa bb cc dd aa")).isEqualTo(false)
    }

    @Test
    fun testFilter_example3() {
        assertThat(isValid("aa bb cc dd ee")).isEqualTo(true)
    }

    @Test
    fun testSortWords() {
        assertThat(sortWords("oiii ioii iioi iiio")).isEqualTo("iiio iiio iiio iiio")
    }

}