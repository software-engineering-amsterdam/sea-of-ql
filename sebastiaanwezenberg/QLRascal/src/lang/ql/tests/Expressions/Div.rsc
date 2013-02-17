module lang::ql::tests::Expressions::Div

import lang::ql::tests::TestHelper;

public test bool testDiv1() 
	= p("a / b") is div
	;

public test bool testDiv2() 
	= p("a / b / c") is div
  	;

public test bool testDiv3() 
	= p("(a / b)") is div
	;

public test bool testDiv4() 
	= p("(a + b) / c") is div
	;

public test bool testDiv5() 
	= p("a / (b / c)") is div
	;

public test bool testDiv6() 
	= p("(a / b) / c") is div
	;