module lang::ql::tests::expressions::Negative

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

private Expr implode(Tree t) = implode(#Expr, t);
private Expr p(str src) = implode(parse(src, |file:///-|));

public test bool testNeg1() = p("-0") is neg;
public test bool testNeg2() = p("-1223") is neg;
public test bool testNeg3() = p("-234234234") is neg;
public test bool testNeg4() = p("-(1223 + 10)") is neg;
