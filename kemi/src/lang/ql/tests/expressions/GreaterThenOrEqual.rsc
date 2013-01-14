module lang::ql::tests::expressions::GreaterThenOrEqual

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testGeq1() = parse("a \>= b") is geq;
public test bool testGeq2() = parse("a + b \>= c") is geq;
public test bool testGeq3() = parse("a \>= b + c") is geq;
