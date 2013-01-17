module syntax::AbstractSyntax

public data TYPE = string() | boolean() | money();

public alias QuestionId = str;
public alias QuestionString = str;
public alias Money = int;
	
public data PROGRAM =
	program(EXP exp, list[DECL] decls, list[STATEMENT] stats); 

//public data DECL =
//   decl(QuestionId name, QuestionString qName, TYPE tp);
   
public data DECL =
   decl(QuestionId name, QUE qName);
   
public data QUE = qName(QuestionString qName, TYPE tp);
   
public data EXP =
	  id (QuestionId name)
	| strQue (QuestionString qName)
	| strCon (str sVal)
	| boolCon (bool bVal)
	| moneyCon (Money mVal)
	| add (EXP left, EXP right)
	| sub (EXP left, EXP right);
	
public data STATEMENT =
       asgStat(QuestionId name, QuestionString qDefinition, EXP exp)
     | ifStat(EXP exp, list[STATEMENT] thenpart, list[STATEMENT] elsepart)
     ;

anno loc TYPE@location;                   
anno loc PROGRAM@location;
anno loc DECL@location;
anno loc EXP@location;
anno loc STATEMENT@location;

public alias Occurrence = tuple[loc location, QuestionId name, STATEMENT stat]; 
   

