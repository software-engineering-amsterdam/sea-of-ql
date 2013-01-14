module lang::ql::tests::expressions::Division

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testDiv1() = parse("a / b") is div;
public test bool testDiv2() = parse("a / b / c") is div;
public test bool testDiv3() = parse("a / (b / c)") is div;
public test bool testDiv4() = parse("(a / b) / c") is div;
public test bool testDiv5() = parse("(a / b)") is div;
public test bool testDiv6() = parse("(a + b) / c") is div;
public test bool testDiv7() = parse("a / (b + c)") is div;
