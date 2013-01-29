module lang::ql::syntax::Syntax

import lang::ql::syntax::Currencies;
import Prelude;

keyword Keywords = "form" | "int" | "bool" | "string" | "if" | "elseif" | "else" | "true" | "false";

lexical Id  	= [a-z][a-zA-Z0-9]* !>> [a-z0-9]\ Keywords;
lexical Natural = [0-9]+ ;
lexical String 	= "\"" ![\"]*  "\"";
lexical Boolean = "false" | "true";
lexical Date 	= [0-3][0-9]"-"[0][1-9] | [1][0-2]"-"[1-2][0|9][0-9][0-9];	//Day-Month-Year
lexical Decimal	= [0-9]+"."[0-9][0-9]*;
lexical Currency = Currencies;

layout Layout = WhitespaceAndComment* !>> [\ \t\n\r%];

lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $
   ;

start syntax Form 
	= @foldable form: "form" Id formName "{" Statement+ statement "}"
	;

syntax Statement 
	= statement: Question question
	| @foldable conditional1: If ifStatement ElseIf* elseIfStatement Else elseStatement
	| @foldable conditional2: If ifStatement ElseIf* elseIfStatement
;  
syntax If
	= @foldable ifStat:		"if" 	  "(" Expr condition ")" "{" Statement+ statement "}"//Id id ":"String x Type t"}"// 
;
syntax ElseIf
	= @foldable elseIfStat:	"elseif"  "(" Expr condition ")" "{" Statement+ statement "}"
;
syntax Else
	= @foldable elseStat:	"else"  		 				 "{" Statement+ statement "}"
;

syntax Question
	= exprQuestion: Id identifier ":" String qst Type t Expr condition
	| question: 	Id identifier ":" String qst Type t
;

syntax Type
	= natural : "int"
	| string  : "str"
	| boolean : "bool"
	| decimal : "money"
	| date    : "date"
;

syntax Expr
  = ident: Id name
  | \int: Natural
  | \bool: Boolean
  | bracket "(" Expr arg ")"
  | pos: "+" Expr
  | neg: "-" Expr
  | not: "!" Expr
  > left (
      mul: Expr "*" Expr
    | div: Expr "/" Expr
  )
  > left (
      add: Expr "+" Expr
    | sub: Expr "-" Expr
  )
  > non-assoc (
      lt: Expr "\<" Expr
    | leq: Expr "\<=" Expr
    | gt: Expr "\>" Expr
    | geq: Expr "\>=" Expr
    | eq: Expr "==" Expr
    | neq: Expr "!=" Expr
  )
  > left and: Expr "&&" Expr
  > left or: Expr "||" Expr
;