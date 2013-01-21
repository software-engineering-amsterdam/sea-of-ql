module syntax::AbstractSyntax

public data Type = string() | integer() | boolean() | money() | money(Expression);

public alias QuestionId = str;
public alias QuestionString = str;

// syntax to start a QL Program	
public data PROGRAM =
	program(Expression exp, list[Declaration] decls, list[Statement] stats);
// Syntax for a question declaration   
public data Declaration = decl(QuestionId name, Question qName);
// Syntax for the question   
//public data Question = qName(list[QuestionString] questionString, Type tp);
public data Question = 
	   easyQuestion(str id, str labelQuestion, Type tp) // list[QuestionString] questionString, Type tp)
	 | computedQuestion() 
	 ;
// syntax to map the questionid with the type
public data QuestionType = result(QuestionId id, Type tp);
// syntax for the expression   
public data Expression =
	  id (str name)
	| \int(int ivalue)
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
	| string (str sVal)
//| strCon (str sVal)
	;
// syntax for statements	
public data Statement =
     asgStat(QuestionId name, Type tp )
     | ifStat(Expression exp, list[Declaration] decls)
     | ifThenStat(Expression exp, list[Statement] thenpart)
     | ifElseStat(Expression exp, list[Statement] thenpart, list[Statement] elsepart)
     ;

anno loc Type@location;                   
anno loc PROGRAM@location;
anno loc Declaration@location;
anno loc Expression@location;
anno loc Statement@location;
anno loc Question@location;
anno loc QuestionType@location;

public alias Occurrence = tuple[loc location, QuestionId name, Statement stat]; 
   

