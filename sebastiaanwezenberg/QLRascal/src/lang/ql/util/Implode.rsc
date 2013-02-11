module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import IO;

public Expr implodeExpr(Tree t) 	
	= implode(#Expr, t)
	;
	
public Question implodeQuestion(Tree t) 	
	= implode(#Question, t)
	;
	
public Form implodeForm(Tree t) 	
	= implode(#Form, t)
	;
	
public Expr load(loc l) 
	= implode(parse(readFile(l), l))
	;

