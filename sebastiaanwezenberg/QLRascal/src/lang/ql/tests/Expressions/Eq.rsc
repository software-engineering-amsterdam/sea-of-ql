module lang::ql::tests::Expressions::Eq

import lang::ql::tests::TestHelper;

public test bool testEq1() 
	= p("a == b") is eq
	;
	
public test bool testEq2() 
	= p("a == (b + c)") is eq
  	;
  
public test bool testEq3() 
	= p("(a + b) == c") is eq
  	;
  
public test bool testEq4() 
	= p("(a == b)") is eq
  	;
  
public test bool testEq5() 
	= p("(a != b) == c") is eq
  	;