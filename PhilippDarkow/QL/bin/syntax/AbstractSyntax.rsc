module syntax::AbstractSyntax

public data Type = string() | integer() | boolean() | money() | money(Expression);

// Data of a QL Program	
public data Program =
	program(str questionnaireName, list[Body] body);
	
// Data of a Body Rule
public data Body =
	  question(Question question)
	| statement(Statement statement)
	;

// Data of a Question   
public data Question = 
	   easyQuestion(str id, str labelQuestion, Type tp)
	 | computedQuestion(str id, str labelQuestion, Type tp,Expression exp ) 
	 ;

// Data of a Expression Rule   
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
	| neq (Expression exp)
	| pos (Expression exp)
	| not (Expression exp)
	| boolCon (bool bVal)
	| moneyCon (str mVal)
	| strCon (str sVal)
	;

// Data of a Statements Rule 	
public data Statement =
       ifStat(Expression exp, list[Body] body) 
     | ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart)
     ;

anno loc Type@location;                   
anno loc Program@location;
anno loc Body@location;
anno loc Expression@location;
anno loc Statement@location;
anno loc Question@location;

public alias Occurrence = tuple[loc location, str name, Question questions]; 
   

