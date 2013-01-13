module lang::ql::tests::expressions::ParseHelper

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::syntax::QL;

private start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

public Expr implode(Tree t) = implode(#Expr, t);

public Expr parse(str src) = implode(parse(src, |file:///-|));
