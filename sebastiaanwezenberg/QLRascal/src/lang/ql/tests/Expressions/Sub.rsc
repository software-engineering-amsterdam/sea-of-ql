module lang::ql::tests::Expressions::Sub

import lang::ql::tests::TestHelper;

public test bool testSub1() 
	= p("a - b") is sub
	;

public test bool testSub2() 
	= p("a - (b - c)") is sub
	;

public test bool testSub3() 
	= p("(a - b - c)") is sub
	;

public test bool testSub4() 
	= p("(a - b)") is sub
	;

public test bool testSub5() 
	= p("(a - b) - c") is sub
	;

public test bool testSub6() 
	= p("a - b - c") is sub
	;

public test bool testSub7() 
	= p("a - b * c") is sub
	;

public test bool testSub8() 
	= p("a * b - c") is sub
	;

public test bool testSub9() 
	= p("a - b / c") is sub
	;

public test bool testSub10() 
	= p("a / b - c") is sub
	;