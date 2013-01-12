module lang::ql::tests::expressions::Negation

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testNot1() = p("!a") is not;
public test bool testNot2() = p("!(a && b)") is not;
public test bool testNot4() = p("!(!a && !b)") is not;
