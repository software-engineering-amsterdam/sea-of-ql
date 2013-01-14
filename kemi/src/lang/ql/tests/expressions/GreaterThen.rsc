module lang::ql::tests::expressions::GreaterThen

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testGt1() = parse("a \> b") is gt;
public test bool testGt2() = parse("a + b \> c") is gt;
public test bool testGt3() = parse("a \> b + c") is gt;
