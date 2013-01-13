module lang::ql::tests::expressions::InEquality

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testneq1() = p("a != b") is neq;
public test bool testneq2() = p("a != (b + c)") is neq;
public test bool testneq3() = p("(a + b) != c") is neq;
public test bool testneq4() = p("(a != b)") is neq;
public test bool testneq5() = p("(a == b) != c") is neq;
