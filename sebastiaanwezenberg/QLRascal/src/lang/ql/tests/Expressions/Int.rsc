module lang::ql::tests::Expressions::Int

import lang::ql::tests::TestHelper;

public test bool testInt1() 
	= p("0") is \int
	;

public test bool testInt2() 
	= p("1223") is \int
	;

public test bool testInt3() 
	= p("234234234") is \int
	;

public test bool testInt3() 
	= p("123123123123123123") is \int
	;
