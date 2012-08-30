#pragma once

namespace StateMachineFramework
{

	/**
	 * StateMachineAction �N���X�B
	 */
	class StateMachineAction
	{
	public:
		/**
		 * ActionCode �N���X�B
		 */
		enum ActionCode {
			ENTRY,
			DO,
			EVENT,
			EXIT
		};

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineAction(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineAction(void) {}

		/**
		 * ���s����B
		 */
		virtual void execute(void) = 0;

		/**
		 * ActionCode �N���X���擾���܂��B
		 */
		virtual ActionCode getActionCode() = 0;
	};

}

