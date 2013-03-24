package org.nstmframework.command

import groovy.util.logging.Slf4j
import org.nstmframework.exception.NstmException
import org.nstmframework.generator.AppGenerator
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class Application {

    CommandOptions commands

    def start() {
        if (!(commands?.size() > 0)) {
            throw new NstmException()
        }

        def app_name = commands.shift()

        if (FileUtils.exists("./${app_name}") || FileUtils.exists('./nstm.txt')) {
            throw new NstmException('  The application is already created.')
        }

        new AppGenerator(app_name: app_name).start()
    }
}
