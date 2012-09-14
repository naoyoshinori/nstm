package org.nstmframework.generator

import spock.lang.Specification

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineMainGeneratorTest extends Specification {

    static app_root = "build/test-projects"
    static app_name = "newApp5"

    def setupSpec() {
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()
    }

    def "#name Mainを作成する"() {
        given:
        def generator = new StateMachineMainGenerator(app_root: "${app_root}/${app_name}", name: name)
        generator.factory_name = "StateMachineFactory"
        generator.first_state_machine = "start"
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${name}.cpp")

        where:
        name << ["Main", "MainA"]
    }
}
