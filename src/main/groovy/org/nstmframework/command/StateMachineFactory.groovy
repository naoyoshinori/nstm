package org.nstmframework.command

import org.ho.yaml.Yaml
import org.ho.yaml.exception.YamlException
import org.nstmframework.exception.NstmErrorException
import org.nstmframework.exception.NstmException
import org.nstmframework.generator.StateMachineFactoryGenerator
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineFactory {

    CommandOptions commands

    def start() {
        if (!FileUtils.exists("./nstm.yml")) {
            throw new NstmException('  It is not in the root directory of the application.')
        }

        def factory_name = commands.shift()

        try {
            new StateMachineFactoryGenerator(
                    factory_name: factory_name ? factory_name : 'StateMachineFactory',
                    state_machine_list: Yaml.load(new File('./nstm.yml'))
            ).start()
        } catch (YamlException ex) {
            throw new NstmErrorException()
        }
    }
}
