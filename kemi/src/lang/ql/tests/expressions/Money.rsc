module lang::ql::tests::expressions::Money

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testMoney1() = p("9.21") is money;
public test bool testMoney2() = p("2.") is money;
public test bool testMoney3() = p("0.5") is money;
public test bool testMoney1() = p("1.2") is money;
public test bool testMoney2() = p("2.00") is money;
public test bool testMoney3() = p("0.99") is money;
