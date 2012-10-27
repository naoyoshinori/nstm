package org.nstmframework.util

import spock.lang.Specification

/**
 * User: Naoyuki Yoshinori
 */
class ArgumentUtilsTest extends Specification {

    def "null の場合は、null を返す"() {
        given:
        def args = null

        expect:
        ArgumentUtils.shift(args) == null

    }

    def "[] の場合は、null を返す"() {
        given:
        def args = []

        expect:
        ArgumentUtils.shift(args) == null

    }

    def "1個は、null を返す"() {
        given:
        def args = ["aa"]

        expect:
        ArgumentUtils.shift(args) == 'aa'
        ArgumentUtils.shift(args) == null

    }

    def "１つずつ取り出す"() {
        given:
        def args = ["aa", "bb", "cc"]

        expect:
        ArgumentUtils.shift(args) == "aa"
        ArgumentUtils.shift(args) == "bb"
        ArgumentUtils.shift(args) == "cc"
        ArgumentUtils.shift(args) == null
    }
}
