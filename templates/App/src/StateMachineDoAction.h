#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineDoAction クラス.<br />
	 * このクラスを継承して、ステートマシンのドゥを実装してください.
	 */
	class StateMachineDoAction :
		public StateMachineAction
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachineDoAction(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineDoAction(void) {}

		/**
		 * ActionCode クラスを取得します。
		 */
		virtual ActionCode getActionCode() { return DO; }
	};

}

