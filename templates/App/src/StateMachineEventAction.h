#pragma once
#include "StateMachineNoticeResolver.h"
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineEventAction �N���X.<br />
	 * ���̃N���X���p�����āA�X�e�[�g�}�V���̃C�x���g���������Ă�������.
	 */
	class StateMachineEventAction :
		public StateMachineNoticeResolver, public StateMachineAction
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineEventAction(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineEventAction(void) {}

		/**
		 * ActionCode �N���X���擾���܂��B
		 */
		virtual ActionCode getActionCode() { return EVENT; }

	};

}

