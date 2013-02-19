@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Int

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testInt1() = 
  parseExpr("0") is \int;

public test bool testInt2() = 
  parseExpr("1223") is \int;

public test bool testInt3() = 
  parseExpr("234234234") is \int;

public test bool testInt3() = 
  parseExpr("234234234929922091319024209190246420919024420913190242911902442919024") is \int;

public test bool testRandomInt() = 
  parseExpr("<randomInt(0, 100000)>") is \int;
