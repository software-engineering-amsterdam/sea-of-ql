module lang::ql::tests::expressions::Boolean

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testBool1() = 
  parseExpr("true") is boolean;

public test bool testBool2() =
  parseExpr("false") is boolean;
