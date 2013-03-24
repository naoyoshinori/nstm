package org.nstmframework.command

import groovy.util.logging.Slf4j
import org.nstmframework.exception.NstmErrorException
import org.nstmframework.exception.NstmException
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class Generators {

    CommandOptions commands

    def start() {
        if (!(commands?.size() >= 2)) {
            throw new NstmException()
        }

        if (!FileUtils.exists("./nstm.txt")) {
            throw new NstmException('  It is not in the root directory of the application.')
        }

        def command = commands.shift()
        def name = commands.shift()

        try {
            def generator_name = createGeneratorName(command) + 'Generator'
            log.debug "Generator Class: {}", generator_name
            Class.forName("org.nstmframework.generator.${generator_name}")?.newInstance(name: name).start()

        } catch (ClassNotFoundException ex) {
            throw new NstmErrorException("[ERROR] command is not found. `${command}`")
        }
    }

    /**
     * state-machine -> StateMachine
     * @param command
     * @return
     */
    def createGeneratorName(String command) {
        command.split('-').collect() { it.capitalize() }.join()
    }
}
