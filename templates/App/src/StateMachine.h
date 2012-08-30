#pragma once
#include "StateMachineNoticeResolver.h"

namespace StateMachineFramework
{

	/**
	 * StateMachine �N���X�B
	 */
	class StateMachine :
		public StateMachineNoticeResolver
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachine(void) {}
		
		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachine(void) {}

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Entry �����s���܂��B
		 */
		virtual void doEntries(void) = 0;

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Do �����s���܂��B
		 */
		virtual void doActions(void) = 0;

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Event �����s���܂��B
		 */
		virtual void doEvents(void) = 0;

		/**
		 * �X�e�[�g�}�V���̂��ׂĂ� Exit �����s���܂��B
		 */
		virtual void doExits(void) = 0;

	};

}

