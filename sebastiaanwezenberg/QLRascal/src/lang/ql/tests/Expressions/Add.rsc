module lang::ql::tests::Expressions::Add

import lang::ql::tests::TestHelper;
	
public test bool testAdd1() 
	= p("a + b") is add
	;
	
public test bool testAdd2() 
	= p("a + b + c") is add
	;
	
public test bool testAdd3() 
	= p("(a + b + c)") is add
	;
	
public test bool testAdd4() 
	= p("a + (b + c)") is add
	;
	
public test bool testAdd5() 
	= p("(a + b) + c") is add
	;
	
public test bool testAdd6() 
	= p("(a + b)") is add
	;
	
public test bool testAdd7() 
	= p("a + b * c") is add
	;

public test bool testAdd8() 
	= p("a * b + c") is add
	;