#pragma once
#include "AbstractStateMachineFactory.h"

namespace StateMachineFramework
{

	/**
	 * StateMachineManager �N���X.
	 */
	class StateMachineManager
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 * @param factory �t�@�N�g���[�N���X
		 */
		StateMachineManager(AbstractStateMachineFactory *factory);

		/**
		 * �f�X�g���N�^�B
		 */
		~StateMachineManager(void);

		/**
		 * �������B
		 * @param key ��ԃL�[
		 */
		bool create(char *key);

		/**
		 * ���s����B
		 */
		bool run(void);

	private:

		/**
		 * �N���[�Y�B
		 */
		void close(void);

		AbstractStateMachineFactory *factory;
		StateMachine *currentStateMachine;
	};

}

