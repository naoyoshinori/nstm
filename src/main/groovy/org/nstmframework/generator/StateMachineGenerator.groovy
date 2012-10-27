package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter
import org.nstmframework.manager.StateMachineManager

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
        new StateMachineManager(app_root: app_root).addStateMachine("${name}")
    }
}
