#pragma once
#include "StateMachine.h"

class ${name} :
    public StateMachineFramework::StateMachine
{
public:
    void doEntries(void); // �J�n���Ɉ�x�������s�����
    void doActions(void); // �J�ڂ����܂Ŏ��s�����
    void doEvents(void);  // �J�ڂ����܂Ŏ��s�����
    void doExits(void);   // �I�����Ɉ�x�������s�����
};

