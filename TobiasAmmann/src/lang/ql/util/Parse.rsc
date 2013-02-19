module lang::ql::util::Parse

import lang::ql::syntax::Syntax;
import lang::ql::ast::AST;
import ParseTree;

public FORM parse(str src, loc l) = parse(#FORM, src, l);