#pragma once
#include "StateMachine.h"

namespace StateMachineFramework
{

	/**
	 * AbstractStateMachineFactory クラス.
	 */
	class AbstractStateMachineFactory
	{
	public:

		/**
		 * コンストラクタ。
		 */
		AbstractStateMachineFactory(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~AbstractStateMachineFactory(void) {}

		/**
		 * StateMachine クラスのインスタンスを作成する。
		 */
		virtual StateMachine * createStateMachine(const char *key) = 0;
	};

}

