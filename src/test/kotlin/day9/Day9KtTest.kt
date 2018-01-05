package day9

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day9KtTest {

    @Test
    fun testCleanGarbage() {
        assertThat("<>".cleanGarbage()).isEmpty()
        assertThat("<random characters>".cleanGarbage()).isEmpty()
        assertThat("<<<<>".cleanGarbage()).isEmpty()
        assertThat("<{!>}>".cleanGarbage()).isEmpty()
        assertThat("<!!>".cleanGarbage()).isEmpty()
        assertThat("<!!!>>".cleanGarbage()).isEmpty()
        assertThat("<{o\"i!a,<{i<a>".cleanGarbage()).isEmpty()
    }

    @Test
    fun testDay9() {
        assertThat(day9("{}")).isEqualTo(1)
        assertThat(day9("{{{}}}")).isEqualTo(6)
        assertThat(day9("{{},{}}")).isEqualTo(5)
        assertThat(day9("{{{},{},{{}}}}")).isEqualTo(16)
        assertThat(day9("{<a>,<a>,<a>,<a>}")).isEqualTo(1)
        assertThat(day9("{{<ab>},{<ab>},{<ab>},{<ab>}}")).isEqualTo(9)
        assertThat(day9("{{<!!>},{<!!>},{<!!>},{<!!>}}")).isEqualTo(9)
        assertThat(day9("{{<a!>},{<a!>},{<a!>},{<ab>}}")).isEqualTo(3)
    }

    @Test
    fun testDay9Bis() {
        assertThat(day9Bis("<>")).isEqualTo(0)
        assertThat(day9Bis("<random characters>")).isEqualTo(17)
        assertThat(day9Bis("<<<<>")).isEqualTo(3)
        assertThat(day9Bis("<{!>}>")).isEqualTo(2)
        assertThat(day9Bis("<!!>")).isEqualTo(0)
        assertThat(day9Bis("<!!!>>")).isEqualTo(0)
        assertThat(day9Bis("<{o\"i!a,<{i<a>")).isEqualTo(10)
    }

}