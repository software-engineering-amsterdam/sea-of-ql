module lang::ql::tests::expressions::Or

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testOr1() = parse("a || b") is or;
public test bool testOr2() = parse("a || b || c") is or;
public test bool testOr3() = parse("(a || b || c)") is or;
public test bool testOr4() = parse("a || (b && c)") is or;
public test bool testOr5() = parse("(a && b) || c") is or;
public test bool testOr6() = parse("(a || b)") is or;
