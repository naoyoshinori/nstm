package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class DoActionGenerator extends Generator {

    @TemplateParameter
    String name

    @TemplateGenerator
    def createFiles() {
        createFile("DoAction/src/DoAction.h", "src/${name}DoAction.h")
        createFile("DoAction/src/DoAction.cpp", "src/${name}DoAction.cpp")
    }
}
