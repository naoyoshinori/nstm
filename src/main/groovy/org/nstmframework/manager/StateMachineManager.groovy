package org.nstmframework.manager

import org.apache.commons.io.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineManager {

    /**
     * Application root path.
     */
    String app_root

    def addStateMachine(String name) {
        def found

        for (state_machine in FileUtils.lineIterator(new File(app_root, "nstm.yml"), "UTF-8")) {
            if (state_machine == "- ${name}") {
                found = true
                break
            }
        }

        if (!found) {
            FileUtils.writeLines(new File(app_root, "nstm.yml"), "UTF-8", ["- ${name}"], true)
        }
    }
}
