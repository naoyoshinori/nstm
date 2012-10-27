package org.nstmframework.command

import org.nstmframework.exception.NstmErrorException
import org.nstmframework.exception.NstmException
import org.nstmframework.generator.StateMachineMainGenerator
import org.nstmframework.util.ArgumentUtils
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineMain {

    List args

    def start() {
        if (!(args?.size() > 0)) {
            throw new NstmException()
        }

        if (!FileUtils.exists('./nstm.txt')) {
            println '  It is not in the root directory of the application.'
            return
        }

        def options = [
                'start'  : 'Start State Machine Name',
                'main'   : 'Main',
                'factory': 'StateMachineFactory',
        ]

        for (String option; option = ArgumentUtils.shift(args); ) {
            def option_and_value = option.split(":")

            if (option_and_value.size() < 2) {
                println "[ERROR] options error. `${option}`"
                throw new NstmErrorException()
            }

            options["${option_and_value[0]}"] = option_and_value[1]
        }

        new StateMachineMainGenerator(first_state_machine: options['start'], name: options['main'], factory_name: options['factory']).start()
    }
}
