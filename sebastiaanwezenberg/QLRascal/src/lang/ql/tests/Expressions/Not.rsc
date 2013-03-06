module lang::ql::tests::Expressions::Not

import lang::ql::tests::TestHelper;

public test bool testNot1() 
	= p("!a") is not
	;

public test bool testNot2() 
	= p("!(!a && !b)") is not
	;

public test bool testNot3()
	= p("!(a && b)") is not
	;