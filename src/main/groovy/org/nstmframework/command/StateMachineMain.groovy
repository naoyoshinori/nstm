package org.nstmframework.command

import groovy.util.logging.Slf4j
import org.nstmframework.exception.NstmException
import org.nstmframework.generator.StateMachineMainGenerator
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class StateMachineMain {

    CommandOptions commands

    def start() {
        if (!(commands?.size() > 0)) {
            throw new NstmException()
        }

        if (!FileUtils.exists('./nstm.txt')) {
            throw new NstmException('  It is not in the root directory of the application.')
        }

        def options = [
                'start'  : 'Start State Machine Name',
                'main'   : 'Main',
                'factory': 'StateMachineFactory',
        ]

        for (String option; option = commands.shift(); ) {
            def option_and_value = option.split(":")

            if (option_and_value.size() < 2) {
                throw new NstmException("[ERROR] options error. `${option}`")
            }

            options[option_and_value[0]] = option_and_value[1]
        }

        log.debug "Options: {}", options

        new StateMachineMainGenerator(first_state_machine: options['start'], name: options['main'], factory_name: options['factory']).start()
    }
}
