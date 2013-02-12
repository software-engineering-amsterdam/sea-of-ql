module lang::ql::tests::Expressions::Leq

import lang::ql::tests::TestHelper;

public test bool testLeq1() 
	= p("a \<= b") is leq
	;

public test bool testLeq2() 
	= p("a \<= b + c") is leq
	;

public test bool testLeq3() 
	= p("a + b \<= c") is leq
	;
