module lang::ql::tests::expressions::Division

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testDiv1() = parseExpr("a / b") is div;
public test bool testDiv2() = parseExpr("a / b / c") is div;
public test bool testDiv3() = parseExpr("a / (b / c)") is div;
public test bool testDiv4() = parseExpr("(a / b) / c") is div;
public test bool testDiv5() = parseExpr("(a / b)") is div;
public test bool testDiv6() = parseExpr("(a + b) / c") is div;
public test bool testDiv7() = parseExpr("a / (b + c)") is div;
