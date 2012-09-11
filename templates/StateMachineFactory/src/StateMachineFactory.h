#pragma once
#include "AbstractStateMachineFactory.h"

using namespace StateMachineFramework;

class ${factory_name} :
	public StateMachineFramework::AbstractStateMachineFactory
{
public:
	${factory_name}(void);
	~${factory_name}(void);

	StateMachine * createStateMachine(const char *state_machine_key);
	void close(void);

private:
	StateMachine *current_stm_;
};

