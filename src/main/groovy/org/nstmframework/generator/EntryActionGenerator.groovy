package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class EntryActionGenerator extends Generator {

    @TemplateParameter
    String name

    @TemplateGenerator
    def createFiles() {
        createFile("EntryAction/src/EntryAction.h", "src/${name}EntryAction.h")
        createFile("EntryAction/src/EntryAction.cpp", "src/${name}EntryAction.cpp")
    }
}
