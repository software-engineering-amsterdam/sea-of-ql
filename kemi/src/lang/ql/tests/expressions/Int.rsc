module lang::ql::tests::expressions::Int

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import util::Random;

public test bool testInt1() = parseExpr("0") is \int;
public test bool testInt2() = parseExpr("1223") is \int;
public test bool testInt3() = parseExpr("234234234") is \int;
public test bool testInt3() = parseExpr("234234234929922091319024209190246420919024420913190242911902442919024") is \int;

public test bool testRandomInt() = parseExpr("<randInt(0, 100000)>") is \int;
