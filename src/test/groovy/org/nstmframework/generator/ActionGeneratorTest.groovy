package org.nstmframework.generator

import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: Naoyuki Yoshinori
 */
class ActionGeneratorTest extends Specification {

    static app_root = "build/test-projects"
    static app_name = "newApp3"

    def setupSpec() {
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()
    }

    @Unroll
    def "#action_name EntryAction を作成する"() {
        given:
        def generator = new EntryActionGenerator(app_root: "${app_root}/${app_name}", name: action_name)
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${action_name}EntryAction.h").exists()
        new File("${app_root}/${app_name}/src/${action_name}EntryAction.cpp").exists()

        where:
        action_name << ["Entry1", "Entry2", "Entry3"]
    }

    @Unroll
    def "#action_name DoAction を作成する"() {
        given:
        def generator = new DoActionGenerator(app_root: "${app_root}/${app_name}", name: action_name)
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${action_name}DoAction.h").exists()
        new File("${app_root}/${app_name}/src/${action_name}DoAction.cpp").exists()

        where:
        action_name << ["Do1", "Do2", "Do3"]
    }

    @Unroll
    def "#action_name EventAction を作成する"() {
        given:
        def generator = new EventActionGenerator(app_root: "${app_root}/${app_name}", name: action_name)
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${action_name}EventAction.h").exists()
        new File("${app_root}/${app_name}/src/${action_name}EventAction.cpp").exists()

        where:
        action_name << ["Event1", "Event2", "Event3"]
    }

    @Unroll
    def "#action_name ExitAction を作成する"() {
        given:
        def generator = new ExitActionGenerator(app_root: "${app_root}/${app_name}", name: action_name)
        generator.start()

        expect:
        new File("${app_root}/${app_name}/src/${action_name}ExitAction.h").exists()
        new File("${app_root}/${app_name}/src/${action_name}ExitAction.cpp").exists()

        where:
        action_name << ["Exit1", "Exit2", "Exit3"]
    }
}
