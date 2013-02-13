module lang::ql::tests::Expressions::Geq

import lang::ql::tests::TestHelper;

public test bool testGeq1() 
	= p("a \>= b") is geq
  	;

public test bool testGeq2() 
	= p("a \>= b + c") is geq
  	;

public test bool testGeq3() 
	= p("a + b \>= c") is geq
  	;
