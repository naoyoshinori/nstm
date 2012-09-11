package org.nstmframework.generator

import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineFactoryGeneratorTest extends Specification {

    static app_root = "build/test-projects"
    static app_name = "newApp4"

    def setupSpec() {
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()
    }

    @Unroll
    def "#factory_name を作成する"() {
        given:
        def generator = new StateMachineFactoryGenerator(app_root: "${app_root}/${app_name}", factory_name: factory_name)
        generator.state_machine_list = state_machine_list
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${factory_name}.h").exists()
        new File("${app_root}/${app_name}/src/${factory_name}.cpp").exists()

        where:
        factory_name          |state_machine_list
        "StateMachineFactory" |["AStm", "BStm", "CStm"]
        "MyFactory"           |["MyAStm", "MyBStm", "MyCStm"]
    }
}
