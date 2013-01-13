module lang::ql::tests::expressions::Equality

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testEq1() = parse("a == b") is eq;
public test bool testEq2() = parse("a == (b + c)") is eq;
public test bool testEq3() = parse("(a + b) == c") is eq;
public test bool testEq4() = parse("(a == b)") is eq;
public test bool testEq5() = parse("(a != b) == c") is eq;
