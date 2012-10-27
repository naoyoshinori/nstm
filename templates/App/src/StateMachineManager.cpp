#include <iostream>
#include "StateMachineManager.h"

using namespace StateMachineFramework;

StateMachineManager::StateMachineManager(AbstractStateMachineFactory *factory)
	: factory(factory), currentStateMachine(0)
{
}

StateMachineManager::~StateMachineManager(void)
{
	close();
}

bool StateMachineManager::create(const char *key)
{
	bool result = false;
	close();
	currentStateMachine = factory->createStateMachine(key);
	if (currentStateMachine != 0) {
		currentStateMachine->doEntries();
		result = true;
	}
	return result;
}

void StateMachineManager::close(void)
{
	if (currentStateMachine != 0) {
		currentStateMachine = 0;
	}
}

bool StateMachineManager::run(void)
{
	bool result = false;

    if (currentStateMachine == 0) {
        result = true;
        return result;
    }

	currentStateMachine->doActions();
	currentStateMachine->doEvents();
	if (currentStateMachine->isChanged()) {
		currentStateMachine->doExits();
		char *key = currentStateMachine->getNextStateMachineKey();
		result = !(create(key));
	}

	return result;
}