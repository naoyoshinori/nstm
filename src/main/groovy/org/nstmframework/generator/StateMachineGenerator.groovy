package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineGenerator extends Generator {

    @TemplateParameter
    String name

    @TemplateGenerator
    def createFiles() {
        createFile("StateMachine/src/StateMachine.h", "src/${name}.h")
        createFile("StateMachine/src/StateMachine.cpp", "src/${name}.cpp")
    }
}
