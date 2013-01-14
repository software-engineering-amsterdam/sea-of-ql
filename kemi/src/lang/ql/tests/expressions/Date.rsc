module lang::ql::tests::expressions::Date

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testDate1() = parse("$1000-01-01") is date;
public test bool testDate2() = parse("$2013-01-08") is date;
public test bool testDate3() = parse("$1000-01-01") is date;
public test bool testDate4() = parse("$1550-11-23") is date;
public test bool testDate5() = parse("$2025-12-31") is date;
public test bool testDate6() = parse("$2999-12-31") is date;
