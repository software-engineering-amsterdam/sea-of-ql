module lang::ql::tests::expressions::LessThenOrEqual

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testLeq1() = p("a \<= b") is leq;
public test bool testLeq2() = p("a + b \<= c") is leq;
public test bool testLeq3() = p("a \<= b + c") is leq;
