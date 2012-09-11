#include <string.h>
#include "${factory_name}.h"
#include "CriteriaStateMachine.h"

using namespace std;

<% state_machine_list?.each { %>
#include "${it}.h"
<% } %>

${factory_name}::${factory_name}(void)
	: current_stm_(0)
{
}

${factory_name}::~${factory_name}(void)
{
	close();
}

StateMachine * ${factory_name}::createStateMachine(const char *state_machine_key)
{
	if (state_machine_key == 0) {
		close();
		return 0;
	}

	// close ����O�ɃR�s�[�����B
	char *cp_key = new char[strlen(state_machine_key) + 1];
	strcpy(cp_key, state_machine_key);
	close();

	<% if (state_machine_list?.size() > 0) { %>
	if (strcmp(cp_key, "${state_machine_list.head()}") == 0) {
		current_stm_ = new ${state_machine_list.head()}();
	}
	<% state_machine_list[1..-1].each { %>
	else if (strcmp(cp_key, "${it}") == 0) {
		current_stm_ = new ${it}();
	}
	<% } } %>

	delete[] cp_key;
	return current_stm_;
}

void ${factory_name}::close(void)
{
	if (current_stm_ != 0) {
		delete current_stm_;
		current_stm_ = 0;
	}
}
