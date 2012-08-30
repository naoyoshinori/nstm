package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class ExitActionGenerator extends Generator {

    @TemplateParameter
    String name

    @TemplateGenerator
    def createFiles() {
        createFile("ExitAction/src/ExitAction.h", "src/${name}ExitAction.h")
        createFile("ExitAction/src/ExitAction.cpp", "src/${name}ExitAction.cpp")
    }
}
