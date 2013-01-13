module lang::ql::tests::expressions::LessThenOrEqual

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testLeq1() = parse("a \<= b") is leq;
public test bool testLeq2() = parse("a + b \<= c") is leq;
public test bool testLeq3() = parse("a \<= b + c") is leq;
