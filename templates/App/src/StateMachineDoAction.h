#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineDoAction �N���X.<br />
	 * ���̃N���X���p�����āA�X�e�[�g�}�V���̃h�D���������Ă�������.
	 */
	class StateMachineDoAction :
		public StateMachineAction
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineDoAction(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineDoAction(void) {}

		/**
		 * ActionCode �N���X���擾���܂��B
		 */
		virtual ActionCode getActionCode() { return DO; }
	};

}

