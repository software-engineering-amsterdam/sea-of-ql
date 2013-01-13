module lang::ql::tests::expressions::And

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testAnd1() = parse("a && b") is and;
public test bool testAnd2() = parse("a && b && c") is and;
public test bool testAnd3() = parse("(a && b && c)") is and;
public test bool testAnd4() = parse("a && (b || c)") is and;
public test bool testAnd5() = parse("(a || b) && c") is and;
public test bool testAnd6() = parse("(a && b)") is and;
