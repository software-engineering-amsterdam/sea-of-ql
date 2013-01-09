module lang::ql::util::Parse

import lang::ql::syntax::Layout;
import lang::ql::syntax::Lexical;
import lang::ql::syntax::Expressions;
import lang::ql::syntax::Types;

import ParseTree;

public start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);