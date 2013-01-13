module lang::ql::tests::expressions::GreaterThen

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testGt1() = p("a \> b") is gt;
public test bool testGt2() = p("a + b \> c") is gt;
public test bool testGt3() = p("a \> b + c") is gt;
