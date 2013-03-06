@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::InEquality

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testneq1() = 
  parseExpr("a != b") is neq;

public test bool testneq2() = 
  parseExpr("a != (b + c)") is neq;

public test bool testneq3() = 
  parseExpr("(a + b) != c") is neq;

public test bool testneq4() = 
  parseExpr("(a != b)") is neq;

public test bool testneq5() = 
  parseExpr("(a == b) != c") is neq;

public test bool testRandomNeq() = 
  parseExpr("<randomWord()> != <randomWord()>") is neq;
