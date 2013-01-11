module lang::ql::syntax::QL

//Syntax for Form
start syntax Form = form: "form" Ident name "{" FormItems formContent "}"; 

//Syntax for FormItems
start syntax FormItems
	= question: Question question
	| conditionalStatement: ConditionalStatement conditionalStatement;
	//maybe insert -> |comment: Comment comment

//Syntax for Conditional Statements .. needs changes	
start syntax ConditionalStatement
	= ifCond: "if" Expr cond "{" Question+ question "}" else "{" Question+ question "}"
	| ifElseIfCond : "if" Expr cond "{" Question+ question "}" elseif Expr cond "{" Question+ question "}" else "{" Question+ question "}";   
	
//Syntax for Question
//start syntax Question
//	= simpleQuestion: Ident ident "," 	
start syntax Expr
  = ident: Ident name
  | \int: Int
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
    
keyword Keywords =;
  
lexical Ident 
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;

  
layout Standard 
  = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";
  
lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  ;

lexical CommentChar
  = ![*]
  | [*] !>> [/]
  ;

syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]
  ; 

  