package org.nstmframework.command

import org.nstmframework.util.FileUtils
import org.nstmframework.generator.AppGenerator
import org.nstmframework.util.ArgumentUtils
import org.nstmframework.exception.NstmException

/**
 * User: Naoyuki Yoshinori
 */
class Application {

    List args

    def start() {
        if (!(args?.size() > 0)) {
            throw new NstmException()
        }

        def app_name = ArgumentUtils.shift(args)
        def debug = ArgumentUtils.shift() == '--debug'

        if (FileUtils.exists("./${app_name}") || FileUtils.exists('./nstm.txt')) {
            println '  The application is already created.'
            return
        }

        new AppGenerator(app_name: app_name, debug: debug).start()
    }
}
