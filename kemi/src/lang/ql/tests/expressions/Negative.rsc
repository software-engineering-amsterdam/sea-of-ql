module lang::ql::tests::expressions::Negative

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testNeg1() = parseExpr("-0") is neg;
public test bool testNeg2() = parseExpr("-1223") is neg;
public test bool testNeg3() = parseExpr("-234234234") is neg;
public test bool testNeg4() = parseExpr("-(1223 + 10)") is neg;
