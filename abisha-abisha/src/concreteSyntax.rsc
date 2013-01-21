module concreteSyntax

import Prelude;

//lexical Keyword = "natural"|"string"|"form"|"Int"|"bool"|"true"|"false"|"if"|"else";

lexical ID = [a-z][a-z0-9]*!>>[a-z0-9];
//lexical Int = [0-9]+!>>[0-9];
lexical Boolean = [true,false];
lexical String= "\" "![\"]*"\"";
lexical Money = [0-9]+;
//lexical Char = [a-z]+!>>[a-z];

layout Layout = WhitespaceAnd Comment*!>>[\ \t\n\r%];

lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $;  
   
//start syntax Program= program: "form" Expression fName "{" "}";
start syntax Program 
   = program: "form" Declarations decls {Statement  ";"}* body "end" ;

syntax Declarations = decl: ID id ":" Type tp;

syntax Statement = question: Question question 
					|ifEsleStat : "if" Expression condition "then"{Statemnet ";"}* thenPart "else" {Statemnet";"}* elsePart "fi"
					|ifElseStat : "if" EXP condition "{"Statement* thenPart"}" ;

syntax ElseIf = elseIf: "else" "if" EXP condition "{" Statement + thenPart"}";


syntax Question = computed:ID Identifier ";" String label Type tp EXP expression
				|uncomputed:ID identifier ":" String label type tp;
				

syntax Expression 
   = id: Id name
   | strCon: String string
   | natCon: Natural natcon
  ;
  
syntax Type 
   = natural:"natural" 
   | string :"string" 
   ;

public start [Program] program(str s)	
	{
	return parse(#start [Program],s);
	}
	
public start [Program] program(str s, loc l)	
	{
	return parse(#start [Program], s, l);
	}