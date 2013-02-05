module syntax::ConcreteSyntax

import Prelude;

// START LEXICAN TOKENS
lexical QuestionString  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _];
lexical Boolean = "true" | "false";
lexical Money = [0-9]*","[0-9] + [0-9];
lexical String = "\"" ![\"]*  "\"";
lexical Int = [0-9]+ !>> [0-9];
keyword Keywords = "if" | "then" | "else" | "false" | "true";
  
lexical Id
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;

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
  
layout Standard 
  = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";

// START SYNTAX 
start syntax Program 
   = program: "form" Id questionnaireName "{" Body* body "}" ; 

// start syntax Body
start syntax Body =
	  question: Question question
	| statement: Statement statement
	;

// start syntax Question
start syntax Question
   = easyQuestion: Id id ":" String label Type tp
   | computedQuestion: Id id ":" String label Type tp Expression exp
   ;
   
// syntax question id and question type
syntax QuestionType
   = result: Id id ":" Type tp;
   
// start syntax Statement
start syntax Statement 
   = asgStat: Id var ":" Type tp
   | ifStat: "if" Expression cond "{" Body* body "}"
   | ifElseStat: "if" Expression cond "{" Body* body "}" "else" "{" Body* body "}"
   ;
   
// start syntax Type
start syntax Type 
   = integer : "integer" 
   | string :"string"
   | boolean :"boolean"
   | money :"money"   
   ;
   
// start syntax Expression  
start syntax Expression
   = id: Id name
   | \int: Int
   | bracket "(" Expression arg ")"
   | pos: "+" Expr
   | neg: "-" Expr
   | not: "!" Expr
   > left (
      add: Expression "+" Expression
    | sub: Expression "-" Expression
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
   
// METHODS
public start[Program] program(str s) {
  return parse(#start[Program], s);
}

public start[Program] program(str s, loc l) {
  return parse(#start[Program], s, l);
} 