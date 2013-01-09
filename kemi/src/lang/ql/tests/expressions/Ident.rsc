module lang::ql::tests::expressions::Ident

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testIdent1() = p("a") is ident;
public test bool testIdent2() = p("abc") is ident;
public test bool testIdent3() = p("ABC") is ident;
public test bool testIdent4() = p("ABCDEF") is ident;
public test bool testIdent5() = p("abc2323") is ident;
public test bool testIdent6() = p("a2bc232") is ident;
public test bool testIdent7() = p("a2bc232aa") is ident;
public test bool testIdent8() = p("a2bc232a") is ident;
public test bool testIdent9() = p("a2bc232aa") is ident;
public test bool testIdent10() = p("a2bc_232aa") is ident;
