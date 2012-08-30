#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineEntryAction クラス.<br />
	 * このクラスを継承して、ステートマシンのエントリを実装してください.
	 */
	class StateMachineEntryAction :
		public StateMachineAction
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachineEntryAction(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineEntryAction(void) {}

		/**
		 * ActionCode クラスを取得します。
		 */
		virtual ActionCode getActionCode() { return ENTRY; }
	};

}
