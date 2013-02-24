module syntax::Abstract


alias QuestionId=str;

public data Type = string() | integer() | boolean() | money() | money();//money(Expression)

// Data of a QL Program	
public data Form = form(str questionName, list[Statement] body);
	
// Data of a Statements Rule 	
public data Statement =
       ifStat(Expression cond, list[Statement] thenPart) 
     | ifElseStat(Expression exp, list[Statement] thenpart, list[Statement] elsepart)
     | question(Question question)
     ;

// Data of a Question   
public data Question = uncomputedQuestion(str id, str labelQuestion, Type tp)
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
	| neq (Expression left, Expression right)
	| not (bool exp)
	| boolCon (bool bVal)
	| moneyCon (str mVal)
	| strCon (str sVal)
	;


anno loc Type@location;                   
anno loc Form@location;
anno loc Expression@location;
anno loc Statement@location;
anno loc Question@location;

public alias Occurrence = tuple[loc location, str name, Question questions];