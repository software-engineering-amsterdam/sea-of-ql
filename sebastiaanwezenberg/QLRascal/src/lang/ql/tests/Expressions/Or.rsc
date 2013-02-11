module lang::ql::tests::Expressions::Or

import lang::ql::tests::TestHelper;
	
public test bool testAnd1()  
	= p("a || b") is or
	;
	
public test bool testAnd2()  
  	= p("(a || b || c)") is or
  	;

public test bool testAnd3()  
  	= p("a || b || c") is or
  	;

public test bool testAnd4() 
  	= p("a || (b || c)") is or
  	;

public test bool testAnd5() 
  	= p("(a || b) || c") is or
  	;

public test bool testAnd6() 
  	= p("(a || b)") is or
  	;