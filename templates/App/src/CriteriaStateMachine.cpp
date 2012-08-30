#include "CriteriaStateMachine.h"

using namespace StateMachineFramework;

CriteriaStateMachine::CriteriaStateMachine(void)
	: actionList(0), sizeOfTable(10), numberOfActions(0)
{
	actionList = new StateMachineAction*[sizeOfTable];
}

CriteriaStateMachine::~CriteriaStateMachine(void)
{
	if (actionList != 0) {
		delete[] actionList;
		actionList = 0;
	}
}

void CriteriaStateMachine::doEntries(void)
{
	for (int i = 0; i < numberOfActions; i++) {
		if (actionList[i]->getActionCode() == StateMachineAction::ENTRY) {
			actionList[i]->execute();
		}
	}
}

void CriteriaStateMachine::doActions(void)
{
	for (int i = 0; i < numberOfActions; i++) {
		if (actionList[i]->getActionCode() == StateMachineAction::DO) {
			actionList[i]->execute();
		}
	}
}

void CriteriaStateMachine::doEvents(void)
{
	for (int i = 0; i < numberOfActions; i++) {
		if (actionList[i]->getActionCode() == StateMachineAction::EVENT) {
			actionList[i]->execute();
			StateMachineEventAction *action = (StateMachineEventAction *)actionList[i];
			if (action->isChanged()) {
				notifyNextStateMachineKey(action->getNextStateMachineKey());
				break;
			}
		}
	}
}

void CriteriaStateMachine::doExits(void)
{
	for (int i = 0; i < numberOfActions; i++) {
		if (actionList[i]->getActionCode() == StateMachineAction::EXIT) {
			actionList[i]->execute();
		}
	}
}

void CriteriaStateMachine::addStateMachineAction(StateMachineAction *action)
{
	if (numberOfActions < sizeOfTable) {
		actionList[numberOfActions++] = action;
	}
}

