module lang::ql::tests::expressions::Date

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testDate1() = parseExpr("$1000-01-01") is date;
public test bool testDate2() = parseExpr("$2013-01-08") is date;
public test bool testDate3() = parseExpr("$1000-01-01") is date;
public test bool testDate4() = parseExpr("$1550-11-23") is date;
public test bool testDate5() = parseExpr("$2025-12-31") is date;
public test bool testDate6() = parseExpr("$2999-12-31") is date;

public test bool testRandomDate() = parseExpr(randomDateString()) is date;
