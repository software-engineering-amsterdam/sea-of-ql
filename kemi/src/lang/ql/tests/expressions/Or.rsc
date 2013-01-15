module lang::ql::tests::expressions::Or

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testOr1() = 
  parseExpr("a || b") is or;
  
public test bool testOr2() = 
  parseExpr("a || b || c") is or;
  
public test bool testOr3() = 
  parseExpr("(a || b || c)") is or;
  
public test bool testOr4() = 
  parseExpr("a || (b && c)") is or;
  
public test bool testOr5() = 
  parseExpr("(a && b) || c") is or;
  
public test bool testOr6() = 
  parseExpr("(a || b)") is or;

public test bool testRandomOr() = 
  parseExpr("<randomWord()> || <randomWord()>") is or;
