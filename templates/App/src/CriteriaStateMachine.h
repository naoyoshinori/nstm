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
	 * CriteriaStateMachine �N���X�B
	 */
	class CriteriaStateMachine :
		public StateMachine
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		CriteriaStateMachine(void);

		/**
		 * ���z�f�X�g���N�^�B
		 */
		~CriteriaStateMachine(void);

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Entry �����s���܂��B
		 */
		void doEntries(void);

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Do �����s���܂��B
		 */
		void doActions(void);

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Event �����s���܂��B
		 */
		void doEvents(void);

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Exit �����s���܂��B
		 */
		void doExits(void);

		void addStateMachineAction(StateMachineAction *action);

	private:
		StateMachineAction **actionList;
		int sizeOfTable;
		int numberOfActions;
	};

}

