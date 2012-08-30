package org.nstmframework.generator

import org.apache.commons.io.FileUtils
import spock.lang.Specification

/**
 * User: Naoyuki Yoshinori
 */
class AppGeneratorTest extends Specification {

    String app_root = 'build/test-projects'

    def "アプリケーションを作成する"() {
        given:
        def generator = new AppGenerator(app_root: app_root, app_name: app_name)
        generator.start()

        expect:
        new File(app_root, app_name)

        where:
        app_name << ["newApp1"]
    }
}
