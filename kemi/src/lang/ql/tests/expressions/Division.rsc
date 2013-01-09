module lang::ql::tests::expressions::Division

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testDiv1() = p("a / b") is div;
public test bool testDiv2() = p("a / b / c") is div;
public test bool testDiv3() = p("a / (b / c)") is div;
public test bool testDiv4() = p("(a / b) / c") is div;
public test bool testDiv5() = p("(a / b)") is div;
public test bool testDiv6() = p("(a + b) / c") is div;
public test bool testDiv7() = p("a / (b + c)") is div;
