package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class EventActionGenerator extends Generator {

    @TemplateParameter
    String name

    @TemplateGenerator
    def createFiles() {
        createFile("EventAction/src/EventAction.h", "src/${name}EventAction.h")
        createFile("EventAction/src/EventAction.cpp", "src/${name}EventAction.cpp")
    }
}
