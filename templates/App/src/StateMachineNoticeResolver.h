#pragma once

namespace StateMachineFramework
{

	/**
	 * StateMachineNoticeResolver クラス。
	 */
	class StateMachineNoticeResolver
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachineNoticeResolver(void);

		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachineNoticeResolver(void);

		/**
		 * 状態が変わったかどうかを返します。
		 * @return bool true の場合、状態が変化した。false の場合、状態が変化していない。
		 */
		virtual bool isChanged();

		/**
		 * 次の遷移先の状態キーを返します。
		 */
		virtual char * getNextStateMachineKey(void);

		/**
		 * 次の遷移先の状態キーを設定します。
		 */
		virtual void setNextStateMachineKey(const char *nextStateMachineKey);

	protected:

		/**
		 * 状態が状態が変わったことを通知します。
		 */
		virtual void notifyChanged(const bool changed);

		/**
		 * 状態遷移先の状態キーを通知します。
		 */
		virtual void notifyNextStateMachineKey(const char * nextStateMachineKey);

	private:

		/**
		 * メモリを開放します。
		 */
		void close(void);

		bool changed;
		char *nextStateMachineKey;
	};

}

