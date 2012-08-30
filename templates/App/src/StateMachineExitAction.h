#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineExitAction クラス.<br />
	 * このクラスを継承して、ステートマシンのイグジットを実装してください.
	 */
	class StateMachineExitAction :
		public StateMachineAction
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachineExitAction(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineExitAction(void) {}

		/**
		 * ActionCode クラスを取得します。
		 */
		virtual ActionCode getActionCode() { return EXIT; }
	};

}

