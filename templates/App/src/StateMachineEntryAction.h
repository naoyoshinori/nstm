#pragma once
#include "StateMachineAction.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineEntryAction �N���X.<br />
	 * ���̃N���X���p�����āA�X�e�[�g�}�V���̃G���g�����������Ă�������.
	 */
	class StateMachineEntryAction :
		public StateMachineAction
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineEntryAction(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineEntryAction(void) {}

		/**
		 * ActionCode �N���X���擾���܂��B
		 */
		virtual ActionCode getActionCode() { return ENTRY; }
	};

}
