module lang::ql::tests::Expressions::Mul

import lang::ql::tests::TestHelper;

public test bool testMul1() 
	= p("a * b") is mul
	;
	
public test bool testMul2() 
	= p("a * b * c") is mul
	;

public test bool testMul3() 
	= p("a * (b * c)") is mul
	;

public test bool testMul4()
	 = p("(a * b) * c") is mul
	;

public test bool testMul5() 
	= p("(a * b)") is mul
	;

public test bool testMul6() 
	= p("(a + b) * c") is mul
	;
	
public test bool testMul7() 
	= p("a * (b + c)") is mul
	;