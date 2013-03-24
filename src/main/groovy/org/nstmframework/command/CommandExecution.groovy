package org.nstmframework.command

import groovy.util.logging.Slf4j
import org.nstmframework.exception.NstmException

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class CommandExecution {

    CommandOptions commands

    def start() {
        def alias = [
                'g':  'generate',
                'cf': 'create-factory',
                'cm': 'create-main',
        ]

        def command = commands.shift()
        command = alias[command] ? alias[command] : command

        log.debug "Execute command: {}", command
        switch (command) {
            case 'new':
                new Application(args: commands).start()
                break

            case 'generate':
                new Generators(args: commands).start()
                break

            case 'create-factory':
                new StateMachineFactory(args: commands).start()
                break

            case 'create-main':
                new StateMachineMain(args: commands).start()
                break

            default:
                throw new NstmException()
                break
        }
    }
}
