package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineFactoryGenerator extends Generator {

    @TemplateParameter
    def factory_name

    @TemplateParameter
    def state_machine_list

    @TemplateGenerator
    def createFiles() {
        createFile("StateMachineFactory/src/StateMachineFactory.h", "src/${factory_name}.h")
        createFile("StateMachineFactory/src/StateMachineFactory.cpp", "src/${factory_name}.cpp")
    }
}
