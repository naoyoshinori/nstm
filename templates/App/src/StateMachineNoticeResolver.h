#pragma once

namespace StateMachineFramework
{

	/**
	 * StateMachineNoticeResolver �N���X�B
	 */
	class StateMachineNoticeResolver
	{
	public:

		/**
		 * �R���X�g���N�^�B
		 */
		StateMachineNoticeResolver(void);

		/**
		 * ���z�f�X�g���N�^�B
		 */
		virtual ~StateMachineNoticeResolver(void);

		/**
		 * ��Ԃ��ς�������ǂ�����Ԃ��܂��B
		 * @return bool true �̏ꍇ�A��Ԃ��ω������Bfalse �̏ꍇ�A��Ԃ��ω����Ă��Ȃ��B
		 */
		virtual bool isChanged();

		/**
		 * ���̑J�ڐ�̏�ԃL�[��Ԃ��܂��B
		 */
		virtual char * getNextStateMachineKey(void);

		/**
		 * ���̑J�ڐ�̏�ԃL�[��ݒ肵�܂��B
		 */
		virtual void setNextStateMachineKey(const char *nextStateMachineKey);

	protected:

		/**
		 * ��Ԃ���Ԃ��ς�������Ƃ�ʒm���܂��B
		 */
		virtual void notifyChanged(const bool changed);

		/**
		 * ��ԑJ�ڐ�̏�ԃL�[��ʒm���܂��B
		 */
		virtual void notifyNextStateMachineKey(const char * nextStateMachineKey);

	private:

		/**
		 * ���������J�����܂��B
		 */
		void close(void);

		bool changed;
		char *nextStateMachineKey;
	};

}

