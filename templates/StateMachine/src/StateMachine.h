#pragma once
#include "StateMachine.h"

class ${name} :
    public StateMachineFramework::StateMachine
{
public:
    void doEntries(void); // 開始時に一度だけ実行される
    void doActions(void); // 遷移されるまで実行される
    void doEvents(void);  // 遷移されるまで実行される
    void doExits(void);   // 終了時に一度だけ実行される
};

