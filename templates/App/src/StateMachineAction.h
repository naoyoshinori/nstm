#pragma once

namespace StateMachineFramework
{

	/**
	 * StateMachineAction クラス。
	 */
	class StateMachineAction
	{
	public:
		/**
		 * ActionCode クラス。
		 */
		enum ActionCode {
			ENTRY,
			DO,
			EVENT,
			EXIT
		};

		/**
		 * コンストラクタ。
		 */
		StateMachineAction(void) {}

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineAction(void) {}

		/**
		 * 実行する。
		 */
		virtual void execute(void) = 0;

		/**
		 * ActionCode クラスを取得します。
		 */
		virtual ActionCode getActionCode() = 0;
	};

}

