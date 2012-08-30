#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineExitAction �N���X.<br />
	 * ���̃N���X���p�����āA�X�e�[�g�}�V���̃C�O�W�b�g���������Ă�������.
	 */
	class StateMachineExitAction :
		public StateMachineAction
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineExitAction(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineExitAction(void) {}

		/**
		 * ActionCode �N���X���擾���܂��B
		 */
		virtual ActionCode getActionCode() { return EXIT; }
	};

}

