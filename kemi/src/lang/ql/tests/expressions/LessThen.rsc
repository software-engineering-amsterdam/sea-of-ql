module lang::ql::tests::expressions::LessThen

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testLt1() = 
  parseExpr("a \< b") is lt;

public test bool testLt2() = 
  parseExpr("a + b \< c") is lt;

public test bool testLt3() = 
  parseExpr("a \< b + c") is lt;

public test bool testRandomLt() = 
  parseExpr("<randomWord()> \< <randomWord()>") is lt;
