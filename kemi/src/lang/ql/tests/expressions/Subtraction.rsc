module lang::ql::tests::expressions::Subtraction

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testsub1() = p("a - b") is sub;
public test bool testSub2() = p("a - b - c") is sub;
public test bool testSub3() = p("(a - b - c)") is sub;
public test bool testSub4() = p("a - (b - c)") is sub;
public test bool testSub5() = p("(a - b) - c") is sub;
public test bool testSub6() = p("(a - b)") is sub;
public test bool testSub7() = p("a - b * c") is sub;
public test bool testSub8() = p("a * b - c") is sub;
public test bool testSub9() = p("a - b / c") is sub;
public test bool testSub10() = p("a / b - c") is sub;
