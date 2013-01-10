module lang::ql::tests::expressions::And

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testAnd1() = p("a && b") is and;
public test bool testAnd2() = p("a && b && c") is and;
public test bool testAnd3() = p("(a && b && c)") is and;
public test bool testAnd4() = p("a && (b || c)") is and;
public test bool testAnd5() = p("(a || b) && c") is and;
public test bool testAnd6() = p("(a && b)") is and;
