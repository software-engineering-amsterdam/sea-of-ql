module lang::ql::tests::expressions::GreaterThenOrEqual

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testGeq1() = parseExpr("a \>= b") is geq;
public test bool testGeq2() = parseExpr("a + b \>= c") is geq;
public test bool testGeq3() = parseExpr("a \>= b + c") is geq;

public test bool testRandomGeq() = parseExpr("<randomWord()> \>= <randomWord()>") is geq;
