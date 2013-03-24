package org.nstmframework.command

import spock.lang.Ignore
import spock.lang.Specification

/**
 * User: Naoyuki Yoshinori
 */
class CommadOptionsTest extends Specification {

    @Ignore
    def "null の場合は、null を返す"() {
        given:
        def args = null
        def commands = new CommandOptions(Arrays.asList(args))

        expect:
        commands.shift() == null
    }

    def "[] の場合は、null を返す"() {
        given:
        def args = []
        def commands = new CommandOptions(args)

        expect:
        commands.size() == 0
        commands.shift() == null
    }

    def "1個は、null を返す"() {
        given:
        def args = ["aa"]
        def commands = new CommandOptions(args)

        expect:
        commands.shift() == 'aa'
        commands.shift() == null
        commands.size() == 0
    }

    def "１つずつ取り出す"() {
        given:
        def args = ["aa", "bb", "cc"]
        def commands = new CommandOptions(args)

        expect:
        commands.shift() == "aa"
        commands.shift() == "bb"
        commands.shift() == "cc"
        commands.shift() == null
    }
}
