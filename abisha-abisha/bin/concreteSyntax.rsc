module ConcreteSyntax

import Prelude;

lexical Id  = [a-z][a-z0-9]* !>> [a-z0-9];
lexical Natural = [0-9]+ ;
lexical Money = [0-9]+ ;
lexical String = "\"" ![\"]*  "\"";
lexical Boolean = [true,false];

layout Layout = WhitespaceAndComment* !>> [\ \t\n\r%];

lexical WhitespaceAndComment  = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $
   ;

start syntax Form = form: "form"  Declarations decls {Statement  ";"}*  ;

syntax Declarations = "form" {Declaration ","}* decls ";" ;  
 
syntax Declaration = decl: Id qustion ":" Type tp;
 
syntax Type = natural:"natural" 
   | string :"string" 
   | money : "money"
   | boolean: "bool"
   | FORM : "string"
   ;

syntax Statement = asgStat: Id var ":="  EXP exp 
   | ifElseStat: "if" EXP cond "then" {Statement ";"}*  thenPart "else" {Statement ";"}* elsePart "fi"
   ;  
     
syntax EXP = id: Id name
   | strCon: String string
   | natCon: Natural natcon
   | boolCon: Boolean boolean
   | moneyCon: Money money  
   | bracket "(" EXP e ")"
   > left conc: EXP lhs "||" EXP rhs
   > left ( add: EXP lhs "+" EXP rhs
          | sub: EXP lhs "-" EXP rhs)
   ;

public start[Form] form(str s) 
	{
  	return parse(#start[Form], s);
	}

public start[Form] form(str s, loc l) 
	{
  	return parse(#start[Form], s, l);
	}
	
	 
