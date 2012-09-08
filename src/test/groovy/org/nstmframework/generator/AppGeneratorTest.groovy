package org.nstmframework.generator

import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: Naoyuki Yoshinori
 */
class AppGeneratorTest extends Specification {

    static app_root = 'build/test-projects'

    @Unroll
    def "#app_name アプリケーションを作成する"() {
        given:
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()

        expect:
        new File(app_root, app_name).exists()

        where:
        app_name << ["newApp1"]
    }
}
