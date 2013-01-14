module lang::ql::tests::questions::ParseHelper

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::syntax::QL;

private start[Question] parse(str src, loc l) = parse(#start[Question], src, l);

public Question implode(Tree t) = implode(#Question, t);

public Question parse(str src) = implode(parse(src, |file:///-|));
