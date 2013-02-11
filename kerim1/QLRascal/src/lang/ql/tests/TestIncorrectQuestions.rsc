module lang::ql::tests::TestIncorrectQuestions

import Message;
import lang::ql::util::Implode;
import lang::ql::checker::Check;

loc testFile = |project://QLRascal/src/lang/ql/tests/ql/IncorrectQuestions.q|;

public test bool testIncorrectQuestions() = 
	{	error("Question has already been defined before with type bool", _),
		error("Question has already been defined before with type int", _),
		error("There is already a non-computed version of this question", _),
		error("There is already a computed version of this question", _),
		error("Question has already been defined before", _),
		error("Question has already been defined before", _),
		warning("Duplicate label", _)
	} := checkForm(load(testFile));