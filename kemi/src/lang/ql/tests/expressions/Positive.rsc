module lang::ql::tests::expressions::Positive

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testPos1() = p("+0") is pos;
public test bool testPos2() = p("+1223") is pos;
public test bool testPos3() = p("+234234234") is pos;
public test bool testPos4() = p("+(1223 - 10)") is pos;
