@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Subtraction

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::Random;

public test bool testsub1() = 
  parseExpr("a - b") is sub;

public test bool testSub2() = 
  parseExpr("a - b - c") is sub;

public test bool testSub3() = 
  parseExpr("(a - b - c)") is sub;

public test bool testSub4() = 
  parseExpr("a - (b - c)") is sub;

public test bool testSub5() = 
  parseExpr("(a - b) - c") is sub;

public test bool testSub6() = 
  parseExpr("(a - b)") is sub;

public test bool testSub7() = 
  parseExpr("a - b * c") is sub;

public test bool testSub8() = 
  parseExpr("a * b - c") is sub;

public test bool testSub9() = 
  parseExpr("a - b / c") is sub;

public test bool testSub10() = 
  parseExpr("a / b - c") is sub;

public test bool testRandomSub() = 
  parseExpr("<randomWord()> - <randomWord()>") is sub;
