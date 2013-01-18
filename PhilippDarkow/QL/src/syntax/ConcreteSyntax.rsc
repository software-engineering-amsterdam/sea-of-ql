module syntax::ConcreteSyntax

import Prelude;

lexical QuestionString  = [a-z][a-z0-9]* !>> [a-z0-9];
lexical Id  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]; 
lexical Boolean = [true,false];
lexical Money = [0-9]+ ;
lexical String = "\"" ![\"]*  "\"";

layout Layout = WhitespaceAndComment* !>> [\ \t\n\r%];   // copied from Pico

lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $
   ;

start syntax Program 
   = program: "form" Expression qName "{" Declarations decls {Statement  ";"}* body "}" ; // Statement stmt 
   
syntax Declarations
   = Declaration* decls;
   
//syntax Declaration
//   = decl: Id id ":" Question qName Type tp;
   
syntax Declaration
   = decl: Id id ":" Question qName;

syntax Question
   = qName: QuestionString questionString Type tp;

syntax Statement 
   = asgStat: Id var ":" Expression qExp " " Type tp   // Question qName
   | ifStat: "if" Expression cond "{" Declaration* decls "}"  // Question 
   | ifThenStat: "if" Expression cond "then" Statement*
   | ifElseStat: "if" Expression cond "then" {Statement ";"}*  thenPart "else" Statement* elsePart
   ;

syntax Type 
   = natural:"natural" 
   | string :"string"
   | boolean :"boolean"
   | money :"money"
   | money :"money" Expression 
   ;
  
syntax Expression 
   = id: Id name
   | strQue: String string
   | strCon: String string
   | boolCon: Boolean boolean
   | bracket "(" Expression arg ")"
   | moneyCon: Money money
   > left ( add: Expression lhs "+" Expression rhs
          | sub: Expression lhs "-" Expression rhs
          )
   > left and: Expression "&&" Expression
   > left or: Expression "||" Expression
   > non-assoc (
      lt: Expression "\<" Expression
    | leq: Expression "\<=" Expression
    | gt: Expression "\>" Expression
    | geq: Expression "\>=" Expression
    | eq: Expression "==" Expression
    | neq: Expression "!=" Expression
  )
   ;

public start[Program] program(str s) {
  return parse(#start[Program], s);
}

public start[Program] program(str s, loc l) {
  return parse(#start[Program], s, l);
} 