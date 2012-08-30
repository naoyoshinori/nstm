package org.nstmframework.generator

import org.nstmframework.engine.TemplateGenerator
import org.nstmframework.engine.TemplateParameter

/**
 * User: Naoyuki Yoshinori
 */
class AppGenerator extends Generator {

    @TemplateParameter
    String app_name

    @TemplateGenerator
    def createAppFiles() {
        createDirectory(app_name)
        copyFile("App/src/StateMachineNoticeResolver.h", "${app_name}/src/StateMachineNoticeResolver.h")
        copyFile("App/src/StateMachineNoticeResolver.cpp", "${app_name}/src/StateMachineNoticeResolver.cpp")
        copyFile("App/src/StateMachine.h", "${app_name}/src/StateMachine.h")
        copyFile("App/src/StateMachineAction.h", "${app_name}/src/StateMachineAction.h")
        copyFile("App/src/StateMachineDoAction.h", "${app_name}/src/StateMachineDoAction.h")
        copyFile("App/src/StateMachineEntryAction.h", "${app_name}/src/StateMachineEntryAction.h")
        copyFile("App/src/StateMachineEventAction.h", "${app_name}/src/StateMachineEventAction.h")
        copyFile("App/src/StateMachineExitAction.h", "${app_name}/src/StateMachineExitAction.h")
        copyFile("App/src/CriteriaStateMachine.h", "${app_name}/src/CriteriaStateMachine.h")
        copyFile("App/src/CriteriaStateMachine.cpp", "${app_name}/src/CriteriaStateMachine.cpp")
        copyFile("App/src/AbstractStateMachineFactory.h", "${app_name}/src/AbstractStateMachineFactory.h")
        copyFile("App/src/StateMachineManager.h", "${app_name}/src/StateMachineManager.h")
        copyFile("App/src/StateMachineManager.cpp", "${app_name}/src/StateMachineManager.cpp")
        copyFile("App/nstm.txt", "${app_name}/nstm.txt")
        copyFile("App/nstm.txt", "${app_name}/nstm.txt")
    }
}
