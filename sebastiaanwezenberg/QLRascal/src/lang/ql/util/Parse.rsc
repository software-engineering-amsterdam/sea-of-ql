module lang::ql::util::Parse

import lang::ql::syntax::Layout;
import lang::ql::syntax::Lexical;
import lang::ql::syntax::Expressions;

import ParseTree;

public start[Expr] parseExpr(str src, loc l) 
	= parse(#start[Expr], src, l)
	;
	
public start[Question] parseQuestion(str src, loc l) 
	= parse(#start[Question], src, l)
	;
	
public start[Form] parseForm(str src, loc l) 
	= parse(#start[Form], src, l)
	;
	