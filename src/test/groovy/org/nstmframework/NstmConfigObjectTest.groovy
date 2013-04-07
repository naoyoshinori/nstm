package org.nstmframework

import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: Naoyuki Yoshinori
 */
class NstmConfigObjectTest extends Specification {

    @Unroll
    def "null テスト ConfigObject #property != null"() {
        given:
        def config = new ConfigObject()

        expect:
        config[property] != null
        config[property] != null

        where:
        property << ['app_root', 'template_root', 'encoding']
    }

    @Unroll
    def "値テスト ConfigObject #property == #value"() {
        given:
        def config = new ConfigObject()
        config[property] = value

        expect:
        config[property] != null
        config[property] == value

        where:
        property       | value
        'app_root'     | '/nstm'
        'template_root'| '/template'
        'encoding'     | 'UTF-8'
    }

    @Unroll
    def "null テスト NstmConfigObject #property == null"() {
        given:
        def config = new NstmConfigObject()

        expect:
        config[property] == null
        config[property] == null

        where:
        property << ['app_root', 'template_root', 'encoding']
    }

    @Unroll
    def "null テスト NstmConfigObject #property1 #property2 == null"() {
        given:
        def config = new NstmConfigObject()
        config[property1] = createProperty()

        expect:
        config[property1][property2] == null
        config[property1][property2] == null

        where:
        property1      |property2 | value
        'app_root'     |'app'     | '/nstm'
        'template_root'|'template'| '/template'
        'encoding'     |'default' | 'UTF-8'
    }

    @Unroll
    def "null テスト NstmConfigObject #property1 #property2 == #value"() {
        given:
        def config = new NstmConfigObject()
        config.map()."$property1"."$property2" = value

        expect:
        config."$property1"."$property2" != null
        config."$property1"."$property2" == value

        where:
        property1      |property2 | value
        'app_root'     |'app'     | '/nstm'
        'template_root'|'template'| '/template'
        'encoding'     |'default' | 'UTF-8'
    }

    def createProperty() {
        ['_PROPERTY_': 'DUMMY']
    }

    @Unroll
    def "値テスト NstmConfigObject #property == #value"() {
        given:
        def config = new NstmConfigObject()
        config[property] = value

        expect:
        config[property] != null
        config[property] == value

        where:
        property       | value
        'app_root'     | '/nstm'
        'template_root'| '/template'
        'encoding'     | 'UTF-8'
    }
}
