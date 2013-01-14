module lang::ql::tests::expressions::LessThen

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testLt1() = parse("a \< b") is lt;
public test bool testLt2() = parse("a + b \< c") is lt;
public test bool testLt3() = parse("a \< b + c") is lt;
