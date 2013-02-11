module lang::ql::tests::Expressions::Gt

import lang::ql::tests::TestHelper;

public test bool testGt1()  
  	= p("a \> b") is gt
  	;

public test bool testGt2() 
  	= p("a \> b + c") is gt
  	;

public test bool testGt3()  
  	= p("a + b \> c") is gt
  	;
