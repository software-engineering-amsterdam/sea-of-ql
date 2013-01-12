module lang::ql::tests::expressions::String

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testString1() = p("\"afalse\"") is string;
public test bool testString2() = p("\"a b _c @ $ ^\"") is string;
public test bool testString3() = p("\"af\\\"alse\"") is string;
