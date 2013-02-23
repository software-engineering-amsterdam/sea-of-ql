@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Addition

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testAdd1() = 
  parseExpr("a + b") is add;

public test bool testAdd2() = 
  parseExpr("a + b + c") is add;

public test bool testAdd3() = 
  parseExpr("(a + b + c)") is add;

public test bool testAdd4() = 
  parseExpr("a + (b + c)") is add;

public test bool testAdd5() = 
  parseExpr("(a + b) + c") is add;

public test bool testAdd6() = 
  parseExpr("(a + b)") is add;

public test bool testAdd7() = 
  parseExpr("a + b * c") is add;

public test bool testAdd8() = 
  parseExpr("a * b + c") is add;

public test bool testAdd9() = 
  parseExpr("a + b / c") is add;

public test bool testAdd10() = 
  parseExpr("a / b + c") is add;

public test bool testRandomAdd() = 
  parseExpr("<randomWord()> + <randomWord()>") is add;
