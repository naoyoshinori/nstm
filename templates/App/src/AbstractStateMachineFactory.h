#pragma once
#include "StateMachine.h"

namespace StateMachineFramework
{

	/**
	 * AbstractStateMachineFactory �N���X.
	 */
	class AbstractStateMachineFactory
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		AbstractStateMachineFactory(void) {}

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~AbstractStateMachineFactory(void) {}

		/**
		 * StateMachine �N���X�̃C���X�^���X���쐬����B
		 */
		virtual StateMachine * createStateMachine(const char *key) = 0;
	};

}

