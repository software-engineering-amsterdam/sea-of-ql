module lang::ql::tests::Expressions::Lt

import lang::ql::tests::TestHelper;

public test bool testLt1() 
	= p("a \< b") is lt
	;

public test bool testLt2() 
	= p("a \< b + c") is lt
	;

public test bool testLt3() 
	= p("a + b \< c") is lt
	;
