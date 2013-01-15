module lang::ql::tests::expressions::Money

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
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
