module syntax::Concrete

import Prelude;

keyword Keywords = "if"|"then"|"else"|"true"|"false";

lexical Id  = ([a-z A-Z 0-9_] !<< [a-z A-Z][a-z A-Z 0-9_]* !>> [a-z A-Z 0-9_])\Keywords;
lexical Boolean = "true" | "false";
lexical Money = [0-9]* "," [0-9] + [0-9];
lexical String = "\"" ![\"]*  "\"";
lexical Int = [0-9]+ !>> [0-9];

lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/";

lexical CommentChar  = ![*] | [*] !>> [/];

syntax WhitespaceOrComment = whitespace: Whitespace | comment: Comment ;   

lexical Whitespace = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]; 
  
layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";

start syntax Form = form: "form" Id qName "{" Body* stats "}" ;

start syntax Question = 
	uncomputedQuestion: Id id ":" String label Type tp
   | computedQuestion: Id id ":" String label Type tp Expression exp 
   ;
   
syntax Body=  question: Question question
				|statement:Statement statement;
				
//question id and type
syntax QuestionType = result: Id id ":" Type tp;
   
start syntax Statement = asgStat: Id var ":" Type tp 
   | ifStat: "if" Expression cond "{" Body* stats "}"
   | ifElseStat: "if" Expression cond "{" Body* stats "}" "else" "{" Body* stats "}"
   ;
   
start syntax Type 
   = integer : "integer" 
   | string  :"string"
   | boolean :"boolean"
   | money   :"money"   
   ;
   
start syntax Expression
   = id: Id name
   | \int: Int integerVal
   | bracket "(" Expression exp ")"
   | pos: "+" Expression
   | neg: "-" Expression
   | not: "!" Expression
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
    | strCon: String sVal
   ;
   
public start[Form] form(str s) 
{
  	return parse(#start[Form], s);
}

public start[Form] form(str s, loc l) 
{
	return parse(#start[Form], s, l);
} 

