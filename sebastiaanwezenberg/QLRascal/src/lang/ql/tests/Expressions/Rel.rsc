module lang::ql::tests::Expressions::Rel

import lang::ql::tests::TestHelper;

public test bool testRel1() 
	= p("a \< b") is lt
	;

public test bool testRel2() 
	= p("(a \<= b)") is leq
	;

public test bool testRel3() 
	= p("(a * b) \< c") is lt
	;

public test bool testRel4() 
	= p("a \< (b * c)") is lt
	;

public test bool testRel5() 
	= p("a \< b + c") is lt
	;

public test bool testRel6() 
	= p("a + b \> c") is gt
	;

public test bool testRel7() 
	= p("a \> b + c") is gt
	;