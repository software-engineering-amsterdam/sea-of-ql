module lang::ql::tests::expressions::Equality

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testEq1() = p("a == b") is eq;
public test bool testEq2() = p("a == (b + c)") is eq;
public test bool testEq3() = p("(a + b) == c") is eq;
public test bool testEq4() = p("(a == b)") is eq;
public test bool testEq5() = p("(a != b) == c") is eq;
