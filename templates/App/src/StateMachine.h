#pragma once
#include "StateMachineNoticeResolver.h"

namespace StateMachineFramework
{

	/**
	 * StateMachine クラス。
	 */
	class StateMachine :
		public StateMachineNoticeResolver
	{
	public:

		/**
		 * コンストラクタ。
		 */
		StateMachine(void) {}
		
		/**
		 * 仮想デストラクタ。
		 */
		virtual ~StateMachine(void) {}

		/**
		 * ステートマシンのすべての Entry を実行します。
		 */
		virtual void doEntries(void) = 0;

		/**
		 * ステートマシンのすべての Do を実行します。
		 */
		virtual void doActions(void) = 0;

		/**
		 * ステートマシンのすべての Event を実行します。
		 */
		virtual void doEvents(void) = 0;

		/**
		 * ステートマシンのすべての Exit を実行します。
		 */
		virtual void doExits(void) = 0;

	};

}

