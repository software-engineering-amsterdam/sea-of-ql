@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::expressions::Money

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;

public test bool testMoney1() = 
  parseExpr("9.21") is money;

public test bool testMoney2() = 
  parseExpr("2.") is money;

public test bool testMoney3() = 
  parseExpr("0.5") is money;

public test bool testMoney1() = 
  parseExpr("1.2") is money;

public test bool testMoney2() = 
  parseExpr("2.00") is money;

public test bool testMoney3() = 
  parseExpr("0.99") is money;

public test bool testRandomMul1() = 
  parseExpr("<randomInt(100)>.<randomInt(9)><randomInt(9)>") is money;

public test bool testRandomMul2() = 
  parseExpr("2.<randomInt(9)><randomInt(9)>") is money;

public test bool testRandomMul3() = 
  parseExpr("<randomInt(100)>.<randomInt(9)>") is money;
