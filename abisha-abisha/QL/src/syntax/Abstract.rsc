//@abisha

module syntax::Abstract

public data Type = string() | integer() | boolean() | money() | money(Expression);

// Data of a QL Program	
public data Form = form(str name, list[Body] stats);

public data Body=question(Question question)
				|statement (Statement statement)
				;
	
public data Statement =
       ifStat(Expression exp, list[Body] stats) 
     | ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart)
     ;

public data Question = uncomputedQuestion(str id, str labelQuestion, Type tp)
	 | computedQuestion(str id, str labelQuestion, Type tp,Expression exp )
	 ;

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
anno loc Body@location;
anno loc Question@location;

public alias Occurrence = tuple[loc location, str name, Question questions];