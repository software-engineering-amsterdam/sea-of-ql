module lang::ql::tests::expressions::Multiplication

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testMul1() = parse("a * b") is mul;
public test bool testMul2() = parse("a * b * c") is mul;
public test bool testMul3() = parse("a * (b * c)") is mul;
public test bool testMul4() = parse("(a * b) * c") is mul;
public test bool testMul5() = parse("(a * b)") is mul;
public test bool testMul6() = parse("(a + b) * c") is mul;
public test bool testMul7() = parse("a * (b + c)") is mul;
