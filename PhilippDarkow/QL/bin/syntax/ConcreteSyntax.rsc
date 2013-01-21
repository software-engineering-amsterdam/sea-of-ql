module syntax::ConcreteSyntax

import Prelude;

// START LEXICAN TOKENS
lexical QuestionString  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _];
//lexical Id  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]; 
lexical Boolean = [true,false];
lexical Money = [0-9]+ ;
lexical String = "\"" ![\"]*  "\"";
lexical Int
  = [0-9]+ !>> [0-9]
  ;
keyword Keywords = "if" | "then" | "else";
  
lexical Id
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;

layout Layout = WhitespaceAndComment* !>> [\ \t\n\r%];   // copied from Pico

lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $
   ;

// START SYNTAX 
// start Program
start syntax Program 
   = program: "form" Expression questionnaireName "{" Declarations decls {Statement  ";"}* body "}" ; // Statement stmt 
// start syntax question Declarations   
syntax Declarations
   = Declaration* decls;
// start syntax question declaration      
syntax Declaration
   = decl: Id id ":" Question qName;
// start syntax question
syntax Question
   = qName: "\"" QuestionString* questionString "\"" Type tp;
// syntax question id and question type
syntax QuestionType
   = result: Id id ":" Type tp;
// syntax Statement
syntax Statement 
   = asgStat: Id var ":" Type tp  //      asgStat: Id var ":" Expression qExp " " Type tp   
  // | decStat: Declarations* decls
   | ifStat: "if" Expression cond "{" Declarations decls "}"  // Question 
   | ifThenStat: "if" Expression cond "then" Statement*
   | ifElseStat: "if" Expression cond "then" {Statement ";"}*  thenPart "else" Statement* elsePart
   ;
// syntax Type
syntax Type 
   = natural:"natural" 
   | string :"string"
   | boolean :"boolean"
   | money :"money"
   | money :"money" Expression exp   
   ;
// syntax Expression  
start syntax Expression 
   = id: Id name
   | \int: Int
   //| strQue: String string
   //| strCon: String string
   | bracket "(" Expression arg ")"
   | pos: "+" Expr
   | neg: "-" Expr
   | not: "!" Expr
   //| moneyCon: Money money
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
   | boolCon: Boolean boolean
   ;
   
//start syntax Expression = Expression;

// METHODS

public start[Program] program(str s) {
  return parse(#start[Program], s);
}

public start[Program] program(str s, loc l) {
  return parse(#start[Program], s, l);
} 