package day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day7KtTest {

    val tower = ProgramTower(listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    ))

    @Test
    fun testDay7() {
        assertThat(tower.day7()).isEqualTo("tknk")
    }

    @Test
    fun testDay7Bis() {
        assertThat(tower.day7Bis()).isEqualTo(60)
    }

}