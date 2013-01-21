module syntax::AbstractSyntax

public data TYPE = string() | boolean() | money() | money(Expression);

public alias QuestionId = str;
public alias QuestionString = str;
//public alias Keywords = str;

// syntax to start a QL Program	
public data PROGRAM =
	program(Expression exp, list[DECL] decls, list[STATEMENT] stats);   // KEY key, 
// Syntax for a question declaration   
public data DECL =
   decl(QuestionId name, QUE qName);
// Syntax for the question   
public data QUE = qName(list[QuestionString] questionString, TYPE tp);
// syntax to map the questionid with the type
public data QUET = result(QuestionId id, TYPE tp);

public data KEY = key (str name);
// syntax for the expression   
public data Expression =
	  id (str name)  // QuestionId
	| \int(int ivalue)
	//| bracket ( EXP arg )
	| add (Expression left, Expression right)
	| mul (Expression left, Expression right)
	| div (Expression left, Expression right)
	| sub (Expression left, Expression right)
	| and (Expression left, Expression right)
	| or (Expression left, Expression right)
	| lt (Expression left, Expression right)
| leq (Expression left, Expression right)
| gt (Expression left, Expression right)
| geq (Expression left, Expression right)
| eq (Expression left, Expression right)
| neq (Expression left, Expression right)
| boolCon (bool bVal)
| moneyCon (str mVal)
//| strQue (str qVal)
//| strCon (str sVal)
	;
// syntax for statements	
public data STATEMENT =
     asgStat(QuestionId name, TYPE tp ) //      asgStat(QuestionId name, QuestionString qDefinition, TYPE tp) // Expression exp
     | ifStat(Expression exp, list[DECL] decls)  //, QUE
     | ifThenStat(Expression exp, list[STATEMENT] thenpart)
     | ifElseStat(Expression exp, list[STATEMENT] thenpart, list[STATEMENT] elsepart)
     ;

anno loc TYPE@location;                   
anno loc PROGRAM@location;
anno loc DECL@location;
anno loc Expression@location;
anno loc STATEMENT@location;
anno loc QUE@location;
anno loc QUET@location;

public alias Occurrence = tuple[loc location, QuestionId name, STATEMENT stat]; 
   

