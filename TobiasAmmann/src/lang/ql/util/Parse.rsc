module lang::ql::util::Parse

import lang::ql::syntax::Syntax;
import lang::ql::ast::AST;
import ParseTree;

public start[Form] parse(str src, loc l) = parse(#start[Form], src, l);