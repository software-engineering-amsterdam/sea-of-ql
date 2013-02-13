module lang::ql::syntax::Lexical

lexical Ident 
	= ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
	;

lexical Int
	= [0-9]+ !>> [0-9]
	;

lexical Boolean
	= "true"
	| "false"
	;

lexical Money
	= [0-9]+ "."
	| [0-9]+ "." [0-9]
  	| [0-9]+ "." [0-9][0-9]
  	;
  
lexical Label 
	= "\"" LabelChar* "\""
	;

lexical LabelChar
  	= [\\] << [\"]
  	| ![\"]
  	;
  
lexical Type
  	= "boolean"
  	| "integer"
  	| "money"
  	| "label"
  	;