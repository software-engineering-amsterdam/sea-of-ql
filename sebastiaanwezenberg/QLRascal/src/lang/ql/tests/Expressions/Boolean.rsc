module lang::ql::tests::Expressions::Boolean

import lang::ql::tests::TestHelper;
	
public test bool testBoolean1() 
	 = p("false") is boolean
	 ;

public test bool testBoolean2()
  	= p("true") is boolean
  	;