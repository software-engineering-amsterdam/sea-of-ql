@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::And

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testAnd1() = 
  parseExpr("a && b") is and;

public test bool testAnd2() = 
  parseExpr("a && b && c") is and;

public test bool testAnd3() = 
  parseExpr("(a && b && c)") is and;

public test bool testAnd4() = 
  parseExpr("a && (b || c)") is and;

public test bool testAnd5() = 
  parseExpr("(a || b) && c") is and;

public test bool testAnd6() = 
  parseExpr("(a && b)") is and;

public test bool testRandomAnd() = 
  parseExpr("<randomWord()> && <randomWord()>") is and;
