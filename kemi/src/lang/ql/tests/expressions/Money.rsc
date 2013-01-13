module lang::ql::tests::expressions::Money

import lang::ql::ast::AST;
import lang::ql::tests::expressions::ParseHelper;

public test bool testMoney1() = parse("9.21") is money;
public test bool testMoney2() = parse("2.") is money;
public test bool testMoney3() = parse("0.5") is money;
public test bool testMoney1() = parse("1.2") is money;
public test bool testMoney2() = parse("2.00") is money;
public test bool testMoney3() = parse("0.99") is money;
