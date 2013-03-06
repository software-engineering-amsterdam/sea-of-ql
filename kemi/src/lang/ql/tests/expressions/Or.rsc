@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Or

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testOr1() = 
  parseExpr("a || b") is or;
  
public test bool testOr2() = 
  parseExpr("a || b || c") is or;
  
public test bool testOr3() = 
  parseExpr("(a || b || c)") is or;
  
public test bool testOr4() = 
  parseExpr("a || (b && c)") is or;
  
public test bool testOr5() = 
  parseExpr("(a && b) || c") is or;
  
public test bool testOr6() = 
  parseExpr("(a || b)") is or;

public test bool testRandomOr() = 
  parseExpr("<randomWord()> || <randomWord()>") is or;
