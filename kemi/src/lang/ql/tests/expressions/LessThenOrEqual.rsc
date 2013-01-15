module lang::ql::tests::expressions::LessThenOrEqual

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testLeq1() = 
  parseExpr("a \<= b") is leq;

public test bool testLeq2() = 
  parseExpr("a + b \<= c") is leq;

public test bool testLeq3() = 
  parseExpr("a \<= b + c") is leq;

public test bool testRandomLeq() = 
  parseExpr("<randomWord()> \<= <randomWord()>") is leq;
