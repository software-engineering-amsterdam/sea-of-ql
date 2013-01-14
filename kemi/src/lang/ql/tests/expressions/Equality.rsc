module lang::ql::tests::expressions::Equality

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testEq1() = parseExpr("a == b") is eq;
public test bool testEq2() = parseExpr("a == (b + c)") is eq;
public test bool testEq3() = parseExpr("(a + b) == c") is eq;
public test bool testEq4() = parseExpr("(a == b)") is eq;
public test bool testEq5() = parseExpr("(a != b) == c") is eq;
