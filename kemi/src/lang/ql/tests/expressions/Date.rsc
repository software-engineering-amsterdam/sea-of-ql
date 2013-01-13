module lang::ql::tests::expressions::Date

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testDate1() = p("$1000-01-01") is date;
public test bool testDate2() = p("$2013-01-08") is date;
public test bool testDate3() = p("$1000-01-01") is date;
public test bool testDate4() = p("$1550-11-23") is date;
public test bool testDate5() = p("$2025-12-31") is date;
public test bool testDate6() = p("$2999-12-31") is date;
