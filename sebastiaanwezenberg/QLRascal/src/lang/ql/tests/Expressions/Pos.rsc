module lang::ql::tests::Expressions::Pos

import lang::ql::tests::TestHelper;

public test bool testPos1() 
	= p("+0") is pos
	;
  
public test bool testPos2()
	= p("+4353") is pos
	;
  
public test bool testPos3() 
	= p("+2345676") is pos
	;
  
public test bool testPos4() 
	= p("+(43532345 - 1340)") is pos
	;