module lang::ql::tests::expressions::InEquality

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testneq1() = parseExpr("a != b") is neq;
public test bool testneq2() = parseExpr("a != (b + c)") is neq;
public test bool testneq3() = parseExpr("(a + b) != c") is neq;
public test bool testneq4() = parseExpr("(a != b)") is neq;
public test bool testneq5() = parseExpr("(a == b) != c") is neq;
