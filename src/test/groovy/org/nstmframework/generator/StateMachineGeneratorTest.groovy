package org.nstmframework.generator

import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineGeneratorTest extends Specification {

    static app_root = "build/test-projects"
    static app_name = "newApp2"

    def setupSpec() {
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()
    }

    @Unroll
    def "#name ステートマシンを作成する"() {
        given:
        def generator = new StateMachineGenerator(app_root: "${app_root}/${app_name}", name: name)
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${name}.h").exists()
        new File("${app_root}/${app_name}/src/${name}.cpp").exists()

        where:
        name << ["AStm", "BStm", "CStm", "AStm", "BStm", "CStm"]
    }
}
