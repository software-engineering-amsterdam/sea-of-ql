module lang::ql::tests::expressions::Subtraction

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
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
