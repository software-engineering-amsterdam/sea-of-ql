module lang::ql::tests::expressions::Or

import ParseTree;
import IO;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testOr1() = p("a || b") is or;
public test bool testOr2() = p("a || b || c") is or;
public test bool testOr3() = p("(a || b || c)") is or;
public test bool testOr4() = p("a || (b && c)") is or;
public test bool testOr5() = p("(a && b) || c") is or;
public test bool testOr6() = p("(a || b)") is or;
