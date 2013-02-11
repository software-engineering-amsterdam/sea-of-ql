module lang::ql::tests::Expressions::Label

import lang::ql::tests::TestHelper;

public test bool testLabel1() 
	= p("\"afalse\"") is label
	;
  
public test bool testLabel2() 
	= p("\"a dasdfb _c @ $ ^\"") is label
	;
  
public test bool testLabel3() 
	= p("\"af\\\"alse\"") is label
	;