module lang::ql::tests::expressions::InEquality

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testneq1() = parse("a != b") is neq;
public test bool testneq2() = parse("a != (b + c)") is neq;
public test bool testneq3() = parse("(a + b) != c") is neq;
public test bool testneq4() = parse("(a != b)") is neq;
public test bool testneq5() = parse("(a == b) != c") is neq;
