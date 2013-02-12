module lang::ql::tests::TestIncorrectExpressions

import Message;
import lang::ql::util::Implode;
import lang::ql::checker::CheckExpressions;

loc testFile = |project://QLRascal/src/lang/ql/tests/ql/IncorrectExpressions.q|;

public test bool testIncorrectExpressions() = 
	{	error("Required bool, got int", _),
		error("Required int, got bool", _),
		error("Required string, got bool", _),
		error("Required bool, got int", _),
		error("Required bool, got int", _),
		error("Required bool, got int", _),
		error("Required bool, got int", _),
		error("Required int or string, got bool", _),
		error("Required int, got string", _),
		error("Required int, got string", _),
		error("Undefined variable \"anUndefinedVariable\"", _),
		error("Cyclic dependency for x and y", _),
		error("Cyclic dependency for y and x", _),
		error("Cyclic dependency for z and z", _)
	} := checkExpressions(load(testFile));