package org.nstmframework.command

import org.nstmframework.exception.NstmException
import org.nstmframework.util.ArgumentUtils
import org.nstmframework.util.FileUtils
import org.nstmframework.exception.NstmErrorException

/**
 * User: Naoyuki Yoshinori
 */
class Generators {

    List args

    def start() {
        if (!(args?.size() >= 2)) {
            throw new NstmException()
        }

        if (!FileUtils.exists("./nstm.txt")) {
            println '  It is not in the root directory of the application.'
            return
        }

        def command = ArgumentUtils.shift(args)
        def name = ArgumentUtils.shift(args)
        def debug = ArgumentUtils.shift(args) == '--debug'

        try {
            command
            def generator_name = createGeneratorName(command) + 'Generator'
            Class.forName("org.nstmframework.generator.${generator_name}")?.newInstance(name: name, debug: debug).start()

        } catch (ClassNotFoundException ex) {
            println "[ERROR] command is not found. `${command}`"
            throw new NstmErrorException()
        }
    }

    def createGeneratorName(String command) {
        command.split('-').collect() { it.capitalize() }.join()
    }
}
