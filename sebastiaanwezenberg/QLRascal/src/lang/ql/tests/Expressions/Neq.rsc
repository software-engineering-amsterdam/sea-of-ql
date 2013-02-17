module lang::ql::tests::Expressions::Neq

import lang::ql::tests::TestHelper;

public test bool testNeq1() 
	= p("a != b") is neq
	;

public test bool testNeq2() 
	= p("a != (b + c)") is neq
	;

public test bool testNeq3() 
	= p("(a != b)") is neq
	;

public test bool testNeq4() 
	= p("(a + b) != c") is neq
	;

public test bool testNeq5() 
	= p("(a == b) != c") is neq
	;
	
