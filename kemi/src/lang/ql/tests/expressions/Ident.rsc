@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Ident

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testIdent1() = 
  parseExpr("a") is ident;
  
public test bool testIdent2() = 
  parseExpr("abc") is ident;
  
public test bool testIdent3() = 
  parseExpr("ABC") is ident;

public test bool testIdent4() = 
  parseExpr("ABCDEF") is ident;

public test bool testIdent5() = 
  parseExpr("abc2323") is ident;

public test bool testIdent6() = 
  parseExpr("a2bc232") is ident;

public test bool testIdent7() = 
  parseExpr("a2bc232aa") is ident;

public test bool testIdent8() = 
  parseExpr("a2bc232a") is ident;

public test bool testIdent9() = 
  parseExpr("a2bc232aa") is ident;

public test bool testIdent10() = 
  parseExpr("a2bc_232aa") is ident;

public test bool testRandomIdent() = 
  parseExpr(randomWord()) is ident;
