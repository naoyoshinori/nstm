package org.nstmframework.command

import org.ho.yaml.Yaml
import org.ho.yaml.exception.YamlException
import org.nstmframework.exception.NstmException
import org.nstmframework.generator.StateMachineFactoryGenerator
import org.nstmframework.util.ArgumentUtils
import org.nstmframework.util.FileUtils

/**
 * User: Naoyuki Yoshinori
 */
class StateMachineFactory {

    List args

    def start() {
        if (!FileUtils.exists("./nstm.yml")) {
            println '  It is not in the root directory of the application.'
            throw new NstmException()
        }

        def factory_name = ArgumentUtils.shift(args)

        try {
            new StateMachineFactoryGenerator(
                    factory_name: factory_name ? factory_name : 'StateMachineFactory',
                    state_machine_list: Yaml.load(new File('./nstm.yml'))
            ).start()
        } catch (YamlException ex) {
            throw new NstmException()
        }
    }
}
