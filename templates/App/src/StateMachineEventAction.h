#pragma once
#include "StateMachineNoticeResolver.h"
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineEventAction クラス.<br />
	 * このクラスを継承して、ステートマシンのイベントを実装してください.
	 */
	class StateMachineEventAction :
		public StateMachineNoticeResolver, public StateMachineAction
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachineEventAction(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineEventAction(void) {}

		/**
		 * ActionCode クラスを取得します。
		 */
		virtual ActionCode getActionCode() { return EVENT; }

	};

}

