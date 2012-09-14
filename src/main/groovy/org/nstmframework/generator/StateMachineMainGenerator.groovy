package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineMainGenerator extends Generator {

    @TemplateParameter
    def name

    @TemplateParameter
    def factory_name

    @TemplateParameter
    def first_state_machine

    @TemplateGenerator
    def createMainFile() {
        createFile("StateMachineMain/src/Main.cpp", "src/${name}.cpp")
    }
}
