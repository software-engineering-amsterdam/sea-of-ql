module lang::ql::tests::Expressions::Money

import lang::ql::tests::TestHelper;

public test bool testMoney1() 
	= p("10.21") is money
	;

public test bool testMoney2() 
	= p("4.") is money
	;

public test bool testMoney3() 
	= p("0.5") is money
	;

public test bool testMoney4() 
	= p("2.4") is money
	;

public test bool testMoney5() 
	= p("9.00") is money
	;

public test bool testMoney6() 
	= p("0.99") is money
	;