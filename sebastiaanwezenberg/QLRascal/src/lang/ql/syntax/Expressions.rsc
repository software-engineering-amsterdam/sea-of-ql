module lang::ql::syntax::Expressions

import lang::ql::syntax::Layout;
import lang::ql::syntax::Lexical;

start syntax Expr
	= ident: Ident
	|  \int: Int
  	| money: Money
	| boolean: Boolean
	| label: Label
	| bracket "(" Expr ")"
	| pos: "+" Expr
	| neg: "-" Expr
	| not: "!" Expr
  	> left (
    	mul: Expr "*" Expr
    	| div: Expr "/" Expr)
  	> left (
    	add: Expr "+" Expr 
    	| sub: Expr "-" Expr)
  	> non-assoc (
    	lt: Expr "\<" Expr 
    	| leq: Expr "\<=" Expr 
    	| gt: Expr "\>" Expr 
    	| geq: Expr "\>=" Expr 
    	| eq: Expr "==" Expr 
    	| neq: Expr "!=" Expr)
  	> left and: Expr "&&" Expr 
  	> left or: Expr "||" Expr 
  	;
    
keyword Keywords 
  = boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | label: "label"
  | \true: "true"
  | \false: "false"
  | form: "form"
  ;
  
start syntax Form 
	= form: "form" Ident "{" Statement+  "}";

syntax Statement 
  	= question: Question
  	| ifCondition: IfClause ElsIfClause* ElseClause?
  	;

syntax Conditional 
  	= conditional: Expr "{" Statement+  "}"
  	;

syntax IfClause 
	= "if" Conditional;

syntax ElsIfPart 
	= "else" "if" Conditional;

syntax ElseClause 
	= elseClause: "else" "{" Statement+ "}";

start syntax Question 
  	= question: Label Type Ident
  	| question: Label Type Ident "=" Expr
  	;
  	
syntax WhitespaceOrComment 
	 = whitespace: Whitespace 
  	| comment: Comment 
  	;   