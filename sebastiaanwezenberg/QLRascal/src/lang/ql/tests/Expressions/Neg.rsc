module lang::ql::tests::Expressions::Neg

import lang::ql::tests::TestHelper;

public test bool testNeg1() 
	= p("-0") is neg
	;
  
public test bool testNeg2() 
	= p("-1223") is neg
	;
  
public test bool testNeg3()
 	= p("-234234234") is neg
 	;
  
public test bool testNeg4() 
	= p("-(1223 + 10)") is neg
	;