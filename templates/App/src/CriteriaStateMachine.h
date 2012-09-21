#pragma once
#include "StateMachineAction.h"
#include "StateMachineEntryAction.h"
#include "StateMachineDoAction.h"
#include "StateMachineEventAction.h"
#include "StateMachineExitAction.h"
#include "StateMachine.h"

namespace StateMachineFramework
{

	/**
	 * CriteriaStateMachine クラス。
	 */
	class CriteriaStateMachine :
		public StateMachine
	{
	public:

		/**
		 * コンストラクタ。
		 */
		CriteriaStateMachine(void);

		/**
		 * 仮想デストラクタ。
		 */
		~CriteriaStateMachine(void);

		/**
		 * ステートマシンのすべての Entry を実行します。
		 */
		void doEntries(void);

		/**
		 * ステートマシンのすべての Do を実行します。
		 */
		void doActions(void);

		/**
		 * ステートマシンのすべての Event を実行します。
		 */
		void doEvents(void);

		/**
		 * ステートマシンのすべての Exit を実行します。
		 */
		void doExits(void);

		void addStateMachineAction(StateMachineAction *action);

	private:
		StateMachineAction **actionList;
		int sizeOfTable;
		int numberOfActions;
	};

}

