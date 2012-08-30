#include <string.h>
#include "StateMachineNoticeResolver.h"

using namespace StateMachineFramework;

StateMachineNoticeResolver::StateMachineNoticeResolver(void)
    : changed(false), nextStateMachineKey(0)
{
}

StateMachineNoticeResolver::~StateMachineNoticeResolver(void)
{
    close();
}

bool StateMachineNoticeResolver::isChanged(void)
{
    return changed;
}

char * StateMachineNoticeResolver::getNextStateMachineKey(void)
{
    return nextStateMachineKey;
}

void StateMachineNoticeResolver::setNextStateMachineKey(const char * nextStateMachineKey)
{
	if (this->nextStateMachineKey == nextStateMachineKey) return;

	this->close();

	if (nextStateMachineKey == 0) {
		this->nextStateMachineKey = 0;
	} else {
		this->nextStateMachineKey = new char[strlen(nextStateMachineKey) + 1]();
		strcpy(this->nextStateMachineKey, nextStateMachineKey);
	}
}


void StateMachineNoticeResolver::notifyChanged(const bool changed)
{
    this->changed = changed;
}

void StateMachineNoticeResolver::notifyNextStateMachineKey(const char * nextStateMachineKey)
{
    notifyChanged(true);
    this->setNextStateMachineKey(nextStateMachineKey);
}

void StateMachineNoticeResolver::close(void)
{
    if (nextStateMachineKey != 0) {
        delete[] nextStateMachineKey;
        nextStateMachineKey = 0;
    }
}
