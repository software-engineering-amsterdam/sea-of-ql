module lang::ql::tests::expressions::Negative

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testNeg1() = parse("-0") is neg;
public test bool testNeg2() = parse("-1223") is neg;
public test bool testNeg3() = parse("-234234234") is neg;
public test bool testNeg4() = parse("-(1223 + 10)") is neg;
