module syntax::AbstractSyntax

public data TYPE = string() | boolean() | money() | money(EXP);

public alias QuestionId = str;
public alias QuestionString = str;
public alias Money = int;
//public alias Keywords = str;

// syntax to start a QL Program	
public data PROGRAM =
	program(EXP exp, list[DECL] decls, list[STATEMENT] stats);   // KEY key, 
// Syntax for a question declaration   
public data DECL =
   decl(QuestionId name, QUE qName);
// Syntax for the question   
public data QUE = qName(list[QuestionString] questionString, TYPE tp);
// syntax to map the questionid with the type
public data QUET = result(QuestionId id, TYPE tp);

public data KEY = key (str name);
// syntax for the expression   
public data EXP =
	  id (QuestionId name)
	| strQue (QuestionString questionString)
	| strCon (str sVal)
	| boolCon (bool bVal)
	| moneyCon (Money mVal)
	| add (EXP left, EXP right)
	| sub (EXP left, EXP right)
	| and (EXP left, EXP right)
	| or (EXP left, EXP right)
	| lt (EXP left, EXP right)
    | leq (EXP left, EXP right)
    | gt (EXP left, EXP right)
    | geq (EXP left, EXP right)
    | eq (EXP left, EXP right)
    | neq (EXP left, EXP right)
    | key (str name)
	;
// syntax for statements	
public data STATEMENT =
     asgStat(QuestionId name, TYPE tp ) //      asgStat(QuestionId name, QuestionString qDefinition, TYPE tp) // EXP exp
     | ifStat(EXP exp, list[DECL] decls)  //, QUE
     | ifThenStat(EXP exp, list[STATEMENT] thenpart)
     | ifElseStat(EXP exp, list[STATEMENT] thenpart, list[STATEMENT] elsepart)
     ;

anno loc TYPE@location;                   
anno loc PROGRAM@location;
anno loc DECL@location;
anno loc EXP@location;
anno loc STATEMENT@location;
anno loc QUE@location;
anno loc QUET@location;

public alias Occurrence = tuple[loc location, QuestionId name, STATEMENT stat]; 
   

