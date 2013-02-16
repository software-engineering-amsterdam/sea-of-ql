module syntax::ConcreteSyntax

import Prelude;

keyword Keywords = "if"|"then"|"else"|"true"|"false"|"bool"|"String"|"int"|"form";

lexical Id = ([a-z A-Z 0-9] !<< [a-z A-Z][a-z A-Z 0-9]* !>> [a-z A-Z 0-9]);
lexical Natural = [0-9]+ >>[0-9];
lexical Int = [0-9]+ >>[0-9];
lexical Money = [0-9]* "," [0-9]+[0-9] ;
lexical String = "\"" ![\"]*  "\"";
lexical Boolean = [true,false];
lexical Layout = [ \t-\n\r\ ];


lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/";
  
lexical CommentChar= ![*]
				|[*]!>>[/];
				
syntax WhitespaceOrComment = whitespace:Whitespace
					|comment:Comment;
					
lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]
  ; 

layout Standard = WhitespaceOrComment* !>>[\ \t\n\f\r] !>>"//" !>>"/*";
					

start syntax Program = program: "form"  Expression qLangName "{" Statement* body  "}"  ;

//start syntax Body= question:Question|statement:Statement statement;

start syntax Statement = asgStat: Id var ":" Type tp
					|ifStat: "if" Expression cond "{" Statement* body "}"
					|ifElseStat: "if" Expression cond "{" Statement* body "}" "else" "{" Statement* body "}"
					|questio:Question question
					;
					
start syntax Question = uncomputedQuestion: Id id ":" String label Type tp
					|computedQuestion: Id id ":" Stringlabel Type tp Expression exp;

syntax QuestionType = result: ID var ":" Type tp;
 
syntax Type = natural:"natural" 
   			| string :"string" 
   			| money : "money"
   			| boolean: "boolean"
   			| integer: "integer"
   			;
     
start syntax Expression = id: Id name
   						| \int: Int
   						| bracket "(" Expression expr ")"
   						| pos: "+" Expr
   						| neg: "-" Expr
   						| not: "!" Expr
   						> left (
      						add: Expression "+" Expression
    					| 	sub: Expression "-" Expression
   								)
   						> left (
    					  mul: Expression "*" Expression
    					| div: Expression "/" Expression
 						  		)  
   						> non-assoc (
    					  lt: Expression "\<" Expression
  						| leq: Expression "\<=" Expression
    					| gt: Expression "\>" Expression
    					| geq: Expression "\>=" Expression
    					| eq: Expression "==" Expression
    					| neq: Expression "!=" Expression
  						 )
   						> left and: Expression "&&" Expression
   						> left or: Expression "||" Expression
    					| boolCon: Boolean bVal
    					| moneyCon: Money mVal
    					| string: String
  						;
  

public start[Program] program(str s) 
	{
  	return parse(#start[Program], s);
	}

public start[Program] program(str s, loc l) 
	{
  	return parse(#start[Program], s, l);
	}
	
	 