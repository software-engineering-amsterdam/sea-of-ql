module lang::ql::tests::Expressions::Ident

import lang::ql::tests::TestHelper;

public test bool testIdent1() 
	= p("a") is ident
	;
	
public test bool testIdent2() 
	= p("abc") is ident
	;
	
public test bool testIdent3() 
	= p("ABC") is ident
	;
	
public test bool testIdent4() 
	= p("ABCDEF") is ident
	;
	
public test bool testIdent5() 
	= p("abc2323") is ident
	;
	
public test bool testIdent6() 
	= p("a2bc232") is ident
	;
	
public test bool testIdent7() 
	= p("a2bc232aa") is ident
	;