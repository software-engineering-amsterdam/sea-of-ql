module lang::ql::tests::expressions::GreaterThenOrEqual

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testGeq1() = p("a \>= b") is geq;
public test bool testGeq2() = p("a + b \>= c") is geq;
public test bool testGeq3() = p("a \>= b + c") is geq;
