module lang::ql::tests::TestHelper

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;
import IO;
	
public Expr p(str src) 
	= implodeExpr(parseExpr(src, |file:///-|))
	;
	
public Question pq(str src) 
	= implodeQuestion(parseQuestion(src, |file:///-|))
	;
	
public Form pf(str src) 
	= implodeForm(parseForm(src, |file:///-|))
	;
	
public Form parseForm(loc l) 
	= pf(readFile(l))
	;
	