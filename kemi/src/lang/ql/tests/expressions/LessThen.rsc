module lang::ql::tests::expressions::LessThen

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testLt1() = p("a \< b") is lt;
public test bool testLt2() = p("a + b \< c") is lt;
public test bool testLt3() = p("a \< b + c") is lt;
