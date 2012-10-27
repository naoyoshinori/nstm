#include "${factory_name}.h"
#include "StateMachineManager.h"

using namespace StateMachineFramework;

int main(void)
{
    // インスタンスを作成するクラス
    // AbstractStateMachineFactory クラスを実装してください。
    ${factory_name} factory;
    // 状態遷移を管理するクラス
    StateMachineManager manager(&factory);

    // 開始するステートマシンを指定してください。
    manager.create("${first_state_machine}");
    // 状態遷移が終わるまで実行。
    while (!manager.run());

    return 0;
}
