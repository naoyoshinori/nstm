package org.nstmframework.command

import org.nstmframework.util.ArgumentUtils
import org.nstmframework.exception.NstmException

/**
 * User: Naoyuki Yoshinori
 */
class Commands {

    String[] args

    def start() {
        def alias = [
                'g':  'generate',
                'cf': 'create-factory',
                'cm': 'create-main',
        ]

        List commands = new ArrayList<>(Arrays.asList(args))

        def command = ArgumentUtils.shift(commands)
        command = alias["${command}"] ? alias[command] : command

        println command
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
