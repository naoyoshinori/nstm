package org.nstmframework

import groovy.util.logging.Slf4j

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class NstmConfigObject implements Writable, Map, Cloneable  {

    @Delegate final private ConfigObject configObject

    NstmConfigObject() {
        this(new ConfigObject())
    }

    NstmConfigObject(Map m) {
        log.debug "The instance of {}.", m.getClass().simpleName
        if (m instanceof ConfigObject) {
            this.configObject = m
        } else {
            def c = new ConfigObject()
            c.putAll(m)
            this.configObject = c
        }
    }

    /**
     * config.property1.property2 = value # プロパティが空の場合 NullException が発生します。
     * config.property1.property2 == null #=> プロパティが空の場合 true になります。
     * {@inheritDoc}
     */
    @Override
    Object get(Object key) {
        def value
        if (configObject.containsKey(key)) {
            def v = configObject.get(key)
            if (v instanceof Map) {
                // map.property を呼び出した時、Map の 値が null の場合 [:] が設定され、
                // map.property == null が true にならないので、空の Map を null として扱うようにする。
                value = v.isEmpty() ? null : new NstmConfigObject(v)
            } else {
                value = v
            }
        }
        log.debug "key: {}, value: {}", key, value
        value
    }

    /**
     * config.map().property1.property2 = value # プロパティが空の場合 NullException は発生しません。
     * config.map().property1.property2 == null #=> プロパティが空の場合 false になります。
     * @return Map
     */
    Map map() {
        configObject
    }
}
