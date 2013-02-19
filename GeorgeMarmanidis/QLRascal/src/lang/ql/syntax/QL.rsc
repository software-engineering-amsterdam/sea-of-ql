@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::syntax::QL

lexical Ident 
 	= @category="Identifier" ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
 	;

lexical Money 
	= ([0-9]+ "," [0-9][0-9]?)
	;

lexical Date
	=  [0-3][0-9] "/" [0-2][0-3] "/"[0-9][0-9][0-9][0-9]"/"
	;

lexical Int
 	=  [0-9]+ !>> [0-9]
 	;

lexical Float 
	=  [0-9]+ "." [0-9] [0-9]
	;

lexical Boolean
	=  "true"
	|  "false";
  
lexical String
	=   "\"" ![\"]* "\""
	;

layout Standard 
 	= WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*"
 	;
  
lexical Comment 
 	= @category="Comment" "/*" CommentChar* "*/"
  	;

lexical CommentChar
 	= ![*]
 	| [*] !>> [/]
  	;
  
lexical Whitespace 
 	= [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]
 	; 
  
syntax WhitespaceOrComment 
 	= whitespace: Whitespace
 	| comment: Comment
 	;   
 
start syntax Form 
	= form: "form" Ident name "{" FormBodyItem+ formBody "}"
	;

start syntax FormBodyItem
	= question: Question question
	| conditionalStatement: ConditionalStatement conditionalStatement
	;

start syntax ConditionalStatement 
	= ifCond: "if" Expr cond "{" FormBodyItem+ question "}" "else" "{" FormBodyItem+ question "}"
	| simpleIfCond : "if" Expr cond "{" FormBodyItem+ question "}"
	| ifElseIfCond : "if" Expr cond "{" FormBodyItem+ question "}" ElseIf+ elseIfCondition "else" "{" FormBodyItem+ question "}"
	;

start syntax ElseIf
	= elseif: "else" "if" Expr cond "{"FormBodyItem+ question"}"
	;

start syntax Question
	= simpleQuestion: Ident ident ":" String label Type type
	| computedQuestion: Ident ident ":"  String label  Type type Expr compExpression 
	;

start syntax Expr
  	= ident: Ident name
  	| \int: Int
  	| boolean: Boolean
  	| money: Money
  	| date: Date
  	| float: Float
  	| string: String
  
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

start syntax Type
 	= boolean:"boolean"
 	| integer:"integer"
 	| date:"date"
 	| money:"money"
 	| string:"string"
 	| float: "float"
 	;    

keyword Keywords //create Keywords in order to not use them in form declaration
	= \true: "true"
	| \false: "false"
	| \if: "if"
	| \else: "else"
	| \form: "form"
	;
  




  