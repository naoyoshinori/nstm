#pragma once
#include "AbstractStateMachineFactory.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineManager クラス.
	 */
	class StateMachineManager
	{
	public:

		/**
		 * コンストラクタ。
		 * @param factory ファクトリークラス
		 */
		StateMachineManager(AbstractStateMachineFactory *factory);

		/**
		 * デストラクタ。
		 */
		~StateMachineManager(void);

		/**
		 * 初期化。
		 * @param key 状態キー
		 */
		bool create(const char *key);

		/**
		 * 実行する。
		 */
		bool run(void);

	private:

		/**
		 * クローズ。
		 */
		void close(void);

		AbstractStateMachineFactory *factory;
		StateMachine *currentStateMachine;
	};

}

