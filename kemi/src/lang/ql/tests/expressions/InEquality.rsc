module lang::ql::tests::expressions::InEquality

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
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
