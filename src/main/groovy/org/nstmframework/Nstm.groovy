package org.nstmframework

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import groovy.util.logging.Slf4j
import org.nstmframework.command.CommandExecution
import org.nstmframework.command.CommandOptions
import org.nstmframework.exception.NstmErrorException
import org.nstmframework.exception.NstmException
import org.slf4j.LoggerFactory

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
class Nstm {

    static main(args) {
        try {

            def commands = new CommandOptions(Arrays.asList(args))
            if (commands.pop(/--debug/) == '--debug') {
                setLoggingLevel(Level.DEBUG)
            }

            new CommandExecution(commands: commands).start()

        } catch (NstmException ex) {
            if (ex.message) println ex.message
        } catch (NstmErrorException ex) {
            log.error ex.message
        } catch (Exception ex) {
            log.error ex.message
        }
    }

    static setLoggingLevel(Level level) {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
        root.setLevel(level)
    }
}
