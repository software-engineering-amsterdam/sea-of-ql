@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::String

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testString1() = 
  parseExpr("\"afalse\"") is string;
  
public test bool testString2() = 
  parseExpr("\"a b _c @ $ ^\"") is string;
  
public test bool testString3() = 
  parseExpr("\"af\\\"alse\"") is string;

public test bool testRandomString() = 
  parseExpr("\"<randomSentence()>\"") is string;
