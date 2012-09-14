#include "${factory_name}.h"
#include "StateMachineManager.h"

using namespace StateMachineFramework;

int main(void)
{
    // �C���X�^���X���쐬����N���X
    // AbstractStateMachineFactory �N���X���������Ă��������B
    ${factory_name} factory;
    // ��ԑJ�ڂ��Ǘ�����N���X
    StateMachineManager manager(&factory);

    // �J�n����X�e�[�g�}�V�����w�肵�Ă��������B
    manager.create("${first_state_machine}");
    // ��ԑJ�ڂ��I���܂Ŏ��s�B
    while (!manager.run());
}
